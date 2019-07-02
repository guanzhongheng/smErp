package com.lcyzh.nmerp.constant;

/**
 * @Project : nm-erp
 * @Description : 常量类,字典：前三位表示一类，第四位表示小类，末尾表示具体参数
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
    /***
     * @Description: 订单状态
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:18 PM
     */
    public static final long ORD_STATUS = 100000L;

    /***
     * @Description: 订单状态-新建
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:18 PM
     */
    public static final long ORD_STATUS_NEW = 100001L;

    /***
     * @Description: 订单状态-待审批
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:18 PM
     */
    public static final long ORD_STATUS_TOASSIGN = 100002L;

    /***
     * @Description: 订单状态-已审批
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:18 PM
     */
    public static final long ORD_STATUS_ASSIGNED = 100003L;

    /***
     * @Description: 订单状态-审批驳回
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:18 PM
     */
    public static final long ORD_STATUS_CHK_RJCT = 100004L;

    /**
     * @Description: 付款方式
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:28 PM
     */
    public static final long PAY_TYPE = 101000L;

    /**
     * @Description: 付款方式-现金
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:28 PM
     */
    public static final long PAY_TYPE_CASH = 101001L;

    /**
     * @Description: 付款方式-电子转账
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:28 PM
     */
    public static final long PAY_TYPE_EFT = 101001L;

    /**
     * @Description: 订单执行状态
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:35 PM
     */
    public static final long ORD_EXE_STATUS = 102000L;

    /**
     * @Description: 订单执行状态-待分配
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:35 PM
     */
    public static final long ORD_EXE_STATUS_TOASSIGN = 102001L;

    /**
     * @Description: 订单执行状态-已分配
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:35 PM
     */
    public static final long ORD_EXE_STATUS_ASSIGNED = 102002L;

    /**
     * @Description: 订单执行状态-执行中
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:35 PM
     */
    public static final long ORD_EXE_STATUS_EXING = 102003L;

    /**
     * @Description: 订单执行状态-未知
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:35 PM
     */
    public static final long ORD_EXE_STATUS_UNKNOWN = 102004L;

    /**
     * @Description: 产品单位
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:42 PM
     */
    public static final long PROD_UNIT = 103000L;

    /**
     * @Description: 产品单位-千克
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:42 PM
     */
    public static final long PROD_UNIT_KG = 103001L;

    /**
     * @Description: 产品单位-顿
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:42 PM
     */
    public static final long PROD_UNIT_TON = 103002L;

    /**
     * @Description: 客户状态
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:48 PM
     */
    public static final long CUS_STATUS = 104000L;

    /**
     * @Description: 客户状态-新建
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:48 PM
     */
    public static final long CUS_STATUS_NEW = 104001L;

    /**
     * @Description: 客户状态-正常（跟进）
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:48 PM
     */
    public static final long CUS_STATUS_FLLOW = 104002L;

    /**
     * @Description: 客户状态-正常（未跟进）
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:48 PM
     */
    public static final long CUS_STATUS_UNFLLOW = 104003L;

    /**
     * @Description: 客户状态-特别
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:48 PM
     */
    public static final long CUS_STATUS_SPEC = 104004L;

    /**
     * @Description: 客户状态-黑户
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:48 PM
     */
    public static final long CUS_STATUS_BH = 104005L;

    /**
     * @Description: 客户星级
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:48 PM
     */
    public static final long CUS_GRADE = 105000L;

    /**
     * @Description: 客户星级-1星
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:48 PM
     */
    public static final long CUS_GRADE_ONE = 105001L;

    /**
     * @Description: 客户星级-2星
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:48 PM
     */
    public static final long CUS_GRADE_TWO = 105002L;

    /**
     * @Description: 客户星级-3星
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:48 PM
     */
    public static final long CUS_GRADE_THR = 105003L;

    /**
     * @Description: 客户星级-4星
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:48 PM
     */
    public static final long CUS_GRADE_FOUR = 105004L;

    /**
     * @Description: 客户星级-5星
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:48 PM
     */
    public static final long CUS_GRADE_FIVE = 105005L;

    /**
     * @Description: 客户来源
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:58 PM
     */
    public static final long CUS_SOURCE = 106000L;

    /**
     * @Description: 客户来源-网络
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:58 PM
     */
    public static final long CUS_SOURCE_NETWORK = 106001L;

    /**
     * @Description: 客户来源-电话营销
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:58 PM
     */
    public static final long CUS_SOURCE_TMK = 106002L;

    /**
     * @Description: 客户来源-人际关系
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 3:58 PM
     */
    public static final long CUS_SOURCE_IR = 106003L;

    /**
     * @Description: 付款周期
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 4:09 PM
     */
    public static final long PAYMENT_PERIOD = 107000L;

    /**
     * @Description: 付款周期-1期
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 4:09 PM
     */
    public static final long PAYMENT_PERIOD_ONE = 107001L;

    /**
     * @Description: 付款周期-2期
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 4:09 PM
     */
    public static final long PAYMENT_PERIOD_TWO = 107002L;

    /**
     * @Description: 付款周期-3期
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 4:09 PM
     */
    public static final long PAYMENT_PERIOD_THR = 107003L;

    /**
     * @Description: 性别
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 4:09 PM
     */
    public static final long SEX = 108000L;

    /**
     * @Description: 性别-男
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 4:09 PM
     */
    public static final long SEX_MAN = 108001L;

    /**
     * @Description: 性别-女
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 4:09 PM
     */
    public static final long SEX_LADY = 108002L;

    /**
     * @Description: 性别-未知
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 4:09 PM
     */
    public static final long SEX_UNKNOWN = 108003L;

    /**
     * @Description: 部门
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 5:08 PM
     */
    public static final long DEPARTMENT = 109000L;

    /**
     * @Description: 部门-销售
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 5:08 PM
     */
    public static final long DEPARTMENT_SALE = 109001L;

    /**
     * @Description: 部门-生产部
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 5:08 PM
     */
    public static final long DEPARTMENT_PROD = 109002L;


    /**
     * @Description: 部门-品保部
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 5:08 PM
     */
    public static final long DEPARTMENT_QA = 109003L;


    /**
     * @Description: 部门-仓库
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 5:08 PM
     */
    public static final long DEPARTMENT_WH = 109004L;


    /**
     * @Description: 部门-内勤
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 5:08 PM
     */
    public static final long DEPARTMENT_OW = 109005L;

    /**
     * @Description: 客户类型
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 5:56 PM
     */
    public static final long CUS_TYPE = 110000L;

    /**
     * @Description: 客户类型-个人
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 5:56 PM
     */
    public static final long CUS_TYPE_PERSON = 110001L;


    /**
     * @Description: 客户类型-企业
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 5:56 PM
     */
    public static final long CUS_TYPE_COM = 110002L;

    /**
     * @Description: 行业
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 10:08 PM
     */
    public static final long INDUSTRY = 120000L;

    /**
     * @Description: 行业-制造业
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 10:08 PM
     */
    public static final long INDUSTRY_MAN = 120001L;

    /**
     * @Description: 行业-化工
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 10:08 PM
     */
    public static final long INDUSTRY_CHEM = 120002L;

    /**
     * @Description: 行业-其他
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 10:08 PM
     */
    public static final long INDUSTRY_OTHER = 120003L;

    /**
     * @Description: 首要联系人角色
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 10:08 PM
     */
    public static final long PRIM_CONTACTOR_ROLE = 130000L;

    /**
     * @Description: 首要联系人角色-决策人
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 10:08 PM
     */
    public static final long PRIM_CONTACTOR_ROLE_PMK = 130001L;

    /**
     * @Description: 首要联系人角色-影响人
     * @Param:
     * @return:
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2019/7/2 10:08 PM
     */
    public static final long PRIM_CONTACTOR_ROLE_APN = 130001L;


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