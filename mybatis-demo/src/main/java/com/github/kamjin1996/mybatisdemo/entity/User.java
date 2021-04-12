package com.github.kamjin1996.mybatisdemo.entity;

import com.kamjin.toolkit.db.crypt.core.annotation.CryptField;
import lombok.Data;

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
