package com.douzone.timeattendance.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class WorkDayType {

    private Long workDayTypeId;
    private String mon;
    private String tue;
    private String wed;
    private String thu;
    private String fri;
    private String sat;
    private String sun;
    private Long workGroupId;
}
