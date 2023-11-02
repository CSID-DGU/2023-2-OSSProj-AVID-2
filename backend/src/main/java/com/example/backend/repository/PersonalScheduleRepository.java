package com.example.backend.repository;

import com.example.backend.entity.PersonalScheduleEntity;
import com.example.backend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PersonalScheduleRepository extends JpaRepository<PersonalScheduleEntity, Long> {
    @Query(value = "select e from PersonalScheduleEntity e where e.user = :user and e.startDate > :now order by e.startDate asc")
    List<PersonalScheduleEntity> findAllByUserAndStartDateGreaterThanOrderByStartDateAsc(@Param("user") UserEntity user, @Param("now") LocalDateTime now);

    @Query(value = "select e from PersonalScheduleEntity e where e.user = :user and e.startDate > :now and e.scheduleType = 'TASK' order by e.startDate asc")
    List<PersonalScheduleEntity> findPersonalToDoList(@Param("user") UserEntity user, @Param("now") LocalDateTime now);

    Optional<PersonalScheduleEntity> findByIdAndUser(Long id, UserEntity user);
}
