package com.lcyzh.nmerp.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Project : nm-erp
 * @Description : 菜单信息实体
 * @Author : chh
 * @Iteration :
 * @Date : 2019/07/01
 * @ModificationHistory Who          When          What
 */
@Data
public class TSysMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer menuId;
    private Integer parentId;
    private String parentIds;
    private String name;
    private BigDecimal sort;
    private String href;
    private String icon;
    private Character isShow;
    private String permission;
    private String createBy;
    private Date createDate;
    private String remarks;
}
