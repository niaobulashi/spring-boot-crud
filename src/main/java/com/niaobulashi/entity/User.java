package com.niaobulashi.entity;

import java.io.Serializable;

/**
 * @Auther: hulang
 * @Date: 2019/5/20 22:49
 * @Description: 用户表
 */
public class User implements Serializable {

    private Long id;
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}