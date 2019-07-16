<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>产品生产表</title>
    <script type="text/javascript">
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/crm/producePlan/list/">当前生产计划</a></li>
    <li><a href="${ctx}/crm/producePlan/list/">历史生产计划</a></li>
</ul>
<form:form id="searchForm" modelAttribute="vo" action="${ctx}/crm/producePlan/list" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li>
            <form:input path="name" htmlEscape="false" maxlength="200" class="input-medium" placeholder="订单号"/>
        </li>
        <li>
            &nbsp;&nbsp;
            <form:select path="kind" class="input-medium" placeholder="品种">
                <form:option value="" label=""/>
                <form:options items="${fns:getCusDictList(110000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
            </form:select>
        </li>
        <li>
            &nbsp;&nbsp;
            <form:select path="width" class="input-medium" placeholder="颜色">
                <form:option value="" label=""/>
                <form:options items="${fns:getCusDictList(105000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
            </form:select>
        </li>
        <li>
            &nbsp;&nbsp;
            <form:select path="machine" class="input-medium" placeholder="机台">
                <form:option value="" label=""/>
                <form:options items="${fns:getCusDictList(110000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
            </form:select>
        </li>
        &nbsp;&nbsp;
        <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
    </ul>
</form:form>
<%--<div class="control-group">&nbsp;&nbsp;&nbsp;&nbsp;--%>
    <%--<a href="/cus/customer_add" type="button" class="btn btn-primary" style="width: 67px;height: 22px"><i--%>
            <%--class="icon-plus"></i>&nbsp;添加</a>--%>
    <%--&nbsp;&nbsp;--%>
    <%--<a type="button" id="toCustomer" class="btn btn-default" style="width: 80px;height: 23px"><i--%>
            <%--class="icon-refresh"></i>&nbsp;转移客户</a>--%>
    <%--&nbsp;&nbsp;--%>
    <%--<a type="button" id="toPoolCustomer" class="btn btn-default" style="width: 80px;height: 23px"><i--%>
            <%--class="icon-group"></i>&nbsp;移入公海</a>--%>
<%--</div>--%>
<div class="control-group">
    <table id="contentTable" class="table table-striped table-bordered table-condensed">
        <thead>
        <tr>
            <th>订单编号</th>
            <th>收货人</th>
            <th>产品名称</th>
            <th>长</th>
            <th>压边类型</th>
            <th>厚度</th>
            <th>延长米</th>
            <th>数量</th>
            <th>计价方式</th>
            <th>面积</th>
            <th>重量</th>
            <th>状态</th>
            <th>创建时间</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>yuiyo789789321</td>
            <td>张三</td>
            <td>PO膜</td>
            <td>5m</td>
            <td>一类</td>
            <td>100mm</td>
            <td>1m</td>
            <td>5</td>
            <td>计价方式</td>
            <td>100平米</td>
            <td>100kg</td>
            <td><a href="${ctx}/produce/produce/info"><i class="icon-pencil">&nbsp;待生产</i></a></td>
            <td>2019-07-11 15:23:21</td>
        </tr>
        <%--<c:forEach items="${page.list}" var="cus">--%>
            <%--<tr>--%>
                <%--<td>${cus.cusName}</td>--%>
                <%--<td>${cus.cusStatus}</td>--%>
                <%--<td>${cus.cusGrade}</td>--%>
                <%--<td>${cus.primaryContactorName}</td>--%>
                <%--<td>${cus.primaryContactorPhone}</td>--%>
                    <%--&lt;%&ndash;<td>${cus.cusAddress}</td>&ndash;%&gt;--%>
                <%--<td><fmt:formatDate value="${cus.lastFollowDate}" pattern="yyyy-MM-dd"/></td>--%>
                <%--<td>${cus.unFollowDays}</td>--%>
                <%--<td>--%>
                    <%--<a href="" onclick="gotoFollowInfo(${cusCode})"><i class="icon-comment">&nbsp;跟进</i></a>--%>
                    <%--<a href="${ctx}/cus/customer_add?cusCode=${cus.cusCode}"><i class="icon-pencil">&nbsp;编辑</i></a>--%>
                    <%--<a href="${ctx}/cus/customer_delete?cusCode=${cus.cusCode}"--%>
                       <%--onclick="return confirmx('确认要删除该客户吗？', this.href)"><i class="icon-trash">&nbsp;删除</i></a>--%>
                <%--</td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
        </tbody>
    </table>
    <div class="pagination">${page}</div>

    <script>


    </script>
</div>
</body>
</html>