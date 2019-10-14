package com.lcyzh.nmerp.model.vo;

import java.util.List;

/**
 * 项目名称：nm-erp
 * 类 名 称：ProdPlanListVo
 * 类 描 述：TODO
 * 创建时间：2019/9/29 9:15 AM
 * 创 建 人：guan
 */
public class ProdPlanListVo extends ProdPlanVo{

    private Double startLength;

    private Double endLength;

    private String orderTitle;

    private String cusName;

    private List<String> planCodes;

    public List<String> getPlanCodes() {
        return planCodes;
    }

    public void setPlanCodes(List<String> planCodes) {
        this.planCodes = planCodes;
    }

    public Double getStartLength() {
        return startLength;
    }

    public void setStartLength(Double startLength) {
        this.startLength = startLength;
    }

    public Double getEndLength() {
        return endLength;
    }

    public void setEndLength(Double endLength) {
        this.endLength = endLength;
    }

    public String getOrderTitle() {
        return orderTitle;
    }

    public void setOrderTitle(String orderTitle) {
        this.orderTitle = orderTitle;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }
}
