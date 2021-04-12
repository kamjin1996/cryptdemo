package com.github.kamjin1996.mybatisdemo.service;

import com.github.kamjin1996.mybatisdemo.entity.User;

import java.util.List;

/**
 * 用户服务
 *
 * @author kamjin1996
 */
public interface UserService {

    List<User> findAll();

    void add(User user);
}
