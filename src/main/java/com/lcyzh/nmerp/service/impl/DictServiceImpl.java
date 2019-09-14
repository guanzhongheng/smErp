package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.TDictMapper;
import com.lcyzh.nmerp.entity.TDict;
import com.lcyzh.nmerp.service.IDictService;
import com.lcyzh.nmerp.utils.DictUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/9/14  9:55 PM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/09/14    create
 */
@Service
public class DictServiceImpl implements IDictService {
    @Autowired
    private TDictMapper dictMapper;

    @Override
    public void loadDictData() {
        List<TDict> list = dictMapper.findList();
        if (list != null && !list.isEmpty()) {
            DictUtils.getDictValueMaps().clear();
            list.forEach(dict -> {
                if (dict != null) {
                    DictUtils.getDictValueMaps().put(dict.getDictKey(), dict.getDictValue());
                    List<Long> keyList = DictUtils.getDictKeyMaps().get(dict.getDictKey());
                    if (keyList == null && dict.getSubDictKey() != null) {
                        keyList = new ArrayList<>();
                        DictUtils.getDictKeyMaps().put(dict.getDictKey(), keyList);
                    }
                    if (dict.getSubDictKey() != null) {
                        keyList.add(dict.getSubDictKey());
                        DictUtils.getDictValueMaps().put(dict.getSubDictKey(), dict.getSubDictValue());
                    }
                }
            });
        }
    }
}