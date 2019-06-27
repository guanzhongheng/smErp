package com.lcyzh.nmerp.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

/**
 * Author ljk
 * Date  2019-06-06
 */
public class TOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String ordCode;
    private String contCode;
    private String ordAddress;
    private String cusCode;
    private Character ordStatus;
    private String deliveryDate;
    private Date createTime;
    private Date updateTime;


    public TOrder() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setOrdCode(String ordCode) {
        this.ordCode = ordCode;
    }

    public String getOrdCode() {
        return ordCode;
    }

    public void setContCode(String contCode) {
        this.contCode = contCode;
    }

    public String getContCode() {
        return contCode;
    }

    public void setOrdAddress(String ordAddress) {
        this.ordAddress = ordAddress;
    }

    public String getOrdAddress() {
        return ordAddress;
    }

    public String getCusCode() {
        return cusCode;
    }

    public void setCusCode(String cusCode) {
        this.cusCode = cusCode;
    }

    public void setOrdStatus(Character ordStatus) {
        this.ordStatus = ordStatus;
    }

    public Character getOrdStatus() {
        return ordStatus;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

}