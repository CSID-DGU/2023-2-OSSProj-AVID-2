package com.example.backend.service;

import com.example.backend.controller.request.CreateScheduleRequestDTO;
import com.example.backend.controller.request.ModifyScheduleRequestDTO;
import com.example.backend.controller.request.TaskRequestDTO;
import com.example.backend.controller.response.*;
import com.example.backend.entity.*;
import com.example.backend.exception.ErrorCode;
import com.example.backend.exception.Exception;
import com.example.backend.repository.*;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleService {
    private final UserRepository userRepository;
    private final PersonalScheduleRepository personalScheduleRepository;
    private final TaskRepository taskRepository;
    private final EntityManager em;
    private final SubjectRepository subjectRepository;
    private final UserSubjectRepository userSubjectRepository;
    private final UserTaskRepository userTaskRepository;
    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDTO getAllSchedule(Month month, int year, String userID) {
        UserEntity user = userRepository.findByUserID(userID)
        .orElseThrow(() -> new Exception(ErrorCode.USER_NOT_FOUND, String.format("%s 학번을 가진 유자가 없습니다.", userID)));
        List<PersonalScheduleResponseDTO> pSchedules = em
                .createQuery("select c from PersonalScheduleEntity c where c.user = :user and(c.startYear = :startYear or c.endYear = : endYear) and (c.startMonth = :startMonth or c.endMonth = :endMonth)", PersonalScheduleEntity.class)
                .setParameter("user", user)
                .setParameter("startYear", year)
                .setParameter("endYear", year)
                .setParameter("startMonth", month)
                .setParameter("endMonth", month)
                .getResultList()
                .stream().map(PersonalScheduleResponseDTO::fromSchedule)
                .collect(Collectors.toList());

        List<UserSubjectEntity> userSubjects = userSubjectRepository.findAllByUser(user);
        List<TaskResponseDTO> tSchedules = new ArrayList<>();
        for (UserSubjectEntity userSubject : userSubjects) {
            List<TaskEntity> task = em
                    .createQuery("select c from TaskEntity c where c.subject = :subject and(c.startYear = :startYear or c.endYear = : endYear) and (c.startMonth = :startMonth or c.endMonth = :endMonth)", TaskEntity.class)
                    .setParameter("subject", userSubject.getSubject())
                    .setParameter("startYear", year)
                    .setParameter("endYear", year)
                    .setParameter("startMonth", month)
                    .setParameter("endMonth", month)
                    .getResultList();
            for (TaskEntity schedule : task) {
                tSchedules.add(TaskResponseDTO.fromTask(schedule));
            }
        }
        return new ScheduleResponseDTO(pSchedules, tSchedules);
    }

    public void createPersonalSchedule(CreateScheduleRequestDTO requestDTO, String userID) {
        UserEntity user = userRepository.findByUserID(userID)
                .orElseThrow(() -> new Exception(ErrorCode.USER_NOT_FOUND, String.format("%s 학번을 가진 유자가 없습니다.", userID)));
        PersonalScheduleEntity schedule = PersonalScheduleEntity.fromPersonalScheduleDTO(requestDTO, user);
        personalScheduleRepository.save(schedule);
    }

    public void deletePersonalSchedule(Long scheduleId, String userID) {
        UserEntity user = userRepository.findByUserID(userID)
                .orElseThrow(() -> new Exception(ErrorCode.USER_NOT_FOUND, String.format("%s 학번을 가진 유자가 없습니다.", userID)));
        PersonalScheduleEntity schedule = personalScheduleRepository.findByIdAndUser(scheduleId, user)
                .orElseThrow(() -> new Exception(ErrorCode.SCHEDULE_NOT_FOUND, String.format("%s 유저가 작성한 %d 일정을 찾을 수 없습니다.", userID, scheduleId)));
        personalScheduleRepository.delete(schedule);
    }

    public void modifyPersonalSchedule(Long scheduleId, String userID, ModifyScheduleRequestDTO requestDTO) {
        UserEntity user = userRepository.findByUserID(userID)
                .orElseThrow(() -> new Exception(ErrorCode.USER_NOT_FOUND, String.format("%s 학번을 가진 유자가 없습니다.", userID)));
        PersonalScheduleEntity personalSchedule = personalScheduleRepository.findByIdAndUser(scheduleId, user)
                .orElseThrow(() -> new Exception(ErrorCode.SCHEDULE_NOT_FOUND, String.format("%s 유저가 작성한 %d 일정을 찾을 수 없습니다.", userID, scheduleId)));
        personalSchedule.modifySchedule(requestDTO);
    }

    public ScheduleDetailResponseDTO getScheduleDetail(String userID, Long scheduleId) {
        UserEntity user = userRepository.findByUserID(userID)
                .orElseThrow(() -> new Exception(ErrorCode.USER_NOT_FOUND, String.format("%s 학번을 가진 유자가 없습니다.", userID)));
        ScheduleEntity schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new Exception(ErrorCode.SCHEDULE_NOT_FOUND));
        String scheduleType = scheduleRepository.findScheduleType(scheduleId);
        if (scheduleType.equals("COMMON"))
            return ScheduleDetailResponseDTO.fromPersonalSchedule((PersonalScheduleEntity) schedule);
        return ScheduleDetailResponseDTO.fromTask((TaskEntity) schedule);
    }

    public void writeTask(TaskRequestDTO requestDTO, String userId) {
        UserEntity user = userRepository
                .findByUserID(userId)
                .orElseThrow(() -> new Exception(ErrorCode.USER_NOT_FOUND, String.format("%s 학번을 가진 유자가 없습니다.", userId)));
        SubjectEntity subject = subjectRepository
                .findBySubjectName(requestDTO.getSubjectName())
                .orElseThrow(() -> new Exception(ErrorCode.SUBJECT_NOT_FOUND, String.format("%s 과목이 존재하지 않습니다.", requestDTO.getSubjectName())));
        TaskEntity subjectSchedule = TaskEntity.fromTaskDTO(requestDTO, subject, user);
        taskRepository.saveAndFlush(subjectSchedule);
        List<UserEntity> users = userSubjectRepository
                .findAllBySubject(subject)
                .stream()
                .map(UserSubjectEntity::getUser)
                .collect(Collectors.toList());
        for (UserEntity listener : users) {
            userTaskRepository.save(UserTaskEntity.newAssignmentFromTask(listener, subjectSchedule));
        }
    }

    public List<EclassResponseDTO> getTask(String userID, String subjectName) {
        UserEntity user = userRepository.findByUserID(userID)
                .orElseThrow(() -> new Exception(ErrorCode.USER_NOT_FOUND, String.format("%s 학번을 가진 유자가 없습니다.", userID)));
        SubjectEntity subject = subjectRepository.findBySubjectName(subjectName)
                .orElseThrow(() -> new Exception(ErrorCode.SUBJECT_NOT_FOUND));
        UserSubjectEntity userSubject = userSubjectRepository.findByUserAndSubject(user, subject)
                .orElseThrow(() -> new Exception(ErrorCode.SUBJECT_NOT_FOUND, "해당 유저는 본 과목을 수강하고 있지 않습니다."));
        return new ArrayList<>(taskRepository
                .findAllBySubject(subject)
                .stream()
                .map(EclassResponseDTO::taskResponseDTO)
                .collect(Collectors.toList()));
    }

    public TaskDetailResponseDTO getTaskDetail(String userID, Long scheduleId) {
        UserEntity user = userRepository.findByUserID(userID)
                .orElseThrow(() -> new Exception(ErrorCode.USER_NOT_FOUND, String.format("%s 학번을 가진 유자가 없습니다.", userID)));
        TaskEntity schedule = taskRepository.findById(scheduleId)
                .orElseThrow(() -> new Exception(ErrorCode.SCHEDULE_NOT_FOUND));
        return TaskDetailResponseDTO.taskResponseDTO(schedule);
    }
}

