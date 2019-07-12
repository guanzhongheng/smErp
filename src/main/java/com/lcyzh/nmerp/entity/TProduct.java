package com.lcyzh.nmerp.entity;

import com.lcyzh.nmerp.common.persistence.Page;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

/**
 * Author ljk
 * Date  2019-06-06
 */
public class TProduct extends Page<TProduct> implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String prodCode;
    private String prodName;
    //类别
    private String prodCgyCode;
    //品种、性质
    private String prodVariety;
    //厚度
    private String prodThick;
    //指导价
    private String prodGuidePrice;
    private Date createTime;
    //计价方式
    private Long prodPriceType;
    //单位
    private String prodUnit;

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

    public void setProdCgyCode(String prodCgyCode) {
        this.prodCgyCode = prodCgyCode;
    }

    public String getProdCgyCode() {
        return prodCgyCode;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getProdVariety() {
        return prodVariety;
    }

    public void setProdVariety(String prodVariety) {
        this.prodVariety = prodVariety;
    }

    public String getProdThick() {
        return prodThick;
    }

    public void setProdThick(String prodThick) {
        this.prodThick = prodThick;
    }

    public String getProdGuidePrice() {
        return prodGuidePrice;
    }

    public void setProdGuidePrice(String prodGuidePrice) {
        this.prodGuidePrice = prodGuidePrice;
    }

    public Long getProdPriceType() {
        return prodPriceType;
    }

    public void setProdPriceType(Long prodPriceType) {
        this.prodPriceType = prodPriceType;
    }

    public String getProdUnit() {
        return prodUnit;
    }

    public void setProdUnit(String prodUnit) {
        this.prodUnit = prodUnit;
    }
}