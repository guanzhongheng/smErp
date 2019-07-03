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
    //订单编号
    private String ordCode;
    //代理商名称
    private String proxyName;
    //产品编号
    private String itemCode;
    //产品名称
    private String itemName;
    //产品规格
    private String itemSpec;
    //产品类型
    private String itemType;
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
    //产品单位-字典
    private Long itemUnit;
    //产品单位值
    private String itemUnitValue;
    //产品所属人
    private String itemOwner;
    //压边类型
    private Long blankPressType;
    //压边类型值
    private Long blankPressTypeValue;
    //备注
    private String remark;

    public String getOrdCode() {
        return ordCode;
    }

    public void setOrdCode(String ordCode) {
        this.ordCode = ordCode;
    }

    public String getProxyName() {
        return proxyName;
    }

    public void setProxyName(String proxyName) {
        this.proxyName = proxyName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemSpec() {
        return itemSpec;
    }

    public void setItemSpec(String itemSpec) {
        this.itemSpec = itemSpec;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
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

    public String getItemOwner() {
        return itemOwner;
    }

    public void setItemOwner(String itemOwner) {
        this.itemOwner = itemOwner;
    }

    public Long getBlankPressType() {
        return blankPressType;
    }

    public void setBlankPressType(Long blankPressType) {
        this.blankPressType = blankPressType;
    }

    public Long getBlankPressTypeValue() {
        return blankPressTypeValue;
    }

    public void setBlankPressTypeValue(Long blankPressTypeValue) {
        this.blankPressTypeValue = blankPressTypeValue;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}