package com.example.backend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddUserToTeamRequestDTO {
    private Long userId;
    private Long teamId;
    private Long subjectId;
}