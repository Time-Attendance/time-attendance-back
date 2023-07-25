package com.douzone.timeattendance.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter @Setter
public class TimeRange {

    private Long timeRangeId;
    private String type;
    private LocalTime start;
    private LocalTime end;
    private Long workGroupId;
}
