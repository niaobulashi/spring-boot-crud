package com.niaobulashi.interceptor;

import com.niaobulashi.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: spring-boot-crud
 * @description: 自定义拦截器
 * @author: hulang
 * @create: 2019-05-22 15:17
 */
@Component
@Aspect
public class MyInterceptor {

    @Pointcut("within (com.niaobulashi.controller..*) && !within(com.niaobulashi.controller.LoginController)")
    public void pointCut() {

    }

    @Around("pointCut()")
    public Object trackinfo(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request =attributes.getRequest();
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            System.out.println("--------用户登陆-------");
            // 手动转发/login的映射路径
            attributes.getResponse().sendRedirect("/login");
        } else {
            System.out.println("--------用户已登陆------");
        }
        //一定要指定Object返回值，若AOP拦截的Controller return了一个视图地址，那么本来Controller应该跳转到这个视图地址的，
        // 但是被AOP拦截了，那么原来Controller仍会执行return，但是视图地址却找不到404了
        //切记一定要调用proceed()方法
        //proceed()：执行被通知的方法，如不调用将会阻止被通知的方法的调用，也就导致Controller中的return会404
        return joinPoint.proceed();
    }
}

