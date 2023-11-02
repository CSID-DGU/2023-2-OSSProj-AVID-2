package com.example.backend.controller.response;

import com.example.backend.entity.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class TaskDetailResponseDTO {
    private Long scheduleId;
    private String title;
    private String taskType;
    private String write;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int dDay;
    private String complete;

    public static TaskDetailResponseDTO taskResponseDTO(TaskEntity schedule, String complete){
        return new TaskDetailResponseDTO(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getTaskType().name(),
                schedule.getWrite(),
                schedule.getStartDate(),
                schedule.getEndDate(),
                LocalDateTime.now().getDayOfMonth() - schedule.getEndDate().getDayOfMonth(),
                complete
        );
    }
}
