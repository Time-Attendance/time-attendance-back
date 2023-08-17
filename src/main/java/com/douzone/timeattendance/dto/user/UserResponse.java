package com.douzone.timeattendance.dto.user;

import com.douzone.timeattendance.domain.User;
import java.time.LocalDate;
import lombok.Getter;

@Getter
public class UserResponse {

    private Long userId;
    private String name;
    private String email;
    private String phone;
    private LocalDate hireDate;
    private LocalDate birthday;
    private String dept;
    private String position;
    private String role;
    private Long companyId;

    public UserResponse(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.hireDate = user.getHireDate();
        this.birthday = user.getBirthday();
        this.dept = user.getDept();
        this.position = user.getPosition();
        this.role = user.getRole();
        this.companyId = user.getCompanyId();
    }
}