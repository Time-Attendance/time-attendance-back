package com.douzone.timeattendance.exception.company;

import com.douzone.timeattendance.exception.TimeAttendanceException;
import org.springframework.http.HttpStatus;

public class AlreadyExistsCompanyNameException extends TimeAttendanceException {

    private static final String MESSAGE = "이미 존재하는 회사 이름입니다.";

    public AlreadyExistsCompanyNameException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }
}
