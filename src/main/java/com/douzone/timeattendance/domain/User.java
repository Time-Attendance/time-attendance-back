package com.douzone.timeattendance.domain;

import com.douzone.timeattendance.dto.UserRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@Setter
@NoArgsConstructor
public class User {

    private Long userId;
    private String name;
    private String email;
    private String password;
    private String phone;
    private LocalDate hireDate;
    private LocalDate birthday;
    private String position;
    private String gender;
    private Boolean distribution;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private LocalDateTime dateDeleted;
    private Boolean isDeleted;
    private Boolean isAdmin;
    private Long workGroupId;
    private Long companyId;
    private Long deptId;

    public User(UserRequestDto userRequestDto) {
        this.name = userRequestDto.getName();
        this.email = userRequestDto.getEmail();
        this.password = userRequestDto.getPassword();
        this.phone = userRequestDto.getPhone();
        this.birthday = userRequestDto.getBirthday();
        this.gender = userRequestDto.getGender();

        Date date = new Date(System.currentTimeMillis());
        Instant instant = date.toInstant();
        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();

        this.hireDate = localDate;
        this.dateCreated = localDateTime;
        this.dateUpdated = localDateTime;
    }
}
