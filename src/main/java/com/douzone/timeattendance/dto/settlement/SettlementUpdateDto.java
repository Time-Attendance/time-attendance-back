package com.douzone.timeattendance.dto.settlement;

import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SettlementUpdateDto {

    private Long settlementId;
    private Long timeRecordId;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalTime workingTime;
    private LocalTime overTime;
    private String dayType;
    private String workState;
    private LocalDateTime dateUpdated;
}
