package com.douzone.timeattendance.exception.user;

import com.douzone.timeattendance.exception.TimeAttendanceException;
import org.springframework.http.HttpStatus;

public class EmailOrPasswordMismatchException extends TimeAttendanceException {

    private static final String MESSAGE = "이메일 또는 비밀번호가 일치하지 않습니다.";

    public EmailOrPasswordMismatchException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }
}
