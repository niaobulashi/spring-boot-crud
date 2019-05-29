package com.niaobulashi.controller.admin;

import com.niaobulashi.entity.Result;
import com.niaobulashi.entity.User;
import com.niaobulashi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @program: spring-boot-crud
 * @description: 用户登陆
 * @author: hulang
 * @create: 2019-05-21 09:55
 */
@Controller
public class LoginController {

    @Resource
    private UserService userService;

    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println("username=" + username + ", password=" + password);
        // 根据用户名查询用户信息
        User user = userService.findByName(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                // 讲登陆信息存入到sessions对象中
                attributes.getRequest().getSession().setAttribute("user", user);
                return new Result(true, user.getUsername());
            }
        }
        return new Result(false, "登陆失败");
    }

    /**
     * 注销
     * @return
     */
    @RequestMapping("/logout")
    public String logout() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        attributes.getRequest().getSession().removeAttribute("user");
        return "/home/login";
    }

    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping("/register")
    public Result register(@RequestParam("username") String username, @RequestParam("password") String password) {
        try {
            userService.create(new User(username, password));
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            //将登陆用户信息存入到session域对象中
            attributes.getRequest().getSession().setAttribute("user", new User(username, password));
            return new Result(true, username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false, "发生位置错误");
    }

    /**
     * 登陆页
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "/home/login";
    }

    /**
     * 注册页
     * @return
     */
    @GetMapping("/register")
    public String regiter() {
        return "/home/register";
    }

    public static void main(String[] args) {
        BigDecimal bignum1 = new BigDecimal("10");
        BigDecimal bignum2 = new BigDecimal("100");
        BigDecimal bignum3 = null;
        bignum3 = bignum1.divide(bignum2);
        System.out.println("商  是：" + bignum3);
    }
}

