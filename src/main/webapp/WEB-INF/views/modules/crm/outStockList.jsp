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
            $("#searchForm").attr("action","${ctx}/crm/inventory/outStockList");
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/crm/inventory/outStockList">出库清单</a></li>
</ul>
    <form:form id="searchForm" modelAttribute="outStockVo" action="${ctx}/crm/inventory/outStockList" method="post"
               class="breadcrumb form-search">
        <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
        <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
        <ul class="ul-form">
            <li>
                <form:input path="outCode" htmlEscape="false" maxlength="200"
                            class="input-medium" placeholder="出库单号"/>
            </li>
            <li>
                &nbsp;&nbsp;
                <select id="outStatus" name="outStatus" class="input-medium" >
                    <option value="">请选择出库单状态</option>
                    <option value="0">未出库</option>
                    <option value="1">已出库</option>
                </select>
            </li>
            <li>
                &nbsp;&nbsp;
                <input id="startDate" name="startDate" placeholder="开始时间" type="text" readonly="readonly" maxlength="20"
                       class="input-small Wdate"
                       value="" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
                ～
                <input id="endDate" name="endDate" placeholder="结束时间" type="text" readonly="readonly" maxlength="20"
                       class="input-small Wdate"
                       value="" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
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
            <th>客户名称</th>
            <th>联系方式</th>
            <th>出库单状态</th>
            <th>创建时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list}" var="cus">
            <tr>
                <td>${cus.outCode}</td>
                <td>${cus.cusName}</td>
                <td>${cus.phone}</td>
                <td>${cus.outStatus == '0'?"未出库":"已出库"}</td>
                <td><fmt:formatDate value="${cus.createTime}" pattern="yyyy-MM-dd"/></td>
                <td>
                    <a href="/crm/inventory/outStockDetail?outCode=${cus.outCode}"><i class="icon-pencil">&nbsp;详情</i></a>
                    <a href="/print/outStock_print?outCode=${cus.outCode}"><i class="icon-pencil">&nbsp;打印</i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagination">${page}</div>
</div>
</body>
</html>