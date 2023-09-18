package com.douzone.timeattendance.dto.user;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserCreateRequest {

    @Pattern(regexp = "^(?!.*(\\.\\.|\\\\\\\\|\\s)).+@[\\da-zA-Z.\\-]+\\.[\\da-zA-Z]+$",
        message = "올바른 형식의 이메일을 입력해주세요.")
    private String email;

    @NotBlank(message = "비밀번호는 공백일 수 없습니다.")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,16}$",
        message = "비밀번호는 8~16자의 영문 대/소문자, 숫자, 특수문자를 포함해야 합니다.")
    private String password;

    @NotBlank(message = "이름은 공백일 수 없습니다.")
    private String name;

    @NotBlank(message = "전화번호는 공백일 수 없습니다.")
    private String phone;

    @NotNull(message = "생일은 공백일 수 없습니다.")
    private LocalDate birthday;

    @NotBlank(message = "회사 인증 코드는 공백일 수 없습니다.")
    private String companyCode;

}
