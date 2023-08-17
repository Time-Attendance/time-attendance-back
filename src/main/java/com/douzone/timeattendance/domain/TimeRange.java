package com.douzone.timeattendance.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter @Setter
@NoArgsConstructor
public class TimeRange {

    private Long timeRangeId;   //PK
    private String type;
    private LocalTime start;
    private LocalTime end;
    private Long workGroupId;   //FK
}
