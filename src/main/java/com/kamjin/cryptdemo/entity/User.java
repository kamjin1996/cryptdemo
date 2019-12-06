package com.kamjin.cryptdemo.entity;

import com.github.kamjin1996.mybatis.intercept.crypt.annotation.CryptField;
import com.kamjin.cryptdemo.base.BaseEntity;
import lombok.Data;

/**
 * 用户数据模型
 *
 * @author kamjin1996
 */
@Data
public class User extends BaseEntity {

    public Long id;

    private String username;

    @CryptField
    private String password;

    private Integer age;
}
