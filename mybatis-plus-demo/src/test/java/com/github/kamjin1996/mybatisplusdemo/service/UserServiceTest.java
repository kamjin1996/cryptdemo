package com.github.kamjin1996.mybatisplusdemo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kamjin1996.mybatisplusdemo.entity.User;
import com.sun.org.apache.bcel.internal.generic.IUSHR;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void add() {
        User user = new User().setUsername("zxx1").setAge(10).setPassword("123456");
        User user1 = new User().setUsername("zhangsan").setAge(10).setPassword("123456");
        User user2 = new User().setUsername("ahaha").setAge(10).setPassword("123");
        User user3 = new User().setUsername("xiaoA").setAge(10).setPassword("456");
        this.userService.addAll(Arrays.asList(user, user1, user2, user3));

        System.out.println(user.getId());
        System.out.println(user1.getId());
        System.out.println(user2.getId());
        System.out.println(user3.getId());
    }

    @Test
    public void update1() {
        this.userService.update(Wrappers.<User>lambdaUpdate()
                .set(User::getUsername, "ahaha")
                .eq(User::getId, 1L));
    }

    @Test
    public void lambadaUpdate1() {
        this.userService.update(Wrappers.<User>lambdaUpdate()
                .set(User::getPassword, "123")
                .eq(User::getUsername, "ahaha"));
    }

    @Test
    public void lambadaQueryOne() {
        System.out.println(this.userService.lambdaQuery()
                .eq(User::getPassword, "123456")
                .eq(User::getUsername, "zhangsan")
                .one());
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
        List<User> list = this.userService.lambdaQuery()
                .eq(User::getPassword, "123456")
                .list();
        List<User> list2 = this.userService.lambdaQuery()
                .eq(User::getPassword, "123456")
                .list();
        System.out.println(list);
        System.out.println("----------------------------");
        System.out.println(list2);
    }


    @Test
    public void lambadaList() {
        System.out.println(this.userService.lambdaQuery()
                .eq(User::getUsername, "zxx1")
                .eq(User::getPassword, "123456")
                .list());
    }

    @Test
    public void queryWrapperQuery() {
        System.out.println(this.userService.query()
                .eq("password", "456")
                .eq("username", "xiaoA")
                .one());
    }

    @Test
    public void deleteByPassword() {
        this.userService.remove(Wrappers.<User>lambdaUpdate()
                .eq(User::getPassword, "456"));
    }

    @Test
    public void queryWrapperList() {
        System.out.println(this.userService.query()
                .eq("username", "zxx")
                .list());
    }

    @Test
    public void listByBaseMapperParam() {
        System.out.println(this.userService.listByPasswordAndUsername("123456", "zxx"));
    }

    @Test
    public void pageQuery() {
        Page<User> page = this.userService.page(new Page<>(1, 10), Wrappers.<User>lambdaQuery().eq(User::getPassword, "123456"));
        System.out.println(page.getRecords());
    }

    @Test
    public void wrapperPageQuery() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("password", "123456");
        IPage<User> page = this.userService.page(new Page<>(1, 10), wrapper);
        List<User> records = page.getRecords();
        System.out.println(records);
    }

}