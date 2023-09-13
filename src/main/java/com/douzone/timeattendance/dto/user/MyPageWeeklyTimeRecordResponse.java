package com.douzone.timeattendance.dto.user;

import com.douzone.timeattendance.dto.timerecord.TimeRecordSettlementResponse;
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
public class MyPageWeeklyTimeRecordResponse {

    //TODO: 총 근로시간, 연장 근로시간
    private List<TimeRecordSettlementResponse> list;

}
