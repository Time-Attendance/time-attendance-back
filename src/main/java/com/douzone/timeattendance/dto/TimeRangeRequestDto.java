package com.douzone.timeattendance.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TimeRangeRequestDto {
    private String type;
    private LocalTime start;
    private LocalTime end;
}
