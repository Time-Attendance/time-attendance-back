package com.douzone.timeattendance.dto.company;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class CompanyUpdateRequest {

    @NotBlank(message = "회사명은 공백일 수 없습니다.")
    @Size(max = 30, message = "회사명은 30자를 초과할 수 없습니다.")
    private String name;

    private MultipartFile file;
    private ImageAction imageAction = ImageAction.KEEP;  //이미지 작업 구분

    public enum ImageAction {
        DELETE,  //이미지 삭제
        KEEP,    //이미지 변경하지 않음
        UPDATE   //새로운 이미지로 변경
    }
}
