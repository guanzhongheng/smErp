package com.lcyzh.nmerp.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Project : nm-erp
 * @Description : 角色信息实体
 * @Author : chh
 * @Iteration :
 * @Date : 2019/07/01
 * @ModificationHistory Who          When          What
 */
@Data
public class TSysRole implements Serializable {
    private static final long serialVersionUID = 1L;
    private String roleId;
    private String roleName;
    private String roleType;
    private BigDecimal roleSort;
    private Character isSys;
    private String userType;
    private Character status;
    private String createBy;
    private Date createDate;
    private String remarks;

}
