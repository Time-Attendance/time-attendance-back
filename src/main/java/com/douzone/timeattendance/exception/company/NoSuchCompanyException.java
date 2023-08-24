package com.douzone.timeattendance.exception.company;

import com.douzone.timeattendance.exception.TimeAttendanceException;
import org.springframework.http.HttpStatus;

public class NoSuchCompanyException extends TimeAttendanceException {

    private static final String MESSAGE = "존재하지 않는 회사입니다.";

    public NoSuchCompanyException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.NOT_FOUND.value();
    }
}
