<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>修改密码</title>
	<link rel="stylesheet" href="/static/common/customize.css">
	<script type="text/javascript">
		$(document).ready(function() {
			$("#oldPassword").focus();
			$("#inputForm").validate({
				rules: {
				},
				messages: {
					confirmNewPassword: {equalTo: "输入与上面相同的密码"}
				},
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
		<%--<li><a href="${ctx}/sys/user/info" class="global-font">个人信息</a></li>--%>
		<%--<li class="active"><a href="${ctx}/sys/user/modifyPwd" class="global-font">修改密码</a></li>--%>
	<%--</ul><br/>--%>
	<div class="tabs-container" style="padding: 20px 9px;">

	<form:form id="inputForm" modelAttribute="user" action="${ctx}/sys/user/modifyPwd" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>





		<div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
			<div class="panel-heading" style="background-color: #50B0E6">
				<h3 class="panel-title global-panel-title" >
					修改密码
				</h3>
			</div>
			<div class="panel-body">
				<div class="control-group"></div>
				<div class="control-group">
					<label class="control-label global-font"><i style="color: red">*</i>&nbsp;旧密码:</label>
					<div class="controls">
						<input id="oldPassword" name="oldPassword" type="password" value="" maxlength="50" minlength="3" class="required"/>
							<%--<span class="help-inline"><font color="red">*</font> </span>--%>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label global-font"><i style="color: red">*</i>&nbsp;新密码:</label>
					<div class="controls">
						<input id="newPassword" name="newPassword" type="password" value="" maxlength="50" minlength="3" class="required"/>
							<%--<span class="help-inline"><font color="red">*</font> </span>--%>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label global-font"><i style="color: red">*</i>&nbsp;确认新密码:</label>
					<div class="controls">
						<input id="confirmNewPassword" name="confirmNewPassword" type="password" value="" maxlength="50" minlength="3" class="required" equalTo="#newPassword"/>
							<%--<span class="help-inline"><font color="red">*</font> </span>--%>
					</div>
				</div>

				<div class="global-button-padding">
					<input id="btnSubmit" class="btn btn-primary global-button-style" style="width: 180px;" type="submit" value="确认修改"/>
				</div>
			</div>
		</div>






	</form:form>
	</div>


</body>
</html>