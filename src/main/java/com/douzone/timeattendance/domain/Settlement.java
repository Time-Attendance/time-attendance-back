package com.douzone.timeattendance.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Settlement {

    private Long settlementId;          //PK
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalTime workingTime;
    private LocalTime overTime;
    private String dayType;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private Long userId;                //FK(관계 X)
    private Long workGroupRecordId;     //FK

}
