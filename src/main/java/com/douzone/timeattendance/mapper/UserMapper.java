package com.douzone.timeattendance.mapper;

import com.douzone.timeattendance.domain.User;
import com.douzone.timeattendance.dto.UserResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User findByUserEmail(String email);

    void insertUser(User user);

    Integer countUsersByWorkGroupId(Long workGroupId);

    List<UserResponseDto> findByNotDistributed();
    List<UserResponseDto> findByDistributed();
}
