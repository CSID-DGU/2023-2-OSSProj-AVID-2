package com.example.backend.repository;

import com.example.backend.entity.ScheduleEntity;
import com.example.backend.entity.TaskEntity;
import com.example.backend.entity.UserEntity;
import com.example.backend.entity.UserTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserTaskRepository extends JpaRepository<UserTaskEntity, Long> {
    Optional<UserTaskEntity> findByScheduleAndUser(TaskEntity schedule, UserEntity user);
    void deleteAllBySchedule(ScheduleEntity schedule);
}
