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
    private String content;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int dDay;

    public static TaskDetailResponseDTO taskResponseDTO(TaskEntity schedule){
        return new TaskDetailResponseDTO(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getTaskType().name(),
                schedule.getContent(),
                schedule.getStartDate(),
                schedule.getEndDate(),
                LocalDateTime.now().getDayOfMonth() - schedule.getEndDate().getDayOfMonth()
        );
    }
}
