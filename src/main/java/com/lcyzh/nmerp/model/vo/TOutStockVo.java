package com.lcyzh.nmerp.model.vo;

import com.lcyzh.nmerp.common.persistence.DataEntity;
import com.lcyzh.nmerp.entity.TOutStock;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目名称：nm-erp
 * 类 名 称：TOutStockVo
 * 类 描 述：TODO
 * 创建时间：2019/7/16 5:02 PM
 * 创 建 人：guan
 */
public class TOutStockVo extends DataEntity<TOutStock> implements Serializable {
    private static final long serialVersionUID = 1L;
    private String outCode;
    private String cusName;
    private String receiver;
    private String phone;
    private String address;
    private Character outStatus;
    private String createBy;
    private Date createTime;
    private Date updateTime;
    private String updateBy;
    private String remarks;

    public void setOutCode (String outCode) {this.outCode = outCode;}
    public String getOutCode(){ return outCode;}
    public void setCusName (String cusName) {this.cusName = cusName;}
    public String getCusName(){ return cusName;}
    public void setReceiver (String receiver) {this.receiver = receiver;}
    public String getReceiver(){ return receiver;}
    public void setPhone (String phone) {this.phone = phone;}
    public String getPhone(){ return phone;}
    public void setAddress (String address) {this.address = address;}
    public String getAddress(){ return address;}
    public void setOutStatus (Character outStatus) {this.outStatus = outStatus;}
    public Character getOutStatus(){ return outStatus;}
    public void setCreateTime (Date createTime) {this.createTime = createTime;}
    public Date getCreateTime(){ return createTime;}
    public void setUpdateTime (Date updateTime) {this.updateTime = updateTime;}
    public Date getUpdateTime(){ return updateTime;}
    public void setRemarks (String remarks) {this.remarks = remarks;}
    public String getRemarks(){ return remarks;}

}