package com.example.backend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class CreateScheduleRequestDTO {
    private String title;
    private String content;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String scheduleType;
}
