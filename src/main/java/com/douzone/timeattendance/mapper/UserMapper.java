package com.douzone.timeattendance.mapper;

import com.douzone.timeattendance.domain.User;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void insert(User user);

    boolean existsEmail(String email);

    Optional<User> findByEmail(String email);

}
