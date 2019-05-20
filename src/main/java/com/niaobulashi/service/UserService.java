package com.niaobulashi.service;

import com.niaobulashi.entity.User;

/**
 * @Auther: hulang
 * @Date: 2019/5/21 00:02
 * @Description:
 */
public interface UserService extends BaseService<User> {

    User findByName(String name);
}
