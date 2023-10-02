package com.douzone.timeattendance.dto.settlement;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class SettlementReplayRequest {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private Long companyId;
}
