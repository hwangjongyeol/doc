package com.skt.tidhub.common.exception;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ApiException {

    private final HttpStatus httpStatus;
    private final String message;

    @Builder
    public ApiException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
