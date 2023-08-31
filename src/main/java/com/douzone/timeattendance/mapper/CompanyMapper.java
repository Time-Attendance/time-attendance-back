package com.douzone.timeattendance.mapper;

import com.douzone.timeattendance.domain.Company;
import com.douzone.timeattendance.dto.company.CompanyUpdateDto;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CompanyMapper {

    void insert(Company company);

    void update(@Param("companyId") Long companyId, @Param("updateParam") CompanyUpdateDto updateParam);

    Optional<Company> findByCompanyId(Long companyId);

    Optional<Company> findByCode(String code);

    List<Company> findAll();

    boolean existsName(String name);

    boolean existsUserInCompany(Long id);
}
