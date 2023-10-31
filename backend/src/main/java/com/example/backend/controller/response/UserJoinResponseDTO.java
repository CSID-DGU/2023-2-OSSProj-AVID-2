package com.example.backend.controller.response;

import com.example.backend.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserJoinResponseDTO {

    private String userID;
    private String userName;
    private String userType;

    public static UserJoinResponseDTO toUserJoinResponse(UserEntity user) {
        return new UserJoinResponseDTO(
                user.getUserID(),
                user.getUserName(),
                user.getUserType().name()
        );
    }
}
