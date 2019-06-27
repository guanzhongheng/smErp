package com.lcyzh.nmerp.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Project : nm-erp
 * @Description : 二维码详细信息
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/6/27  9:43 AM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/06/27    create
 */
public class TBarCodeInfo implements Serializable {
    private static final Long serialVersionUID = 121L;
    //二维码号
    private String barCode;
    //订单号
    private String ordCode;
    //商品明细ID
    private String itemId;
    //入库状态
    private Character status;
    //计量
    private Double num;
    //单位
    private String unit;
    private Date createTime;
    private Date updateTime;

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getOrdCode() {
        return ordCode;
    }

    public void setOrdCode(String ordCode) {
        this.ordCode = ordCode;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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