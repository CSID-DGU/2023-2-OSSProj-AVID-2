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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @PostMapping("/signup")
    public Response<UserJoinResponseDTO> join(@RequestBody UserJoinRequestDTO requestDTO) {
        return Response.success(userService.join(requestDTO));
    }

    @PostMapping("/login")
    public Response<UserLoginResponseDTO> login(@RequestBody UserLoginRequestDTO requestDTO) {
        return Response.success(userService.login(requestDTO.getUserID(), requestDTO.getUserPwd()));

    }

    @GetMapping("/home")
    public Response<UserHomeResponseDTO> home(Authentication authentication) {
        return Response.success(userService.getHome(authentication.name()));
    }


}
