package com.example.backend.repository;

import com.example.backend.entity.SubjectEntity;
import com.example.backend.entity.UserEntity;
import com.example.backend.entity.UserSubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UserSubjectRepository extends JpaRepository<UserSubjectEntity, Long> {
    List<UserSubjectEntity> findAllByUser(UserEntity user);
    Optional<UserSubjectEntity> findByUserAndSubject(UserEntity user, SubjectEntity subject);
    List<UserSubjectEntity> findAllBySubject(SubjectEntity subject);

    @Query("SELECT us.user.userName FROM UserSubjectEntity us WHERE us.subject.id = :subjectId")
    List<String> findUserNamesBySubjectId(@Param("subjectId") Long subjectId);

    @Query("SELECT us.subject.subjectName FROM UserSubjectEntity us WHERE us.user.id = :userId")
    List<String> findSubjectByUserId(@Param("userId") Long userId);

}
