package com.douzone.timeattendance.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class DeptPrivilege {

    private Long userId;
    private Long deptId;
    private LocalDateTime privilegeDate;
}
