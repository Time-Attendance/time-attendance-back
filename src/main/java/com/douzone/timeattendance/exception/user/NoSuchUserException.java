package com.douzone.timeattendance.exception.user;

import com.douzone.timeattendance.exception.TimeAttendanceException;
import org.springframework.http.HttpStatus;

public class NoSuchUserException extends TimeAttendanceException {

    private static final String MESSAGE = "존재하지 않는 사용자입니다.";

    public NoSuchUserException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }
}
