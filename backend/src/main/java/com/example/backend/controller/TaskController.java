package com.example.backend.controller;


import com.example.backend.controller.request.TaskRequestDTO;
import com.example.backend.controller.response.EclassResponseDTO;
import com.example.backend.controller.response.Response;
import com.example.backend.controller.response.TaskDetailResponseDTO;
import com.example.backend.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 과제 일정 api
@RestController
@RequestMapping("/api/schedule/task")
@RequiredArgsConstructor
public class TaskController {
    private final ScheduleService scheduleService;

    @PostMapping("")
    public Response<Void> createTask(@RequestBody TaskRequestDTO requestDTO){

        String userID = "2019111602";
        scheduleService.writeTask(requestDTO, userID);

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
