package com.niaobulashi.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: hulang
 * @Date: 2019/5/20 22:55
 * @Description: 分页公共部分
 */
public class PageBean implements Serializable {

    // 当前页
    private long totle;
    // 当前页记录
    private List rows;

    public PageBean(long totle, List rows) {
        this.totle = totle;
        this.rows = rows;
    }

    public long getTotle() {
        return totle;
    }

    public void setTotle(long totle) {
        this.totle = totle;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
