package com.lcyzh.nmerp.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

/**
 * Author ljk
 * Date  2019-06-06
 */
public class TProdPlanDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String prodPlanCode;
    private String prodCode;
    private String prodSpec;
    private Integer prodNum;
    private Double leastTime;
    private Double mostTime;
    private Date createTime;


    public TProdPlanDetail() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setProdPlanCode(String prodPlanCode) {
        this.prodPlanCode = prodPlanCode;
    }

    public String getProdPlanCode() {
        return prodPlanCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdSpec(String prodSpec) {
        this.prodSpec = prodSpec;
    }

    public String getProdSpec() {
        return prodSpec;
    }

    public Integer getProdNum() {
        return prodNum;
    }

    public void setProdNum(Integer prodNum) {
        this.prodNum = prodNum;
    }

    public void setLeastTime(Double leastTime) {
        this.leastTime = leastTime;
    }

    public Double getLeastTime() {
        return leastTime;
    }

    public void setMostTime(Double mostTime) {
        this.mostTime = mostTime;
    }

    public Double getMostTime() {
        return mostTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

}