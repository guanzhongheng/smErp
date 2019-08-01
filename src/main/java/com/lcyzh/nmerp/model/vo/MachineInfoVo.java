package com.lcyzh.nmerp.model.vo;

import java.util.Date;
import java.util.List;

public class MachineInfoVo {
    private Long id;
    private String macCode;
    private String prodCodes;
    private Double minWidth;
    private Double maxWidth;
    private Date createTime;
    private Date updateTime;
    private List<ProductVo> productVos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMacCode() {
        return macCode;
    }

    public void setMacCode(String macCode) {
        this.macCode = macCode;
    }

    public String getProdCodes() {
        return prodCodes;
    }

    public void setProdCodes(String prodCodes) {
        this.prodCodes = prodCodes;
    }

    public Double getMinWidth() {
        return minWidth;
    }

    public void setMinWidth(Double minWidth) {
        this.minWidth = minWidth;
    }

    public Double getMaxWidth() {
        return maxWidth;
    }

    public void setMaxWidth(Double maxWidth) {
        this.maxWidth = maxWidth;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<ProductVo> getProductVos() {
        return productVos;
    }

    public void setProductVos(List<ProductVo> productVos) {
        this.productVos = productVos;
    }
}
