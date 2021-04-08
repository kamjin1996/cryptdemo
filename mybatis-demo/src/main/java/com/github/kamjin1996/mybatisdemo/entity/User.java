package com.github.kamjin1996.mybatisdemo.entity;

import com.github.kamjin1996.mybatis.intercept.crypt.annotation.CryptField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户数据模型
 *
 * @author kamjin1996
 */
@Data
public class User {

    public Long id;

    private String username;

    @CryptField
    private String password;

    private Integer age;
}
