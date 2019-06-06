package com.lcyzh.nmerp.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

/**
 * Author ljk
 * Date  2019-06-06
 */
public class TRawMaterial implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String rawmCode;
    private String rawmName;
    private String rawnSpecs;
    private String rawnSupplier;
    private String rawnCtyCode;
    private Date createTime;
    private Date updateTime;


    public TRawMaterial() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setRawmCode(String rawmCode) {
        this.rawmCode = rawmCode;
    }

    public String getRawmCode() {
        return rawmCode;
    }

    public void setRawmName(String rawmName) {
        this.rawmName = rawmName;
    }

    public String getRawmName() {
        return rawmName;
    }

    public void setRawnSpecs(String rawnSpecs) {
        this.rawnSpecs = rawnSpecs;
    }

    public String getRawnSpecs() {
        return rawnSpecs;
    }

    public void setRawnSupplier(String rawnSupplier) {
        this.rawnSupplier = rawnSupplier;
    }

    public String getRawnSupplier() {
        return rawnSupplier;
    }

    public void setRawnCtyCode(String rawnCtyCode) {
        this.rawnCtyCode = rawnCtyCode;
    }

    public String getRawnCtyCode() {
        return rawnCtyCode;
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