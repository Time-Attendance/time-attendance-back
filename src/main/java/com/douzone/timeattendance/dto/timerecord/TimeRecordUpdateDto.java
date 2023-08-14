package com.douzone.timeattendance.dto.timerecord;

import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class TimeRecordUpdateDto {

    private final Long userId;
    private final LocalDate date;
    private final LocalTime work;
    private final LocalTime leaveWork;
    private final String workState; //WorkState enum 사용 고려

}
