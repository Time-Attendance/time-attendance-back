package com.douzone.timeattendance.exception.holiday;

import com.douzone.timeattendance.exception.TimeAttendanceException;
import org.springframework.http.HttpStatus;

public class AlreadyExistsDateException extends TimeAttendanceException {

    private static final String MESSAGE = "이미 휴일이 존재하는 날짜입니다.";

    public AlreadyExistsDateException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }
}
