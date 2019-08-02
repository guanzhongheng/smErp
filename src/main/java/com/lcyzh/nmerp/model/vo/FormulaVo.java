package com.lcyzh.nmerp.model.vo;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.*;

/**
 * @Project :
 * @Description :
 * @Author :
 * @Iteration :
 * @Date :
 * @ModificationHistory Who          When          What
 */
public class FormulaVo implements Serializable {
    private String fCode;
    //配方名称
    private String fName;
    //产品类别
    private Long prodCgyCode;
    private String prodCgyCodeValue;
    //产品品种
    private Long prodVariety;
    private String prodVarietyValue;
    //创建时间
    private Date createDate;
    //更新时间
    private Date updateDate;
    //删除标志
    private Character delFlag;
    //备注
    private String remarks;
    //成分内容
    private Map<String, FormulaDetailVo> context;

    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public Long getProdCgyCode() {
        return prodCgyCode;
    }

    public void setProdCgyCode(Long prodCgyCode) {
        this.prodCgyCode = prodCgyCode;
    }

    public Long getProdVariety() {
        return prodVariety;
    }

    public void setProdVariety(Long prodVariety) {
        this.prodVariety = prodVariety;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Character getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Character delFlag) {
        this.delFlag = delFlag;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Map<String, FormulaDetailVo> getContext() {
        return context;
    }

    public void setContext(Map<String, FormulaDetailVo> context) {
        this.context = context;
    }

    public String getProdCgyCodeValue() {
        return prodCgyCodeValue;
    }

    public void setProdCgyCodeValue(String prodCgyCodeValue) {
        this.prodCgyCodeValue = prodCgyCodeValue;
    }

    public String getProdVarietyValue() {
        return prodVarietyValue;
    }

    public void setProdVarietyValue(String prodVarietyValue) {
        this.prodVarietyValue = prodVarietyValue;
    }
//public static void main(String[] args) {
//        List<RawMaterialVo> rawMaterialVos = new ArrayList<>();
//        for(int i = 0; i < 3; i++) {
//            RawMaterialVo rawMaterialVo = new RawMaterialVo();
//            rawMaterialVo.setRawmCode("AAA");
//            rawMaterialVo.setRawmName("高压M21");
//            rawMaterialVo.setWeight("1袋");
//            rawMaterialVos.add(rawMaterialVo);
//        }
//        FormulaDetailVo fdVo1 = new FormulaDetailVo();
//        fdVo1.setRawMaterialVos(rawMaterialVos);
//        fdVo1.setRemarks("内层");
//        fdVo1.setTemperature("210℃");
//        FormulaDetailVo fdVo2 = new FormulaDetailVo();
//        fdVo2.setRawMaterialVos(rawMaterialVos);
//        fdVo2.setRemarks("外层");
//        fdVo2.setTemperature("200℃");
//        FormulaDetailVo fdVo3 = new FormulaDetailVo();
//        fdVo3.setRawMaterialVos(rawMaterialVos);
//        fdVo3.setRemarks("中层");
//        fdVo3.setTemperature("195℃");
//        Map<String, FormulaDetailVo> context = new HashMap<>();
//        context.put("inner", fdVo1);
//        context.put("midder", fdVo3);
//        context.put("outer", fdVo2);
//        String jsonStr = JSON.toJSONString(context);
//        Map<String, FormulaDetailVo> context1 = JSON.parseObject(jsonStr, context.getClass());
//        System.out.println(context1.size());
//        System.out.println(context1.get("midder"));
//    }
}
