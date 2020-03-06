package com.lcyzh.nmerp.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

/**
 * Author ljk
 * Date  2019-06-06
 */
public class TProdCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String cgyCode;
    private String cgyName;
    private String parentCgyCode;
    private Date createTime;


    public TProdCategory() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCgyCode(String cgyCode) {
        this.cgyCode = cgyCode;
    }

    public String getCgyCode() {
        return cgyCode;
    }

    public void setCgyName(String cgyName) {
        this.cgyName = cgyName;
    }

    public String getCgyName() {
        return cgyName;
    }

    public void setParentCgyCode(String parentCgyCode) {
        this.parentCgyCode = parentCgyCode;
    }

    public String getParentCgyCode() {
        return parentCgyCode;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

}