package com.douzone.timeattendance.service;

import com.douzone.timeattendance.domain.Company;
import com.douzone.timeattendance.domain.User;
import com.douzone.timeattendance.dto.user.UserCreateRequest;
import com.douzone.timeattendance.exception.user.AlreadyExistsEmailException;
import com.douzone.timeattendance.exception.user.InvalidCompanyCodeException;
import com.douzone.timeattendance.mapper.CompanyMapper;
import com.douzone.timeattendance.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserMapper userMapper;
    private final CompanyMapper companyMapper;

    public void signup(UserCreateRequest userCreateRequest) {
        //중복 이메일 검증
        validateEmail(userCreateRequest.getEmail());

        //회사 코드 검증
        Company company = companyMapper.findByCode(userCreateRequest.getCompanyCode())
                                       .orElseThrow(InvalidCompanyCodeException::new);

        User user = new User(
            userCreateRequest.getName(),
            userCreateRequest.getEmail(),
            userCreateRequest.getPassword(), //TODO: 비밀번호 암호화
            userCreateRequest.getPhone(),
            userCreateRequest.getBirthday(),
            "USER", //TODO: enum 사용
            company.getCompanyId());

        //처음으로 가입하는 사용자에게 관리자 권한 부여
        if (!companyMapper.existsUserInCompany(company.getCompanyId())) {
            user.grantAdmin();
        }

        userMapper.insert(user);
    }

    /**
     * 회원가입 시, 이미 가입된 이메일의 경우 예외를 발생시킵니다.
     *
     * @param email
     */
    @Transactional(readOnly = true)
    public void validateEmail(String email) {
        if (userMapper.existsEmail(email)) {
            throw new AlreadyExistsEmailException();
        }
    }
}