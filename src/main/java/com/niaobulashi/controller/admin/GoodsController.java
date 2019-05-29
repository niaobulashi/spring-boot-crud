package com.niaobulashi.controller.admin;

import com.niaobulashi.entity.Goods;
import com.niaobulashi.entity.PageBean;
import com.niaobulashi.entity.Result;
import com.niaobulashi.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: spring-boot-crud
 * @description: 商品表数据相关查询
 * @author: hulang
 * @create: 2019-05-29 15:40
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 商品列表查询
     * @param goods     查询条件
     * @param pageCode  当前页
     * @param pageSize  每页显示的记录数
     * @return
     */
    @RequestMapping("/findByConPage")
    public PageBean findByConPage(Goods goods,
                                  @RequestParam(value = "pageCode", required = false) int pageCode,
                                  @RequestParam(value = "pageSize", required = false) int pageSize) {
        return goodsService.findByPages(goods, pageCode, pageSize);
    }

    /**
     * 新增商品
     * @param goods
     * @return
     */
    @RequestMapping("/create")
    public Result create(@RequestBody Goods goods) {
        try {
            goodsService.create(goods);
            return new Result(true, "创建商品成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发生未知错误");
        }
    }

    /**
     * 修改商品信息
     * @param goods
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody Goods goods) {
        try {
            goodsService.update(goods);
            return new Result(true, "更新商品信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发生未知错误");
        }
    }

    /**
     * 批量删除数据
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody Long... ids){
        try {
            goodsService.delete(ids);
            return new Result(true, "删除商品成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true, "发生未知错误");
        }
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public List<Goods> findById(@RequestParam(value = "id", required = false) Long id) {
        return goodsService.findById(id);
    }
}

