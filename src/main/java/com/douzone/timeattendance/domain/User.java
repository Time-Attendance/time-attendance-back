package com.douzone.timeattendance.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class User {

    private Long userId;
    private String name;
    private String email;
    private String password;
    private String phone;
    private LocalDate hireDate;
    private LocalDate birthday;
    private Long deptId;
    private String position;
    private String gender;
    private Boolean distribution;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private LocalDateTime dateDeleted;
    private Boolean isDeleted;
    private Boolean isAdmin;
    private Long companyId;
    private Long workGroupId;
}
