package com.niaobulashi.mapper;

import com.niaobulashi.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * @Auther: hulang
 * @Date: 2019/5/20 23:04
 * @Description: UserMapper
 */
@Mapper
public interface UserMapper {
    List<User> findAll();

    List<User> findById(Long id);

    void create(User user);

    void delete(Long id);

    void update(User user);

    User findByName(String name);
}
