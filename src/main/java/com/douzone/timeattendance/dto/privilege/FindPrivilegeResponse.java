package com.douzone.timeattendance.dto.privilege;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class FindPrivilegeResponse {

    private Long userId;
    private String name;
    private String email;
    private String phone;
    private String position;
    private Long userDeptId;
    private String userDeptName;
    private Long privilegeDeptId;
    private String privilegeDeptName;
    private LocalDateTime privilegeDate;

}
