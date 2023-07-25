package com.douzone.timeattendance.dto.authorization;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class FindAuthorizationResponse {

    private Long userId;
    private String name;
    private String phoneNumber;
    private String department;
    private String position;
    private LocalDateTime privilegeAssignedDate;
    private Long privilegeId;
    private String privilegeName;

}
