package com.douzone.timeattendance.service;

import com.douzone.timeattendance.domain.Company;
import com.douzone.timeattendance.dto.company.CompanyCreateRequest;
import com.douzone.timeattendance.dto.company.CompanyResponse;
import com.douzone.timeattendance.dto.company.CompanyUpdateDto;
import com.douzone.timeattendance.exception.FileUploadException;
import com.douzone.timeattendance.exception.company.AlreadyExistsCompanyNameException;
import com.douzone.timeattendance.global.util.FileUtil;
import com.douzone.timeattendance.mapper.CompanyMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Transactional
public class CompanyService {

    private final CompanyMapper companyMapper;

    public Company createCompany(MultipartFile file, CompanyCreateRequest companyCreateRequest) {
        //회사 이름 중복 검증
        validateCompanyName(companyCreateRequest.getName());

        //파일저장
        String storeFilename = "";
        try {
            if (file != null && !file.isEmpty()) {
                storeFilename = FileUtil.createStoreFilename(file.getOriginalFilename());
                String fullPath = FileUtil.UPLOAD_PATH + storeFilename;
                file.transferTo(new File(fullPath));
            }
        } catch (IOException e) {
            throw new FileUploadException();
        }

        //새 회사 생성
        Company company = new Company(
                companyCreateRequest.getName(),
                UUID.randomUUID().toString(),
                storeFilename);

        companyMapper.insert(company);

        return company;
    }

    public void update(Long companyId, CompanyUpdateDto updateParam) {
        companyMapper.update(companyId, updateParam);
    }

    @Transactional(readOnly = true)
    public List<CompanyResponse> findAll() {
        return companyMapper.findAll()
                            .stream()
                            .map(CompanyResponse::new)
                            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Company> findByCompanyId(Long companyId) {
        return companyMapper.findByCompanyId(companyId);
    }

    @Transactional(readOnly = true)
    public void validateCompanyName(String name) {
        if (companyMapper.existsName(name)) {
            throw new AlreadyExistsCompanyNameException();
        }
    }
}
