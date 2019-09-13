package com.lcyzh.nmerp.entity;

import java.util.Date;

/**
 * 项目名称：nm-erp
 * 类 名 称：TEquipment
 * 类 描 述：TODO
 * 创建时间：2019/9/11 2:01 PM
 * 创 建 人：guan
 */
public class TEquipment {

    private Long eqId;

    private String macName;

    private String macAddress;

    private Date createTime;

    private String devSwitch;

    public String getMacName() {
        return macName;
    }

    public void setMacName(String macName) {
        this.macName = macName;
    }

    public String getDevSwitch() {
        return devSwitch;
    }

    public void setDevSwitch(String devSwitch) {
        this.devSwitch = devSwitch;
    }

    public Long getEqId() {
        return eqId;
    }

    public void setEqId(Long eqId) {
        this.eqId = eqId;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
