package com.lcyzh.nmerp.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/6/19  5:13 PM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/06/19    create
 */
public class StringUtils {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    public static String genFixPreFixStr(String prefix) {
        LocalDateTime now = LocalDateTime.now();
        String dateStr = now.format(formatter);
        return prefix + dateStr;
    }
}