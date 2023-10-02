package com.douzone.timeattendance.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkGroup {

    private Long workGroupId;       //PK
    private String name;
    private String type;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private LocalDateTime dateDeleted;
    private Boolean isDeleted;
    private Boolean isOn;
    private Long companyId;         //FK
}
