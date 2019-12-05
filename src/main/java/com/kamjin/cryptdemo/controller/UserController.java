package com.kamjin.cryptdemo.controller;

import com.kamjin.cryptdemo.entity.UserDto;
import com.kamjin.cryptdemo.service.UserService;
import com.kamjin.cryptdemo.base.BaseController;
import com.kamjin.cryptdemo.base.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户控制器
 *
 * @author kamjin1996
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired private UserService userService;

    @GetMapping(value = "/all")
    public BaseResult<List<UserDto>> all() {
        List<UserDto> all = this.userService.findAll();
        return response(all);
    }

    @PostMapping("/add")
    public BaseResult add(@RequestBody UserDto userDto) {
        this.userService.add(userDto);
        return response();
    }
}
