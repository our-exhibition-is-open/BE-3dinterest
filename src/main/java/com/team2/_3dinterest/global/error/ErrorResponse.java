package com.team2._3dinterest.global.error;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
@NoArgsConstructor
public class ErrorResponse {
    private HttpStatus status;
    private String code;
    private String message;

    @Builder
    public ErrorResponse(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}