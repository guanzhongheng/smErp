package com.lcyzh.nmerp.entity;


import com.lcyzh.nmerp.common.persistence.DataEntity;

/**
 * 项目名称：smErp
 * 类 名 称：Customer
 * 类 描 述：TODO
 * 创建时间：2019/6/26 11:24 PM
 * 创 建 人：guan
 */
public class Customer extends DataEntity<Customer> {

    private static final long serialVersionUID = 1L;
    private String cusName;
    private String cusStatus;
    private String cusContent;
    private String cusStar;
    private String lastFollowTime;

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusStatus() {
        return cusStatus;
    }

    public void setCusStatus(String cusStatus) {
        this.cusStatus = cusStatus;
    }

    public String getCusContent() {
        return cusContent;
    }

    public void setCusContent(String cusContent) {
        this.cusContent = cusContent;
    }

    public String getCusStar() {
        return cusStar;
    }

    public void setCusStar(String cusStar) {
        this.cusStar = cusStar;
    }

    public String getLastFollowTime() {
        return lastFollowTime;
    }

    public void setLastFollowTime(String lastFollowTime) {
        this.lastFollowTime = lastFollowTime;
    }
}
