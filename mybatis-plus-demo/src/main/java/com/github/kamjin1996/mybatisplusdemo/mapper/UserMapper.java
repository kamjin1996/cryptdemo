package com.github.kamjin1996.mybatisplusdemo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kamjin1996.mybatisplusdemo.entity.User;
import com.kamjin.toolkit.db.crypt.core.annotation.CryptField;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户Dao
 *
 * @author kamjin1996
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> selectAll();

    int insertOne(User user);

    List<User> selectListByPasswordAndUsername(@CryptField @Param("password") String password, @Param("username") String username);
}
