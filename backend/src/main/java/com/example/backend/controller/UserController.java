package com.example.backend.controller;

import com.example.backend.controller.request.UserJoinRequestDTO;
import com.example.backend.controller.request.UserLoginRequestDTO;
import com.example.backend.controller.request.UserSubjectRequestDTO;
import com.example.backend.controller.response.*;
import com.example.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @PostMapping("/signup")
    public Response<UserJoinResponseDTO> join(@RequestBody UserJoinRequestDTO requestDTO) {
        return Response.success(userService.join(requestDTO));
    }

    @PostMapping("/login")
    public UserLoginResponseDTO login(@RequestBody UserLoginRequestDTO requestDTO, HttpSession session) {
        UserLoginResponseDTO responseDTO = userService.login(requestDTO.getUserID(), requestDTO.getUserPwd());

        // 로그인 성공 시 세션에 사용자 정보 저장
        session.setAttribute("loginUser", responseDTO);

        return responseDTO;
    }

    @PostMapping("/logout")
    public Response<Void> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        return Response.success();
    }

    @GetMapping("/home")
    public Response<UserHomeResponseDTO> home(HttpSession session) {
        // 세션에서 로그인 정보 읽어오기
        UserLoginResponseDTO loginUser = (UserLoginResponseDTO) session.getAttribute("loginUser");

        if (loginUser == null) {
           return null;
        }

        // 로그인 정보가 있다면 처리 결과와 홈 페이지 URL을 응답으로 전송
        return Response.success(new UserHomeResponseDTO(loginUser.getUserID(), loginUser.getUserName(), loginUser.getUserType()));
    }

    @PostMapping("/subjects")
    public Response<UserSubjectResponseDTO> setSubjects(@RequestBody UserSubjectRequestDTO requestDTO, HttpSession session) {
        UserLoginResponseDTO loginUser = (UserLoginResponseDTO) session.getAttribute("loginUser");
        if (loginUser == null) {
            return null;
        }
        UserSubjectResponseDTO responseDTO = userService.setSubjects(loginUser, requestDTO);
        return Response.success(responseDTO);
    }

    @GetMapping("/subjects")
    public Response<List<String>> getSubjectNames(HttpSession session) {
        UserLoginResponseDTO loginUser = (UserLoginResponseDTO) session.getAttribute("loginUser");
        if (loginUser == null) {
            return null;
        }

        List<String> subjectNames = userService.getSubjectNames(loginUser);
        return Response.success(subjectNames);
    }
}
