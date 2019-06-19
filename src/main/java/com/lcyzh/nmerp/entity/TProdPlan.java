package com.lcyzh.nmerp.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

/**
 * Author ljk
 * Date  2019-06-06
 */
public class TProdPlan implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String prodPlanCode;
    private String ordCode;
    private Character planStatus;
    private Long operUserId;
    private Date createTime;
    private Date updateTime;


    public TProdPlan() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setProdPlanCode(String prodPlanCode) {
        this.prodPlanCode = prodPlanCode;
    }

    public String getProdPlanCode() {
        return prodPlanCode;
    }

    public void setOrdCode(String ordCode) {
        this.ordCode = ordCode;
    }

    public String getOrdCode() {
        return ordCode;
    }

    public void setPlanStatus(Character planStatus) {
        this.planStatus = planStatus;
    }

    public Character getPlanStatus() {
        return planStatus;
    }

    public void setOperUserId(Long operUserId) {
        this.operUserId = operUserId;
    }

    public Long getOperUserId() {
        return operUserId;
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