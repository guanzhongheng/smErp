package com.lcyzh.nmerp.entity;

import java.io.Serializable;

/**
 * Author ljk
 * Date  2019-06-06
 */
public class TProdPlanDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String prodPlanCode;
    private String ordCode;
    private String ordTitle;
    private Long orderItemId;
    private String itemCode;
    private Double itemLenth;
    private Double itemWidth;
    private Double itemThick;
    private Long itemNum;
    private Double itemTotalWeight;
    private Double itemTotalSq;
    private String itemYbType;
    private String itemYcType;
    private Character itemStatus;
    private Long itemCgyCode;
    private Long itemVariety;
    private Long itemUnit;
    private String itemOwner;
    private String itemColor;
    private String macCode;
    private Long itemPriceType;
    // 产品备注
    private String itemRemarks;

    // 理论重量
    private Double theoryWeight;

    // 密度
    private Double itemDensity;

    // 标准件浮动上下值
    private Double thresholdUp;
    private Double thresholdDown;
    // 关联客户信息
    private String cusName;

    public Double getItemDensity() {
        return itemDensity;
    }

    public void setItemDensity(Double itemDensity) {
        this.itemDensity = itemDensity;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public Double getThresholdUp() {
        return thresholdUp;
    }

    public void setThresholdUp(Double thresholdUp) {
        this.thresholdUp = thresholdUp;
    }

    public Double getThresholdDown() {
        return thresholdDown;
    }

    public void setThresholdDown(Double thresholdDown) {
        this.thresholdDown = thresholdDown;
    }

    public Double getTheoryWeight() {
        return theoryWeight;
    }

    public void setTheoryWeight(Double theoryWeight) {
        this.theoryWeight = theoryWeight;
    }

    public String getItemRemarks() {
        return itemRemarks;
    }

    public void setItemRemarks(String itemRemarks) {
        this.itemRemarks = itemRemarks;
    }

    public TProdPlanDetail(){
    }

    public String getOrdTitle() {
        return ordTitle;
    }

    public void setOrdTitle(String ordTitle) {
        this.ordTitle = ordTitle;
    }

    public void setId (Long id) {this.id = id;}
    public Long getId(){ return id;}
    public void setProdPlanCode (String prodPlanCode) {this.prodPlanCode = prodPlanCode;}
    public String getProdPlanCode(){ return prodPlanCode;}
    public void setOrdCode (String ordCode) {this.ordCode = ordCode;}
    public String getOrdCode(){ return ordCode;}
    public void setOrderItemId (Long orderItemId) {this.orderItemId = orderItemId;}
    public Long getOrderItemId(){ return orderItemId;}
    public void setItemCode (String itemCode) {this.itemCode = itemCode;}
    public String getItemCode(){ return itemCode;}
    public void setItemLenth (Double itemLenth) {this.itemLenth = itemLenth;}
    public Double getItemLenth(){ return itemLenth;}
    public void setItemWidth (Double itemWidth) {this.itemWidth = itemWidth;}
    public Double getItemWidth(){ return itemWidth;}
    public void setItemThick (Double itemThick) {this.itemThick = itemThick;}
    public Double getItemThick(){ return itemThick;}
    public void setItemNum (Long itemNum) {this.itemNum = itemNum;}
    public Long getItemNum(){ return itemNum;}
    public void setItemTotalWeight (Double itemTotalWeight) {this.itemTotalWeight = itemTotalWeight;}
    public Double getItemTotalWeight(){ return itemTotalWeight;}
    public void setItemTotalSq (Double itemTotalSq) {this.itemTotalSq = itemTotalSq;}
    public Double getItemTotalSq(){ return itemTotalSq;}
    public void setItemYbType (String itemYbType) {this.itemYbType = itemYbType;}
    public String getItemYbType(){ return itemYbType;}
    public void setItemYcType (String itemYcType) {this.itemYcType = itemYcType;}
    public String getItemYcType(){ return itemYcType;}
    public void setItemStatus (Character itemStatus) {this.itemStatus = itemStatus;}
    public Character getItemStatus(){ return itemStatus;}
    public void setItemCgyCode (Long itemCgyCode) {this.itemCgyCode = itemCgyCode;}
    public Long getItemCgyCode(){ return itemCgyCode;}
    public void setItemVariety (Long itemVariety) {this.itemVariety = itemVariety;}
    public Long getItemVariety(){ return itemVariety;}
    public void setItemUnit (Long itemUnit) {this.itemUnit = itemUnit;}
    public Long getItemUnit(){ return itemUnit;}
    public String getItemOwner() {
        return itemOwner;
    }
    public void setItemOwner(String itemOwner) {
        this.itemOwner = itemOwner;
    }
    public String getItemColor() { return itemColor; }
    public void setItemColor(String itemColor) { this.itemColor = itemColor; }
    public String getMacCode() { return macCode; }
    public void setMacCode(String macCode) { this.macCode = macCode; }
    public Long getItemPriceType() { return itemPriceType; }
    public void setItemPriceType(Long itemPriceType) { this.itemPriceType = itemPriceType; }
}