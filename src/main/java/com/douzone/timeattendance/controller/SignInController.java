package com.douzone.timeattendance.controller;

import com.douzone.timeattendance.domain.User;
import com.douzone.timeattendance.dto.UserRequestDto;
import com.douzone.timeattendance.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class SignInController {
    private final UserService userService;

    public SignInController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/signIn")
    public String signIn(@RequestBody UserRequestDto userRequestDto, Model model, HttpSession session) {
        User user = userService.findByUserEmail(userRequestDto.getEmail());

        if (user != null) {
            if (user.getPassword().equals(userRequestDto.getPassword())) {
                session.setAttribute("user", user);

                return "Logged in.";
            } else {
                return "Wrong password.";
            }
        } else {
            return "No matched account. Please sign up.";
        }
    }

    @PostMapping("/api/signUp")
    public String signUp(@RequestBody UserRequestDto userRequestDto, Model model, HttpSession session) {
        User user = userService.findByUserEmail(userRequestDto.getEmail());

        if (user != null) {
            return "Account already exists.";
        } else {
            User userToBeInserted = new User(userRequestDto);
            userService.insertUser(userToBeInserted);

            session.setAttribute("user", userToBeInserted);

            return "Signed Up!";
        }
    }

}
