package com.douzone.timeattendance.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class distribution {

    private Long distributionId;    //PK
    private LocalDateTime date;
    private Long userId;            //FK
    private Long workGroupId;       //FK
}
