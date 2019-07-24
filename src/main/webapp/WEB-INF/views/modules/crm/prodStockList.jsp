<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>全部客户</title>
    <script type="text/javascript">

        function page(n,s){
            debugger;
            if(n) $("#pageNo").val(n);
            if(s) $("#pageSize").val(s);
            $("#searchForm").attr("action","${ctx}/crm/customer/list");
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/crm/customer/list/">客户列表</a></li>
    <li><a href="${ctx}/crm/customer/poollist/">公海列表</a></li>
</ul>
<form:form id="searchForm" modelAttribute="customer" action="${ctx}/crm/customer/list" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li>
            <form:input path="cusName" htmlEscape="false" maxlength="200" class="input-medium" placeholder="客户名称"/>
        </li>
        <li>
            &nbsp;&nbsp;
            <form:select path="cusType" class="input-medium" placeholder="客户类型">
                <form:option value="" label=""/>
                <form:options items="${fns:getCusDictList(110000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
            </form:select>
        </li>
        <li>
            &nbsp;&nbsp;
            <form:select path="cusGrade" class="input-medium" placeholder="客户星级">
                <form:option value="" label=""/>
                <form:options items="${fns:getCusDictList(105000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
            </form:select>
            <input id="beginDate" name="beginDate" placeholder="最后跟进" type="text" readonly="readonly" maxlength="20"
                   class="input-small Wdate"
                   value="" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
        </li>
        <li>
            &nbsp;&nbsp;
            <input type="checkbox" name="followType" id="type" value="1">归属模式
        </li>
        &nbsp;&nbsp;
        <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
    </ul>
</form:form>
<div class="control-group">&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="/cus/customer_add" type="button" class="btn btn-primary" style="width: 67px;height: 22px"><i
            class="icon-plus"></i>&nbsp;添加</a>
    &nbsp;&nbsp;
    <a type="button" id="toCustomer" class="btn btn-default" style="width: 80px;height: 23px"><i
            class="icon-refresh"></i>&nbsp;转移客户</a>
    &nbsp;&nbsp;
    <a type="button" id="toPoolCustomer" class="btn btn-default" style="width: 80px;height: 23px"><i
            class="icon-group"></i>&nbsp;移入公海</a>
</div>
<div class="control-group">
    <table id="contentTable" class="table table-striped table-bordered table-condensed">
        <thead>
        <tr>
            <th>客户名称</th>
            <th>订单标题</th>
            <th>订单总重量</th>
            <th>订单总面积</th>
            <th>订单总价格</th>
            <th>订单总数量</th>
            <th>出库产品数量</th>
            <th>未出库产品数量</th>
            <th>订单创建时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list}" var="cus">
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <%--<td><fmt:formatDate value="${cus.lastFollowDate}" pattern="yyyy-MM-dd"/></td>--%>
                <td></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagination">${page}</div>

    <script>

    </script>
</div>
</body>
</html>