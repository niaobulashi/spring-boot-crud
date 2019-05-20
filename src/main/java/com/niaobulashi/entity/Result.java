package com.niaobulashi.entity;

import java.io.Serializable;

/**
 * @Auther: hulang
 * @Date: 2019/5/20 22:53
 * @Description: 返回值
 */
public class Result implements Serializable {

    // 判断结果
    private boolean success;
    // 返回信息
    private String messgae;

    public Result() {
    }

    public Result(boolean success, String messgae) {
        this.success = success;
        this.messgae = messgae;
    }

    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
