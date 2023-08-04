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
    private String dept;
    private String position;
    private Boolean distribution;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private LocalDateTime dateDeleted;
    private Boolean isDeleted;
    private String role; //Role enum 사용 고려
    private Long companyId;
    private Long workGroupId;
}
