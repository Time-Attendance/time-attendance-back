package com.douzone.timeattendance.service;

import static org.junit.jupiter.api.Assertions.*;

import com.douzone.timeattendance.domain.Company;
import com.douzone.timeattendance.mapper.CompanyMapper;
import java.util.UUID;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CompanyServiceTest {

    @Autowired
    CompanyMapper companyMapper;

    @Test
    @DisplayName("회사 더미 데이터 생성")
    void createCompany() {
        IntStream.rangeClosed(1, 300)
                 .forEach(i -> companyMapper.insert(
                                 new Company("회사" + i, UUID.randomUUID()
                                                           .toString())
                         )
                 );
    }
}