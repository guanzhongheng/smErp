package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.dao.common.CrudDao;
import com.lcyzh.nmerp.entity.sys.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TSysMenuMapper extends CrudDao<Menu> {

    public List<Menu> findByParentIdsLike(Menu menu);

    public List<Menu> findByUserId(Menu menu);

    public int updateParentIds(Menu menu);

    public int updateSort(Menu menu);
}
