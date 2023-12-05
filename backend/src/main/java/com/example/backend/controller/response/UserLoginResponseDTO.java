package com.example.backend.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class UserLoginResponseDTO {

    private String userID;
    private String userName;
    private String userType;
}
