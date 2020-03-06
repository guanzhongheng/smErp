package com.lcyzh.nmerp.model.vo;

import java.util.Date;

/**
 * @Project :
 * @Description :
 * @Author :
 * @Iteration :
 * @Date :
 * @ModificationHistory Who          When          WhatitemVariety
 */
public class ProdPlanDetailVo{
    private Long prodPlanDetailId;
    private String prodPlanDetailIds;
    private String prodPlanCode;
    private String ordCode;
    private String orderTitle;
    private String proxyName;
    private String cusName;
    private Long orderItemId;
    private String itemCode;
    private Double itemLenth;
    private Double itemWidth;
    private Double itemThick;
    private Long itemNum;
    private Double itemTotalWeight;
    private Double itemTotalSq;
    private String itemYbType;
    private String itemYbTypeValue;
    private String itemYcType;
    private String itemYcTypeValue;
    private Character itemStatus;
    private String itemStatusValue;
    private Long itemCgyCode;
    private String itemCgyCodeValue;
    private Long itemVariety;
    private String itemVarietyValue;

    private String useTime;
    private Long itemUnit;
    private String itemOwner;
    private String itemColor;
    private String itemColorValue;
    //机台编码
    private String macCode;
    //配方
    private String formula;
    //条形码
    private String barCode;
    //产品单件重量
    private Double itemWeight;
    //产品单件面积
    private String itemSq;

    private Date createTime;
    //皮重
    private Double itemTareWeight;

    private Long itemPriceType;

    private String seCode;

    private int ordSort = 0;

    // 产品备注
    private String itemRemarks;

    // 理论重量
    private Double theoryWeight;

    private Double startLength;

    private Double endLength;

    // 标准件浮动上下值
    private Double thresholdUp;
    private Double thresholdDown;

    // 密度
    private Double itemDensity;

    private Double itemMickWeight;

    // 延长后长度
    private Double itemYcLenth;

    private Double trueWeight;

