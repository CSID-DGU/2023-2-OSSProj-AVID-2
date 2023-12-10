package com.example.backend.controller;

import com.example.backend.controller.request.CreateScheduleRequestDTO;
import com.example.backend.controller.request.ModifyScheduleRequestDTO;
import com.example.backend.controller.response.Response;
import com.example.backend.controller.response.ScheduleDetailResponseDTO;
import com.example.backend.controller.response.ScheduleTeamResponseDTO;
import com.example.backend.entity.TeamScheduleEntity;
import com.example.backend.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.util.List;

// 팀 스케줄 관련 api
@RestController
@RequestMapping("/api/schedule/team")
@RequiredArgsConstructor
public class TeamScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping("/{teamId}/create")
    public Response<Void> createSchedule(@RequestBody CreateScheduleRequestDTO requestDTO, @PathVariable Long teamId) throws NotFoundException {
        scheduleService.createTeamSchedule(requestDTO, teamId);
        return Response.success();
    }

    @DeleteMapping("/{scheduleId}")
    public Response<Void> deleteSchedule(@PathVariable Long scheduleId, @PathVariable Long teamId) throws NotFoundException {
        scheduleService.deleteTeamSchedule(scheduleId, teamId);
        return Response.success();
    }

    @PutMapping("/{scheduleId}")
    public Response<Void> modifySchedule(@PathVariable Long scheduleId, @PathVariable Long teamId, @RequestBody ModifyScheduleRequestDTO requestDTO) throws NotFoundException {
        scheduleService.modifyTeamSchedule(scheduleId, teamId, requestDTO);
        return Response.success();
    }

    @GetMapping("/{teamId}/list")
    public Response<ScheduleTeamResponseDTO> getSchedule(@RequestParam("month") @DateTimeFormat(pattern = "yyyy-MM") YearMonth yearMonth, @PathVariable Long teamId) throws NotFoundException {
        Month month = yearMonth.getMonth();
        int year = yearMonth.getYear();
        return Response.success(scheduleService.getTeamSchedule(month, year, teamId));
    }

    @GetMapping("/{scheduleId}")
    public Response<ScheduleDetailResponseDTO> getScheduleDetail(@PathVariable Long teamId, @PathVariable Long scheduleId) throws NotFoundException {
        return Response.success(scheduleService.getTeamDetail(teamId, scheduleId));
    }

    // 투두 반환
    @Transactional
    @GetMapping("/Todolist")
    public List<TeamScheduleEntity> getToDoList(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        return scheduleService.getToDoList(date);
    }
}
