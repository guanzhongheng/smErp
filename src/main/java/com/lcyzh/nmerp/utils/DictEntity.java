package com.lcyzh.nmerp.utils;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/7/1  11:12 AM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/07/01    create
 */
public class DictEntity {
    //值
    private String value;
    //标签
    private Long lable;
    //类型
    private Long type;
    //描述
    private String describe;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getLable() {
        return lable;
    }

    public void setLable(Long lable) {
        this.lable = lable;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}