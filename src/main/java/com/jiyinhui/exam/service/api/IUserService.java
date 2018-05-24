package com.jiyinhui.exam.service.api;

import com.jiyinhui.exam.entity.User;

public interface IUserService {
    User getUserByMobileAndPassword(User user);

    User getUserByMobile(String email);

    void insertUser(User user);

    void updateUser(User user);
}
