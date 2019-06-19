package com.lcyzh.nmerp.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

/**
 * Author ljk
 * Date  2019-06-06
 */
public class TInStock implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String inCode;
    private Character inStatus;
    private Long applyUserId;
    private Long operUserId;
    private String renark;
    private Date createTime;


    public TInStock() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setInCode(String inCode) {
        this.inCode = inCode;
    }

    public String getInCode() {
        return inCode;
    }

    public void setInStatus(Character inStatus) {
        this.inStatus = inStatus;
    }

    public Character getInStatus() {
        return inStatus;
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

}