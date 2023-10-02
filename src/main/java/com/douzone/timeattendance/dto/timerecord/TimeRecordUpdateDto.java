package com.douzone.timeattendance.dto.timerecord;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class TimeRecordUpdateDto {

    private final Long userId;
    private final LocalDate date;
    private final LocalDateTime startWork;
    private final LocalDateTime leaveWork;
    private final String workState; //WorkState enum 사용 고려

}
