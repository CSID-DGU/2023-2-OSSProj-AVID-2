package com.example.backend.repository;

import com.example.backend.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {
    @Query(value = "select schedule from schedule where id = :scheduleId", nativeQuery = true)
    String findScheduleType(Long scheduleId);
}
