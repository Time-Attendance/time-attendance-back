package com.douzone.timeattendance.domain;

import com.douzone.timeattendance.dto.workgroup.DistributionRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter @Setter
@NoArgsConstructor
public class Distribution {

    private Long distributionId;    //PK
    private LocalDateTime date;
    private Long userId;            //FK
    private Long workGroupId;       //FK
}
