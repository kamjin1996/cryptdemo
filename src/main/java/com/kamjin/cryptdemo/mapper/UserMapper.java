package com.kamjin.cryptdemo.mapper;

import com.kamjin.cryptdemo.entity.User;

import java.util.List;

/**
 * 用户Dao
 *
 * @author kamjin1996
 */
public interface UserMapper {

    List<User> selectAll();

    int insert(User user);
}
