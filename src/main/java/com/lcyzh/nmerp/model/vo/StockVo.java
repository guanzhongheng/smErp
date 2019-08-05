package com.lcyzh.nmerp.model.vo;


/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/7/3  11:39 AM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/07/03    create
 */
public class StockVo {
    private Long stockId;
    private String barCode;
    private String ordCode;
    private Long orderItemId;
    private String itemCode;
    private Double itemLenth;
    private Double itemWidth;
    private Double itemThick;
    private Double itemWeight;
    private Double itemSq;
    private String itemOwner;
    private String itemYcType;
    private String itemYbType;
    private Long itemCgyCode;
    private String itemCgyCodeValue;
    private Long itemVariety;
    private String itemVarietyValue;
    private Long itemUnit;
    private String itemUnitValue;
    private String itemColor;
    private String macCode;
    private Double itemTareWeight;

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getOrdCode() {
        return ordCode;
    }

    public void setOrdCode(String ordCode) {
        this.ordCode = ordCode;
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

    public Long getItemCgyCode() {
        return itemCgyCode;
    }

    public void setItemCgyCode(Long itemCgyCode) {
        this.itemCgyCode = itemCgyCode;
    }

    public String getItemCgyCodeValue() {
        return itemCgyCodeValue;
    }

    public void setItemCgyCodeValue(String itemCgyCodeValue) {
        this.itemCgyCodeValue = itemCgyCodeValue;
    }

    public Long getItemVariety() {
        return itemVariety;
    }

    public void setItemVariety(Long itemVariety) {
        this.itemVariety = itemVariety;
    }

    public String getItemVarietyValue() {
        return itemVarietyValue;
    }

    public void setItemVarietyValue(String itemVarietyValue) {
        this.itemVarietyValue = itemVarietyValue;
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

    public Double getItemTareWeight() {
        return itemTareWeight;
    }

    public void setItemTareWeight(Double itemTareWeight) {
        this.itemTareWeight = itemTareWeight;
    }
}