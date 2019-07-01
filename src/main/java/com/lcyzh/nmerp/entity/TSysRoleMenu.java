package com.lcyzh.nmerp.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Project : nm-erp
 * @Description : 角色菜单关系信息实体
 * @Author : chh
 * @Iteration :
 * @Date : 2019/07/01
 * @ModificationHistory Who          When          What
 */
@Data
public class TSysRoleMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer roleId;
    private Integer menuId;
}
