package com.douzone.timeattendance.dto.company;

import com.douzone.timeattendance.domain.Company;
import java.time.LocalDate;
import lombok.Getter;

@Getter
public class CompanyResponse {

    private Long companyId;
    private String name;
    private String code;
    private String logoUrl;
    private LocalDate dateCreated;
    private LocalDate dateUpdated;

    public CompanyResponse(Company company) {
        this.companyId = company.getCompanyId();
        this.name = company.getName();
        this.code = company.getCode();
        this.logoUrl = company.getLogoUrl();
        this.dateCreated = LocalDate.from(company.getDateCreated());
        this.dateUpdated = LocalDate.from(company.getDateUpdated());
    }
}
