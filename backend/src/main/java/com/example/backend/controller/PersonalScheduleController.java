package com.example.backend.controller;

import com.example.backend.controller.request.CreateScheduleRequestDTO;
import com.example.backend.controller.request.ModifyScheduleRequestDTO;
import com.example.backend.controller.response.Response;
import com.example.backend.controller.response.ScheduleDetailResponseDTO;
import com.example.backend.controller.response.ScheduleResponseDTO;
import com.example.backend.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.Month;
import java.time.YearMonth;

// 개인 스케쥴 관련 api
@RestController
@RequestMapping("/api/schedule/personal")
@RequiredArgsConstructor
public class PersonalScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping("")
    public Response<Void> createSchedule(@RequestBody CreateScheduleRequestDTO requestDTO){
        String userID = "2019111598";
        scheduleService.createPersonalSchedule(requestDTO, userID);
        return Response.success();
    }

    @GetMapping("")
    public Response<ScheduleResponseDTO> getSchedule(@RequestParam("month") @DateTimeFormat(pattern = "yyyy-MM") YearMonth yearMonth , Authentication authentication){
        Month month = yearMonth.getMonth();
        int year = yearMonth.getYear();
        return Response.success(scheduleService.getAllSchedule(month, year, authentication.getName()));
    }

    @GetMapping("/{scheduleId}")
    public Response<ScheduleDetailResponseDTO> getScheduleDetail(Authentication authentication, @PathVariable Long scheduleId){
        return Response.success(scheduleService.getScheduleDetail(authentication.getName(), scheduleId));
    }

    @DeleteMapping("/{scheduleId}")
    public Response<Void> deleteSchedule(@PathVariable Long scheduleId, Authentication authentication){
        scheduleService.deletePersonalSchedule(scheduleId, authentication.getName());
        return Response.success();
    }

    @PutMapping("/{scheduleId}")
    public Response<Void> modifySchedule(@PathVariable Long scheduleId, Authentication authentication, @RequestBody ModifyScheduleRequestDTO requestDTO){
        scheduleService.modifyPersonalSchedule(scheduleId, authentication.getName(), requestDTO);
        return Response.success();
    }
}
