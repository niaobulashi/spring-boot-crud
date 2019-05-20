package com.niaobulashi.service;

import com.niaobulashi.entity.Goods;
import com.niaobulashi.entity.PageBean;

/**
 *
 */
public interface GoodsService extends BaseService<Goods> {

    /**
     * 分页查询
     * @param goods 查询条件
     * @param pageCode  当前页
     * @param pageSize  每页的记录数
     * @return
     */
    PageBean findByPages(Goods goods, int pageCode, int pageSize);
}
