package com.douzone.timeattendance.dto.workgroup;


import com.douzone.timeattendance.dto.workdaytype.WorkDayTypeRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class WorkGroupRequestDto {
    private Long id;
    @NotBlank(message = "이름은 공백일 수 없습니다.")
    private String name;
    @NotBlank(message = "타입은 공백일 수 없습니다.")
    private String type;
    private WorkDayTypeRequestDto workDayType;
    private List<String> timeRangeType;
    private List<LocalTime> start;
    private List<LocalTime> end;
    private Long companyId;
}
