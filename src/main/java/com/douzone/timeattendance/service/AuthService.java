package com.douzone.timeattendance.service;

import com.douzone.timeattendance.domain.User;
import com.douzone.timeattendance.dto.auth.JwtResponse;
import com.douzone.timeattendance.dto.auth.LoginRequest;
import com.douzone.timeattendance.exception.user.EmailOrPasswordMismatchException;
import com.douzone.timeattendance.mapper.UserMapper;
import com.douzone.timeattendance.global.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Transactional(readOnly = true)
    public JwtResponse login(LoginRequest loginRequest) {
        //사용자 검색
        User user = userMapper.findByEmail(loginRequest.getEmail())
                              .orElseThrow(EmailOrPasswordMismatchException::new);

        //비밀번호 검증
        validatePassword(loginRequest.getPassword(), user.getPassword());

        //토큰 생성
        String accessToken = jwtUtil.createAccessToken(
            user.getEmail(),
            user.getName(),
            user.getUserId(),
            user.getRole());

        return new JwtResponse(accessToken);
    }

    /**
     * 로그인 시 입력한 비밀번호와 사용자의 암호화 된 비밀번호를 비교하여,
     * 일치하지 않을 경우 예외를 발생시킵니다.
     *
     * @param requestPassword 로그인 시 입력한 비밀번호
     * @param userPassword 비교할 저장소의 인코딩된 비밀번호
     */
    private void validatePassword(String requestPassword, String userPassword) {
        boolean isSame = passwordEncoder.matches(requestPassword, userPassword);
        if (!isSame) {
            throw new EmailOrPasswordMismatchException();
        }
    }
}
