package com.niaobulashi.service;

import java.util.List;

/**
 * @Auther: hulang
 * @Date: 2019/5/20 23:52
 * @Description: 通用的Service层接口
 */
public interface BaseService<T> {

    /**
     * 查询所有
     * @return
     */
    List<T> findAll();

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    List<T> findById(Long id);

    /**
     * 添加
     * @param t
     */
    void create(T t);

    /**
     * 删除（批量）
     * @param ids
     */
    void delete(Long... ids);

    /**
     * 修改
     * @param t
     */
    void update(T t);
}
