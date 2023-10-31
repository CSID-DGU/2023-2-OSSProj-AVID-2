package com.example.backend.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserHomeResponseDTO {
    private String userID;
    private String userName;
    private String userType;
}
