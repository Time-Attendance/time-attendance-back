package com.douzone.timeattendance.dto.holiday;

import com.douzone.timeattendance.domain.Holiday;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class HolidayResponse {

    private Long holidayId;
    private LocalDate date;
    private String name;
    private String payType;

    public HolidayResponse(Holiday holiday) {
        this.holidayId = holiday.getHolidayId();
        this.date = holiday.getDate();
        this.name = holiday.getName();
        this.payType = holiday.getPayType();
    }
}
