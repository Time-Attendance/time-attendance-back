package com.douzone.timeattendance.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter
public class User {

    private Long userId;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private LocalDate joinCompany;
    private LocalDate birthday;
    private String department;
    private String position;
    private String gender;
    private Boolean distribution;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private LocalDateTime dateDeleted;
    private Boolean isDeleted;
    private Long companyId;
    private Long privilegeId;
    private Long workGroupId;
}
