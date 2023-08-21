package com.douzone.timeattendance.controller;

import com.douzone.timeattendance.dto.company.CompanyCreateRequest;
import com.douzone.timeattendance.dto.company.CompanyResponse;
import com.douzone.timeattendance.service.CompanyService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    //TODO: 관리자만 허용
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CompanyCreateRequest companyCreateRequest) {
        companyService.createCompany(companyCreateRequest);
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
