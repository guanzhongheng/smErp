package com.lcyzh.nmerp.model.vo;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/6/27  11:32 AM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/06/27    create
 */
public class OutStockDetailVo {
    private Long outStockDetailId;
    private String outCode;
    private String barCode;
    private Long stockId;
    private String ordCode;
    private String ordTitle;
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
    private Long itemCgyCode;
    private String itemCgyCodeValue;
    private Long itemVariety;
    private String itemVarietyValue;
    private Long itemUnit;
    private String itemUnitValue;
    private String itemColor;
    private String itemColorValue;
    //0-未扫描 1-已扫描确认过
    private Character isOut;

    private Double itemPrice;
    // 单个产品计算后价格
    private Double price;
    //计价方式-字典
    private Long itemPriceType;

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getItemPriceType() {
        return itemPriceType;
    }

    public void setItemPriceType(Long itemPriceType) {
        this.itemPriceType = itemPriceType;
    }

    public String getOrdTitle() {
        return ordTitle;
    }

    public void setOrdTitle(String ordTitle) {
        this.ordTitle = ordTitle;
    }

    public Long getOutStockDetailId() {
        return outStockDetailId;
    }

    public void setOutStockDetailId(Long outStockDetailId) {
        this.outStockDetailId = outStockDetailId;
    }

    public String getOutCode() {
        return outCode;
    }

    public void setOutCode(String outCode) {
        this.outCode = outCode;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
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

    public String getItemColorValue() {
        return itemColorValue;
    }

    public void setItemColorValue(String itemColorValue) {
        this.itemColorValue = itemColorValue;
    }

    public Character getIsOut() {
        return isOut;
    }

    public void setIsOut(Character isOut) {
        this.isOut = isOut;
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
}