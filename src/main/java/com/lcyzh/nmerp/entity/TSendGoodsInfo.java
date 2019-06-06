package com.lcyzh.nmerp.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

/**
 * Author ljk
 * Date  2019-06-06
 */
public class TSendGoodsInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String sgiCode;
    private String driverName;
    private String driverPhone;
    private String driverCarNo;
    private String ordCode;
    private Date createTime;


    public TSendGoodsInfo() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setSgiCode(String sgiCode) {
        this.sgiCode = sgiCode;
    }

    public String getSgiCode() {
        return sgiCode;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverCarNo(String driverCarNo) {
        this.driverCarNo = driverCarNo;
    }

    public String getDriverCarNo() {
        return driverCarNo;
    }

    public void setOrdCode(String ordCode) {
        this.ordCode = ordCode;
    }

    public String getOrdCode() {
        return ordCode;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

}