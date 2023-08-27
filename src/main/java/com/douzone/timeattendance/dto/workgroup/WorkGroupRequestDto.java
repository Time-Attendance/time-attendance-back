package com.douzone.timeattendance.dto.workgroup;


import com.douzone.timeattendance.dto.workdaytype.WorkDayTypeRequestDto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

    @NotBlank
    private String name;

    @NotBlank
    private String type;

    @NotNull
    private WorkDayTypeRequestDto workDayType;

    @NotEmpty
    private List<String> timeRangeType;

    @NotEmpty
    private List<LocalTime> start;

    @NotEmpty
    private List<LocalTime> end;

    private Long companyId;
}
