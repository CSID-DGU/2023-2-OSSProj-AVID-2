package com.example.backend.service;

import com.example.backend.controller.request.UserJoinRequestDTO;
import com.example.backend.controller.response.UserHomeResponseDTO;
import com.example.backend.controller.response.UserJoinResponseDTO;

import com.example.backend.entity.UserEntity;
import com.example.backend.model.UserType;
import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public UserJoinResponseDTO join(UserJoinRequestDTO requestDTO) {

        UserEntity user = UserEntity.saveUser(
                requestDTO.getUserNum(),
                requestDTO.getUserName(),
                encoder.encode(requestDTO.getUserPwd()),
                UserType.returnUserType(requestDTO.getUserType()));

        UserJoinResponseDTO result = UserJoinResponseDTO.toUserJoinResponse(userRepository.save(user));

        return result;
    }

    public UserEntity login(String userNum, String userPwd) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserNum(userNum);

        if(!encoder.matches(userPwd, user.getUserPwd())) {
            throw new UsernameNotFoundException("비밀번호가 틀렸습니다.");
        }
        return user;
    }

    public UserHomeResponseDTO getHome(String userNum) {
        UserEntity user = userRepository
                .findByUserNum(userNum);

        return new UserHomeResponseDTO(user.getUserName(), user.getUserNum(), user.getUserType().name());
    }
}
