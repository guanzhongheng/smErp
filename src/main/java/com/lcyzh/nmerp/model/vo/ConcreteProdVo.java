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
public class ConcreteProdVo {

    //订单编号
    private String ordCode;
    //一级客户
    private String cusName;
    //代理商名称
    private String proxyName;
    //产品名称
    private String itemName;
    //产品规格
    private String itemSpec;
    //产品分类
    private String itemCgyCode;
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
    //订单产品数量
    private Double itemNum;
    //具体产品数量
    private Double ccProdNum;
    //剩余产品数量
    private Double remainProdNum;
    //产品单位
    private String itemUnit;
    //产品所属人
    private String itemOwner;
    /**
     * @Description: 出库状态0-未出库，1-已出库
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/4 9:21 PM
     */
    private Character outStockStatus;

    public String getOrdCode() {
        return ordCode;
    }

    public void setOrdCode(String ordCode) {
        this.ordCode = ordCode;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
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

    public String getItemSpec() {
        return itemSpec;
    }

    public void setItemSpec(String itemSpec) {
        this.itemSpec = itemSpec;
    }

    public String getItemCgyCode() {
        return itemCgyCode;
    }

    public void setItemCgyCode(String itemCgyCode) {
        this.itemCgyCode = itemCgyCode;
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

    public Double getCcProdNum() {
        return ccProdNum;
    }

    public void setCcProdNum(Double ccProdNum) {
        this.ccProdNum = ccProdNum;
    }

    public Double getRemainProdNum() {
        return remainProdNum;
    }

    public void setRemainProdNum(Double remainProdNum) {
        this.remainProdNum = remainProdNum;
    }

    public String getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }

    public String getItemOwner() {
        return itemOwner;
    }

    public void setItemOwner(String itemOwner) {
        this.itemOwner = itemOwner;
    }

    public Character getOutStockStatus() {
        return outStockStatus;
    }

    public void setOutStockStatus(Character outStockStatus) {
        this.outStockStatus = outStockStatus;
    }
}