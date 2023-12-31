package com.douzone.timeattendance.controller;

import com.douzone.timeattendance.exception.auth.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {

    /**
     * 서버 인증 예외 처리
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public String unauthorizedException(UnauthorizedException e) {
        return "error/403";
    }
}
