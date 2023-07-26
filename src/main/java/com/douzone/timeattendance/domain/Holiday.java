package com.douzone.timeattendance.domain;

import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class Holiday {

    private Long holidayId;
    private LocalDate date;
    private String name;
    private String payType;

    public Holiday(LocalDate date, String name, String payType) {
        this.date = date;
        this.name = name;
        this.payType = payType;
    }
}
