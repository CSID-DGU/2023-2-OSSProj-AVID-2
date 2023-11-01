package com.example.backend.entity;

import com.example.backend.controller.request.TaskRequestDTO;
import com.example.backend.model.ScheduleType;
import com.example.backend.model.Complete;
import com.example.backend.model.Importance;
import com.example.backend.model.TaskType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "task")
@NoArgsConstructor
@Getter
@DiscriminatorValue("SUBJECT")
public class TaskEntity extends ScheduleEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private SubjectEntity subject;
    @Enumerated(EnumType.STRING)
    private TaskType taskType;
    @Enumerated(EnumType.STRING)
    private ScheduleType scheduleType;
    @Enumerated(EnumType.STRING)
    private Importance importance;
    @Enumerated(EnumType.STRING)
    private Complete complete;

    @Builder
    private TaskEntity(TaskRequestDTO requestDTO, UserEntity user, SubjectEntity subject, String complete) {
        this.title = requestDTO.getTitle();
        this.user = user;
        this.startMonth = requestDTO.getStartDate().getMonth();
        this.endMonth = requestDTO.getEndDate().getMonth();
        this.subject = subject;
        this.write = requestDTO.getWrite();
        this.startDate = requestDTO.getStartDate();
        this.endDate = requestDTO.getEndDate();
        this.importance = Importance.returnType(requestDTO.getImportance());
        this.scheduleType = ScheduleType.returnType(requestDTO.getScheduleType());
        this.taskType = TaskType.returnType(requestDTO.getTaskType());
        this.startYear = requestDTO.getStartDate().getYear();
        this.endYear = requestDTO.getEndDate().getYear();
        this.complete = Complete.returnType(complete);
    }

    public static TaskEntity fromTaskDTO(TaskRequestDTO requestDTO, UserEntity user, SubjectEntity subject, String complete){
        return new TaskEntity(requestDTO, user, subject, complete);
    }

    public void modifySchedule(TaskRequestDTO requestDTO, SubjectEntity subject, String complete) {
        this.title = requestDTO.getTitle();
        this.subject = subject;
        this.startMonth = requestDTO.getStartDate().getMonth();
        this.endMonth = requestDTO.getEndDate().getMonth();
        this.write = requestDTO.getWrite();
        this.startDate = requestDTO.getStartDate();
        this.endDate = requestDTO.getEndDate();
        this.importance = Importance.returnType(requestDTO.getImportance());
        this.scheduleType = ScheduleType.returnType(requestDTO.getScheduleType());
        this.taskType = TaskType.returnType(requestDTO.getTaskType());
        this.startYear = requestDTO.getStartDate().getYear();
        this.endYear = requestDTO.getEndDate().getYear();
        this.complete = Complete.returnType(complete);
    }

    public void updateSubjectComplete() {
        if(this.getComplete().name().equals("FALSE")) {
            this.complete = Complete.TRUE;
            return;
        }
        if(this.getComplete().name().equals("TRUE")) this.complete = Complete.FALSE;
    }
}
