<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>设备管理</title>
	<link rel="stylesheet" href="/static/common/customize.css">
	<script type="text/javascript">
		function page(n,s){

			if(n) $("#pageNo").val(n);
			if(s) $("#pageSize").val(s);
			$("#searchForm").attr("action","${ctx}/tMachineInfo/list");
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
					设备列表
				</h3>
			</div>
			<div class="panel-body" style="padding: 10px 10px 0px 10px;">
				<form:form id="searchForm" modelAttribute="machine" action="${ctx}/tMachineInfo/list" method="post" class="breadcrumb form-search ">
					<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
					<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
					<sys:tableSort id="orderBy" name="orderBy" value="${page.orderBy}" callback="page();"/>
					<ul class="ul-form">
						<li><label>设备编号：</label><form:input path="macCode" htmlEscape="false" maxlength="50" class="input-medium"/></li>
						<li><label>最小宽度(m)：</label><form:input path="minWidth" htmlEscape="false" maxlength="50" class="input-medium"/></li>
						<li><label>最大宽度(m)：</label><form:input path="maxWidth" htmlEscape="false" maxlength="50" class="input-medium"/></li>
						<li class="btns">
							<input id="btnSubmit" class="btn btn-primary" type="submit" style="width: 80px" value="查询" onclick="return page();"/>
						<li class="btns">
							<a href="${ctx}/tMachineInfo/addForm" type="button" class="btn btn-primary" style="width: 54px;height: 20px">新增</a>
						</li>
						<li class="btns"><input class="btn btn-primary" type="button" style="width: 80px" onclick="macFormReset()" value="重置"/></li>
					</ul>
				</form:form>
				<sys:message content="${message}"/>
				<div class="control-group table-responsive">
					<table id="contentTable" class="table table-striped table-bordered table-hover text-nowrap">
						<thead>
						<tr>
							<th style="text-align: center">序号</th>
							<th style="text-align: center">设备编号</th>
							<th style="text-align: center">可生产产品</th>
							<th style="text-align: center">最小宽度(m)</th>
							<th style="text-align: center">最大宽度(m)</th>
							<th style="text-align: center">操作</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach items="${page.list}" var="machine" varStatus="status">
							<tr>
								<td style="text-align: center">${status.index + 1}</td>
								<td>${machine.macCode}</td>
								<td><c:if test="${machine.prodCodes == 0}">所有产品</c:if></td>
								<td>${machine.minWidth}</td>
								<td>${machine.maxWidth}</td><%--
				<td>${user.roleNames}</td> --%>
								<td>
									<a href="${ctx}/tMachineInfo/get?id=${machine.id}"><i class="icon-pencil">&nbsp;修改</i></a>
									<a href="${ctx}/tMachineInfo/delete?id=${machine.id}" onclick="return confirmx('确认要删除该设备吗？', this.href)"><i class="icon-trash">&nbsp;删除</i></a>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="pagination">${page}</div>

			</div>
		</div>
	</div>
<script>
	function macFormReset() {
        $("#searchForm")[0].reset();
    }
</script>
</body>
</html>