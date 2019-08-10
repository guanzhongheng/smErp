<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>任务审批</title>
    <link rel="stylesheet" href="/static/common/customize.css">
    <script type="text/javascript">
        function page(n,s){

            if(n) $("#pageNo").val(n);
            if(s) $("#pageSize").val(s);
            $("#searchForm").attr("action","${ctx}/crm/approval/list");
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<%--<ul class="nav nav-tabs">--%>
    <%--<li class="active"><a href="${ctx}/crm/approval/list/">任务审批</a></li>--%>
<%--</ul>--%>







<div class="tabs-container" style="padding: 20px 20px;">
    <div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
        <div class="panel-heading" style="background-color: #50B0E6">
            <h3 class="panel-title global-panel-title" >
                订单审核
            </h3>
            <code class="pull-right" style="margin-top: -33px;margin-right: 8px;"><span style="color: red; ">*</span>
                <small>为必填项</small>
            </code>
        </div>
        <div class="panel-body" style="padding: 10px 10px 0px 10px;">

            <form:form id="searchForm" modelAttribute="order" action="${ctx}/crm/approval/list" method="post"
                       class="breadcrumb form-search">
                <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
                <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
                <ul class="ul-form">
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
                        <form:input path="ordSignDate" htmlEscape="false" maxlength="20"
                                    class="input-small Wdate" placeholder="签单日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
                    </li>
                    <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" style="width: 80px" value="查询"/></li>
                    &nbsp;&nbsp;
                    <li class="btns"><input class="btn btn-primary" type="button" style="width: 80px" onclick="apprFormReset()" value="重置"/></li>
                </ul>
            </form:form>
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
                                    <a href="/cus/orderStatus_update?ordCode=${ord.ordCode}&&ordStatus=0"  ><i class="icon-ok-circle">&nbsp;通过</i></a>&nbsp;&nbsp;
                                    <a href="/cus/orderStatus_update?ordCode=${ord.ordCode}&&ordStatus=1" style="color: red"  ><i class="icon-remove-circle">&nbsp;不通过</i></a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="pagination">${page}</div>
            </div>
        </div>
    </div>
</div>
<script>
    function apprFormReset() {
        $("#ordTitle").val("");
        $("#cusName").val("");
        $("#ordSignDate").val("");
    }
</script>





<%--<sys:message content="${message}"/>--%>
</body>
</html>