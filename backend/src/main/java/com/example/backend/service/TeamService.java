package com.example.backend.service;

import com.example.backend.entity.*;
import com.example.backend.exception.ErrorCode;
import com.example.backend.repository.TeamRepository;
import com.example.backend.repository.UserRepository;
import com.example.backend.repository.UserSubjectRepository;
import com.example.backend.repository.UserTeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.backend.exception.ErrorCode.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class TeamService {

    @Autowired
    private UserTeamRepository userTeamRepository;

    @Autowired
    private UserSubjectRepository userSubjectRepository;

    // 각 과목을 수강하는 userName 반환
    public List<String> getUserNamesBySubjectId(Long subjectId) {
        return userSubjectRepository.findUserNamesBySubjectId(subjectId);
    }

    // 각 team_id를 가지는 userName 반환
    public List<String> getUsersByTeam(TeamEntity team) {
        List<UserTeamEntity> userTeamEntityList = userTeamRepository.findAllByTeam(team);

        return userTeamEntityList.stream()
                .map(userTeamEntity -> userTeamEntity.getUser().getUserName())
                .collect(Collectors.toList());
    }

    // user_id에 해당하는 team의 subject_id로부터 subjectName을 가져오는 메소드
    public String getSubjectNameByUserId(Long userId) {
        return userTeamRepository.findSubjectNameByUserId(userId);
    }

    // team_id에 해당하는 user_id로부터 userID, userName, userMajor를 가져오는 메소드
    public List<String> getUserInfoByTeamId(Long teamId) {
        return userTeamRepository.findUserInfoByTeamId(teamId);
    }
}
