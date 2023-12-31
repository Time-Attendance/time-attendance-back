package com.douzone.timeattendance.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class User {

    private Long userId;                //PK
    private String userCode;
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
    private String role;                //Role enum 사용 고려
    private Long companyId;             //FK

    public User(String userCode, String name, String email, String password, String phone, LocalDate hireDate, LocalDate birthday, String dept, String position, String role, Long companyId) {
        this.userCode = userCode;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.hireDate = hireDate;
        this.birthday = birthday;
        this.dept = dept;
        this.position = position;
        this.role = role;
        this.companyId = companyId;
    }

    //@Setter 사용보다는 변경 메서드를 제공하는 것이 좋습니다.
    public void grantAdmin() {
        this.role = "ADMIN";
        this.position = "CEO";
    }
}
