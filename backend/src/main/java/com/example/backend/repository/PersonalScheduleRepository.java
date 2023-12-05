package com.example.backend.repository;

import com.example.backend.entity.PersonalScheduleEntity;
import com.example.backend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonalScheduleRepository extends JpaRepository<PersonalScheduleEntity, Long> {
    Optional<PersonalScheduleEntity> findByIdAndUser(Long id, UserEntity user);
}
