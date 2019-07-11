/**
 * Copyright &copy; 2017-2019  All rights reserved.
 */
package com.lcyzh.nmerp.dao.common;

import com.lcyzh.nmerp.entity.sys.Dict;

import java.util.List;

/**
 * 字典DAO接口
 * @author ThinkGem
 * @version 2014-05-16
 */
@MyBatisDao
public interface DictDao extends CrudDao<Dict> {

	public List<String> findTypeList(Dict dict);
	
}
