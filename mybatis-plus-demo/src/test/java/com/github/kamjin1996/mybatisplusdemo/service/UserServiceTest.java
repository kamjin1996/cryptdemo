package com.github.kamjin1996.mybatisplusdemo.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.kamjin1996.mybatisplusdemo.entity.User;
import com.sun.org.apache.bcel.internal.generic.IUSHR;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

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

    @Test
    public void list() {
        //列表方法查询
        this.userService.findAll().forEach(System.out::println);
        System.out.println("-----------------------------------");
        this.userService.findAll().forEach(System.out::println);
    }

    @Test
    public void listByWrapper() {
        //列表方法查询
        List<User> list = this.userService.lambdaQuery().eq(User::getPassword, "123456").list();
        List<User> list2 = this.userService.lambdaQuery().eq(User::getPassword, "123456").list();
        System.out.println(list);
        System.out.println("----------------------------");
        System.out.println(list2);
    }

    @Test
    public void lambadaUpdate1() {
        this.userService.update(Wrappers.<User>lambdaUpdate().set(User::getPassword, "123").eq(User::getUsername, "ahaha"));
    }

    @Test
    public void lambadaQueryByCrypt() {

        System.out.println(this.userService.lambdaQuery().eq(User::getUsername, "zxx").eq(User::getPassword, "123456").list());
    }

    @Test
    public void queryWrapperQuery() {
        System.out.println(this.userService.query().eq("password", "456").eq("username", "xiaoA").one());
    }

    @Test
    public void updateWrapperUpdate() {
        System.out.println(this.userService.query().eq("password", "123").eq("username", "ahaha").one());
    }

    @Test
    public void deleteByPassword() {
        this.userService.remove(Wrappers.<User>lambdaUpdate().eq(User::getPassword, "456"));
    }

    @Test
    public void queryWrapperQueryList() {
        System.out.println(this.userService.query().eq("username", "zxx").list());
    }

    @Test
    public void listByBaseMapperParam() {
        System.out.println(this.userService.listByPasswordAndUsername("123456", "zxx"));
    }
}