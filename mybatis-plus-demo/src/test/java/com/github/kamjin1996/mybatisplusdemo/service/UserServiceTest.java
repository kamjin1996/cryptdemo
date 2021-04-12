package com.github.kamjin1996.mybatisplusdemo.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.kamjin1996.mybatisplusdemo.entity.User;
import com.sun.org.apache.bcel.internal.generic.IUSHR;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void list() {
        //列表方法查询
        this.userService.findAll().forEach(System.out::println);
    }

    @Test
    public void update1() {
        this.userService.update(Wrappers.<User>lambdaUpdate().set(User::getUsername, "ahaha").eq(User::getId, 1L));
    }


    @Test
    public void lambadaOneByCrypt() {
        System.out.println(this.userService.lambdaQuery().eq(User::getPassword, "123456").eq(true, User::getUsername, "zhangsan").one());
    }

    @Test
    public void add() {
        User user = new User().setUsername("zxx1").setAge(10).setPassword("123456");
        this.userService.add(user);

        System.out.println(user.getId());
    }
}