package com.lcyzh.nmerp.entity;

import java.util.Date;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/6/28  10:49 AM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/06/28    create
 */
public class TDict {
    private Long id;
    private Long dictKey;
    private String dictValue;
    private Long subDictKey;
    private String subDictValue;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDictKey() {
        return dictKey;
    }

    public void setDictKey(Long dictKey) {
        this.dictKey = dictKey;
    }

    public Long getSubDictKey() {
        return subDictKey;
    }

    public void setSubDictKey(Long subDictKey) {
        this.subDictKey = subDictKey;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public String getSubDictValue() {
        return subDictValue;
    }

    public void setSubDictValue(String subDictValue) {
        this.subDictValue = subDictValue;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}