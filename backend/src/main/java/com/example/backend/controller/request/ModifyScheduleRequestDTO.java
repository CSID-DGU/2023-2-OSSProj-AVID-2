package com.example.backend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ModifyScheduleRequestDTO {
    private String title;
    private String write;
    private String importance;
    private String scheduleType;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
