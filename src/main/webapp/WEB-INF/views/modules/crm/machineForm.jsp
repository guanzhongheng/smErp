<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>设备操作</title>

    <link rel="stylesheet" href="/static/common/customize.css">
    <script type="text/javascript">

    </script>
</head>
<body>


<div class="tabs-container" style="padding: 20px 20px;">
    <div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
        <div class="panel-heading" style="background-color: #50B0E6">
            <h3 class="panel-title global-panel-title" >
                设备操作
            </h3>
            <code class="pull-right" style="margin-top: -33px; margin-right: 8px"><span style="color: red; ">*</span>
                <small>为必填项</small>
            </code>
        </div>
        <div class="panel-body" style="padding: 10px 10px 0px 10px;">

            <form:form id="inputForm" modelAttribute="machine" action="${ctx}/tMachineInfo/insert" method="post" class="form-horizontal">
                <input name="id" id="id" type="hidden" value="${machineId}">
                <sys:message content="${message}"/>

                <div class="control-group">
                    <label class="control-label"><i style="color: red">*</i>&nbsp;设备编号:</label>
                    <div class="controls">
                        <form:input path="macCode" htmlEscape="false" maxlength="50" class="required"/>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <i style="color: red">*</i>&nbsp;支持产品:&nbsp;&nbsp;&nbsp;&nbsp;
                        <form:select path="prodCodes" class="input-medium" cssStyle="width: 220px" placeholder="生产产品">
                            <form:option value="0" label="所有产品"/>
                            <%--<form:options items="${fns:getCusDictList(148000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>--%>
                        </form:select>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label"><i style="color: red">*</i>&nbsp;最小宽度(m):</label>
                    <div class="controls">
                        <form:input path="minWidth" htmlEscape="false" maxlength="50" class="required"/>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <i style="color: red">*</i>&nbsp;最大宽度(m):&nbsp;&nbsp;&nbsp;&nbsp;
                        <form:input path="maxWidth" htmlEscape="false" maxlength="50" class="required"/>
                    </div>
                </div>

                <div class="">

                    <input id="btnSubmit" class="btn btn-primary"
                           style="width: 130px;font-size: 18px;height: 40px;margin-left: 59px;margin-bottom: 10px;"
                           type="submit" value="保  存"/>
                    <input id="btnCancel" class="btn" type="button"
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
            minWidth: {
                required: true
            },
            maxWidth: {
                required: true
            },
            macCode: {
                required: true
            },
            prodCodes: {
                required: true
            }
        },
        messages: {
            minWidth: {
                required: "请输入最小宽度"
            },
            maxWidth: {
                required: "请输入最大宽度"
            },
            macCode: {
                required: "请输入设备编号"
            },
            prodCodes: {
                required: "请选择支持产品"
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