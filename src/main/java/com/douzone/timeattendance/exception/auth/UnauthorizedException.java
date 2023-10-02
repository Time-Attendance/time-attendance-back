package com.douzone.timeattendance.exception.auth;

import com.douzone.timeattendance.exception.TimeAttendanceException;
import org.springframework.http.HttpStatus;

public class UnauthorizedException extends TimeAttendanceException {

    private static final String MESSAGE = "로그인이 필요한 서비스입니다.";

    public UnauthorizedException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.UNAUTHORIZED.value();
    }
}
