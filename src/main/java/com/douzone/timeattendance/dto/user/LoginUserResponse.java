package com.douzone.timeattendance.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 클라이언트에서 현재 로그인한 사용자의 정보를 요청할 때, 응답하는 객체입니다.
 */
@Getter
@RequiredArgsConstructor
@Builder
public class LoginUserResponse {

    private final String email;
    private final String name;
    private final String position;
    private final Long userId;
    private final String role;
    private final Long companyId;
    private final String companyLogoUrl;

}
