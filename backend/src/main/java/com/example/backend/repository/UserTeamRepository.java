package com.example.backend.repository;

import com.example.backend.entity.TeamEntity;
import com.example.backend.entity.UserTeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTeamRepository extends JpaRepository<UserTeamEntity, Long> {
    List<UserTeamEntity> findAllByTeam(TeamEntity team);
}
