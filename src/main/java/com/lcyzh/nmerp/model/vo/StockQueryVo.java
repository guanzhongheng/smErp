package com.lcyzh.nmerp.model.vo;


import java.io.Serializable;

/**
 * @Project :
 * @Description :补签查询vo
 * @Author :
 * @Iteration :
 * @Date :
 * @ModificationHistory Who          When          What
 */
public class StockQueryVo implements Serializable {
    //订单编号（模糊匹配）
    private String ordCode;
    //订单标题
    private String orderTitle;
    //产品类别-字典
    private Long itemCgyCode;
    //产品类型-字典值
    private String itemCgyCodeValue;
    //产品品种-字典
    private Long itemVariety;
    //产品品种-字典值
    private String itemVarietyValue;
    //开始时间
    private String startDate;
    //结束时间
    private String endDate;

    private Long stockId;
    private String barCode;
    private String itemCode;
    private Double itemLenth;
    private Double itemWidth;
    private Double itemThick;
    private Double itemWeight;
    private Double itemSq;
    private String itemOwner;
    private String itemYcType;
    private String itemYcTypeValue;
    private String itemYbType;
    private String itemYbTypeValue;
    private Long itemUnit;
    private String itemUnitValue;
    private String itemColor;
    private String itemColorValue;
    private String macCode;
    private Double itemTareWeight;
    // 产品出库状态
    private String outStatus;

    public String getOutStatus() {
        return outStatus;
    }

    public void setOutStatus(String outStatus) {
        this.outStatus = outStatus;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
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

    public Double getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(Double itemWeight) {
        this.itemWeight = itemWeight;
    }

    public Double getItemSq() {
        return itemSq;
    }

    public void setItemSq(Double itemSq) {
        this.itemSq = itemSq;
    }

    public String getItemOwner() {
        return itemOwner;
    }

    public void setItemOwner(String itemOwner) {
        this.itemOwner = itemOwner;
    }

    public String getItemYcType() {
        return itemYcType;
    }

    public void setItemYcType(String itemYcType) {
        this.itemYcType = itemYcType;
    }

    public String getItemYbType() {
        return itemYbType;
    }

    public void setItemYbType(String itemYbType) {
        this.itemYbType = itemYbType;
    }

    public Long getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(Long itemUnit) {
        this.itemUnit = itemUnit;
    }

    public String getItemUnitValue() {
        return itemUnitValue;
    }

    public void setItemUnitValue(String itemUnitValue) {
        this.itemUnitValue = itemUnitValue;
    }

    public String getItemColor() {
        return itemColor;
    }

    public void setItemColor(String itemColor) {
        this.itemColor = itemColor;
    }

    public String getMacCode() { return macCode; }

    public void setMacCode(String macCode) { this.macCode = macCode; }

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

    public String getItemYcTypeValue() {
        return itemYcTypeValue;
    }

    public void setItemYcTypeValue(String itemYcTypeValue) {
        this.itemYcTypeValue = itemYcTypeValue;
    }

    public String getItemYbTypeValue() {
        return itemYbTypeValue;
    }

    public void setItemYbTypeValue(String itemYbTypeValue) {
        this.itemYbTypeValue = itemYbTypeValue;
    }

    public String getItemColorValue() {
        return itemColorValue;
    }

    public void setItemColorValue(String itemColorValue) {
        this.itemColorValue = itemColorValue;
    }

    public Double getItemTareWeight() {
        return itemTareWeight;
    }

    public void setItemTareWeight(Double itemTareWeight) {
        this.itemTareWeight = itemTareWeight;
    }

    @Override
    public String toString() {
        return "StockQueryVo{" +
                "ordCode='" + ordCode + '\'' +
                ", orderTitle='" + orderTitle + '\'' +
                ", itemCgyCode=" + itemCgyCode +
                ", itemCgyCodeValue='" + itemCgyCodeValue + '\'' +
                ", itemVariety=" + itemVariety +
                ", itemVarietyValue='" + itemVarietyValue + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", stockId=" + stockId +
                ", barCode='" + barCode + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", itemLenth=" + itemLenth +
                ", itemWidth=" + itemWidth +
                ", itemThick=" + itemThick +
                ", itemWeight=" + itemWeight +
                ", itemSq=" + itemSq +
                ", itemOwner='" + itemOwner + '\'' +
                ", itemYcType='" + itemYcType + '\'' +
                ", itemYcTypeValue='" + itemYcTypeValue + '\'' +
                ", itemYbType='" + itemYbType + '\'' +
                ", itemYbTypeValue='" + itemYbTypeValue + '\'' +
                ", itemUnit=" + itemUnit +
                ", itemUnitValue='" + itemUnitValue + '\'' +
                ", itemColor='" + itemColor + '\'' +
                ", itemColorValue='" + itemColorValue + '\'' +
                ", macCode='" + macCode + '\'' +
                ", itemTareWeight=" + itemTareWeight +
                '}';
    }
}
