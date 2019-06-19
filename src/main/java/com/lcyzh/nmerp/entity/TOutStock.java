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
    private Long id;
    private String outCode;
    private Character outStatus;
    private Long applyUserId;
    private Long operUserId;
    private String renark;
    private Date createTime;
    private Date updateTime;


    public TOutStock() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setOutCode(String outCode) {
        this.outCode = outCode;
    }

    public String getOutCode() {
        return outCode;
    }

    public void setOutStatus(Character outStatus) {
        this.outStatus = outStatus;
    }

    public Character getOutStatus() {
        return outStatus;
    }

    public void setApplyUserId(Long applyUserId) {
        this.applyUserId = applyUserId;
    }

    public Long getApplyUserId() {
        return applyUserId;
    }

    public void setOperUserId(Long operUserId) {
        this.operUserId = operUserId;
    }

    public Long getOperUserId() {
        return operUserId;
    }

    public void setRenark(String renark) {
        this.renark = renark;
    }

    public String getRenark() {
        return renark;
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