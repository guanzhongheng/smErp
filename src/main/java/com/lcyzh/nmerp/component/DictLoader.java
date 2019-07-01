package com.lcyzh.nmerp.component;

import com.lcyzh.nmerp.dao.TDictMapper;
import com.lcyzh.nmerp.entity.TDict;
import com.lcyzh.nmerp.utils.DictUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/6/28  10:51 AM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/06/28    create
 */

@Component
public class DictLoader implements CommandLineRunner {

    @Autowired
    private TDictMapper dictMapper;


    @Override
    public void run(String... args) throws Exception {
        List<TDict> list = dictMapper.findList();
        if (list != null && !list.isEmpty()) {
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