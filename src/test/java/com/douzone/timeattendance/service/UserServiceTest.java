package com.douzone.timeattendance.service;

import static org.junit.jupiter.api.Assertions.*;

import com.douzone.timeattendance.domain.User;
import com.douzone.timeattendance.mapper.UserMapper;
import java.time.LocalDate;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserMapper userMapper;

    @Test
    @DisplayName("회원 더미 데이터 생성")
    void createUser() {
        IntStream.rangeClosed(1, 100)
                 .forEach(i -> userMapper.insert(
                         new User(
                                 "홍길동" + i,
                                 "hong" + i + "@email.com",
                                 "$2a$10$ZMETmAAMW2w8LYQJAQIJqeZ9Nx1PHVa/gvPnzDx3J8ot7qek2QB3K",
                                 "010-1234-5678",
                                 LocalDate.parse("1980-01-01"),
                                 LocalDate.now(),
                                 "인사",
                                 "대리",
                                 "USER",
                                 1L
                         )));
    }
}