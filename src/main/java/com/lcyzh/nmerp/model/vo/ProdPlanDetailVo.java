package com.lcyzh.nmerp.model.vo;

import com.lcyzh.nmerp.common.persistence.DataEntity;
import com.lcyzh.nmerp.common.persistence.Page;

/**
 * @Project :
 * @Description :
 * @Author :
 * @Iteration :
 * @Date :
 * @ModificationHistory Who          When          What
 */
public class ProdPlanDetailVo extends DataEntity<ProdPlanDetailVo> {
    private Long prodPlanDetailId;
    private String prodPlanCode;
    private String ordCode;
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
    //机台编码
    private String macCode;
    //配方
    private String formula;
    //条形码
    private String barCode;
    //产品单件重量
    private String itemWeight;
    //产品单件面积
    private String itemSq;

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

    public String getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(String itemWeight) {
        this.itemWeight = itemWeight;
    }

    public String getItemSq() {
        return itemSq;
    }

    public void setItemSq(String itemSq) {
        this.itemSq = itemSq;
    }
}
