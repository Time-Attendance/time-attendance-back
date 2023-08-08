package com.douzone.timeattendance.dto.user;

import com.douzone.timeattendance.domain.User;
import lombok.Getter;

/**
 * 클라이언트에서 현재 로그인한 사용자의 정보를 요청할 때, 응답하는 객체입니다.
 */
@Getter
public class LoginUserResponse {

    private final String email;
    private final String name;
    private final Long userId;
    private final String role;

    private LoginUserResponse(String email, String name, Long userId, String role) {
        this.email = email;
        this.name = name;
        this.userId = userId;
        this.role = role;
    }

    public static LoginUserResponse from(User user) {
        return new LoginUserResponse(
            user.getEmail(),
            user.getName(),
            user.getUserId(),
            user.getRole());
    }
}
