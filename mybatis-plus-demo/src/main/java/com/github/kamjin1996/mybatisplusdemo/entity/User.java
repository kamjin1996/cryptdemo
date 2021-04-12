package com.github.kamjin1996.mybatisplusdemo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kamjin.toolkit.db.crypt.core.annotation.CryptField;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户数据模型
 *
 * @author kamjin1996
 */
@Data
@Accessors(chain = true)
@TableName("user")
public class User {

    @TableId("id")
    public Long id;

    @TableField(value = "username")
    private String username;

    @CryptField
    @TableField("password")
    private String password;

    @TableField("age")
    private Integer age;
}
