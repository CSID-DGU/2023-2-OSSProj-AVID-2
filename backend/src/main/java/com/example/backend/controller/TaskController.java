package com.example.backend.controller;


import com.example.backend.controller.request.TaskRequestDTO;
import com.example.backend.controller.response.EclassResponseDTO;
import com.example.backend.controller.response.Response;
import com.example.backend.controller.response.TaskDetailResponseDTO;
import com.example.backend.controller.response.UserLoginResponseDTO;
import com.example.backend.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

// 과제 일정 api
@RestController
@RequestMapping("/api/schedule/task")
@RequiredArgsConstructor
public class TaskController {
    private final ScheduleService scheduleService;

    @PostMapping("")
    public Response<Void> createTask(@RequestBody TaskRequestDTO requestDTO, HttpSession session){
        UserLoginResponseDTO loginUser = (UserLoginResponseDTO) session.getAttribute("loginUser");
        scheduleService.writeTask(requestDTO, loginUser.getUserID());

        return Response.success();
    }

    @GetMapping("")
    public Response<List<EclassResponseDTO>> getSchedule(@RequestParam("subjectName") String subjectName, HttpSession session) {
        UserLoginResponseDTO loginUser = (UserLoginResponseDTO) session.getAttribute("loginUser");
        return Response.success(scheduleService.getTask(loginUser.getUserID(), subjectName));
    }

    @GetMapping("/{scheduleId}")
    public Response<TaskDetailResponseDTO> getScheduleDetail(@PathVariable Long scheduleId, HttpSession session){
        UserLoginResponseDTO loginUser = (UserLoginResponseDTO) session.getAttribute("loginUser");
        return Response.success(scheduleService.getTaskDetail(loginUser.getUserID(), scheduleId));
    }
}
