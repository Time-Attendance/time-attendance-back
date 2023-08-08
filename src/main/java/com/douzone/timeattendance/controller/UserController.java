package com.douzone.timeattendance.controller;

import com.douzone.timeattendance.domain.User;
import com.douzone.timeattendance.dto.UserResponseDto;
import com.douzone.timeattendance.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/findByNotDistributed")
    public List<UserResponseDto> findByNotDistributed() {
        return userService.findByNotDistributed();
    }

    @GetMapping("/api/findByDistributed")
    public List<UserResponseDto> findByDistributed() {
        return userService.findByDistributed();
    }
}
