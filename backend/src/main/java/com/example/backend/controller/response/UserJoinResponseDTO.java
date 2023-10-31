package com.example.backend.controller.response;

import com.example.backend.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserJoinResponseDTO {

    private String userNum;
    private String userPwd;
    private String userType;

    public static UserJoinResponseDTO toUserJoinResponse(UserEntity user) {
        return new UserJoinResponseDTO(
                user.getUserNum(),
                user.getUserName(),
                user.getUserType().name()
        );
    }
}
