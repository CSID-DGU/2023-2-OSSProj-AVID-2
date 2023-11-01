package com.example.backend.controller.response;

import com.example.backend.entity.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TaskResponseDTO {
    private Long scheduleId;
    private String title;
    private String subjectName;
    private String write;
    private String schedule;
    private String taskType;
    private String scheduleType;
    private String importance;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int dDay;
    private String complete;

    public static TaskResponseDTO fromTask(TaskEntity schedule){
        return new TaskResponseDTO(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getSubject().getSubjectName(),
                schedule.getWrite(),
                TaskEntity.class.getAnnotation(DiscriminatorValue.class).value(),
                schedule.getTaskType().name(),
                schedule.getScheduleType().name(),
                schedule.getImportance().name(),
                schedule.getStartDate(),
                schedule.getEndDate(),
                LocalDateTime.now().getDayOfYear() - schedule.getEndDate().getDayOfYear(),
                schedule.getComplete().name()
        );
    }
}
