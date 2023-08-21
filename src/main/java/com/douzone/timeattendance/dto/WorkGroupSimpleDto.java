package com.douzone.timeattendance.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WorkGroupSimpleDto {
    private Long id;
    private String name;
    private String type;
    private Integer numOfMembers;
}
