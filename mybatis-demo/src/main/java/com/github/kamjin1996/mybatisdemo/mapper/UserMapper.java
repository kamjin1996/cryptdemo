package com.github.kamjin1996.mybatisdemo.mapper;

import com.github.kamjin1996.mybatisdemo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户Dao
 *
 * @author kamjin1996
 */
@Repository
public interface UserMapper {

    List<User> selectAll();

    int insert(User user);
}
