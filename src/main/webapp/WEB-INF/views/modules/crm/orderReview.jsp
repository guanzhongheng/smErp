<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>全部订单</title>
    <script type="text/javascript">


    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/order/list/">订单列表</a></li>
</ul>
<form:form id="searchForm" modelAttribute="order" action="${ctx}/order/list" method="post" class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li>
            <form:input path="ordCode" htmlEscape="false" maxlength="200"
                        class="input-medium" placeholder="订单编号"/>
        </li>
        <li>
            &nbsp;&nbsp;
            <form:input path="contCode" htmlEscape="false" maxlength="200"
                        class="input-medium" placeholder="订单标题"/>
        </li>
        <li>
            &nbsp;&nbsp;
            <form:input path="cusCode" htmlEscape="false" maxlength="200"
                        class="input-medium" placeholder="关联客户"/>
        </li>
        <li>
            &nbsp;&nbsp;
            <input id="deliveryDate" name="deliveryDate" placeholder="签单日期" type="text" readonly="readonly" maxlength="20" class="input-small Wdate"
                   value="" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
        </li>
        <li>
            <label for="exception"><input id="exception" name="exception" type="checkbox" value="1"/>跟进状态</label>
        </li>
        <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
        <li class="clearfix"></li>
    </ul>
</form:form>
<div class="control-group">&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="/order/order_add" type="button" class="btn btn-primary" style="width: 67px;height: 22px"><i class="icon-plus"></i>&nbsp;添加</a>
</div>
<div class="control-group">
    <table id="contentTable" class="table table-striped table-bordered table-condensed">
        <thead>
        <tr>
            <th>序号</th>
            <th>订单编号</th>
            <th>订单标题</th>
            <th>关联客户</th>
            <th>审批状态</th>
            <th>订单总金额</th>
            <th>已回款金额</th>
            <th>已开票金额</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>1</td>
            <td>1</td>
            <td>1</td>
            <td>1</td>
            <td>1</td>
            <td>1</td>
            <td>1</td>
            <td>1</td>
            <td>
                <a href=""><i class="icon-comment">跟进</i></a>
                <a href=""><i class="icon-pencil">编辑</i></a>
                <a href=""><i class="icon-trash">删除</i></a>
            </td>
        </tr>
        </tbody>
    </table>
    <div class="pagination">${page}</div>
</div>
<%--<sys:message content="${message}"/>--%>
</body>
</html>