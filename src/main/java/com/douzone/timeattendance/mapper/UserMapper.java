package com.douzone.timeattendance.mapper;

import com.douzone.timeattendance.domain.User;
import com.douzone.timeattendance.dto.user.UserSearchDto;
import com.douzone.timeattendance.dto.user.UserUpdateDto;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    void insert(User user);

    boolean existsEmail(String email);

    Optional<User> findByUserId(Long userId);

    Optional<User> findByEmail(String email);

    List<User> findAll(UserSearchDto searchDto);

    void update(@Param("userId") Long userId, @Param("updateDto") UserUpdateDto updateDto);
}
