package com.douzone.timeattendance.service;

import com.douzone.timeattendance.domain.User;
import com.douzone.timeattendance.dto.UserResponseDto;
import com.douzone.timeattendance.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User findByUserEmail(String email) {
        return userMapper.findByUserEmail(email);
    }

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    public Integer countUsersByWorkGroupId(Long workGroupId) {
        return userMapper.countUsersByWorkGroupId(workGroupId);
    }

    public List<UserResponseDto> findByNotDistributed() {
        return userMapper.findByNotDistributed();
    }

    public List<UserResponseDto> findByDistributed() {
        return userMapper.findByDistributed();
    }
}
