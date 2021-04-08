package com.github.kamjin1996.mybatisdemo.service.impl;

import com.github.kamjin1996.mybatisdemo.entity.User;
import com.github.kamjin1996.mybatisdemo.mapper.UserMapper;
import com.github.kamjin1996.mybatisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务实现类
 *
 * @author kamjin1996
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return this.userMapper.selectAll();
    }

    @Override
    public void add(User user) {
        this.userMapper.insert(user);
    }
}
