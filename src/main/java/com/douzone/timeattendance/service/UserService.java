package com.douzone.timeattendance.service;

import com.douzone.timeattendance.domain.Company;
import com.douzone.timeattendance.domain.User;
import com.douzone.timeattendance.dto.auth.AuthInfo;
import com.douzone.timeattendance.dto.user.LoginUserResponse;
import com.douzone.timeattendance.dto.user.UserCreateRequest;
import com.douzone.timeattendance.dto.user.UserResponse;
import com.douzone.timeattendance.dto.user.UserSearchDto;
import com.douzone.timeattendance.dto.user.UserUpdateDto;
import com.douzone.timeattendance.dto.user.UserUpdateRequest;
import com.douzone.timeattendance.exception.user.AlreadyExistsEmailException;
import com.douzone.timeattendance.exception.user.InvalidCompanyCodeException;
import com.douzone.timeattendance.exception.user.NoSuchUserException;
import com.douzone.timeattendance.mapper.CompanyMapper;
import com.douzone.timeattendance.mapper.UserMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserMapper userMapper;
    private final CompanyMapper companyMapper;
    private final PasswordEncoder passwordEncoder;

    public void signup(UserCreateRequest userCreateRequest) {
        //중복 이메일 검증
        validateEmail(userCreateRequest.getEmail());

        //회사 코드 검증
        Company company = companyMapper.findByCode(userCreateRequest.getCompanyCode())
                                       .orElseThrow(InvalidCompanyCodeException::new);

        //비밀번호 암호화
        String encryptedPassword = passwordEncoder.encode(userCreateRequest.getPassword());

        User user = new User(
            userCreateRequest.getName(),
            userCreateRequest.getEmail(),
            encryptedPassword,
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

    @Transactional(readOnly = true)
    public LoginUserResponse loginUserInfo(AuthInfo authInfo) {
        //사용자 검색
        User user = userMapper.findByUserId(authInfo.getUserId())
                              .orElseThrow(NoSuchUserException::new);

        //로그인 사용자 정보 객체 생성
        return LoginUserResponse.from(user);
    }

    @Transactional(readOnly = true)
    public List<UserResponse> getUsers(UserSearchDto searchDto) {
        return userMapper.findAll(searchDto)
                         .stream()
                         .map(UserResponse::new)
                         .collect(Collectors.toList());
    }

    public void updateUser(Long userId, String role) {
        userMapper.findByUserId(userId)
                  .orElseThrow(NoSuchUserException::new);

        UserUpdateDto updateDto = UserUpdateDto.builder()
                                               .role(role)
                                               .build();
        userMapper.update(userId, updateDto);
    }

    public void updateUsers(List<UserUpdateRequest> userUpdateRequests) {
        for (UserUpdateRequest updateRequest : userUpdateRequests) {
            updateUser(updateRequest.getUserId(), updateRequest.getRole());
        }
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