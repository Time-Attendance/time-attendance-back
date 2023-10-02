package com.douzone.timeattendance.exception.holiday;

import com.douzone.timeattendance.exception.TimeAttendanceException;
import org.springframework.http.HttpStatus;

public class NoSuchHolidayException extends TimeAttendanceException {

    private static final String MESSAGE = "존재하지 않는 휴일입니다.";

    public NoSuchHolidayException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.NOT_FOUND.value();
    }
}
