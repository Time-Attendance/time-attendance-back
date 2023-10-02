package com.douzone.timeattendance.domain;

import com.douzone.timeattendance.dto.workdaytype.WorkDayTypeRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WorkDayType {

    private Long workDayTypeId;                //PK
    private String mon;
    private String tue;
    private String wed;
    private String thu;
    private String fri;
    private String sat;
    private String sun;
    private Long workGroupId;                  //FK

    public WorkDayType(WorkDayTypeRequestDto workDayTypeRequestDto) {
        this.mon = workDayTypeRequestDto.getMon();
        this.tue = workDayTypeRequestDto.getTue();
        this.wed = workDayTypeRequestDto.getWed();
        this.thu = workDayTypeRequestDto.getThu();
        this.fri = workDayTypeRequestDto.getFri();
        this.sat = workDayTypeRequestDto.getSat();
        this.sun = workDayTypeRequestDto.getSun();
    }
}
