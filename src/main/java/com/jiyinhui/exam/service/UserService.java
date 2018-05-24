package com.jiyinhui.exam.service;

import com.jiyinhui.exam.entity.User;
import com.jiyinhui.exam.mapper.UserMapper;
import com.jiyinhui.exam.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByMobileAndPassword(User user) {
        return userMapper.getUserByMobileAndPassword(user);
    }

    @Override
    public User getUserByMobile(String email) {
        return userMapper.getUserByMobile(email);
    }

    @Override
    @Transactional
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}
