package com.douzone.timeattendance.dto.auth;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequest {

    @Pattern(regexp = "^(?!.*(\\.\\.|\\\\\\\\|\\s)).+@[\\da-zA-Z.\\-]+\\.[\\da-zA-Z]+$",
        message = "올바른 형식의 이메일을 입력해주세요.")
    private String email;

    @NotBlank(message = "비밀번호는 공백일 수 없습니다.")
    private String password;

}
