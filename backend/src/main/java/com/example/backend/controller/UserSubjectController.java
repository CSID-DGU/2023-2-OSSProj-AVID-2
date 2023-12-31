package com.example.backend.controller;

import com.example.backend.controller.request.UserSubjectRequestDTO;
import com.example.backend.controller.response.*;
import com.example.backend.entity.SubjectEntity;
import com.example.backend.exception.ErrorCode;
import com.example.backend.exception.Exception;
import com.example.backend.repository.SubjectRepository;
import com.example.backend.service.UserSubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user-subjects")
@RequiredArgsConstructor
public class UserSubjectController {

    @Autowired
    private final UserSubjectService userSubjectService;
    private final SubjectRepository subjectRepository;

    @PostMapping
    public Response<UserSubjectResponseDTO> setSubjects(@RequestBody UserSubjectRequestDTO requestDTO, HttpSession session) {
        UserLoginResponseDTO loginUser = (UserLoginResponseDTO) session.getAttribute("loginUser");
        if (loginUser == null) {
            return null;
        }
        UserSubjectResponseDTO responseDTO = userSubjectService.setSubjects(loginUser, requestDTO);
        return Response.success(responseDTO);
    }

    @GetMapping
    public Response<List<SubjectResponseDTO>> getSubjectNames(HttpSession session) {
        UserLoginResponseDTO loginUser = (UserLoginResponseDTO) session.getAttribute("loginUser");
        if (loginUser == null) {
            return null;
        }

        List<SubjectResponseDTO> subjectNames = userSubjectService.getSubjectNames(loginUser);
        return Response.success(subjectNames);
    }

    @GetMapping("/{subjectId}/students")
    public Response<List<SubjectUsersResponseDTO>> getStudentsInSameSubject(@PathVariable Long subjectId) {
        SubjectEntity subject = subjectRepository
                .findById(subjectId)
                .orElseThrow(() -> new Exception(ErrorCode.SUBJECT_NOT_FOUND));

        List<SubjectUsersResponseDTO> students = userSubjectService.getStudentsInSameSubject(subject)
                .stream()
                .map(SubjectUsersResponseDTO::of)
                .distinct()
                .collect(Collectors.toList());

        return Response.success(students);
    }
}
