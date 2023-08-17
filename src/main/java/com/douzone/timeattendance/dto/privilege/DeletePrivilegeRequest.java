package com.douzone.timeattendance.dto.privilege;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeletePrivilegeRequest {
    private Long userId;
    private Long deptId;
}
