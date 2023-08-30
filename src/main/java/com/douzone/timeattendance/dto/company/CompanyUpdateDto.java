package com.douzone.timeattendance.dto.company;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyUpdateDto {

    private String name;
    private String code;
    private String logoUrl;
    private final LocalDateTime dateUpdated = LocalDateTime.now();

}
