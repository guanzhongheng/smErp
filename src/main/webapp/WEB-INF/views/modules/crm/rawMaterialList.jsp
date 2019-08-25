<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>原材料管理</title>
	<link rel="stylesheet" href="/static/common/customize.css">
	<script type="text/javascript">
		function page(n,s){

			if(n) $("#pageNo").val(n);
			if(s) $("#pageSize").val(s);
			$("#searchForm").attr("action","${ctx}/tRawMaterial/list");
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
				<form:form id="searchForm" modelAttribute="rawMaterial" action="${ctx}/tRawMaterial/list" method="post" class="breadcrumb form-search ">
					<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
					<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
					<ul class="ul-form">
						<li>
							<form:input path="rawmCode" htmlEscape="false" maxlength="200" class="input-medium"
										placeholder="原料编号"/>
						</li>
						<li>
							&nbsp;&nbsp;
							<form:input path="rawmName" htmlEscape="false" maxlength="200" class="input-medium"
										placeholder="原料名称"/>
						</li>
						<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
						<li class="btns"><a href="${ctx}/tRawMaterial/addForm" type="button" class="btn btn-primary" style="width: 38px;height: 20px">新增</a></li>
						<li class="btns"><input class="btn btn-primary" type="button" onclick="rawFormRest()" value="重置"/></li>
					</ul>
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

			</div>
		</div>
	</div>
<script>
	function rawFormRest() {
        $("#rawmCode").val("");
        $("#rawmName").val("");
    }
</script>
</body>
</html>