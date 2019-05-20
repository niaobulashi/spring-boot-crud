package com.niaobulashi.controller;

import com.niaobulashi.entity.User;
import com.niaobulashi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: hulang
 * @Date: 2019/5/21 00:15
 * @Description:
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }
}