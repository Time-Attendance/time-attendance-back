package com.douzone.timeattendance.dto.user;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSearchDto {

    @NotNull(message = "회사 ID는 공백일 수 없습니다.")
    private Long companyId;

}
