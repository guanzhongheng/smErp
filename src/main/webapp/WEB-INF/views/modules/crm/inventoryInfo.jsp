<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>出库清单</title>
    <script type="text/javascript">
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li ><a href="${ctx}/crm/inventory/list/">库存列表</a></li>
    <li class="active"><a href="${ctx}/crm/inventory/info/">出库清单</a></li>
</ul>
<form:form id="searchForm" modelAttribute="outStockDetailVo" action="${ctx}/crm/inventory/info" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li>
            <form:input path="outCode" htmlEscape="false" maxlength="200" class="input-medium" placeholder="出库单号"/>
        </li>
        <li>
            &nbsp;&nbsp;
            <form:input path="itemName" htmlEscape="false" maxlength="200" class="input-medium" placeholder="产品名称"/>
        </li>
        <li>
            &nbsp;&nbsp;
            <form:input path="itemName" htmlEscape="false" maxlength="200" class="input-medium" placeholder="二维码号"/>
        </li>
        &nbsp;&nbsp;
        <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
    </ul>
</form:form>
<div class="control-group">
    <table id="contentTable" class="table table-striped table-bordered table-condensed">
        <thead>
        <tr>
            <th>出库单号</th>
            <th>产品名称</th>
            <th>产品编码</th>
            <th>产品规格</th>
            <th>出库数量</th>
            <th>二维码号</th>
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
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagination">${page}</div>


</div>
</body>
</html>