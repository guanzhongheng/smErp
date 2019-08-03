<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>原材料管理</title>
	<link rel="stylesheet" href="/static/common/customize.css">
	<script type="text/javascript">
		function page(n,s){
		    debugger;
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
					原材料列表
				</h3>
			</div>
			<div class="panel-body" style="padding: 10px 10px 0px 10px;">
				<form:form id="searchForm" modelAttribute="rawMaterial" action="${ctx}/tRawMaterial/list" method="post" class=" form-search ">
					<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
					<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
					<sys:tableSort id="orderBy" name="orderBy" value="${page.orderBy}" callback="page();"/>
					<%--<ul class="ul-form">--%>
						<%--<li><label>设备编号：</label><form:input path="macCode" htmlEscape="false" maxlength="50" class="input-medium"/></li>--%>
						<%--<li><label>最小宽度：</label><form:input path="minWidth" htmlEscape="false" maxlength="50" class="input-medium"/></li>--%>
						<%--<li><label>最大宽度：</label><form:input path="maxWidth" htmlEscape="false" maxlength="50" class="input-medium"/></li>--%>
						<%--<li class="btns">--%>
							<%--<input id="btnSubmit" class="btn btn-primary" type="submit" style="width: 100px" value="查询" onclick="return page();"/>--%>
						<%--<li class="clearfix"></li>--%>
					<%--</ul>--%>
				</form:form>
				<sys:message content="${message}"/>
				<div class="control-group table-responsive">
					<table id="contentTable" class="table table-striped table-bordered table-hover text-nowrap">
						<thead>
						<tr>
							<th style="text-align: center">序号</th>
							<th style="text-align: center">原料编号</th>
							<th style="text-align: center">原料名称</th>
							<th style="text-align: center">原料规格</th>
							<th style="text-align: center">原料供应商</th>
							<th style="text-align: center">原料分类</th>
							<th style="text-align: center">操作</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach items="${page.list}" var="rawMaterial" varStatus="status">
							<tr>
								<td style="text-align: center">${status.index + 1}</td>
								<td>${rawMaterial.rawmCode}</td>
								<td>${rawMaterial.rawmName}</td>
								<td>${rawMaterial.rawnSpecs}</td>
								<td>${rawMaterial.rawnSupplier}</td>
								<td>${rawMaterial.rawnCtyCode}</td>
								<td>
									<a href="${ctx}/tRawMaterial/get?id=${rawMaterial.id}"><i class="icon-pencil">&nbsp;修改</i></a>
									<a href="${ctx}/tRawMaterial/delete?id=${rawMaterial.id}" onclick="return confirmx('确认要删除该原料吗？', this.href)"><i class="icon-trash">&nbsp;删除</i></a>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="pagination">${page}</div>

				<div class="control-group">&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="${ctx}/tRawMaterial/addForm" type="button" class="btn btn-primary" style="width: 140px;height: 23px"><i
							class="icon-plus"></i>&nbsp;添加原材料</a>
				</div>
			</div>
		</div>
	</div>

</body>
</html>