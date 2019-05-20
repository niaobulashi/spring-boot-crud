package com.niaobulashi.mapper;

import com.github.pagehelper.Page;
import com.niaobulashi.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: hulang
 * @Date: 2019/5/20 23:16
 * @Description: 商品表
 */
@Mapper
public interface GoodsMapper {

    List<Goods> findAll();

    Page<Goods> findByPage(Goods goods);

    List<Goods> findById(Long id);

    void create(Goods goods);

    void update(Goods goods);

    void delete(Long id);
}
