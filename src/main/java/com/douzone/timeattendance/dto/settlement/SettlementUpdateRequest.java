package com.douzone.timeattendance.dto.settlement;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Getter @Setter
@NoArgsConstructor
public class SettlementUpdateRequest {

    @NotNull
    private Long settlementId;

    @NotNull
    private LocalTime startTime;    //근무시작시간(인정시작시간)

    @NotNull
    private LocalTime endTime;      //근무종료시간(인정종료시간)

    @NotNull
    private LocalTime workingTime;  //소정근로시간

    @NotNull
    private String workState;       //근무 상태(TimeRecord)

}
