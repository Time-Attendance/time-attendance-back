package com.douzone.timeattendance.exception.timerecord;

import com.douzone.timeattendance.exception.TimeAttendanceException;
import org.springframework.http.HttpStatus;

public class ImpossibleLeaveWorkException extends TimeAttendanceException {

    private static final String MESSAGE = "오늘의 퇴근 기록을 저장할 출근 기록이 존재하지 않습니다.";

    public ImpossibleLeaveWorkException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }
}
