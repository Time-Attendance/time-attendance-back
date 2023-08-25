package com.douzone.timeattendance.dto.workgroup;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class DistributionRequestDto {
    private LocalDateTime date;
    private List<Long> userIds;
    private Long workGroupId;
}
