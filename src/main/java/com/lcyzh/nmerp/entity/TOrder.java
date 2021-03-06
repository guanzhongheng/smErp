package com.lcyzh.nmerp.entity;



import java.util.Date;

/**
 * Author ljk
 * Date  2019-06-06
 */
public class TOrder{
    //订单编号
    private String ordCode;
    //客户资料编号
    private String cusCode;
    //代理商名称
    private String proxyName;
    //订单标题
    private String ordTitle;
    //订单总金额
    private Double ordTotalAmount;
    //订单类型
    private Long ordType;
    //订单签订日期
    private String ordSignDate;
    //订单状态
    private Long ordStatus;
    private String ordDeliveryDate;
    //付款方式
    private Long payType;
    //支付状态
    private Long payStatus;
    //客户签约人
    private String cusContractor;
    //公司签约人
    private String comContractor;
    //合同附件
    private String contAttachUrl;
    //备注
    private String remarks;
    private Date createTime;
    private Date updateTime;
    //订单产品总数量
    private Long ordTotalNum;
    //订单产品总面积
    private Double ordTotalSq;
    //订单产品总重量
    private Double ordTotalWeight;
    //订单产品出库数量
    private Long ordOutNum;

    //订单创建者
    private String createBy;
    //订单修改者
    private String updateBy;
    // 审批人员
    private String approvalBy;

    public String getApprovalBy() {
        return approvalBy;
    }

    public void setApprovalBy(String approvalBy) {
        this.approvalBy = approvalBy;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getOrdCode() {
        return ordCode;
    }

    public void setOrdCode(String ordCode) {
        this.ordCode = ordCode;
    }

    public String getCusCode() {
        return cusCode;
    }

    public void setCusCode(String cusCode) {
        this.cusCode = cusCode;
    }

    public String getProxyName() {
        return proxyName;
    }

    public void setProxyName(String proxyName) {
        this.proxyName = proxyName;
    }

    public String getOrdTitle() {
        return ordTitle;
    }

    public void setOrdTitle(String ordTitle) {
        this.ordTitle = ordTitle;
    }

    public Double getOrdTotalAmount() {
        return ordTotalAmount;
    }

    public void setOrdTotalAmount(Double ordTotalAmount) {
        this.ordTotalAmount = ordTotalAmount;
    }


    public String getOrdSignDate() {
        return ordSignDate;
    }

    public void setOrdSignDate(String ordSignDate) {
        this.ordSignDate = ordSignDate;
    }

    public Long getOrdStatus() {
        return ordStatus;
    }

    public void setOrdStatus(Long ordStatus) {
        this.ordStatus = ordStatus;
    }

    public String getOrdDeliveryDate() {
        return ordDeliveryDate;
    }

    public void setOrdDeliveryDate(String ordDeliveryDate) {
        this.ordDeliveryDate = ordDeliveryDate;
    }

    public Long getOrdType() {
        return ordType;
    }

    public void setOrdType(Long ordType) {
        this.ordType = ordType;
    }

    public String getCusContractor() {
        return cusContractor;
    }

    public void setCusContractor(String cusContractor) {
        this.cusContractor = cusContractor;
    }

    public String getComContractor() {
        return comContractor;
    }

    public void setComContractor(String comContractor) {
        this.comContractor = comContractor;
    }

    public String getContAttachUrl() {
        return contAttachUrl;
    }

    public void setContAttachUrl(String contAttachUrl) {
        this.contAttachUrl = contAttachUrl;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public void setPayType(Long payType) {
        this.payType = payType;
    }

    public Long getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Long payStatus) {
        this.payStatus = payStatus;
    }

    public Long getPayType() {
        return payType;
    }

    public Long getOrdTotalNum() {
        return ordTotalNum;
    }

    public void setOrdTotalNum(Long ordTotalNum) {
        this.ordTotalNum = ordTotalNum;
    }

    public Double getOrdTotalSq() {
        return ordTotalSq;
    }

    public void setOrdTotalSq(Double ordTotalSq) {
        this.ordTotalSq = ordTotalSq;
    }

    public Double getOrdTotalWeight() {
        return ordTotalWeight;
    }

    public void setOrdTotalWeight(Double ordTotalWeight) {
        this.ordTotalWeight = ordTotalWeight;
    }

    public Long getOrdOutNum() {
        return ordOutNum;
    }

    public void setOrdOutNum(Long ordOutNum) {
        this.ordOutNum = ordOutNum;
    }
}