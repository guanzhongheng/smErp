package com.lcyzh.nmerp.model.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Project :
 * @Description :
 * @Author :
 * @Iteration :
 * @Date :
 * @ModificationHistory Who          When          What
 */
public class FormulaDetailVo implements Serializable {
    private String temperature;
    private String remarks;
    List<RawMaterialVo> rawMaterialVos;

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<RawMaterialVo> getRawMaterialVos() {
        return rawMaterialVos;
    }

    public void setRawMaterialVos(List<RawMaterialVo> rawMaterialVos) {
        this.rawMaterialVos = rawMaterialVos;
    }
}
