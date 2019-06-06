package com.lcyzh.nmerp.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

/**
 * Author ljk
 * Date  2019-06-06
 */
public class TInStockDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String inCode;
    private String itemCode;
    private String itemSpec;
    private Double inNum;
    private Character itemType;
    private String unit;
    private Character qualityStatus;
    private String qualityUsCode;
    private Date createTime;


    public TInStockDetail() {
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

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemSpec(String itemSpec) {
        this.itemSpec = itemSpec;
    }

    public String getItemSpec() {
        return itemSpec;
    }

    public void setInNum(Double inNum) {
        this.inNum = inNum;
    }

    public Double getInNum() {
        return inNum;
    }

    public void setItemType(Character itemType) {
        this.itemType = itemType;
    }

    public Character getItemType() {
        return itemType;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
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