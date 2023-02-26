package com.salomondev.exception.controller;

import com.salomondev.exception.ApiRestException;
import com.salomondev.exception.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    /**
     * Handle ApiException
     *
     * @param ex ApiRestException
     * @return ResponseEntity<ErrorDto>
     * @author Joan Nieto
     */
    @ExceptionHandler(ApiRestException.class)
    public ResponseEntity<ErrorDto> handleGeneralException(ApiRestException ex) {
        return ResponseEntity.status(ex.getStatus()).body(ErrorDto.builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .build());
    }

    /**
     * Handle MissingServletRequestParameterException
     *
     * @param ex MissingServletRequestParameterException
     * @return ResponseEntity<ErrorDto>
     * @author Joan Nieto
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorDto> handleMissingParams(MissingServletRequestParameterException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorDto.builder()
                .code("400")
                .message("Missing parameter: " + ex.getParameterName())
                .build());
    }

    /**
     * Handle Other Exceptions
     *
     * @param ex Exception
     * @return ResponseEntity<ErrorDto>
     * @author Joan Nieto
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorDto.builder()
                .code("500")
                .message(ex.getMessage())
                .build());
    }
}
