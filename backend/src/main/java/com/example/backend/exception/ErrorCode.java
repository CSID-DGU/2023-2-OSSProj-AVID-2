package com.example.backend.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    DUPLICATED_CODE(HttpStatus.CONFLICT, "이미 존재하는 학번 정보입니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "찾으시는 유저가 없습니다."),
    INVALID_LOGIN(HttpStatus.CONFLICT, "다시 로그인을 시도해주세요");

    private HttpStatus status;
    private String message;
}
