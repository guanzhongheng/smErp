<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>全部客户</title>
    <link rel="stylesheet" href="/static/common/customize.css">
    <script type="text/javascript">
        function page(n,s){

            if(n) $("#pageNo").val(n);
            if(s) $("#pageSize").val(s);
            $("#searchForm").attr("action","${ctx}/crm/inventory/outStockList");
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>

<div class="tabs-container" style="padding: 20px 20px;">
    <div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
        <div class="panel-heading" style="background-color: #50B0E6">
            <h3 class="panel-title global-panel-title" >
                出库单列表
            </h3>
            <code class="pull-right" style="margin-top: -33px; margin-right: 8px;"><span style="color: red; ">*</span>
                <small>为必填项</small>
            </code>
        </div>
        <div class="panel-body" style="padding: 10px 10px 0px 10px;">
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
                        <form:select path="outStatus" class="input-medium" placeholder="出库单状态">
                            <form:option value="" label=""/>
                            <form:option value="0" label="新建"/>
                            <form:option value="1" label="待审核"/>
                            <form:option value="2" label="已审核通过"/>
                        </form:select>
                    </li>
                    <li>
                        &nbsp;&nbsp;
                        <form:input path="startDate" htmlEscape="false" readonly="readonly" class="input-small Wdate"
                                    placeholder="开始时间" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
                        ～
                        <form:input path="endDate" htmlEscape="false" readonly="readonly" class="input-small Wdate"
                                    placeholder="开始时间" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
                    </li>
                    &nbsp;&nbsp;
                    <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" style="width: 80px"  value="查询"/></li>
                    &nbsp;&nbsp;
                    <li class="btns"><input class="btn btn-primary" type="button" style="width: 80px" onclick="stockFormReset()" value="重置"/></li>
                </ul>
            </form:form>
            <div class="control-group table-responsive">
                <table id="contentTable" class="table table-striped table-bordered table-hover text-nowrap">
                    <thead>
                    <tr>
                        <th style="text-align: center">序号</th>
                        <th style="text-align: center">出库单号</th>
                        <th style="text-align: center">客户名称</th>
                        <th style="text-align: center">联系方式</th>
                        <th style="text-align: center">出库单状态</th>
                        <th style="text-align: center">创建时间</th>
                        <th style="text-align: center">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.list}" var="cus" varStatus="status">
                        <tr>
                            <td style="text-align: center">${status.index + 1}</td>
                            <td>${cus.outCode}</td>
                            <td>${cus.cusName}</td>
                            <td>${cus.phone}</td>
                            <td>
                                <c:if test="${cus.outStatus eq '48'}">新建</c:if>
                                <c:if test="${cus.outStatus eq '49'}">待审核</c:if>
                                <c:if test="${cus.outStatus eq '50'}">审核通过</c:if>
                            </td>
                            <td><fmt:formatDate value="${cus.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td>
                                <a href="/crm/inventory/outStockDetail?outCode=${cus.outCode}"><i class="icon-th-list">&nbsp;详情</i></a>
                                <c:if test="${cus.outStatus eq '50'}">
                                    <a href="/print/outStock_print?outCode=${cus.outCode}"><i class="icon-print">&nbsp;打印</i></a>
                                </c:if>
                                <a href="/print/outStockInvoice_print?outCode=${cus.outCode}"><i class="icon-print">&nbsp;单据</i></a>
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
    function stockFormReset() {
        $("#outCode").val("");
        $("#startDate").val("");
        $("#endDate").val("");
        $("#outStatus").val("").select2();
    }
</script>




</body>
</html>