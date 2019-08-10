<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>用户管理</title>
	<link rel="stylesheet" href="/static/common/customize.css">
	<script type="text/javascript">
		$(document).ready(function() {
			$("#btnExport").click(function(){
				top.$.jBox.confirm("确认要导出用户数据吗？","系统提示",function(v,h,f){
					if(v=="ok"){
						$("#searchForm").attr("action","${ctx}/sys/user/export");
						$("#searchForm").submit();
					}
				},{buttonsFocus:1});
				top.$('.jbox-body .jbox-icon').css('top','55px');
			});
			$("#btnImport").click(function(){
				$.jBox($("#importBox").html(), {title:"导入数据", buttons:{"关闭":true},
					bottomText:"导入文件不能超过5M，仅允许导入“xls”或“xlsx”格式文件！"});
			});;
		})
		function page(n,s){
			if(n) $("#pageNo").val(n);
			if(s) $("#pageSize").val(s);
			$("#searchForm").attr("action","${ctx}/sys/user/list");
			$("#searchForm").submit();
	    	return false;
	    }
	</script>
</head>
<body>
	<div id="importBox" class="hide">
		<form id="importForm" action="${ctx}/sys/user/import" method="post" enctype="multipart/form-data"
			class="form-search" style="padding-left:20px;text-align:center;" onsubmit="loading('正在导入，请稍等...');"><br/>
			<input id="uploadFile" name="file" type="file" style="width:330px"/><br/><br/>　　
			<input id="btnImportSubmit" class="btn btn-primary" type="submit" value="   导    入   "/>
			<a href="${ctx}/sys/user/import/template">下载模板</a>
		</form>
	</div>
	<%--<ul class="nav nav-tabs">--%>
		<%--<li class="active"><a href="${ctx}/sys/user/list">用户列表</a></li>--%>
		<%--<li><a href="${ctx}/sys/user/form">用户新增</a></li>--%>
	<%--</ul>--%>


	<div class="tabs-container" style="padding: 20px 20px;">
		<div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
			<div class="panel-heading" style="background-color: #50B0E6">
				<h3 class="panel-title global-panel-title" >
					用户列表
				</h3>
			</div>
			<div class="panel-body" style="padding: 10px 10px 0px 10px;">
				<form:form id="searchForm" modelAttribute="user" action="${ctx}/sys/user/list" method="post" class="breadcrumb form-search ">
					<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
					<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
					<sys:tableSort id="orderBy" name="orderBy" value="${page.orderBy}" callback="page();"/>
					<ul class="ul-form">
						<li>&nbsp;&nbsp;<form:input path="loginName" htmlEscape="false" maxlength="50" class="input-medium" placeholder="登录名" /></li>
						<li>&nbsp;&nbsp;<form:input path="name" htmlEscape="false" maxlength="50" class="input-medium" placeholder="姓名"/></li>
                        <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" style="width: 80px" value="查询" onclick="return page();"/></li>
                        <li class="btns"><a href="${ctx}/sys/user/form" type="button" class="btn btn-primary" style="width: 54px;height: 20px">新建</a></li>
                        <li class="btns"><input class="btn btn-primary" type="button" style="width: 80px" onclick="userFormReset()" value="重置"/></li>
						<li class="clearfix"></li>
					</ul>
				</form:form>
				<sys:message content="${message}"/>
				<div class="control-group table-responsive">
					<table id="contentTable" class="table table-striped table-bordered table-hover text-nowrap">
						<thead>
						<tr>
							<%--<th class="sort-column login_name">登录名</th>--%>
							<%--<th class="sort-column name">姓名</th>--%>
							<th style="text-align: center">序号</th>
							<th  style="text-align: center">登录名</th>
							<th style="text-align: center">姓名</th>
							<th style="text-align: center">电话</th>
							<th style="text-align: center">手机</th>
							<th style="text-align: center">操作</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach items="${page.list}" var="user" varStatus="status">
							<tr>
								<td style="text-align: center">${status.index + 1}</td>
								<td><a href="${ctx}/sys/user/form?id=${user.id}">${user.loginName}</a></td>
								<td>${user.name}</td>
								<td>${user.phone}</td>
								<td>${user.mobile}</td>
								<td>
									<a href="${ctx}/sys/user/form?id=${user.id}"><i class="icon-pencil">&nbsp;修改</i></a>
									<a href="${ctx}/sys/user/delete?id=${user.id}" onclick="return confirmx('确认要删除该用户吗？', this.href)"><i class="icon-trash">&nbsp;删除</i></a>
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
	function userFormReset() {
        $("#loginName").val("");
        $("#name").val("");
    }
</script>
</body>
</html>