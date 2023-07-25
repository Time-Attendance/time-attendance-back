package com.douzone.timeattendance.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Privilege {

    private Long privilegeId;
    private String name;
    private Integer level;
    private Boolean isManager;
}
