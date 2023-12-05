package com.example.backend.service;

import com.example.backend.entity.*;
import com.example.backend.repository.TeamRepository;
import com.example.backend.repository.UserRepository;
import com.example.backend.repository.UserSubjectRepository;
import com.example.backend.repository.UserTeamRepository;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    @Autowired
    private UserTeamRepository userTeamRepository;

    @Autowired
    private UserSubjectRepository userSubjectRepository;

    private final TeamRepository teamRepository;

    private final UserRepository userRepository;

    // 유저가 수강하는 과목 반환
    public List<String> getSubjectByUserId(Long userId) {
        return userSubjectRepository.findSubjectByUserId(userId);
    }

    // 각 과목을 수강하는 userName 반환
    public List<String> getUserNamesBySubjectId(Long subjectId) {
        return userSubjectRepository.findUserNamesBySubjectId(subjectId);
    }

    // user_id에 해당하는 team의 subject_id로부터 subjectName을 가져오는 메소드
    public String getSubjectNameByUserId(Long userId) {
        return userTeamRepository.findSubjectNameByUserId(userId);
    }

    // team_id에 해당하는 user_id로부터 userID, userName, userMajor를 가져오는 메소드
    public List<String> getUserInfoByTeamId(Long teamId) {
        return userTeamRepository.findUserInfoByTeamId(teamId);
    }

    // 팀 생성
    public TeamEntity createTeam(SubjectEntity subject) {
        TeamEntity team = TeamEntity.builder()
                .subject(subject)
                .build();

        return teamRepository.save(team);
    }

    // 팀원 추가
    public void addUserToTeam(Long userId, Long teamId, Long subjectId) throws NotFoundException {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("유저를 찾을 수 없습니다. ID: " + userId));

        TeamEntity team = teamRepository.findById(teamId)
                .orElseThrow(() -> new NotFoundException("팀을 찾을 수 없습니다. ID: " + teamId));

        // 팀에 유저가 이미 존재하는지 확인
        if (!userTeamRepository.existsByUserAndTeam(user, subjectId)) {
            UserTeamEntity userTeam = UserTeamEntity.builder()
                    .user(user)
                    .team(team)
                    .build();

            userTeamRepository.save(userTeam);
        }
    }
}
