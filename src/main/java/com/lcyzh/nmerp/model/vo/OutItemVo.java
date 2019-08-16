package com.lcyzh.nmerp.model.vo;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/7/3  3:51 PM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/07/03    create
 */
public class OutItemVo {
    //出库单
    private String outCode;
    //订单编号
    private String ordCode;
    //产品所属人
    private String itemOwner;
    //产品名称
    private String itemName;
    //产品长度
    private Double itemLenth;
    //产品宽度
    private Double itemWidth;
    //产品厚度
    private Double itemThick;
    //产品颜色-字典值
    private String prodColorValue;
    //类别值
    private String prodCgyCodeValue;
    //品种、性质-字典值
    private String prodVarietyValue;
    // 产品重量
    private Double itemWeight;

    public Double getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(Double itemWeight) {
        this.itemWeight = itemWeight;
    }

    public String getOutCode() {
        return outCode;
    }

    public void setOutCode(String outCode) {
        this.outCode = outCode;
    }

    public String getOrdCode() {
        return ordCode;
    }

    public void setOrdCode(String ordCode) {
        this.ordCode = ordCode;
    }

    public String getItemOwner() {
        return itemOwner;
    }

    public void setItemOwner(String itemOwner) {
        this.itemOwner = itemOwner;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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

    public String getProdColorValue() {
        return prodColorValue;
    }

    public void setProdColorValue(String prodColorValue) {
        this.prodColorValue = prodColorValue;
    }



    public String getProdCgyCodeValue() {
        return prodCgyCodeValue;
    }

    public void setProdCgyCodeValue(String prodCgyCodeValue) {
        this.prodCgyCodeValue = prodCgyCodeValue;
    }



    public String getProdVarietyValue() {
        return prodVarietyValue;
    }

    public void setProdVarietyValue(String prodVarietyValue) {
        this.prodVarietyValue = prodVarietyValue;
    }
}