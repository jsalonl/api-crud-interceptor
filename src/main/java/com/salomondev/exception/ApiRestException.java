package com.salomondev.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ApiRestException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private final String code;
    private final HttpStatus status;
    private final String message;
}
