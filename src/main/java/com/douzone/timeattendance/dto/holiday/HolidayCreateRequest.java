package com.douzone.timeattendance.dto.holiday;

import java.time.LocalDate;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class HolidayCreateRequest {

    @NotNull
    @Future(message = "등록 날짜는 현재 이후여야 합니다.")
    private LocalDate date;

    @NotBlank(message = "휴일명은 공백일 수 없습니다.")
    private String name;

    @NotBlank(message = "급여 구분은 필수입니다.")
    private String payType;

}
