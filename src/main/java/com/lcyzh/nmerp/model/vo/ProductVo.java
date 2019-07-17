package com.lcyzh.nmerp.model.vo;

import com.lcyzh.nmerp.common.persistence.DataEntity;
import com.lcyzh.nmerp.entity.TProduct;

import java.util.Date;

/**
 * @Project :
 * @Description :
 * @Author :
 * @Iteration :
 * @Date :
 * @ModificationHistory Who          When          What
 */
public class ProductVo extends DataEntity<TProduct> {
 //   private Long id;
    private String prodCode;
    private String prodName;
    //类别-字典
    private Long prodCgyCode;
    //类别值
    private String prodCgyCodeValue;
    //品种、性质-字典
    private Long prodVariety;
    //品种、性质-字典值
    private String prodVarietyValue;
    //厚度
    private Double prodThick;
    //指导价
    private Double prodGuidePrice;
    private Date createTime;
    //计价方式-字典
    private Long prodPriceType;
    //计价方式-字典值
    private String prodPriceTypeValue;
    //单位-字典
    private Long prodUnit;
    //单位-字典值
    private String prodUnitValue;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public Long getProdCgyCode() {
        return prodCgyCode;
    }

    public void setProdCgyCode(Long prodCgyCode) {
        this.prodCgyCode = prodCgyCode;
    }

    public String getProdCgyCodeValue() {
        return prodCgyCodeValue;
    }

    public void setProdCgyCodeValue(String prodCgyCodeValue) {
        this.prodCgyCodeValue = prodCgyCodeValue;
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

    public Double getProdThick() {
        return prodThick;
    }

    public void setProdThick(Double prodThick) {
        this.prodThick = prodThick;
    }

    public Double getProdGuidePrice() {
        return prodGuidePrice;
    }

    public void setProdGuidePrice(Double prodGuidePrice) {
        this.prodGuidePrice = prodGuidePrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getProdPriceType() {
        return prodPriceType;
    }

    public void setProdPriceType(Long prodPriceType) {
        this.prodPriceType = prodPriceType;
    }

    public String getProdPriceTypeValue() {
        return prodPriceTypeValue;
    }

    public void setProdPriceTypeValue(String prodPriceTypeValue) {
        this.prodPriceTypeValue = prodPriceTypeValue;
    }

    public Long getProdUnit() {
        return prodUnit;
    }

    public void setProdUnit(Long prodUnit) {
        this.prodUnit = prodUnit;
    }

    public String getProdUnitValue() {
        return prodUnitValue;
    }

    public void setProdUnitValue(String prodUnitValue) {
        this.prodUnitValue = prodUnitValue;
    }
}
