package com.douzone.timeattendance.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class WorkGroupRequestDto {
    private String name;
    private String type;
    private WorkDayTypeRequestDto workDayType;
    private List<String> timeRangeType;
    private List<LocalTime> start;
    private List<LocalTime> end;
}
