package com.douzone.timeattendance.exception.timerecord;

import com.douzone.timeattendance.exception.TimeAttendanceException;
import org.springframework.http.HttpStatus;

public class AlreadyExistsWorkRecordException extends TimeAttendanceException {

    private static final String MESSAGE = "오늘의 출근 기록이 이미 존재합니다.";

    public AlreadyExistsWorkRecordException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }
}
