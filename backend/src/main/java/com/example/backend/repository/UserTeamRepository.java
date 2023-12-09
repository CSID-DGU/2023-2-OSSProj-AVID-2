package com.example.backend.repository;

import com.example.backend.entity.SubjectEntity;
import com.example.backend.entity.TeamEntity;
import com.example.backend.entity.UserEntity;
import com.example.backend.entity.UserTeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserTeamRepository extends JpaRepository<UserTeamEntity, Long> {
    List<UserTeamEntity> findAllByTeam(TeamEntity team);
    List<UserTeamEntity> findByTeam(TeamEntity team);

    @Query("SELECT t.team.subject.subjectName FROM UserTeamEntity t WHERE t.user.id = :userId")
    String findSubjectNameByUserId(@Param("userId") Long userId);

    @Query("SELECT CONCAT(u.userID, ', ', u.userName, ', ', u.userMajor) FROM UserTeamEntity t JOIN t.user u WHERE t.team.id = :teamId")
    List<String> findUserInfoByTeamId(@Param("teamId") Long teamId);

    boolean existsByUserAndTeam(UserEntity user, TeamEntity team);

    boolean existsByUserAndSubject(UserEntity user, SubjectEntity subject);

    List<UserTeamEntity> findByUser(UserEntity user);

    Optional<UserTeamEntity> findByUserAndTeamAndSubject(UserEntity user, TeamEntity team, SubjectEntity subject);

}
