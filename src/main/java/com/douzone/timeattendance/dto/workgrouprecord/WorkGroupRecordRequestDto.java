package com.douzone.timeattendance.dto.workgrouprecord;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkGroupRecordRequestDto {

    private Long workGroupRecordId;     //PK
    @NotNull
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalDateTime date;
    @NotBlank(message = "이름은 공백일 수 없습니다.")
    private String workGroupName;
    @NotBlank(message = "타입은 공백일 수 없습니다.")
    private String workGroupType;
    private String timeRangeType;
    private String start;
    private String end;

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

    private Long workGroupId;           //FK(관계 X)
}
