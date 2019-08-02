package com.lcyzh.nmerp.component;

import com.lcyzh.nmerp.dao.EmployeeMapper;
import com.lcyzh.nmerp.dao.TDictMapper;
import com.lcyzh.nmerp.dao.TProductMapper;
import com.lcyzh.nmerp.entity.Employee;
import com.lcyzh.nmerp.entity.TDict;
import com.lcyzh.nmerp.entity.TProduct;
import com.lcyzh.nmerp.utils.DictEntity;
import com.lcyzh.nmerp.utils.DictUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

@Order(value = 0)
@Component
public class DictLoader implements CommandLineRunner {

    @Autowired
    private TDictMapper dictMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private TProductMapper productMapper;


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

        List<Employee> employees = employeeMapper.findAllList();
        if (employees != null && !employees.isEmpty()) {
            employees.forEach(emp -> {
                List<DictEntity> dictEntities = DictUtils.getEmpMapsByDept().get(emp.getDepartment());
                if (dictEntities == null) {
                    dictEntities = new ArrayList<>(10);
                    DictUtils.getEmpMapsByDept().put(emp.getDepartment(),dictEntities);
                }
                dictEntities.add(new DictEntity(emp.getEmpCode(), emp.getEmpName()));
            });
        }

        List<TProduct> prods = productMapper.findAllList();
        if(prods!=null && !prods.isEmpty()){
            Map<String, TProduct> prodMaps = DictUtils.getProdMaps();
            prods.forEach(prod->{
              prodMaps.put(String.valueOf(prod.getProdCgyCode())+prod.getProdVariety()+prod.getProdColor(),prod);
            });
        }
    }
}