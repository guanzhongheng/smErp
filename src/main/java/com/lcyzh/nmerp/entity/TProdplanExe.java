package com.lcyzh.nmerp.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/6/14  3:59 PM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/06/14    create
 */
public class TProdplanExe implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long ordItemId;
    private String macCode;
    private Double itemNum;
    private Double itemFinishNum;
    private String itemUnit;
    private Character status;
    private Date finishTime;
    private Date createTime;
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrdItemId() {
        return ordItemId;
    }

    public void setOrdItemId(Long ordItemId) {
        this.ordItemId = ordItemId;
    }

    public String getMacCode() {
        return macCode;
    }

    public void setMacCode(String macCode) {
        this.macCode = macCode;
    }

    public Double getItemNum() {
        return itemNum;
    }

    public void setItemNum(Double itemNum) {
        this.itemNum = itemNum;
    }

    public Double getItemFinishNum() {
        return itemFinishNum;
    }

    public void setItemFinishNum(Double itemFinishNum) {
        this.itemFinishNum = itemFinishNum;
    }

    public String getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}