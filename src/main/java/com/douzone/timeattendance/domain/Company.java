package com.douzone.timeattendance.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class Company {

    private Long companyId; //PK
    private String name;
    private String code;
    private String logoUrl;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private LocalDateTime dateDeleted;
    private Boolean isDeleted;

    public Company(String name, String code, String logoUrl) {
        this.name = name;
        this.code = code;
        this.logoUrl = logoUrl;
    }
}
