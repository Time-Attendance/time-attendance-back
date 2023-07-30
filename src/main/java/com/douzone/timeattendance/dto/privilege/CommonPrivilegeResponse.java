package com.douzone.timeattendance.dto.privilege;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommonPrivilegeResponse {

    private Long privilegeId;
    private String name;
    private Integer level;
    private Boolean isManager;
}
