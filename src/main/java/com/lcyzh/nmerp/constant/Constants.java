package com.lcyzh.nmerp.constant;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/6/19  5:23 PM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/06/19    create
 */
public class Constants {
    public static final String CONT_PRE_FIX="HT";

    public static final String ORD_PRE_FIX="ORD";

    public static final String CUS_PRE_FIX="CS";

    public static final String OUT_STORE_PRE_FIX="OST";

    //新建
    public static final char CONT_STATUS_NEW='0';
    //已完善
    public static final char CONT_STATUS_FINISH='1';
    //合同无效
    public static final char CONT_STATUS_INVALID='2';
    //新建
    public static final long ORD_STATUS_NEW=12000l;
    /**
     * @Description: 待分配
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/6/27 9:40 AM
     */
    public static final long ORD_STATUS_TOASSIGN=12001l;
    /**
     * @Description: 已分配
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/6/27 9:41 AM
     */
    public static final long ORD_STATUS_ASSIGNED=12002l;
    //执行中
    public static final char ORD_STATUS_EXE='3';
    //完成
    public static final char ORD_STATUS_FINISH='4';
    //废弃
    public static final char ORD_STATUS_INVALID='5';

    //正常
    public static final long CUS_STATUS_NOR=11000l;
    //特别-无需审核
    public static final long CUS_STATUS_SPEC=11001l;
    //需审核
    public static final long CUS_STATUS_CHECK=11002l;
    //拒绝
    public static final long CUS_STATUS_RJCT=11003l;

    /**
     * @Description: 产品大类字典编号
     * @Param:
     * @return: 
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/6/28 12:06 PM
     */
    public static final String DICT_PROD_BIG_CGY = "PD0001";
    /**
     * @Description: 半产品大类字典编号
     * @Param:
     * @return: 
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/6/28 12:07 PM
     */
    public static final String DICT_SEM_BIG_CGY = "SEM0001";
    /**
     * @Description: 原材料大类字典编号
     * @Param:
     * @return: 
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/6/28 12:07 PM
     */
    public static final String DICT_RAW_BIG_CGY = "SEM0001";

}