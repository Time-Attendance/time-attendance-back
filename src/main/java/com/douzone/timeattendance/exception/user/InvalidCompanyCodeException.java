package com.douzone.timeattendance.exception.user;

import com.douzone.timeattendance.exception.TimeAttendanceException;
import org.springframework.http.HttpStatus;

public class InvalidCompanyCodeException extends TimeAttendanceException {

    private static final String MESSAGE = "유효하지 않은 회사 인증 코드입니다.";

    public InvalidCompanyCodeException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }
}
