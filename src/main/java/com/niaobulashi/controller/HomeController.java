package com.niaobulashi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: spring-boot-crud
 * @description: 首页控制器
 * @author: hulang
 * @create: 2019-05-21 09:52
 */
@Controller
public class HomeController {

    /**
     * 首页
     * @return
     */
    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "home/index";
    }

    @GetMapping(value = {"/goods"})
    public String goods() {
        return "site/goods";
    }
}

