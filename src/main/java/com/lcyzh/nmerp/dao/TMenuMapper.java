package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.dao.common.CrudDao;
import com.lcyzh.nmerp.entity.Menu;

import java.util.List;

/**
 * 项目名称：nm-erp
 * 类 名 称：TMenu
 * 类 描 述：TODO
 * 创建时间：2019/7/1 3:21 PM
 * 创 建 人：guan
 */
public interface TMenuMapper extends CrudDao<Menu> {

    public List<Menu> findByParentIdsLike(Menu menu);

    public List<Menu> findByUserId(Menu menu);

    public int updateParentIds(Menu menu);

    public int updateSort(Menu menu);
}
