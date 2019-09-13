package com.lcyzh.nmerp.model.vo;

import java.util.Date;

/**
 * 项目名称：nm-erp
 * 类 名 称：TEquipmentVo
 * 类 描 述：TODO
 * 创建时间：2019/9/11 3:12 PM
 * 创 建 人：guan
 */
public class TEquipmentVo {

    private Long eqId;

    private String macAddress;

    private Date createTime;

    private Character devSwitch;

    public Character getDevSwitch() {
        return devSwitch;
    }

    public void setDevSwitch(Character devSwitch) {
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
