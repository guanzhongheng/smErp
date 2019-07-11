package com.lcyzh.nmerp.model.vo;

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
    //产品长度
    private Double itemLenth;
    //产品宽度
    private Double itemWidth;
    //产品厚度
    private Double itemThick;
    //产品颜色
    private String itemColor;
    //产品数量
    private Double itemNum;
    //产品所属人
    private String itemOwner;
    //产品单位
    private String itemUnit;
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
    //备注
    private String remarks;

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

    public Double getItemNum() {
        return itemNum;
    }

    public void setItemNum(Double itemNum) {
        this.itemNum = itemNum;
    }

    public String getItemOwner() {
        return itemOwner;
    }

    public void setItemOwner(String itemOwner) {
        this.itemOwner = itemOwner;
    }

    public String getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}