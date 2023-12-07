package com.example.backend.controller.response;

import com.example.backend.entity.UserSubjectEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UserSubjectResponseDTO {
    private Long userId;
    private List<UserSubjectEntity> userSubjectEntities;
    public static UserSubjectResponseDTO of(Long userId, List<UserSubjectEntity> userSubjectEntities) {
        return new UserSubjectResponseDTO(userId, userSubjectEntities);
    }

}
