package com.douzone.timeattendance.mapper;

import com.douzone.timeattendance.domain.Company;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyMapper {

    void insert(Company company);

    Optional<Company> findByCompanyId(Long companyId);

    Optional<Company> findByCode(String code);

    List<Company> findAll();

    boolean existsName(String name);

    boolean existsUserInCompany(Long id);
}
