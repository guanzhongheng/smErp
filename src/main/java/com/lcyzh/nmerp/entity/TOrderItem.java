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
    //订单编号
    private Long ordCode;
    //产品编号
    private String itemCode;
    //长度
    private Double itemLenth;
    //宽度
    private Double itemWidth;
    //厚度
    private Double itemThick;
    //颜色
    private String itemColor;
    //计件数
    private Double itemNum;
    //单位
    private Long itemUnit;
    //单价
    private Double itemPrice;
    //计价方式 0-按面积 1-按重量
    private Character itemPriceType;
    //上级客户
    private String superOwer;
    //所属人
    private String itemOwner;
    //备注
    private String remarks;
    private Date createTime;
    //单件重量
    private Double itemWeight;
    //总重量
    private Double itemTotalWeight;
    //总面积
    private Double itemTotalSq;
    //压边类型
    private String itemYbType;
    //延长类型
    private String itemYcType;


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

    public Long getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(Long itemUnit) {
        this.itemUnit = itemUnit;
    }

    public void setItemOwner(String itemOwner) {
        this.itemOwner = itemOwner;
    }

    public String getItemOwner() {
        return itemOwner;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Character getItemPriceType() {
        return itemPriceType;
    }

    public void setItemPriceType(Character itemPriceType) {
        this.itemPriceType = itemPriceType;
    }

    public Double getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(Double itemWeight) {
        this.itemWeight = itemWeight;
    }

    public Double getItemTotalWeight() {
        return itemTotalWeight;
    }

    public void setItemTotalWeight(Double itemTotalWeight) {
        this.itemTotalWeight = itemTotalWeight;
    }

    public Double getItemTotalSq() {
        return itemTotalSq;
    }

    public void setItemTotalSq(Double itemTotalSq) {
        this.itemTotalSq = itemTotalSq;
    }

    public String getItemYbType() {
        return itemYbType;
    }

    public void setItemYbType(String itemYbType) {
        this.itemYbType = itemYbType;
    }

    public String getItemYcType() {
        return itemYcType;
    }

    public void setItemYcType(String itemYcType) {
        this.itemYcType = itemYcType;
    }
}