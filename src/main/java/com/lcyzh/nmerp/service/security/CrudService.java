/**
 * Copyright &copy; 2017-2019  All rights reserved.
 */
package com.lcyzh.nmerp.service.security;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcyzh.nmerp.common.persistence.DataEntity;
import com.lcyzh.nmerp.common.persistence.Page;
import com.lcyzh.nmerp.dao.common.CrudDao;
import com.lcyzh.nmerp.model.vo.ProdPlanVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service基类
 * @author ThinkGem
 * @version 2014-05-16
 */
@Transactional(readOnly = true)
public abstract class CrudService<D extends CrudDao<T>, T extends DataEntity<T>> extends BaseService {
	
	/**
	 * 持久层对象
	 */
	@Autowired
	protected D dao;
	
	/**
	 * 获取单条数据
	 * @param id
	 * @return
	 */
	public T get(String id) {
		return dao.get(id);
	}
	
	/**
	 * 获取单条数据
	 * @param entity
	 * @return
	 */
	public T get(T entity) {
		return dao.get(entity);
	}
	
	/**
	 * 查询列表数据
	 * @param entity
	 * @return
	 */
	public List<T> findList(T entity) {
		return dao.findList(entity);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param entity
	 * @return
	 */
	public Page<T> findPage(Page<T> page, T entity) {
//		entity.setPage(page);
		page.setList(dao.findList(entity));
		return page;
	}

	/**
	 * 通过PageHelp 分页
	 * @param page 分页对象
	 * @param entity
	 * @return
	 */
	public Page<T> findPageForHelp(Page<T> page, T entity) {
		PageHelper.startPage(page.getPageNo(),page.getPageSize());
//		entity.setPage(page);
		List<T> list = dao.findList(entity);
		PageInfo<T> p = new PageInfo<>(list);
		page.setTotal(p.getTotal());
		page.setList(list);
		page.setCount(list.size());
		return page;
	}

	/**
	 * 保存数据（插入或更新）
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void save(T entity) {
		if (entity.getIsNewRecord()){
			entity.preInsert();
			dao.insert(entity);
		}else{
			entity.preUpdate();
			dao.update(entity);
		}
	}
	
	/**
	 * 删除数据
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void delete(T entity) {
		dao.delete(entity);
	}

}
