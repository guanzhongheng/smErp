\<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>菜单管理</title>
	<link rel="stylesheet" href="/static/common/customize.css">
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<%--<ul class="nav nav-tabs">--%>
		<%--<li><a href="${ctx}/sys/menu/">菜单列表</a></li>--%>
		<%--<li class="active"><a href="${ctx}/sys/menu/form?id=${menu.id}&parent.id=${menu.parent.id}">菜单管理</a></li>--%>
	<%--</ul><br/>--%>







	<div class="tabs-container" style="padding: 20px 20px;">
		<div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
			<div class="panel-heading" style="background-color: #50B0E6">
				<h3 class="panel-title global-panel-title" >
					菜单管理
				</h3>
				<code class="pull-right" style="margin-top: -33px; margin-right: 8px"><span style="color: red; ">*</span>
					<small>为必填项</small>
				</code>
			</div>
			<div class="panel-body" style="padding: 10px 10px 0px 10px;">
				<form:form id="inputForm" modelAttribute="menu" action="${ctx}/sys/menu/save" method="post" class="form-horizontal">
					<form:hidden path="id"/>
					<sys:message content="${message}"/>
					<div class="control-group">
						<label class="control-label">上级菜单:</label>
						<div class="controls">
							<sys:treeselect id="menu" name="parent.id" value="${menu.parent.id}" labelName="parent.name" labelValue="${menu.parent.name}"
											title="菜单" url="/sys/menu/treeData" extId="${menu.id}" cssClass="required"/>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">名称:</label>
						<div class="controls">
							<form:input path="name" htmlEscape="false" maxlength="50" class="required input-xlarge"/>
							<span class="help-inline"><font color="red">*</font> </span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">链接:</label>
						<div class="controls">
							<form:input path="href" htmlEscape="false" maxlength="2000" class="input-xxlarge"/>
							<span class="help-inline">点击菜单跳转的页面</span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">目标:</label>
						<div class="controls">
							<form:input path="target" htmlEscape="false" maxlength="10" class="input-small"/>
							<span class="help-inline">链接地址打开的目标窗口，默认：mainFrame</span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">图标:</label>
						<div class="controls">
							<sys:iconselect id="icon" name="icon" value="${menu.icon}"/>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">排序:</label>
						<div class="controls">
							<form:input path="sort" htmlEscape="false" maxlength="50" class="required digits input-small"/>
							<span class="help-inline">排列顺序，升序。</span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">可见:</label>
						<div class="controls">
							<form:radiobuttons path="isShow" items="${fns:getDictList('show_hide')}" itemLabel="label" itemValue="value" htmlEscape="false" class="required"/>
							<span class="help-inline">该菜单或操作是否显示到系统菜单中</span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">权限标识:</label>
						<div class="controls">
							<form:input path="permission" htmlEscape="false" maxlength="100" class="input-xxlarge"/>
							<span class="help-inline">控制器中定义的权限标识，如：@RequiresPermissions("权限标识")</span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">备注:</label>
						<div class="controls">
							<form:textarea path="remarks" htmlEscape="false" rows="3" maxlength="200" class="input-xxlarge"/>
						</div>
					</div>
					<div class="">
						<input id="btnSubmit" class="btn btn-primary" type="submit" style="width: 180px; margin-left: 180px;height: 40px" value="保 存"/>&nbsp;
						<input id="btnCancel" class="btn" type="button" style="width: 180px;height: 40px" value="返 回" onclick="history.go(-1)"/>
					</div>
					<br/>
				</form:form>
			</div>
		</div>
	</div>






</body>
</html>