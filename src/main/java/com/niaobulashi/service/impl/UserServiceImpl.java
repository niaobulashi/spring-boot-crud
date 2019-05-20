package com.niaobulashi.service.impl;

import com.niaobulashi.entity.User;
import com.niaobulashi.mapper.UserMapper;
import com.niaobulashi.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: hulang
 * @Date: 2019/5/21 00:05
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public List<User> findById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public void create(User user) {
        userMapper.create(user);
    }

    @Override
    public void delete(Long... ids) {
        for (Long id : ids) {
            userMapper.delete(id);
        }
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }
}
