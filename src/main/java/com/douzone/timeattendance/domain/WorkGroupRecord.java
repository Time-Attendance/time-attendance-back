package com.douzone.timeattendance.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkGroupRecord {

    private Long workGroupRecordId;     //PK
    private LocalDateTime date;
    private String workGroupName;
    private String workGroupType;
    private String timeRangeType;
    private String start;
    private String end;
    private String mon;
    private String tue;
    private String wed;
    private String thu;
    private String fri;
    private String sat;
    private String sun;
    private Long workGroupId;           //FK(관계 X)

}
