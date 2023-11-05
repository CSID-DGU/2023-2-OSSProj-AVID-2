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
    private String content;
    private String schedule;
    private String taskType;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int dDay;

    public static TaskResponseDTO fromTask(TaskEntity schedule){
        return new TaskResponseDTO(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getSubject().getSubjectName(),
                schedule.getContent(),
                TaskEntity.class.getAnnotation(DiscriminatorValue.class).value(),
                schedule.getTaskType().name(),
                schedule.getStartDate(),
                schedule.getEndDate(),
                LocalDateTime.now().getDayOfYear() - schedule.getEndDate().getDayOfYear()
        );
    }
}
