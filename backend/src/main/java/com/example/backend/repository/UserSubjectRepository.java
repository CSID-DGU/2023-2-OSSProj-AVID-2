package com.example.backend.repository;

import com.example.backend.entity.SubjectEntity;
import com.example.backend.entity.UserEntity;
import com.example.backend.entity.UserSubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserSubjectRepository extends JpaRepository<UserSubjectEntity, Long> {
    List<UserSubjectEntity> findAllByUser(UserEntity user);
    Optional<UserSubjectEntity> findByUserAndSubject(UserEntity user, SubjectEntity subject);
    List<UserSubjectEntity> findAllBySubject(SubjectEntity subject);

}
