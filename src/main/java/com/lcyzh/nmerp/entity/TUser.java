package com.lcyzh.nmerp.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

/**
 * Author ljk
 * Date  2019-06-06
 */
public class TUser implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String usCode;
    private String usName;
    private String usBirth;
    private String usPhone;
    private String usPosition;
    private String usEmail;
    private Date createTime;
    private Date updateTime;


    public TUser() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUsCode(String usCode) {
        this.usCode = usCode;
    }

    public String getUsCode() {
        return usCode;
    }

    public void setUsName(String usName) {
        this.usName = usName;
    }

    public String getUsName() {
        return usName;
    }

    public void setUsBirth(String usBirth) {
        this.usBirth = usBirth;
    }

    public String getUsBirth() {
        return usBirth;
    }

    public void setUsPhone(String usPhone) {
        this.usPhone = usPhone;
    }

    public String getUsPhone() {
        return usPhone;
    }

    public void setUsPosition(String usPosition) {
        this.usPosition = usPosition;
    }

    public String getUsPosition() {
        return usPosition;
    }

    public void setUsEmail(String usEmail) {
        this.usEmail = usEmail;
    }

    public String getUsEmail() {
        return usEmail;
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