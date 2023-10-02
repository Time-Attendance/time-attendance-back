package com.douzone.timeattendance.dto.workdaytype;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class WorkDayTypeRequestDto {

    @Pattern(regexp = "^(근무|유급|무급)$", message = "Invalid value for Monday")
    private String mon;

    @Pattern(regexp = "^(근무|유급|무급)$", message = "Invalid value for Tuesday")
    private String tue;

    @Pattern(regexp = "^(근무|유급|무급)$", message = "Invalid value for Wednesday")
    private String wed;

    @Pattern(regexp = "^(근무|유급|무급)$", message = "Invalid value for Thursday")
    private String thu;

    @Pattern(regexp = "^(근무|유급|무급)$", message = "Invalid value for Friday")
    private String fri;

    @Pattern(regexp = "^(근무|유급|무급)$", message = "Invalid value for Saturday")
    private String sat;

    @Pattern(regexp = "^(근무|유급|무급)$", message = "Invalid value for Sunday")
    private String sun;
}
