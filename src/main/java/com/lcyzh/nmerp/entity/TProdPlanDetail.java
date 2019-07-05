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
    private Long ordItemId;
    private String prodPlanCode;
    private Double itemNum;
    private Double itemFinishNum;
    private String elstFinishDate;
    private String latestFinishDate;
    private Date createTime;
    private Date updateTime;


    public void setOrdItemId(Long ordItemId) {
        this.ordItemId = ordItemId;
    }

    public Long getOrdItemId() {
        return ordItemId;
    }

    public void setProdPlanCode(String prodPlanCode) {
        this.prodPlanCode = prodPlanCode;
    }

    public String getProdPlanCode() {
        return prodPlanCode;
    }

    public void setItemNum(Double itemNum) {
        this.itemNum = itemNum;
    }

    public Double getItemNum() {
        return itemNum;
    }

    public void setItemFinishNum(Double itemFinishNum) {
        this.itemFinishNum = itemFinishNum;
    }

    public Double getItemFinishNum() {
        return itemFinishNum;
    }

    public void setElstFinishDate(String elstFinishDate) {
        this.elstFinishDate = elstFinishDate;
    }

    public String getElstFinishDate() {
        return elstFinishDate;
    }

    public void setLatestFinishDate(String latestFinishDate) {
        this.latestFinishDate = latestFinishDate;
    }

    public String getLatestFinishDate() {
        return latestFinishDate;
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