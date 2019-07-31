<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>全部客户</title>
    <link rel="stylesheet" href="/static/common/customize.css">
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
<%--<ul class="nav nav-tabs">--%>
    <%--<li class="active"><a href="${ctx}/crm/inventory/outStockList">出库清单</a></li>--%>
<%--</ul>--%>






<div class="tabs-container" style="padding: 20px 20px;">
    <div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
        <div class="panel-heading" style="background-color: #50B0E6">
            <h3 class="panel-title global-panel-title" >
                客户列表
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
                        <select id="outStatus" name="outStatus" class="input-medium" style="width: 200px" >
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
                    <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" style="width: 100px"  value="查询"/></li>
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
                            <td>${cus.outStatus == '0'?"未出库":"已出库"}</td>
                            <td><fmt:formatDate value="${cus.createTime}" pattern="yyyy-MM-dd"/></td>
                            <td>
                                <a href="/crm/inventory/outStockDetail?outCode=${cus.outCode}"><i class="icon-th-list">&nbsp;详情</i></a>
                                <a href="/print/outStock_print?outCode=${cus.outCode}"><i class="icon-print">&nbsp;打印</i></a>
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





</body>
</html>