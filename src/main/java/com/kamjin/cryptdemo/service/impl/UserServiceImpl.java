package com.kamjin.cryptdemo.service.impl;

import com.kamjin.cryptdemo.entity.User;
import com.kamjin.cryptdemo.entity.UserDto;
import com.kamjin.cryptdemo.service.UserService;
import com.kamjin.cryptdemo.base.BaseConverter;
import com.kamjin.cryptdemo.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务实现类
 *
 * @author kamjin1996
 */
@Service
public class UserServiceImpl extends BaseConverter<User, UserDto> implements UserService {

    @Autowired private UserMapper userMapper;

    protected UserServiceImpl() {
        super(
                userDTO -> {
                    User user = new User();
                    BeanUtils.copyProperties(userDTO, user);
                    return user;
                },
                user -> {
                    UserDto userDTO = new UserDto();
                    BeanUtils.copyProperties(user, userDTO);
                    return userDTO;
                });
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = this.userMapper.selectAll();
        return this.converterFromEntitys(users);
    }

    @Override
    public void add(UserDto userDto) {
        User user = this.converterFromDto(userDto);
        this.userMapper.insert(user);
    }
}
