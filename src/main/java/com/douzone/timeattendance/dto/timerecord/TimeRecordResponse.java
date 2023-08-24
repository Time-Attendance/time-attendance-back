package com.douzone.timeattendance.dto.timerecord;

import com.douzone.timeattendance.domain.TimeRecord;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TimeRecordResponse {

    private Long timeRecordId;
    private LocalDate date;
    private LocalTime startWork;
    private LocalTime leaveWork;
    private String workState; //WorkState enum 사용 고려
    private Long userId;

    public TimeRecordResponse(TimeRecord timeRecord) {
        this.timeRecordId = timeRecord.getTimeRecordId();
        this.date = timeRecord.getDate();
        this.startWork = timeRecord.getStartWork();
        this.leaveWork = timeRecord.getLeaveWork();
        this.workState = timeRecord.getWorkState();
        this.userId = timeRecord.getUserId();
    }
}
