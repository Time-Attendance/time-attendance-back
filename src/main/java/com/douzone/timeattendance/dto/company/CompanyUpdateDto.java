package com.douzone.timeattendance.dto.company;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class CompanyUpdateDto {

    private final String name;
    private final String code;
    private final String logoUrl;
    private final LocalDateTime dateUpdated = LocalDateTime.now();

}
