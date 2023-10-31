package com.example.backend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserJoinRequestDTO {

    private String userID;
    private String userName;
    private String userPwd;
    private String userType;
}
