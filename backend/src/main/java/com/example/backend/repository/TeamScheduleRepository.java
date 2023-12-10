package com.example.backend.repository;

import com.example.backend.entity.TeamEntity;
import com.example.backend.entity.TeamScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TeamScheduleRepository extends JpaRepository<TeamScheduleEntity, Long> {
    Optional<TeamScheduleEntity> findByIdAndTeam(Long id, TeamEntity team);

    @Query("SELECT ts FROM TeamScheduleEntity ts WHERE ts.startDate <= :date AND ts.endDate >= :date")
    List<TeamScheduleEntity> findByDate(@Param("date") LocalDateTime date);

}
