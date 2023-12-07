package com.example.backend.controller.response;

import com.example.backend.entity.SubjectEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SubjectResponseDTO {
    Long id;
    String subjectName;
    String professor;

    public SubjectResponseDTO(SubjectEntity subjectEntity) {
        this.id = subjectEntity.getId();
        this.subjectName = subjectEntity.getSubjectName();
        this.professor = subjectEntity.getProfessor();

    }

}
