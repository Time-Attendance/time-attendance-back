package com.douzone.timeattendance.dto.privilege;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class InsertPrivilegeRequest {
    private Long userId;
    private List<Long> deptIds;
}
