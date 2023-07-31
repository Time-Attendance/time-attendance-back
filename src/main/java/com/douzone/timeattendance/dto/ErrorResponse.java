package com.douzone.timeattendance.dto;

import java.util.HashMap;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorResponse {

    private final String code;
    private final String message;
    private final Map<String, String> errors; //유효성 검증 에러

    @Builder
    private ErrorResponse(String code, String message, Map<String, String> errors) {
        this.code = code;
        this.message = message;
        this.errors = errors != null ? errors : new HashMap<>();
    }

    public void addErrors(String fieldName, String errorMessage) {
        this.errors.put(fieldName, errorMessage);
    }
}
