package com.douzone.timeattendance.dto.user;

import com.douzone.timeattendance.dto.timerange.TimeRangeRequestDto;
import com.douzone.timeattendance.dto.workdaytype.WorkDayTypeRequestDto;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserWorkGroupResponse {

    private Long workGroupId;
    private String name;
    private String type;
    private List<TimeRangeRequestDto> timeRangeList;
    private WorkDayTypeRequestDto workDayType;

}
