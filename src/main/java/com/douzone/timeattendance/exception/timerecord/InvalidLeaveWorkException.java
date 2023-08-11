package com.douzone.timeattendance.exception.timerecord;

import com.douzone.timeattendance.exception.TimeAttendanceException;
import org.springframework.http.HttpStatus;

public class InvalidLeaveWorkException extends TimeAttendanceException {

    private static final String MESSAGE = "오늘의 출근 기록이 존재하지 않습니다.";

    public InvalidLeaveWorkException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }
}
