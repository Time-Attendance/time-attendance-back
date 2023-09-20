package com.douzone.timeattendance.dto.company;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CompanyCreateRequest {

    @NotBlank(message = "회사명은 공백일 수 없습니다.")
    @Size(max = 30, message = "회사명은 30자를 초과할 수 없습니다.")
    private String name;

}
