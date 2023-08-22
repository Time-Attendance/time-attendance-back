package com.douzone.timeattendance.dto.settlement;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class SettlementFindRequest {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate start = LocalDate.now().minusDays(1);    //시작일자(default: 오늘)

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end = LocalDate.now().minusDays(1);      //종료일자(default: 오늘)
    private String names;

}