    private Integer isYb;

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }
    public Integer getIsYb() {
        return isYb;
    }

    public void setIsYb(Integer isYb) {
        this.isYb = isYb;
    }

    public String getProdPlanDetailIds() {
        return prodPlanDetailIds;
    }

    public void setProdPlanDetailIds(String prodPlanDetailIds) {
        this.prodPlanDetailIds = prodPlanDetailIds;
    }

    public Double getTrueWeight() {
        return trueWeight;
    }

    public void setTrueWeight(Double trueWeight) {
        this.trueWeight = trueWeight;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public Double getItemYcLenth() {
        return itemYcLenth;
    }

    public void setItemYcLenth(Double itemYcLenth) {
        this.itemYcLenth = itemYcLenth;
    }

    public Double getItemMickWeight() {
        return itemMickWeight;
    }

    public void setItemMickWeight(Double itemMickWeight) {
        this.itemMickWeight = itemMickWeight;
    }

    public Double getItemDensity() {
        return itemDensity;
    }

    public void setItemDensity(Double itemDensity) {
        this.itemDensity = itemDensity;
    }

    public String getItemStatusValue() {
        return itemStatusValue;
    }

    public void setItemStatusValue(String itemStatusValue) {
        this.itemStatusValue = itemStatusValue;
    }

    public String getItemYbTypeValue() {
        return itemYbTypeValue;
    }

    public void setItemYbTypeValue(String itemYbTypeValue) {
        this.itemYbTypeValue = itemYbTypeValue;
    }

    public String getItemYcTypeValue() {
        return itemYcTypeValue;
    }

    public void setItemYcTypeValue(String itemYcTypeValue) {
        this.itemYcTypeValue = itemYcTypeValue;
    }

    public String getItemCgyCodeValue() {
        return itemCgyCodeValue;
    }

    public void setItemCgyCodeValue(String itemCgyCodeValue) {
        this.itemCgyCodeValue = itemCgyCodeValue;
    }

    public String getItemVarietyValue() {
        return itemVarietyValue;
    }

    public void setItemVarietyValue(String itemVarietyValue) {
        this.itemVarietyValue = itemVarietyValue;
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

    public Double getStartLength() {
        return startLength;
    }

    public void setStartLength(Double startLength) {
        this.startLength = startLength;
    }

    public Double getEndLength() {
        return endLength;
    }

    public void setEndLength(Double endLength) {
        this.endLength = endLength;
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

    public String getSeCode() {
        return seCode;
    }

    public void setSeCode(String seCode) {
        this.seCode = seCode;
    }

    public int getOrdSort() {
        return ordSort;
    }

    public void setOrdSort(int ordSort) {
        this.ordSort = ordSort;
    }

    public String getProxyName() {
        return proxyName;
    }

    public void setProxyName(String proxyName) {
        this.proxyName = proxyName;
    }

    public String getItemColorValue() {
        return itemColorValue;
    }

    public void setItemColorValue(String itemColorValue) {
        this.itemColorValue = itemColorValue;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getProdPlanDetailId() {
        return prodPlanDetailId;
    }

    public void setProdPlanDetailId(Long prodPlanDetailId) {
        this.prodPlanDetailId = prodPlanDetailId;
    }

    public String getProdPlanCode() {
        return prodPlanCode;
    }

    public void setProdPlanCode(String prodPlanCode) {
        this.prodPlanCode = prodPlanCode;
    }

    public String getOrdCode() {
        return ordCode;
    }

    public void setOrdCode(String ordCode) {
        this.ordCode = ordCode;
    }

    public String getOrderTitle() {
        return orderTitle;
    }

    public void setOrderTitle(String orderTitle) {
        this.orderTitle = orderTitle;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Double getItemLenth() {
        return itemLenth;
    }

    public void setItemLenth(Double itemLenth) {
        this.itemLenth = itemLenth;
    }

    public Double getItemWidth() {
        return itemWidth;
    }

    public void setItemWidth(Double itemWidth) {
        this.itemWidth = itemWidth;
    }

    public Double getItemThick() {
        return itemThick;
    }

    public void setItemThick(Double itemThick) {
        this.itemThick = itemThick;
    }

    public Long getItemNum() {
        return itemNum;
    }

    public void setItemNum(Long itemNum) {
        this.itemNum = itemNum;
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

    public Character getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(Character itemStatus) {
        this.itemStatus = itemStatus;
    }

    public Long getItemCgyCode() {
        return itemCgyCode;
    }

    public void setItemCgyCode(Long itemCgyCode) {
        this.itemCgyCode = itemCgyCode;
    }

    public Long getItemVariety() {
        return itemVariety;
    }

    public void setItemVariety(Long itemVariety) {
        this.itemVariety = itemVariety;
    }

    public Long getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(Long itemUnit) {
        this.itemUnit = itemUnit;
    }

    public String getItemOwner() {
        return itemOwner;
    }

    public void setItemOwner(String itemOwner) {
        this.itemOwner = itemOwner;
    }

    public String getItemColor() {
        return itemColor;
    }

    public void setItemColor(String itemColor) {
        this.itemColor = itemColor;
    }

    public String getMacCode() {
        return macCode;
    }

    public void setMacCode(String macCode) {
        this.macCode = macCode;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Double getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(Double itemWeight) {
        this.itemWeight = itemWeight;
    }

    public String getItemSq() {
        return itemSq;
    }

    public void setItemSq(String itemSq) {
        this.itemSq = itemSq;
    }

    public Double getItemTareWeight() {
        return itemTareWeight;
    }

    public void setItemTareWeight(Double itemTareWeight) {
        this.itemTareWeight = itemTareWeight;
    }

    public Long getItemPriceType() {
        return itemPriceType;
    }

    public void setItemPriceType(Long itemPriceType) {
        this.itemPriceType = itemPriceType;
    }
}
