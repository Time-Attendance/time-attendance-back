package com.douzone.timeattendance.dto.authorization;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UpdateAuthorizationResponse {

    private Long userId;
    private LocalDateTime privilegeAssignedDate;
    private Long privilegeId;
    private String privilegeName;
    private Integer privilegeLevel;
    private Boolean isManager;
}
