package com.example.backend.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    DUPLICATED_CODE(HttpStatus.CONFLICT, "이미 존재하는 학번 정보입니다."),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "잘못된 토큰입니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "찾으시는 유저가 없습니다."),
    INVALID_LOGIN(HttpStatus.CONFLICT, "다시 로그인을 시도해주세요"),
    SUBJECT_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 과목을 찾을 수 없습니다."),
    USER_NOT_AUTHORIZED(HttpStatus.UNAUTHORIZED,"교수만 가능한 작업입니다." ),
    SCHEDULE_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 일정을 찾을 수 없습니다."),
    SCHEDULE_TYPE_PROBLEM(HttpStatus.CONFLICT, "스케쥴이 잘못 기록되었습니다."),
    INVALID_SCHEDULE(HttpStatus.BAD_REQUEST, "해당 일정으로는 요청하신 내용을 처리할 수 없습니다."),
    SUBJECT_NOT_FOUND_IN_USER_SUBJECT(HttpStatus.NOT_FOUND, "해당 과목을 수강하지 않았습니다."),
    TEAM_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 팀을 찾을 수 없습니다.");

    private HttpStatus status;
    private String message;
}
