<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title></title>
    <script type="text/javascript">
        function page(n,s){
            debugger;
            if(n) $("#pageNo").val(n);
            if(s) $("#pageSize").val(s);
            $("#searchForm").attr("action","${ctx}/crm/inventory/prodStockList");
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/crm/inventory/prodStockList">产品清单列表</a></li>
</ul>
<form:form id="searchForm" modelAttribute="orderQueryVo" action="${ctx}/crm/inventory/prodStockList" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li>
            <form:input path="cusName" htmlEscape="false" maxlength="200" class="input-medium" placeholder="客户名称"/>
        </li>
        <li>
            &nbsp;&nbsp;
            <form:input path="ordTitle" htmlEscape="false" maxlength="200" class="input-medium" placeholder="订单标题"/>
        </li>
        &nbsp;&nbsp;
        <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
        &nbsp;&nbsp;
        <li class="btns"><input id="btnExport" class="btn btn-primary" type="button" value="导出" onclick="exportInfo()"/></li>
    </ul>
</form:form>
<div class="control-group">
    <table id="contentTable" class="table table-striped table-bordered table-condensed">
        <thead>
        <tr>
            <th>客户名称</th>
            <th>订单标题</th>
            <th>订单总重量</th>
            <th>订单总面积</th>
            <th>订单总数量</th>
            <th>出库产品数量</th>
            <th>未出库产品数量</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list}" var="oq">
            <tr>
                <td>${oq.cusName}</td>
                <td>${oq.ordTitle}</td>
                <td>${oq.ordTotalWeight}</td>
                <td>${oq.ordTotalSq}</td>
                <td>${oq.ordTotalNum}</td>
                <td>${oq.ordTotalNum - oq.ordOutNum}</td>
                <td>${oq.ordOutNum}</td>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagination">${page}</div>

    <script>
        function exportInfo() {
            var cusName = $("#cusName").val();
            var ordTitle = $("#ordTitle").val();
            if((cusName == null || cusName == undefined || cusName == '') &&
                (ordTitle == null || ordTitle == undefined || ordTitle == '')){
                $.ajax({})
            }

        }
    </script>
</div>
</body>
</html>