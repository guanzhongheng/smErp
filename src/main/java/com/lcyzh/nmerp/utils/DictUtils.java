package com.lcyzh.nmerp.utils;

import com.lcyzh.nmerp.entity.TProduct;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/6/28  11:02 AM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/06/28    create
 */
public class DictUtils {

    /**
     * @Description: key-value 值，不分大类小类
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/6/28 11:49 AM
     */
    private static final Map<Long, String> dictValueMaps = new HashMap<>(100);

    /**
     * @Description: key-list<Long>key与subkey的关系
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/6/28 11:49 AM
     */
    private static final Map<Long, List<Long>> dictKeyMaps = new HashMap<>(60);


    public static Map<Long, String> getDictValueMaps() {
        return dictValueMaps;
    }

    public static Map<Long, List<Long>> getDictKeyMaps() {
        return dictKeyMaps;
    }


    /**
     * @Description: 根据字典key获取值
     * @Param: [dictKey]
     * @return: java.lang.String
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/6/28 11:50 AM
     */
    public static String getValueByDictKey(Long dictKey) {
        if (dictKey != null) {
            return dictValueMaps.get(dictKey);
        }
        return null;
    }

    /**
     * @Description: 根据字典key获取subKey的集合
     * @Param: [dictKey]
     * @return: java.util.List<java.lang.String>
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/6/28 11:51 AM
     */
    public static List<Long> getSubKeysByDictKey(Long dictKey) {
        if (dictKey != null) {
            return dictKeyMaps.get(dictKey);
        }
        return null;
    }

    /**
     * @Description: 根据字典key获取subKey的value集合
     * @Param: [dictKey]
     * @return: java.util.List<java.lang.String>
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/6/28 11:51 AM
     */
    public static List<String> getSubValuesByDictKey(Long dictKey) {
        if (dictKey != null) {
            List<Long> subKeys = dictKeyMaps.get(dictKey);
            if (subKeys != null) {
                return subKeys.stream().map(sbk -> dictValueMaps.get(sbk)).collect(Collectors.toList());
            }
        }
        return null;
    }


    /**
     * @Description: 根据大类获取子类型的字典值集合
     * @Param: [dictKey]
     * @return: java.util.List<com.lcyzh.nmerp.utils.DictEntity>
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/1 11:50 AM
     */
    public static List<DictEntity> getDictList(Long dictKey) {
        if (dictKey != null) {
            List<Long> subDictKeys = dictKeyMaps.get(dictKey);
            List<DictEntity> dictEntityList = null;
            if (subDictKeys != null) {
                dictEntityList = subDictKeys.stream().map(subkey -> {
                    DictEntity dictEntity = new DictEntity();
                    dictEntity.setLabel(dictValueMaps.get(subkey));
                    dictEntity.setValue(String.valueOf(subkey));
                    dictEntity.setType(String.valueOf(dictKey));
                    dictEntity.setDescribe(dictValueMaps.get(dictKey));
                    return dictEntity;
                }).collect(Collectors.toList());
            }

            return dictEntityList;
        }

        return null;
    }


    //key-员工编号；value-员工名称

    //按照部门分类：员工字典
    private static final Map<Long, List<DictEntity>> empMapsByDept = new HashMap<>(60);

    public static Map<Long, List<DictEntity>> getEmpMapsByDept() {
        return empMapsByDept;
    }

    public static List<DictEntity> getEmpListByDept(Long deptKey) {
        if (deptKey != null) {
           return empMapsByDept.get(deptKey);
        }
        return null;
    }


    private static final Map<String,TProduct> prodMaps = new HashMap<>(100);

    public static Map<String, TProduct> getProdMaps() {
        return prodMaps;
    }

    public static TProduct getProdCodeByProdCgyAndVari(String dictKey){
        if (dictKey != null) {
            return prodMaps.get(dictKey);
        }
        return null;
    }
}