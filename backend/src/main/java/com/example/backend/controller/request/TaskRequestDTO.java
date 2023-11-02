package com.example.backend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class TaskRequestDTO {
    private String title;
    private String write;
    private String subjectName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String taskType;
}
