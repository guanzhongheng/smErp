package com.lcyzh.nmerp.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Author ljk
 * Date  2019-07-01
 */
public class CusEmpRel implements Serializable {
    private static final long serialVersionUID = 1L;
    private String cusCode;
    private String empCode;
    private Date createTime;
    private Date updateTime;


    public void setCusCode(String cusCode) {
        this.cusCode = cusCode;
    }

    public String getCusCode() {
        return cusCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

}