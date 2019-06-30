package com.lcyzh.nmerp.utils;

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
    private static final Map<String, String> dictValueMaps = new HashMap<>(100);

    /**
     * @Description: key-list<String>key与subkey的关系
     * @Param:
     * @return: 
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/6/28 11:49 AM
     */
    private static final Map<String, List<String>> dictKeyMaps = new HashMap<>(60);


    public static Map<String, String> getDictValueMaps() {
        return dictValueMaps;
    }

    public static Map<String, List<String>> getDictKeyMaps() {
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
    public static String getValueByDictKey(String dictKey) {
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
    public static List<String> getSubKeysByDictKey(String dictKey) {
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
    public static List<String> getSubValuesByDictKey(String dictKey) {
        if (dictKey != null) {
            List<String> subKeys = dictKeyMaps.get(dictKey);
            if (subKeys != null) {
                return subKeys.stream().map(sbk -> dictValueMaps.get(sbk)).collect(Collectors.toList());
            }
        }
        return null;
    }
}