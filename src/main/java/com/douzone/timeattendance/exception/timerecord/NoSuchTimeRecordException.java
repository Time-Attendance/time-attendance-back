package com.douzone.timeattendance.exception.timerecord;

import com.douzone.timeattendance.exception.TimeAttendanceException;
import org.springframework.http.HttpStatus;

public class NoSuchTimeRecordException extends TimeAttendanceException {

    private static final String MESSAGE = "존재하지 않는 출퇴근 기록입니다.";

    public NoSuchTimeRecordException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.NOT_FOUND.value();
    }
}
