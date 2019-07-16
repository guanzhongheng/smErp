<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>库存列表</title>
    <script type="text/javascript">
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/crm/inventory/list/">库存列表</a></li>
    <%--<li><a href="${ctx}/crm/inventory/info/">出库清单</a></li>--%>
</ul>
<form:form id="searchForm" modelAttribute="prodInvInfoVo" action="${ctx}/crm/inventory/list" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li>
            <form:input path="ordCode" htmlEscape="false" maxlength="200" class="input-medium" placeholder="订单编号"/>
        </li>
        <li>
            &nbsp;&nbsp;
            <form:input path="itemName" htmlEscape="false" maxlength="200" class="input-medium" placeholder="产品名称"/>

        </li>
        &nbsp;&nbsp;
        <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
    </ul>
</form:form>
<div class="control-group">
    <table id="contentTable" class="table table-striped table-bordered table-condensed">
        <thead>
        <tr>
            <th>订单编号</th>
            <th>订单标题</th>
            <th>产品编号</th>
            <th>产品名称</th>
            <th>产品规格</th>
            <th>产品所属人</th>
            <th>当前库存</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list}" var="cus">
            <tr>
                <td>${cus.ordCode}</td>
                <td><a href="#">${cus.ordTitle}</a></td>
                <td>${cus.itemCode}</td>
                <td>${cus.itemName}</td>
                <td>${cus.itemSpec}</td>
                <td>${cus.itemOwner}</td>
                <td>${cus.num}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagination">${page}</div>


</div>
</body>
</html>