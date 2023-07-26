package com.douzone.timeattendance.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class WorkGroup {

    private Long workGroupId;
    private String name;
    private String type;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private LocalDateTime dateDeleted;
    private Boolean isDeleted;
    private Boolean isOn;
}
