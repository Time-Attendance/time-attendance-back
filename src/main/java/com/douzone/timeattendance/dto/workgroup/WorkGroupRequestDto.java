package com.douzone.timeattendance.dto.workgroup;


import com.douzone.timeattendance.dto.workdaytype.WorkDayTypeRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class WorkGroupRequestDto {
    private Long id;
    private String name;
    private String type;
    private WorkDayTypeRequestDto workDayType;
    private List<String> timeRangeType;
    private List<LocalTime> start;
    private List<LocalTime> end;
    private Long companyId;
}
