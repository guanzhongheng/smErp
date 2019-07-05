package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.dao.common.CrudDao;
import com.lcyzh.nmerp.entity.sys.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface TSysRoleMapper extends CrudDao<Role> {

    public Role getByName(Role role);

    /**
     * 维护角色与菜单权限关系
     * @param role
     * @return
     */
    public int deleteRoleMenu(Role role);

    public int insertRoleMenu(Role role);

}
