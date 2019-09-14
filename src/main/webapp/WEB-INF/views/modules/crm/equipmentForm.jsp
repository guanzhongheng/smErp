<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>MAC设备操作</title>

    <link rel="stylesheet" href="/static/common/customize.css">
    <script type="text/javascript">

    </script>
</head>
<body>


<div class="tabs-container" style="padding: 20px 20px;">
    <div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
        <div class="panel-heading" style="background-color: #50B0E6">
            <h3 class="panel-title global-panel-title" >
                <c:if test="${empty eqId}">MAC设备新增</c:if>
                <c:if test="${not empty eqId}">MAC设备编辑</c:if>
            </h3>
            <code class="pull-right" style="margin-top: -33px; margin-right: 8px"><span style="color: red; ">*</span>
                <small>为必填项</small>
            </code>
        </div>
        <div class="panel-body" style="padding: 10px 10px 0px 10px;">

            <form:form id="inputForm" modelAttribute="equipment" action="${ctx}/equipment/save" method="post" class="form-horizontal">
                <input name="eqId" id="eqId" type="hidden" value="${eqId}">
                <sys:message content="${message}"/>

                <div class="control-group">
                    <label class="control-label"><i style="color: red">*</i>&nbsp;名称:</label>
                    <div class="controls">
                        <form:input path="macName" htmlEscape="false" maxlength="50" class="required"/>
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label"><i style="color: red">*</i>&nbsp;设备IP地址:</label>
                    <div class="controls">
                        <form:input path="macAddress" htmlEscape="false" maxlength="50" class="required"/>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <i style="color: red">*</i>&nbsp;是否启用:&nbsp;&nbsp;&nbsp;&nbsp;
                        <form:select path="devSwitch" class="input-medium" cssStyle="width: 220px" placeholder="启用开关"  >
                            <form:option value="0" label="启用"/>
                            <form:option value="1" label="不启用"/>
                        </form:select>
                    </div>
                </div>
 
                <div class="">

                    <input id="btnSubmit" class="btn btn-primary"
                           style="width: 130px;font-size: 18px;height: 40px;margin-left: 59px;margin-bottom: 10px;"
                           type="submit" value="保  存"/>
                    <input id="btnCancel" class="btn " type="button"
                           style="width: 130px;font-size: 18px;height: 40px;margin-left: 43px;margin-bottom: 10px;"
                           value="返  回" onclick="history.go(-1)"/>
                </div>
            </form:form>

        </div>
    </div>
</div>
<script>
    $("#inputForm").validate({
        rules: {
            macAddress: {
                required: true
            },
            macName: {
                required: true
            },
        },
        messages: {
            macAddress: {
                required: "请输入MAC地址"
            },
            macName: {
                required: "请输入名称"
            }
        },
        ignore: ":hidden:not(select)",
        errorPlacement: function (error, element) {
            error.appendTo(element.parent());
        },
    });
</script>





</body>
</html>