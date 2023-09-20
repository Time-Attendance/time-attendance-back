package com.douzone.timeattendance.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.HashMap;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorResponse {

    private final String code;
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_EMPTY) // null일 경우 json 응답에서 제외
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
