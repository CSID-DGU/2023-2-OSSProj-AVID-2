package com.example.backend.controller.response;

import com.example.backend.entity.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class EclassResponseDTO {
    private Long scheduleId;
    private String title;
    private String taskType;
    private LocalDateTime endDate;
    private int dDay;

    public static EclassResponseDTO taskResponseDTO(TaskEntity schedule){
        return new EclassResponseDTO(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getTaskType().name(),
                schedule.getEndDate(),
                LocalDateTime.now().getDayOfYear() - schedule.getEndDate().getDayOfYear());
    }
}
