package com.example.backend.controller.response;

import com.example.backend.entity.TaskEntity;
import com.example.backend.entity.PersonalScheduleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserScheduleResponseDTO {
    private Long scheduleId;
    private String title;
    private LocalDateTime scheduleTime;
    private String schedule;
    private String scheduleType;
    private String subjectName;

    private int dDay;

    public static UserScheduleResponseDTO fromPersonalSchedule(PersonalScheduleEntity schedule) {
        return new UserScheduleResponseDTO(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getStartDate(),
                PersonalScheduleEntity.class.getAnnotation(DiscriminatorValue.class).value(),
                schedule.getScheduleType().name(),
                "",
                LocalDateTime.now().getDayOfYear() - schedule.getEndDate().getDayOfYear()
        );
    }

    public static UserScheduleResponseDTO fromTask(TaskEntity schedule) {
        return new UserScheduleResponseDTO(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getStartDate(),
                TaskEntity.class.getAnnotation(DiscriminatorValue.class).value(),
                schedule.getTaskType().name(),
                schedule.getSubject().getSubjectName(),
                LocalDateTime.now().getDayOfYear() - schedule.getEndDate().getDayOfYear()
        );
    }
}
