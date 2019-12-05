package com.kamjin.cryptdemo.service;

import com.kamjin.cryptdemo.base.BaseService;
import com.kamjin.cryptdemo.entity.UserDto;

import java.util.List;

/**
 * 用户服务
 *
 * @author kamjin1996
 */
public interface UserService extends BaseService {

    List<UserDto> findAll();

    void add(UserDto userDto);
}
