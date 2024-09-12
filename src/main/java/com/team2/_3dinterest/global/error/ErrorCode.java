package com.team2._3dinterest.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    DUPLICATE_SUMMONER_NAME(HttpStatus.CONFLICT, "C001", "DUPLICATE_SUMMONER_NAME"),
    POSITION_NOT_FOUND(HttpStatus.NOT_FOUND, "C002", "POSITION_NOT_FOUND"),
    EXIST_TEAM(HttpStatus.CONFLICT, "C003", "EXIST_TEAM"),
    FILE_SIZE_EXCEED(HttpStatus.BAD_REQUEST, "C004", "FILE_SIZE_EXCEED"); // 파일 크기 초과

    private final HttpStatus status;
    private final String code;
    private final String message;
}
