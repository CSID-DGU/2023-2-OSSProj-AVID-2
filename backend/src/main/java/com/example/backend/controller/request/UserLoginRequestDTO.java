package com.example.backend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserLoginRequestDTO {

    private String userNum;
    private String userPwd;
}
