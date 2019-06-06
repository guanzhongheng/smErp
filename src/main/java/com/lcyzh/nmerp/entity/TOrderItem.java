package com.lcyzh.nmerp.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

/**
 * Author ljk
 * Date  2019-06-06
 */
public class TOrderItem implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long ordCode;
    private String itemCode;
    private Double itemNum;
    private Double itemLenth;
    private Double itemWidth;
    private Double itemThick;
    private String itemColor;
    private Double itemWeight;
    private String itemOwner;
    private String remark;
    private Date createTime;


    public TOrderItem() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setOrdCode(Long ordCode) {
        this.ordCode = ordCode;
    }

    public Long getOrdCode() {
        return ordCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemNum(Double itemNum) {
        this.itemNum = itemNum;
    }

    public Double getItemNum() {
        return itemNum;
    }

    public void setItemLenth(Double itemLenth) {
        this.itemLenth = itemLenth;
    }

    public Double getItemLenth() {
        return itemLenth;
    }

    public void setItemWidth(Double itemWidth) {
        this.itemWidth = itemWidth;
    }

    public Double getItemWidth() {
        return itemWidth;
    }

    public void setItemThick(Double itemThick) {
        this.itemThick = itemThick;
    }

    public Double getItemThick() {
        return itemThick;
    }

    public void setItemColor(String itemColor) {
        this.itemColor = itemColor;
    }

    public String getItemColor() {
        return itemColor;
    }

    public void setItemWeight(Double itemWeight) {
        this.itemWeight = itemWeight;
    }

    public Double getItemWeight() {
        return itemWeight;
    }

    public void setItemOwner(String itemOwner) {
        this.itemOwner = itemOwner;
    }

    public String getItemOwner() {
        return itemOwner;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

}