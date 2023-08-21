package com.douzone.timeattendance.mapper;

import com.douzone.timeattendance.domain.User;
import com.douzone.timeattendance.dto.user.UserSearchDto;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void insert(User user);

    boolean existsEmail(String email);

    Optional<User> findByUserId(Long userId);

    Optional<User> findByEmail(String email);

    List<User> findAll(UserSearchDto searchDto);
}
