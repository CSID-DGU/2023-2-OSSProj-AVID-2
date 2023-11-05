package com.example.backend.controller;


import com.example.backend.controller.request.CreateScheduleRequestDTO;
import com.example.backend.controller.request.TaskRequestDTO;
import com.example.backend.controller.response.EclassResponseDTO;
import com.example.backend.controller.response.Response;
import com.example.backend.controller.response.TaskDetailResponseDTO;
import com.example.backend.service.ScheduleService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 과제 일정 api
@RestController
@RequestMapping("/schedule/task")
@RequiredArgsConstructor
public class TaskController {
    private final ScheduleService scheduleService;

    @PostMapping("")
    public Response<Void> createTask(@RequestBody TaskRequestDTO requestDTO, Authentication authentication){
        scheduleService.writeTask(requestDTO, authentication.getName());
        return Response.success();
    }

    @PutMapping("/{scheduleId}")
    public Response<Void> modifyTask(@RequestBody TaskRequestDTO requestDTO, @PathVariable Long scheduleId, Authentication authentication){
        scheduleService.modifyTask(requestDTO, scheduleId,authentication.getName());
        return Response.success();
    }

    @DeleteMapping("/{scheduleId}")
    public Response<Void> deleteTask(@PathVariable Long scheduleId,Authentication authentication){
        scheduleService.deleteTask(scheduleId,authentication.getName());
        return Response.success();
    }

    @GetMapping("")
    public Response<List<EclassResponseDTO>> getSchedule(@RequestParam("subjectName") String subjectName, Authentication authentication) {
        return Response.success(scheduleService.getTask(authentication.getName(), subjectName));
    }

    @GetMapping("/{scheduleId}")
    public Response<TaskDetailResponseDTO> getScheduleDetail(@PathVariable Long scheduleId, Authentication authentication){
        return Response.success(scheduleService.getTaskDetail(authentication.getName(), scheduleId));
    }
}
