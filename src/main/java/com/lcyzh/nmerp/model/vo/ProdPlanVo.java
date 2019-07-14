package com.lcyzh.nmerp.model.vo;

import com.lcyzh.nmerp.common.persistence.Page;

/**
 * @Project :
 * @Description :
 * @Author :
 * @Iteration :
 * @Date :
 * @ModificationHistory Who          When          What
 */
public class ProdPlanVo extends Page<ProdPlanVo> {
    //计划单号
    private String prodPlanCode;
    //产品品种-字典
    private Long prodVariety;
    //产品品种-字典值
    private String prodVarietyValue;
    //产品颜色
    private String prodColor;
    //机台编码
    private String macCode;
    //总数量
    private Long totalQuantity;
    //已下发生产数量
    private Long quantity;
    //配方
    private String formula;
    //自动下发开关；0-关闭；1-开启
    private Character isAuto;

    public String getProdPlanCode() {
        return prodPlanCode;
    }

    public void setProdPlanCode(String prodPlanCode) {
        this.prodPlanCode = prodPlanCode;
    }

    public Long getProdVariety() {
        return prodVariety;
    }

    public void setProdVariety(Long prodVariety) {
        this.prodVariety = prodVariety;
    }

    public String getProdVarietyValue() {
        return prodVarietyValue;
    }

    public void setProdVarietyValue(String prodVarietyValue) {
        this.prodVarietyValue = prodVarietyValue;
    }

    public String getProdColor() {
        return prodColor;
    }

    public void setProdColor(String prodColor) {
        this.prodColor = prodColor;
    }

    public String getMacCode() {
        return macCode;
    }

    public void setMacCode(String macCode) {
        this.macCode = macCode;
    }

    public Long getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Long totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public Character getIsAuto() {
        return isAuto;
    }

    public void setIsAuto(Character isAuto) {
        this.isAuto = isAuto;
    }
}