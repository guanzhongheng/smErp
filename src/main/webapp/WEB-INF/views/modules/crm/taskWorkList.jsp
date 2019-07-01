<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>全部客户</title>
    <script type="text/javascript">


    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/crm/list/">客户列表</a></li>
    <li class="active"><a href="${ctx}/crm/poollist/">公海列表</a></li>
</ul>
<form:form id="searchForm" modelAttribute="customer" action="${ctx}/crm/list" method="post" class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li>
            <form:input path="cusName" htmlEscape="false" maxlength="200" class="input-medium" placeholder="客户名称"/>
        </li>
        <li>
            &nbsp;&nbsp;
            <form:select path="cusStatus" class="input-medium" placeholder="客户状态">
                <form:option value="" label=""/>
                <%--<form:options items="${fns:getDictList('oa_notify_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>--%>
            </form:select>
        </li>
        <li>
            &nbsp;&nbsp;
            <form:select path="cusContent" class="input-medium" placeholder="客户类型">
                <form:option value="" label=""/>
                <%--<form:options items="${fns:getDictList('oa_notify_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>--%>
            </form:select>
        </li>
        <li>
            &nbsp;&nbsp;
            <form:select path="cusStar" class="input-medium" placeholder="客户星级">
                <form:option value="" label=""/>
                <%--<form:options items="${fns:getDictList('oa_notify_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>--%>
            </form:select>
        </li>
        <li>
            &nbsp;&nbsp;
            <input id="beginDate" name="beginDate" placeholder="最后跟进" type="text" readonly="readonly" maxlength="20" class="input-small Wdate"
                   value="" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
        </li>
        <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
        <li class="clearfix"></li>
    </ul>
</form:form>
<div class="control-group">
    <table id="contentTable" class="table table-striped table-bordered table-condensed">
        <thead>
        <tr>
            <th>序号</th>
            <th>客户名称</th>
            <th>客户状态</th>
            <th>客户星级</th>
            <th>首联系人</th>
            <th>手机号码</th>
            <th>最后跟进</th>
            <th>未跟进天数</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>1</td>
            <td>1</td>
            <td>1</td>
            <td>1</td>
            <td>1</td>
            <td>1</td>
            <td>1</td>
            <td>1</td>
            <td>
                <a href=""><i class="icon-comment">跟进</i></a>
                <a href=""><i class="icon-pencil">编辑</i></a>
                <a href=""><i class="icon-trash">删除</i></a>
            </td>
        </tr>
        </tbody>
    </table>
    <div class="pagination">${page}</div>
    <script>

    </script>
</div>
</body>
</html>