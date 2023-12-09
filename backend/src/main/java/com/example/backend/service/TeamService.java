package com.example.backend.service;

import com.example.backend.controller.request.CreateTeamRequestDTO;
import com.example.backend.controller.response.UserLoginResponseDTO;
import com.example.backend.controller.response.UserTeamResponseDTO;
import com.example.backend.entity.SubjectEntity;
import com.example.backend.entity.TeamEntity;
import com.example.backend.entity.UserEntity;
import com.example.backend.entity.UserTeamEntity;
import com.example.backend.exception.ErrorCode;
import com.example.backend.exception.Exception;
import com.example.backend.repository.*;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    private final SubjectRepository subjectRepository;
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

    // 팀 생성 보완(유저 추가)
    public TeamEntity createTeamAndAddUser(CreateTeamRequestDTO requestDTO, UserEntity user) {
        //과목 정보 가져오기
        SubjectEntity subject = subjectRepository
                .findById(requestDTO.getSubjectId())
                .orElseThrow(() -> new Exception(ErrorCode.SUBJECT_NOT_FOUND));

        if(userTeamRepository.existsByUserAndSubject(user, subject)) {
            throw new Exception(ErrorCode.DUPLICATED_CODE, String.format("이미 해당 과목의 팀이 존재합니다. (%s)", subject.getSubjectName()));
        }

        // 팀 생성
        TeamEntity team = TeamEntity.builder()
                .subject(subject)
                .build();
        TeamEntity savedTeam = teamRepository.save(team);

        // 팀에 유저 추가
        UserTeamEntity userTeam = UserTeamEntity.builder()
                .user(user)
                .team(savedTeam)
                .subject(subject)
                .build();
        userTeamRepository.save(userTeam);

        return savedTeam;
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

    @Transactional
    public List<UserTeamResponseDTO> getTeamList(UserLoginResponseDTO loginUser) {
        UserEntity user = userRepository
                .findByUserID(loginUser.getUserID())
                .orElseThrow(() -> new UsernameNotFoundException("유저를 찾을 수 없습니다. ID: " + loginUser.getUserID()));

        List<UserTeamEntity> userTeamEntities = userTeamRepository.findByUser(user);

        List<UserTeamResponseDTO> responseDTOs = new ArrayList<>();

        for (UserTeamEntity userTeamEntity : userTeamEntities) {
            UserTeamResponseDTO responseDTO = UserTeamResponseDTO.of(
                    user.getId(),
                    userTeamEntity.getTeam().getId(),  // Assuming there is a getTeam() method in UserTeamEntity
                    userTeamEntity.getTeam().getSubject().getSubjectName()  // Assuming there is a getSubject() method in TeamEntity
            );
            responseDTOs.add(responseDTO);
        }

        return responseDTOs;
    }
}
