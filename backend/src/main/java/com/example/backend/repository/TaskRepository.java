package com.example.backend.repository;

import com.example.backend.entity.SubjectEntity;
import com.example.backend.entity.TaskEntity;
import com.example.backend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    Optional<TaskEntity> findByUserAndId(UserEntity user, Long id);

    List<TaskEntity> findAllBySubject(SubjectEntity subject);
    @Query(value = "select e from TaskEntity e where e.subject = :subject and e.startDate > :now order by e.startDate asc")
    List<TaskEntity> findAllBySubjectAndStartDateGreaterThanOrderByStartDateAsc(@Param("subject") SubjectEntity subject, @Param("now") LocalDateTime now);

    @Query(value = "select e from TaskEntity e where e.subject = :subject and e.startDate > :now and e.taskType = 'ASSIGNMENT' order by e.startDate asc")
    List<TaskEntity> findOfficialToDoList(SubjectEntity subject, LocalDateTime now);
}
