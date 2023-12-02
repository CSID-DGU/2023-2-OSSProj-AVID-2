package com.example.backend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserSubjectRequestDTO {
    private String userID;
    private String subjectID;
}
