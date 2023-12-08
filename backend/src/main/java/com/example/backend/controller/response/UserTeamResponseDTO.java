package com.example.backend.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserTeamResponseDTO {
    private Long userId;
    private Long teamId;
    private String subjectName;

    public static UserTeamResponseDTO of(Long userId, Long teamId, String subjectName) {
        return new UserTeamResponseDTO(userId, teamId, subjectName);
    }
}
