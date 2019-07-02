package com.lcyzh.nmerp.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Author ljk
 * Date  2019-07-01
 */
public class CusFollow implements Serializable {
    private static final long serialVersionUID = 1L;
    private String cusCode;
    private Date latestFollowTime;
    private Date createTime;
    private Date updateTime;


    public void setCusCode(String cusCode) {
        this.cusCode = cusCode;
    }

    public String getCusCode() {
        return cusCode;
    }

    public void setLatestFollowTime(Date latestFollowTime) {
        this.latestFollowTime = latestFollowTime;
    }

    public Date getLatestFollowTime() {
        return latestFollowTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}