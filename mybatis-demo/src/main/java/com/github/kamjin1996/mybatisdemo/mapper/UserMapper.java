package com.github.kamjin1996.mybatisdemo.mapper;

import com.github.kamjin1996.mybatisdemo.entity.User;

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
