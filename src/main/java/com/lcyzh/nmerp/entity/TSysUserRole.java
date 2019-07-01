package com.lcyzh.nmerp.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Project : nm-erp
 * @Description : 用户角色关系信息实体
 * @Author : chh
 * @Iteration :
 * @Date : 2019/07/01
 * @ModificationHistory Who          When          What
 */
@Data
public class TSysUserRole implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer userId;
    private Integer roleId;
}
