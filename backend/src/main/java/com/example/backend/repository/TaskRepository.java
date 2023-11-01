package com.example.backend.repository;

import com.example.backend.entity.TaskEntity;
import com.example.backend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    List<TaskEntity> findAllByUserAndStartDateGreaterThanOrderByStartDateAsc(UserEntity user, LocalDateTime standard);

    Optional<TaskEntity> findByUserAndId(UserEntity user, Long scheduleId);

    @Query(value = "select e from TaskEntity e where e.user = :user and e.startDate > :now and e.scheduleType = 'TASK' order by e.startDate asc")
    List<TaskEntity> findTaskToDoList(@Param("user") UserEntity user, @Param("now")LocalDateTime now);
}
