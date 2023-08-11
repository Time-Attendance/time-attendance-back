package com.douzone.timeattendance.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class TimeRecord {

    private Long timeRecordId;
    private LocalDate date;
    private LocalTime work;
    private LocalTime leaveWork;
    private String workState; //WorkState enum 사용 고려
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private Long userId;
}
