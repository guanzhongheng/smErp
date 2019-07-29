package com.lcyzh.nmerp.entity;

import java.util.Date;

/**
 * @Project :
 * @Description :
 * @Author :
 * @Iteration :
 * @Date :
 * @ModificationHistory Who          When          What
 */
public class TFormula {
    //配方编码
    private String fCode;
    //配方名称
    private String fName;
    //成分内容
    private String fContext;
    //产品类别
    private Long prodCgyCode;
    //产品品种
    private Long prodVariety;
    //创建时间
    private Date createDate;
    //更新时间
    private Date updateDate;
    //删除标志
    private Character delFlag;
    //备注
    private String remarks;

    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfContext() {
        return fContext;
    }

    public void setfContext(String fContext) {
        this.fContext = fContext;
    }

    public Long getProdCgyCode() {
        return prodCgyCode;
    }

    public void setProdCgyCode(Long prodCgyCode) {
        this.prodCgyCode = prodCgyCode;
    }

    public Long getProdVariety() {
        return prodVariety;
    }

    public void setProdVariety(Long prodVariety) {
        this.prodVariety = prodVariety;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Character getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Character delFlag) {
        this.delFlag = delFlag;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
