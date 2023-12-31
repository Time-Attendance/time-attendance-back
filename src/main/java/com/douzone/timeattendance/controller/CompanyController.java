package com.douzone.timeattendance.controller;

import com.douzone.timeattendance.dto.auth.AuthInfo;
import com.douzone.timeattendance.dto.company.CompanyCodeUpdateResponse;
import com.douzone.timeattendance.dto.company.CompanyCreateRequest;
import com.douzone.timeattendance.dto.company.CompanyResponse;
import com.douzone.timeattendance.dto.company.CompanyUpdateRequest;
import com.douzone.timeattendance.global.auth.LoginUser;
import com.douzone.timeattendance.service.CompanyFacade;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/companies")
public class CompanyController {

    //TODO: company 퍼사드가 아니라 workGroup 퍼사드가 적절함
    //여러 service를 필요로 하는 곳은 근로그룹에 관련되어 있기 때문에
    //workGroup 퍼사드를 작성하면, 객체 재사용성이 향상됨(다른 곳에서 퍼사드 객체 하나만 불러서 쓰면 되기 때문)
    private final CompanyFacade companyFacade;

    //TODO: 관리자만 허용
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> create(
            @LoginUser AuthInfo authInfo,
            @RequestPart(required = false) MultipartFile file,
            @RequestPart @Valid CompanyCreateRequest companyCreateRequest) {
        companyFacade.createCompany(file, companyCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                             .build();
    }

    //TODO: 관리자만 허용
    @GetMapping
    public ResponseEntity<List<CompanyResponse>> findAll(@LoginUser AuthInfo authInfo) {
        return ResponseEntity.ok()
                             .body(companyFacade.findAll());
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyResponse> findByCompanyId(
            @LoginUser AuthInfo authInfo,
            @PathVariable Long companyId) {
        return ResponseEntity.ok()
                             .body(companyFacade.findByCompanyId(companyId));
    }

    @PatchMapping("/{companyId}/code")
    public ResponseEntity<CompanyCodeUpdateResponse> updateCode(
            @LoginUser AuthInfo authInfo,
            @PathVariable Long companyId) {
        return ResponseEntity.ok()
                             .body(companyFacade.updateCompanyCode(companyId));
    }

    @PatchMapping(value = "/{companyId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> update(
            @LoginUser AuthInfo authInfo,
            @PathVariable Long companyId,
            @RequestPart(required = false) MultipartFile file,
            @RequestPart @Valid CompanyUpdateRequest companyUpdateRequest) {
        //파일이 있으면 CompanyUpdateRequest 객체에 설정
        if (file != null) {
            companyUpdateRequest.setFile(file);
        }
        companyFacade.updateCompany(companyId, companyUpdateRequest);
        return ResponseEntity.ok()
                             .build();
    }
}
