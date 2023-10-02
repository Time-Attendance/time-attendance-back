package com.douzone.timeattendance.dto.timerecord;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TimeRecordSettlementResponse {

    private Long timeRecordId;
    private LocalDate date;
    private LocalDateTime startWork;
    private LocalDateTime leaveWork;
    private String workState;
    private LocalTime workingTime;
    private LocalTime overTime;

}
