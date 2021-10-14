package com.github.kamjin1996.mybatisplusdemo.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.kamjin1996.mybatisplusdemo.entity.User;
import com.github.kamjin1996.mybatisplusdemo.mapper.UserMapper;
import com.github.kamjin1996.mybatisplusdemo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务实现类
 *
 * @author kamjin1996
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public List<User> findAll() {
        return this.list();
    }

    @Override
    public void add(User user) {
        this.save(user);
    }

    @Override
    public void addAll(List<User> users) {
        this.saveBatch(users);
    }

    @Override
    public List<User> listByPasswordAndUsername(String password, String username) {
        return this.baseMapper.selectListByPasswordAndUsername(password, username
        );
    }
}
