package com.github.kamjin1996.mybatisplusdemo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.github.kamjin1996.mybatisplusdemo.entity.User;

import java.util.List;

/**
 * 用户服务
 *
 * @author kamjin1996
 */
public interface UserService extends IService<User> {

    List<User> findAll();

    void add(User user);

    List<User> listByPasswordAndUsername(String password, String username);
}
