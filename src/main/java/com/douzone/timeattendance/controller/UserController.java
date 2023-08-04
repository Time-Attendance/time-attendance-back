package com.douzone.timeattendance.controller;

import com.douzone.timeattendance.dto.user.UserCreateRequest;
import com.douzone.timeattendance.service.UserService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@RequestBody @Valid UserCreateRequest userCreateRequest) {
        userService.signup(userCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                             .build();
    }
}
