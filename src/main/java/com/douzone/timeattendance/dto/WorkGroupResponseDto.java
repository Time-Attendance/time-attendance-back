package com.douzone.timeattendance.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class WorkGroupResponseDto {
    private Long id;
    private String name;
    private String type;
    private Integer numOfMembers;
    private String workDays;
    private String timeRangeType;
    private String start;
    private String end;
    private Boolean isOn;
    private LocalDateTime dateUpdated;
}
