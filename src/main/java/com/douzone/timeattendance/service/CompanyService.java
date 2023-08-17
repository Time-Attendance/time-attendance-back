package com.douzone.timeattendance.service;

import com.douzone.timeattendance.domain.Company;
import com.douzone.timeattendance.dto.company.CompanyCreateRequest;
import com.douzone.timeattendance.dto.company.CompanyResponse;
import com.douzone.timeattendance.exception.company.AlreadyExistsCompanyNameException;
import com.douzone.timeattendance.mapper.CompanyMapper;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CompanyService {

    private final CompanyMapper companyMapper;

    public void createCompany(CompanyCreateRequest companyCreateRequest) {
        //회사 이름 중복 검증
        validateCompanyName(companyCreateRequest.getName());

        //새 회사 생성
        Company company = new Company(
                companyCreateRequest.getName(),
                UUID.randomUUID()
                    .toString());

        companyMapper.insert(company);
    }

    @Transactional(readOnly = true)
    public List<CompanyResponse> findAll() {
        return companyMapper.findAll()
                            .stream()
                            .map(CompanyResponse::new)
                            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public void validateCompanyName(String name) {
        if (companyMapper.existsName(name)) {
            throw new AlreadyExistsCompanyNameException();
        }
    }
}
