package com.example.backend.controller.response;

import com.example.backend.entity.UserSubjectEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class UserSubjectResponseDTO {
    private Long userId;
    private List<UserSubjectEntity> userSubjectEntities;
    public static UserSubjectResponseDTO of(Long userId, List<UserSubjectEntity> userSubjectEntities) {
        return new UserSubjectResponseDTO(userId, userSubjectEntities);
    }

    public List<String> getSubjectNames() {
        return userSubjectEntities.stream()
                .map(userSubjectEntity -> userSubjectEntity.getSubject().getSubjectName())
                .collect(Collectors.toList());
    }

}
