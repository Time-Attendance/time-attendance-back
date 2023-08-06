package com.douzone.timeattendance.dto.auth;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class LoginUserEmail {

    private final String email;

}
