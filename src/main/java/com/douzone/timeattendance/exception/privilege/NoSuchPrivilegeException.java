package com.douzone.timeattendance.exception.privilege;

import com.douzone.timeattendance.exception.TimeAttendanceException;
import org.springframework.http.HttpStatus;

public class NoSuchPrivilegeException extends TimeAttendanceException {

    private static final String MESSAGE = "권한이 없는 부서입니다.";

    public NoSuchPrivilegeException(){
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.NOT_FOUND.value();
    }
}
