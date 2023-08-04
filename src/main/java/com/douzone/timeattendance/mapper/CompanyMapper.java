package com.douzone.timeattendance.mapper;

import com.douzone.timeattendance.domain.Company;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyMapper {

    Optional<Company> findByCode(String code);

    boolean existsUserInCompany(Long id);

}
