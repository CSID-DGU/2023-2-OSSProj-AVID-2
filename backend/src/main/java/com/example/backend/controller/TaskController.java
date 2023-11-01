package com.example.backend.controller;


import com.example.backend.controller.request.CreateScheduleRequestDTO;
import com.example.backend.controller.request.TaskRequestDTO;
import com.example.backend.controller.response.Response;
import com.example.backend.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

// 과제 일정 api
@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class TaskController {
    private final ScheduleService scheduleService;

    @PostMapping("/task")
    public Response<Void> createSubjectSchedule(@RequestBody TaskRequestDTO requestDTO, Authentication authentication){
        scheduleService.createTask(requestDTO, authentication.getName());
        return Response.success();
    }

    @PutMapping("/task/{scheduleId}")
    public Response<Void> modifySubjectSchedule(@RequestBody TaskRequestDTO requestDTO, @PathVariable Long scheduleId, Authentication authentication){
        scheduleService.modifyTask(requestDTO, scheduleId,authentication.getName());
        return Response.success();
    }

    @DeleteMapping("/task/{scheduleId}")
    public Response<Void> deleteSubjectSchedule(@PathVariable Long scheduleId,Authentication authentication){
        scheduleService.deleteTask(scheduleId,authentication.getName());
        return Response.success();
    }
}
