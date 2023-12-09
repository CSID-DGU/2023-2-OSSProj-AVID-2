package com.example.backend.controller.response;

import com.example.backend.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SubjectUsersResponseDTO {
    private Long userID;
    private String username;

    public static SubjectUsersResponseDTO of(UserEntity userEntity) {
        return new SubjectUsersResponseDTO(userEntity.getId(), userEntity.getUserName());
    }
}
