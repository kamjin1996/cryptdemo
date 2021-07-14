package com.github.kamjin1996.mybatisdemo.service;

import com.github.kamjin1996.mybatisdemo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired UserService userService;

    @Test
    public void listAll() {
        this.userService.findAll().forEach(System.out::println);
    }

    @Test
    public void add() {
        User user = new User();
        user.setId(11L);
        user.setUsername("kam");
        user.setAge(11);
        user.setPassword("123456");
        this.userService.add(user);
    }

}