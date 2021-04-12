package com.github.kamjin1996.mybatisplusdemo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kamjin1996.mybatisplusdemo.entity.User;

import java.util.List;

/**
 * 用户Dao
 *
 * @author kamjin1996
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> selectAll();

    int insert(User user);
}
