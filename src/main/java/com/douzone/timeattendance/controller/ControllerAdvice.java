package com.douzone.timeattendance.controller;

import com.douzone.timeattendance.dto.ErrorResponse;
import com.douzone.timeattendance.exception.TimeAttendanceException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    /**
     * 유효성 검증에 실패한 예외를 처리합니다.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> invalidRequestHandler(MethodArgumentNotValidException e) {
        ErrorResponse response = ErrorResponse.builder()
                                              .code("400")
                                              .message("잘못된 요청입니다.")
                                              .build();

        //유효성 검증에 실패한 필드와 오류 메시지를 응답 객체에 담음
        for (FieldError fieldError : e.getFieldErrors()) {
            response.addErrors(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity.badRequest()
                             .body(response);
    }

    /**
     * 공통 예외 처리
     * RuntimeException을 상속받은 공통 예외 객체와 그 자식 객체들의 예외를 처리합니다.
     */
    @ExceptionHandler(TimeAttendanceException.class)
    public ResponseEntity<ErrorResponse> timeAttendanceException(TimeAttendanceException e) {
        ErrorResponse response = ErrorResponse.builder()
                                              .code(String.valueOf(e.getStatusCode()))
                                              .message(e.getMessage())
                                              .build();
        return ResponseEntity.status(e.getStatusCode())
                             .body(response);
    }
}
