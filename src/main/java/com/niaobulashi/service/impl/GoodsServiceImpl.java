package com.niaobulashi.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.niaobulashi.entity.Goods;
import com.niaobulashi.entity.PageBean;
import com.niaobulashi.mapper.GoodsMapper;
import com.niaobulashi.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: hulang
 * @Date: 2019/5/21 00:10
 * @Description: 商品实现类
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 分页查询
     * @param goods 查询条件
     * @param pageCode  当前页
     * @param pageSize  每页的记录数
     * @return
     */
    @Override
    public PageBean findByPages(Goods goods, int pageCode, int pageSize) {
        // 使用Mybatis分页插件
        PageHelper.startPage(pageCode, pageSize);

        // 调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        Page<Goods> page = goodsMapper.findByPage(goods);

        return new PageBean(page.getTotal(), page.getResult());
    }

    @Override
    public List<Goods> findAll() {
        return goodsMapper.findAll();
    }

    @Override
    public List<Goods> findById(Long id) {
        return goodsMapper.findById(id);
    }

    @Override
    public void create(Goods goods) {
        goodsMapper.create(goods);
    }

    @Override
    public void delete(Long... ids) {
        for (Long id : ids) {
            goodsMapper.delete(id);
        }
    }

    @Override
    public void update(Goods goods) {
        goodsMapper.update(goods);
    }
}
