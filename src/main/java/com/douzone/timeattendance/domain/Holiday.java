package com.douzone.timeattendance.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class Holiday {

    private Long holidayId;
    private LocalDate date;
    private String name;
    private String payType;
}
