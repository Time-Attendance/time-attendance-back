package com.douzone.timeattendance.controller;

import com.douzone.timeattendance.dto.ErrorResponse;
import com.douzone.timeattendance.exception.TimeAttendanceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@RestControllerAdvice
public class RestExceptionController {

    @Value("${spring.servlet.multipart.max-file-size}")
    private String maxFileSize;

    /**
     * 유효성 검증에 실패한 예외를 처리합니다.
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErrorResponse> invalidRequestHandler(BindException e) {
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
     * 파일 업로드 크기를 초과한 경우의 예외를 처리합니다.
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ErrorResponse> handleMaxSizeException(MaxUploadSizeExceededException e) {
        ErrorResponse response = ErrorResponse.builder()
                                              .code("400")
                                              .message("허용된 파일 업로드 크기(" + maxFileSize + ")를 초과하였습니다.")
                                              .build();
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
