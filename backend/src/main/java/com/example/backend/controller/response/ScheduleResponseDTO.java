package com.example.backend.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ScheduleResponseDTO {
    List<PersonalScheduleResponseDTO> PersonalSchedule;
    List<TaskResponseDTO> Task;
    // List<OfficialScheduleResponseDTO> officialSchedule;
}
