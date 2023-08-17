package com.douzone.timeattendance.dto.company;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CompanyCreateRequest {

    @NotBlank(message = "회사 이름은 공백일 수 없습니다.")
    private String name;

}
