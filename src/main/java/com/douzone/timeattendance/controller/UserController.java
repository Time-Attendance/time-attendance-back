package com.douzone.timeattendance.controller;

import com.douzone.timeattendance.dto.auth.LoginUserEmail;
import com.douzone.timeattendance.dto.user.LoginUserResponse;
import com.douzone.timeattendance.dto.user.UserCreateRequest;
import com.douzone.timeattendance.global.auth.LoginUser;
import com.douzone.timeattendance.service.UserService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 로그인 한 사용자 정보를 가져올 수 있는 샘플 코드입니다.
     *
     * LoginUser 어노테이션과 LoginUserEmail 객체를 핸들러 메서드의 인자로 선언하면,
     * 요청을 보낸 사용자의 이메일을 알 수 있습니다.
     * 이메일을 통해 DB에서 사용자를 조회한 후, 비즈니스 로직을 처리하면 됩니다.
     *
     * @param loginUserEmail 토큰 검증이 완료된 사용자의 email
     */
    @GetMapping("/test")
    public ResponseEntity<String> signup(@LoginUser LoginUserEmail loginUserEmail) {
        System.out.println("loginUserEmail.getEmail() = " + loginUserEmail.getEmail());
        return ResponseEntity.ok()
                             .build();
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@RequestBody @Valid UserCreateRequest userCreateRequest) {
        userService.signup(userCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                             .build();
    }

    /**
     * 현재 로그인 한 사용자의 정보를 응답하는 핸들러입니다.
     *
     * @param loginUserEmail 토큰 검증이 완료된 사용자의 email
     * @return LoginUserResponse 객체
     */
    @GetMapping("/me")
    public ResponseEntity<LoginUserResponse> loginUserInfo(@LoginUser LoginUserEmail loginUserEmail) {
        return ResponseEntity.ok()
                             .body(userService.loginUserInfo(loginUserEmail));
    }
}
