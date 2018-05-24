package com.jiyinhui.exam.mapper;

import com.jiyinhui.exam.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User getUserByMobileAndPassword(@Param("user") User user);

    User getUserByMobile(@Param("mobile") String email);

    void insertUser(@Param("user") User user);

    void updateUser(@Param("user") User user);
}
