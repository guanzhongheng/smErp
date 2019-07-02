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
    public static final long ORD_STATUS_EXE=12003l;
    //完成
    public static final long ORD_STATUS_FINISH=12004l;
    //废弃
    public static final long ORD_STATUS_INVALID=12005l;

    //正常
    public static final long CUS_STATUS_NOR=11000l;
    //特别-无需审核
    public static final long CUS_STATUS_SPEC=11001l;
    //需审核
    public static final long CUS_STATUS_CHECK=11002l;
    //拒绝
    public static final long CUS_STATUS_RJCT=11003l;
    //没人跟进
    public static final long CUS_STATUS_IDEL=11004l;

    /**
     * @Description: 客户资料类型-个人
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/1 4:10 PM
     */
    public static final long CUS_TYPE_PERSON=11101l;

    /**
     * @Description: 客户资料类型-企业
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/1 4:10 PM
     */
    public static final long CUS_TYPE_COM=11102l;
    /**
     * @Description: 客户星级-1
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/1 4:26 PM
     */
    public static final long CUS_GRADE_1=11201l;

    /**
     * @Description: 客户星级-2
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/1 4:26 PM
     */
    public static final long CUS_GRADE_2=11202l;

    /**
     * @Description: 客户星级-3
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/1 4:26 PM
     */
    public static final long CUS_GRADE_3=11203l;


    /**
     * @Description: 客户星级-4
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/1 4:26 PM
     */
    public static final long CUS_GRADE_4=11204l;


    /**
     * @Description: 客户星级-5
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/1 4:26 PM
     */
    public static final long CUS_GRADE_5=11205l;

    /**
     * @Description: 性别-女
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/1 3:48 PM
     */
    public static final long SEX_LADY=13001L;

    /**
     * @Description: 性别男
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/1 3:48 PM
     */
    public static final long SEX_MAN=13002L;


    /**
     * @Description: 订单类型
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/1 3:50 PM
     */
    public static final long ORD_TYPE_01=14000l;

    /**
     * @Description: 现金
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/1 3:51 PM
     */
    public static final long PAY_TYPE_CASH=15001l;

    /**
     * @Description: 电子转账
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/1 3:52 PM
     */
    public static final long PAY_TYPE_EFT=15002l;

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