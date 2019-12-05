package com.kamjin.cryptdemo.entity;

import com.kamjin.cryptdemo.base.BaseEntity;
import lombok.Data;
import mybatis.intercept.crypt.annotation.CryptField;

/**
 * 用户数据模型
 *
 * @author kamjin1996
 */
@Data
public class User extends BaseEntity {

    public Long id;

    private String username;

    @CryptField private String password;

    private Integer age;
}
