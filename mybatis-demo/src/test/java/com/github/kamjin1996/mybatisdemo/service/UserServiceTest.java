package com.github.kamjin1996.mybatisdemo.service;

import com.github.kamjin1996.mybatisdemo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void findByPassword() {
        System.out.println(this.userService.findByPassword("123456"));
    }

    @Test
    public void listAll() {
        this.userService.findAll().forEach(System.out::println);
    }

    @Test
    public void batchAdd() {
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId((long) i);
            user.setUsername("kam" + i);
            user.setAge(11 + i);
            user.setPassword("123456");
            this.userService.add(user);
        }

    }

}