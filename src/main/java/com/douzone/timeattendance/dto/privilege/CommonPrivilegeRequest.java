package com.douzone.timeattendance.dto.privilege;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CommonPrivilegeRequest {

    private List<Long> privilegeIds;
}
