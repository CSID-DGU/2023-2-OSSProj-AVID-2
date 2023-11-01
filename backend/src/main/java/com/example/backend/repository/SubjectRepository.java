package com.example.backend.repository;

import com.example.backend.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
    Optional<SubjectEntity> findBySubjectName(String subjectName);
}
