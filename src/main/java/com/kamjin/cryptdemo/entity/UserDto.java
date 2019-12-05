package com.kamjin.cryptdemo.entity;

import com.kamjin.cryptdemo.base.BaseDto;
import lombok.Data;

/**
 * 用户业务模型
 *
 * @author kamjin1996
 */
@Data
public class UserDto extends BaseDto {

    public Long id;

    private String username;

    private String password;

    private Integer age;
}
