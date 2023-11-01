package com.example.backend.controller.response;

import com.example.backend.entity.UserSubjectEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserSubjectResponseDTO {
    private Long subjectId;
    private String subjectName;

    public static UserSubjectResponseDTO fromUserSubject(UserSubjectEntity userSubject) {
        return new UserSubjectResponseDTO(
                userSubject.getId(),
                userSubject.getSubject().getSubjectName()
        );
    }
}
