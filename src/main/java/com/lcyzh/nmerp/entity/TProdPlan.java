package com.lcyzh.nmerp.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

/**
 * Author ljk
 * Date  2019-06-06
 */
public class TProdPlan implements Serializable {
    private static final long serialVersionUID = 1L;
    private String prodPlanCode;
    private Long prodVariety;
    private Long prodCgyCode;
    private String prodColor;
    private String macCode;
    private Long totalQuantity;
    private Long quantity;
    private String formula;
    private Character isAuto;
    private String prodYbType;
    private String isYb;

    private String planDetailIds;

    public TProdPlan(){
    }

    public String getPlanDetailIds() {
        return planDetailIds;
    }

    public void setPlanDetailIds(String planDetailIds) {
        this.planDetailIds = planDetailIds;
    }

    public String getIsYb() {
        return isYb;
    }

    public void setIsYb(String isYb) {
        this.isYb = isYb;
    }

    public void setProdPlanCode (String prodPlanCode) {this.prodPlanCode = prodPlanCode;}
    public String getProdPlanCode(){ return prodPlanCode;}
    public void setProdVariety (Long prodVariety) {this.prodVariety = prodVariety;}
    public Long getProdVariety(){ return prodVariety;}
    public Long getProdCgyCode() { return prodCgyCode; }
    public void setProdCgyCode(Long prodCgyCode) { this.prodCgyCode = prodCgyCode; }
    public void setProdColor (String prodColor) {this.prodColor = prodColor;}
    public String getProdColor(){ return prodColor;}
    public void setMacCode (String macCode) {this.macCode = macCode;}
    public String getMacCode(){ return macCode;}
    public void setTotalQuantity (Long totalQuantity) {this.totalQuantity = totalQuantity;}
    public Long getTotalQuantity(){ return totalQuantity;}
    public void setQuantity (Long quantity) {this.quantity = quantity;}
    public Long getQuantity(){ return quantity;}
    public void setFormula (String formula) {this.formula = formula;}
    public String getFormula(){ return formula;}
    public void setIsAuto (Character isAuto) {this.isAuto = isAuto;}
    public Character getIsAuto(){ return isAuto;}
    public String getProdYbType() { return prodYbType; }
    public void setProdYbType(String prodYbType) { this.prodYbType = prodYbType; }
}