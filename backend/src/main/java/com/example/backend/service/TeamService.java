package com.example.backend.service;

import com.example.backend.entity.SubjectEntity;
import com.example.backend.entity.TeamEntity;
import com.example.backend.entity.UserSubjectEntity;
import com.example.backend.entity.UserTeamEntity;
import com.example.backend.repository.UserSubjectRepository;
import com.example.backend.repository.UserTeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// 팀 생성 폼에서 username(외래키 subject_id 마다) 리스트로 받아와서 띄우기
// 팀 생성
// 팀 메모 기능: 이거는 약간 투두처럼 아니면 게시판?
@Service
@RequiredArgsConstructor
public class TeamService {
    private UserSubjectRepository userSubjectRepository;
    private UserTeamRepository userTeamRepository;

    // 각 과목을 수강하는 userName 반환
    public List<String> getUsersBySubject(SubjectEntity subject) {
        List<UserSubjectEntity> userSubjectEntityList = userSubjectRepository.findAllBySubject(subject);

        return userSubjectEntityList.stream()
                .map(userSubjectEntity -> userSubjectEntity.getUser().getUserName())
                .collect(Collectors.toList());
    }

    // 각 team_id를 가지는 userName 반환
    public List<String> getUsersByTeam(TeamEntity team) {
        List<UserTeamEntity> userTeamEntityList = userTeamRepository.findAllByTeam(team);

        return userTeamEntityList.stream()
                .map(userTeamEntity -> userTeamEntity.getUser().getUserName())
                .collect(Collectors.toList());
    }
}
