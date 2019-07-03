package com.lcyzh.nmerp.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

/**
 * Author ljk
 * Date  2019-06-06
 */
public class TOutStock implements Serializable {
    private static final long serialVersionUID = 1L;
    private String outCode;
    private String ordCode;
    private Character outStatus;
    private String applyEmpCode;
    private String operEmpCode;
    private Integer outCount;
    private String remark;
    private Date createTime;
    private Date updateTime;
    //天数-默认3天
    private Integer days = 3;

    public String getOutCode() {
        return outCode;
    }

    public void setOutCode(String outCode) {
        this.outCode = outCode;
    }

    public String getOrdCode() {
        return ordCode;
    }

    public void setOrdCode(String ordCode) {
        this.ordCode = ordCode;
    }

    public Character getOutStatus() {
        return outStatus;
    }

    public void setOutStatus(Character outStatus) {
        this.outStatus = outStatus;
    }

    public String getApplyEmpCode() {
        return applyEmpCode;
    }

    public void setApplyEmpCode(String applyEmpCode) {
        this.applyEmpCode = applyEmpCode;
    }

    public String getOperEmpCode() {
        return operEmpCode;
    }

    public void setOperEmpCode(String operEmpCode) {
        this.operEmpCode = operEmpCode;
    }

    public Integer getOutCount() {
        return outCount;
    }

    public void setOutCount(Integer outCount) {
        this.outCount = outCount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }
}