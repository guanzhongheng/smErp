<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>任务审批</title>
    <script type="text/javascript">
        function page(n,s){
            debugger;
            if(n) $("#pageNo").val(n);
            if(s) $("#pageSize").val(s);
            $("#searchForm").attr("action","${ctx}/crm/approval/list");
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/crm/approval/list/">任务审批</a></li>
</ul>
<form:form id="searchForm" modelAttribute="order" action="${ctx}/crm/approval/list" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li>
            <form:input path="ordCode" htmlEscape="false" maxlength="200"
                        class="input-medium" placeholder="订单编号"/>
        </li>
        <li>
            &nbsp;&nbsp;
            <form:input path="ordTitle" htmlEscape="false" maxlength="200"
                        class="input-medium" placeholder="订单标题"/>
        </li>
        <li>
            &nbsp;&nbsp;
            <form:input path="cusName" htmlEscape="false" maxlength="200"
                        class="input-medium" placeholder="关联客户"/>
        </li>
        <li>
            &nbsp;&nbsp;
            <input id="ordSignDate" name="ordSignDate" placeholder="签单日期" type="text" readonly="readonly" maxlength="20"
                   class="input-small Wdate"
                   value="" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
        </li>
        <li>
            <label for="exception"><input id="exception" name="exception" type="checkbox" value="1"/>跟进状态</label>
        </li>
        <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" style="width: 100px" value="查询"/></li>
        <li class="clearfix"></li>
    </ul>
</form:form>
<%--<div class="control-group">&nbsp;&nbsp;&nbsp;&nbsp;--%>
    <%--<a href="/order/order_add" type="button" class="btn btn-primary" style="width: 67px;height: 22px"><i--%>
            <%--class="icon-plus"></i>&nbsp;添加</a>--%>
<%--</div>--%>
<div class="control-group table-responsive">
    <table id="contentTable" class="table table-striped table-bordered table-hover text-nowrap">
        <thead>
        <tr>
            <th style="text-align: center">序号</th>
            <th style="text-align: center">订单标题</th>
            <th style="text-align: center">关联客户</th>
            <th style="text-align: center">审批状态</th>
            <th style="text-align: center">订单总金额</th>
            <th style="text-align: center">订单交付期</th>
            <th style="text-align: center">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list}" var="ord" varStatus="status">
            <tr>
                <td style="text-align: center">${status.index + 1}</td>
                <td>${ord.ordTitle}</td>
                <td>${ord.cusName}</td>
                <td>${ord.ordStatusValue}</td>
                <td>${ord.ordTotalAmount}</td>
                <td>${ord.ordDeliveryDate}</td>
                <td>
                    <c:if test="${ord.ordStatus eq '100001'}">
                        <a href="/cus/orderStatus_update?ordCode=${ord.ordCode}&&ordStatus=0"  type="button" class="btn btn-primary" >通过</a>&nbsp;&nbsp;
                        <a href="/cus/orderStatus_update?ordCode=${ord.ordCode}&&ordStatus=1" type="button" class="btn btn-primary" >不通过</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagination">${page}</div>
</div>
<%--<sys:message content="${message}"/>--%>
</body>
</html>