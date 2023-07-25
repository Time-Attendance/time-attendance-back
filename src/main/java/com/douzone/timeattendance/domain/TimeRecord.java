package com.douzone.timeattendance.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter @Setter
public class TimeRecord {

    private Long timeRecordId;
    private LocalDate date;
    private LocalTime work;
    private LocalTime leave;
    private String workState;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private Long userId;
}
