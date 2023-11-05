package com.example.backend.controller;

import com.example.backend.controller.request.UserJoinRequestDTO;
import com.example.backend.controller.request.UserLoginRequestDTO;
import com.example.backend.controller.response.Response;
import com.example.backend.controller.response.UserHomeResponseDTO;
import com.example.backend.controller.response.UserJoinResponseDTO;
import com.example.backend.controller.response.UserLoginResponseDTO;
import com.example.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public UserLoginResponseDTO login(@RequestBody UserLoginRequestDTO requestDTO) {

        // UserLoginResponseDTO를 사용하여 응답 생성
        UserLoginResponseDTO responseDTO = userService.login(requestDTO.getUserID(), requestDTO.getUserPwd());

        return responseDTO;
    }
    @GetMapping("/home")
    public Response<UserHomeResponseDTO> home(Authentication authentication) {
        return Response.success(userService.getHome(authentication.name()));
    }


}
