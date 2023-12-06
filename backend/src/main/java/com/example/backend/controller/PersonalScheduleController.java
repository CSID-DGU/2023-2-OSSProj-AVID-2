package com.example.backend.controller;

import com.example.backend.controller.request.CreateScheduleRequestDTO;
import com.example.backend.controller.request.ModifyScheduleRequestDTO;
import com.example.backend.controller.response.Response;
import com.example.backend.controller.response.ScheduleDetailResponseDTO;
import com.example.backend.controller.response.ScheduleResponseDTO;
import com.example.backend.controller.response.UserLoginResponseDTO;
import com.example.backend.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.Month;
import java.time.YearMonth;

// 개인 스케쥴 관련 api
@RestController
@RequestMapping("/api/schedule/personal")
@RequiredArgsConstructor
public class PersonalScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping("")
    public Response<Void> createSchedule(@RequestBody CreateScheduleRequestDTO requestDTO, HttpSession session){
        UserLoginResponseDTO loginUser = (UserLoginResponseDTO) session.getAttribute("loginUser");
        scheduleService.createPersonalSchedule(requestDTO, loginUser.getUserID());
        return Response.success();
    }

    @GetMapping("")
    public Response<ScheduleResponseDTO> getSchedule(@RequestParam("month") @DateTimeFormat(pattern = "yyyy-MM") YearMonth yearMonth, HttpSession session){
        UserLoginResponseDTO loginUser = (UserLoginResponseDTO) session.getAttribute("loginUser");
        Month month = yearMonth.getMonth();
        int year = yearMonth.getYear();
        return Response.success(scheduleService.getAllSchedule(month, year, loginUser.getUserID()));
    }

    @GetMapping("/{scheduleId}")
    public Response<ScheduleDetailResponseDTO> getScheduleDetail(HttpSession session, @PathVariable Long scheduleId){
        UserLoginResponseDTO loginUser = (UserLoginResponseDTO) session.getAttribute("loginUser");
        return Response.success(scheduleService.getScheduleDetail(loginUser.getUserID(), scheduleId));
    }

    @DeleteMapping("/{scheduleId}")
    public Response<Void> deleteSchedule(@PathVariable Long scheduleId, HttpSession session){
        UserLoginResponseDTO loginUser = (UserLoginResponseDTO) session.getAttribute("loginUser");
        scheduleService.deletePersonalSchedule(scheduleId, loginUser.getUserID());
        return Response.success();
    }

    @PutMapping("/{scheduleId}")
    public Response<Void> modifySchedule(@PathVariable Long scheduleId, HttpSession session, @RequestBody ModifyScheduleRequestDTO requestDTO){
        UserLoginResponseDTO loginUser = (UserLoginResponseDTO) session.getAttribute("loginUser");
        scheduleService.modifyPersonalSchedule(scheduleId, loginUser.getUserID(), requestDTO);
        return Response.success();
    }
}
