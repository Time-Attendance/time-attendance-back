package com.douzone.timeattendance.controller;

import com.douzone.timeattendance.dto.company.CompanyCreateRequest;
import com.douzone.timeattendance.dto.company.CompanyResponse;
import com.douzone.timeattendance.service.CompanyService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    //TODO: 관리자만 허용
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Void> create(@RequestPart(required = false) MultipartFile file,
            @RequestPart @Valid CompanyCreateRequest companyCreateRequest) {
        companyService.createCompany(file, companyCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                             .build();
    }

    //TODO: 관리자만 허용
    @GetMapping
    public ResponseEntity<List<CompanyResponse>> findAll() {
        return ResponseEntity.ok()
                             .body(companyService.findAll());
    }
}
