package com.douzone.timeattendance.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class Settlement {

    private Long settlementId;
    private Date date;
    private LocalTime workingTime;
    private LocalTime overTime;
    private String dayType;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private Long userId;


}
