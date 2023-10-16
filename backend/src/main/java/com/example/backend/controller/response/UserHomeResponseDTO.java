package com.example.backend.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserHomeResponseDTO {
    private String userNum;
    private String userName;
    private String userType;
}
