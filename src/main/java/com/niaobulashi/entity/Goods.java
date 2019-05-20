package com.niaobulashi.entity;

import java.io.Serializable;

/**
 * @Auther: hulang
 * @Date: 2019/5/20 22:51
 * @Description: 产品表
 */
public class Goods implements Serializable {

    private Long id;
    private String title;
    private String price;
    private String image;
    private String brand;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
