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
    private String sessionId;

    public UserLoginResponseDTO(String userID, String userName, String userType) {
        this.userID = userID;
        this.userName = userName;
        this.userType = userType;
        this.sessionId = UUID.randomUUID().toString();
    }
}
