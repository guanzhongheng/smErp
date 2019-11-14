package com.lcyzh.nmerp.entity;

import com.lcyzh.nmerp.common.persistence.Page;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

/**
 * Author ljk
 * Date  2019-06-06
 */
public class TProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String prodCode;
    private String prodName;
    //类别
    private Long prodCgyCode;
    //品种、性质
    private Long prodVariety;
    //厚度
    private Double prodThick;
    //指导价
    private Double prodGuidePrice;
    private Date createTime;
    //计价方式
    private Long prodPriceType;
    //单位
    private Long prodUnit;
    //颜色
    private String prodColor;
    // 密度
    private Double prodDensity;

    private String delFlag;

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public Double getProdDensity() {
        return prodDensity;
    }

    public void setProdDensity(Double prodDensity) {
        this.prodDensity = prodDensity;
    }

    public TProduct() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdCgyCode(Long prodCgyCode) {
        this.prodCgyCode = prodCgyCode;
    }

    public Long getProdCgyCode() {
        return prodCgyCode;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Long getProdVariety() {
        return prodVariety;
    }

    public void setProdVariety(Long prodVariety) {
        this.prodVariety = prodVariety;
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

    public Long getProdPriceType() {
        return prodPriceType;
    }

    public void setProdPriceType(Long prodPriceType) {
        this.prodPriceType = prodPriceType;
    }

    public Long getProdUnit() {
        return prodUnit;
    }

    public void setProdUnit(Long prodUnit) {
        this.prodUnit = prodUnit;
    }

    public String getProdColor() {
        return prodColor;
    }

    public void setProdColor(String prodColor) {
        this.prodColor = prodColor;
    }
}