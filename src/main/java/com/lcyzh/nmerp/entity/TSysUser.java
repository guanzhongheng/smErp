package com.lcyzh.nmerp.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Project : nm-erp
 * @Description : 用户信息实体
 * @Author : chh
 * @Iteration :
 * @Date : 2019/07/01
 * @ModificationHistory Who          When          What
 */
@Data
public class TSysUser implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer userId;
    private String username;
    private String password;
    private String name;
    private String email;
    private String mobile;
    private String phone;
    private Character sex;
    private String avatar;
    private String sign;
    private String userType;
    private Character mgrType;
    private Character status;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    private String remarks;
    private String no;
    private String loginIp;
    private Date loginDate;
    private List<TSysRole> roles;
    private List<TSysMenu> menus;
}
