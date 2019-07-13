package com.lcyzh.nmerp.model.vo;

import java.util.Date;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/6/19  6:18 PM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/06/19    create
 */
public class OrderItemVo {
    //商品明细ID
    private Long itemId;
    //订单编号
    private String ordCode;
    //产品编号
    private String itemCode;
    //产品名称
    private String itemName;
    //产品类别-字典
    private Long itemCgyCode;
    //产品类别值
    private String itemCgyCodeValue;
    //产品品种-字典
    private Long itemVariety;
    //产品品种值
    private String itemVaritemValue;
    //长度
    private Double itemLenth;
    //宽度
    private Double itemWidth;
    //厚度
    private Double itemThick;
    //颜色
    private String itemColor;
    //颜色
    private String itemColorValue;
    //计件数
    private Long itemNum;
    //单位-字典
    private Long itemUnit;
    //单位值
    private String itemUnitValue;
    //单价
    private Double itemPrice;
    //计价方式-字典
    private Long itemPriceType;
    //计价方式值
    private String itemPriceTypeValue;
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

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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

    public String getItemVaritemValue() {
        return itemVaritemValue;
    }

    public void setItemVaritemValue(String itemVaritemValue) {
        this.itemVaritemValue = itemVaritemValue;
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

    public String getItemColor() {
        return itemColor;
    }

    public void setItemColor(String itemColor) {
        this.itemColor = itemColor;
    }

    public Long getItemNum() { return itemNum; }

    public void setItemNum(Long itemNum) {
        this.itemNum = itemNum;
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

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Long getItemPriceType() {
        return itemPriceType;
    }

    public void setItemPriceType(Long itemPriceType) {
        this.itemPriceType = itemPriceType;
    }

    public String getItemPriceTypeValue() {
        return itemPriceTypeValue;
    }

    public void setItemPriceTypeValue(String itemPriceTypeValue) {
        this.itemPriceTypeValue = itemPriceTypeValue;
    }

    public String getItemOwner() {
        return itemOwner;
    }

    public void setItemOwner(String itemOwner) {
        this.itemOwner = itemOwner;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public String getItemColorValue() {
        return itemColorValue;
    }

    public void setItemColorValue(String itemColorValue) {
        this.itemColorValue = itemColorValue;
    }
}