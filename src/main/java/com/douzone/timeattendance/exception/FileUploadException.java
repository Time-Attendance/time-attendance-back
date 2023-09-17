package com.douzone.timeattendance.exception;

import org.springframework.http.HttpStatus;

public class FileUploadException extends TimeAttendanceException {

    private static final String MESSAGE = "파일 업로드에 실패하였습니다.";

    public FileUploadException() {
        super(MESSAGE);
    }

    public FileUploadException(String message) {
        super(message);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }
}
