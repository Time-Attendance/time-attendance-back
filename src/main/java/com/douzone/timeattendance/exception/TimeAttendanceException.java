package com.douzone.timeattendance.exception;

public abstract class TimeAttendanceException extends RuntimeException {

    public TimeAttendanceException(String message) {
        super(message);
    }

    public abstract int getStatusCode();

}
