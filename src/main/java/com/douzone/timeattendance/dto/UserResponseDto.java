package com.douzone.timeattendance.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class UserResponseDto {
    private Long id;
    private String name;
    private String position;
    private String email;
    private Date hireDate;
    private String department;
}
