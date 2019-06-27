package com.lcyzh.nmerp.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

/**
 * Author ljk
 * Date  2019-06-06
 */
public class TOutStockDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String outCode;
    private String barCode;
    private Character qualityStatus;
    private String qualityUsCode;
    private Date createTime;


    public TOutStockDetail() {
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

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public void setQualityStatus(Character qualityStatus) {
        this.qualityStatus = qualityStatus;
    }

    public Character getQualityStatus() {
        return qualityStatus;
    }

    public void setQualityUsCode(String qualityUsCode) {
        this.qualityUsCode = qualityUsCode;
    }

    public String getQualityUsCode() {
        return qualityUsCode;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

}