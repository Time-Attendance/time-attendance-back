package com.douzone.timeattendance.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class UserGroupRecord {

    private Long userGroupRecordId;
    private LocalDate time;
    private Long userId;
    private Long workGroupId;

}
