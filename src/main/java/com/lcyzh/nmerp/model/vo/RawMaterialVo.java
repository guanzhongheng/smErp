package com.lcyzh.nmerp.model.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Project :
 * @Description :
 * @Author :
 * @Iteration :
 * @Date :
 * @ModificationHistory Who          When          What
 */
public class RawMaterialVo implements Serializable {
    //原料编号
    private String rawmCode;
    //原料名称
    private String rawmName;
    //原料规格
    private String rawnSpecs;
    //原料供应商
    private String rawnSupplier;
    //原料分类
    private String rawnCtyCode;
    //份量
    private String weight;

    private Date createTime;
    private Date updateTime;

    public String getRawmCode() {
        return rawmCode;
    }

    public void setRawmCode(String rawmCode) {
        this.rawmCode = rawmCode;
    }

    public String getRawmName() {
        return rawmName;
    }

    public void setRawmName(String rawmName) {
        this.rawmName = rawmName;
    }

    public String getRawnSpecs() {
        return rawnSpecs;
    }

    public void setRawnSpecs(String rawnSpecs) {
        this.rawnSpecs = rawnSpecs;
    }

    public String getRawnSupplier() {
        return rawnSupplier;
    }

    public void setRawnSupplier(String rawnSupplier) {
        this.rawnSupplier = rawnSupplier;
    }

    public String getRawnCtyCode() {
        return rawnCtyCode;
    }

    public void setRawnCtyCode(String rawnCtyCode) {
        this.rawnCtyCode = rawnCtyCode;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
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
}
