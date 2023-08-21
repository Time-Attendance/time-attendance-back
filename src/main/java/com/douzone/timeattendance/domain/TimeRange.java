package com.douzone.timeattendance.domain;

import com.douzone.timeattendance.dto.timerange.TimeRangeRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class TimeRange {

    private Long timeRangeId;
    private String type;
    private LocalTime start;
    private LocalTime end;
    private Long workGroupId;

    public TimeRange(TimeRangeRequestDto timeRangeRequestDto) {
        this.type = timeRangeRequestDto.getType();
        this.start = timeRangeRequestDto.getStart();
        this.end = timeRangeRequestDto.getEnd();
    }
}
