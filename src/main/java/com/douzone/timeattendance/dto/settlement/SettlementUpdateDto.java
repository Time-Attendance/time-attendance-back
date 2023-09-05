package com.douzone.timeattendance.dto.settlement;

import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SettlementUpdateDto {

    private LocalTime startTime;
    private LocalTime endTime;
    private LocalTime workingTime;
    private LocalTime overTime;
    private String dayType;
    private LocalDateTime dateUpdated;
}
