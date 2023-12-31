package com.example.backend.service;

import com.example.backend.controller.request.UserJoinRequestDTO;
import com.example.backend.controller.request.UserSubjectRequestDTO;
import com.example.backend.controller.response.UserHomeResponseDTO;
import com.example.backend.controller.response.UserJoinResponseDTO;
import com.example.backend.controller.response.UserLoginResponseDTO;
import com.example.backend.controller.response.UserSubjectResponseDTO;
import com.example.backend.entity.SubjectEntity;
import com.example.backend.entity.UserEntity;
import com.example.backend.entity.UserSubjectEntity;
import com.example.backend.exception.ErrorCode;
import com.example.backend.exception.Exception;
import com.example.backend.model.UserType;
import com.example.backend.repository.SubjectRepository;
import com.example.backend.repository.UserRepository;
import com.example.backend.repository.UserSubjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final SubjectRepository subjectRepository;
    private final UserSubjectRepository userSubjectRepository;

    @Override
    public UserDetails loadUserByUsername(String userID) throws UsernameNotFoundException {
        UserEntity userentity = userRepository.findByUserID(userID)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with userID: " + userID));

        return new User(userID, userentity.getUserPwd(), Collections.singleton(new SimpleGrantedAuthority("USER")));
    }
    public UserJoinResponseDTO join(UserJoinRequestDTO requestDTO) {
        userRepository.findByUserID(requestDTO.getUserID())
                .ifPresent(user -> {
                    throw new Exception(ErrorCode.DUPLICATED_CODE, String.format("이미 존재하는 학번 정보입니다. (%s)", user.getUserID()));
                });

        UserEntity user = UserEntity.save(
                requestDTO.getUserID(),
                encoder.encode(requestDTO.getUserPwd()),
                requestDTO.getUserName(),
                requestDTO.getUserMajor(),
                UserType.returnUserType(requestDTO.getUserType()));

        UserJoinResponseDTO result;
        result = UserJoinResponseDTO.toUserJoinResponse(userRepository.save(user));

        return result;
    }

    public UserLoginResponseDTO login(String userID, String userPwd) {

        UserEntity user = userRepository
                .findByUserID(userID)
                .orElseThrow(()-> new Exception(ErrorCode.INVALID_LOGIN));

        if(!encoder.matches(userPwd, user.getUserPwd())) {
            throw new Exception (ErrorCode.INVALID_LOGIN);
        }


        return new UserLoginResponseDTO(user.getUserID(), user.getUserName(), user.getUserType().name());
    }

    public UserHomeResponseDTO getHome(String userID) {
        UserEntity user = userRepository
                .findByUserID(userID)
                .orElseThrow(()-> new Exception(ErrorCode.INVALID_LOGIN));

        return new UserHomeResponseDTO(user.getUserID(), user.getUserName(), user.getUserType().name());
    }

    public UserSubjectResponseDTO setSubjects(UserLoginResponseDTO loginUser, UserSubjectRequestDTO requestDTO) {
        UserEntity user = userRepository
                .findByUserID(loginUser.getUserID())
                .orElseThrow(() -> new Exception(ErrorCode.INVALID_LOGIN));

        List<Long> subjectIds = requestDTO.getId();

        for (Long subjectId : subjectIds) {
            // 해당 강의 ID로 SubjectEntity를 찾고, 없으면 예외 발생
            SubjectEntity subject = subjectRepository
                    .findById(subjectId)
                    .orElseThrow(() -> new Exception(ErrorCode.SUBJECT_NOT_FOUND));

            // 사용자가 이미 수강 중인 과목인지 확인
            userSubjectRepository.findByUserAndSubject(user, subject)
                    .ifPresent(userSubjectEntity -> {
                        throw new Exception(ErrorCode.DUPLICATED_CODE, String.format("이미 수강 중인 과목입니다. (%s)", userSubjectEntity.getSubject().getSubjectName()));
                    });

            // UserSubjectEntity 객체 생성
            UserSubjectEntity userSubjectEntity = UserSubjectEntity.fromUserSubject(user, subject);

            // userSubjectRepository에 저장
            userSubjectRepository.save(userSubjectEntity);
        }
        return UserSubjectResponseDTO.of(user.getId(), userSubjectRepository.findByUser(user));
    }

    public List<String> getSubjectNames(UserLoginResponseDTO loginUser) {
        UserEntity user = userRepository
                .findByUserID(loginUser.getUserID())
                .orElseThrow(() -> new Exception(ErrorCode.INVALID_LOGIN));

        UserSubjectResponseDTO responseDTO = UserSubjectResponseDTO.of(user.getId(), userSubjectRepository.findByUser(user));
        return responseDTO.getSubjectNames();
    }
}
