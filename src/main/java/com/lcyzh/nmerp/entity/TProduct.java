package com.lcyzh.nmerp.entity;

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
    private String prodCgyCode;
    private String prodVariety;
    private String prodThick;
    private String prodGuidePrice;
    private Date createTime;


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
}