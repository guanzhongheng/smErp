<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>原材料操作</title>

    <link rel="stylesheet" href="/static/common/customize.css">
    <script type="text/javascript">

    </script>
</head>
<body>


<div class="tabs-container" style="padding: 20px 20px;">
    <div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
        <div class="panel-heading" style="background-color: #50B0E6">
            <h3 class="panel-title global-panel-title" >
                <c:if test="${empty rawMaterialId}">原料新增</c:if>
                <c:if test="${not empty rawMaterialId}">原料编辑</c:if>
            </h3>
            <code class="pull-right" style="margin-top: -33px; margin-right: 8px"><span style="color: red; ">*</span>
                <small>为必填项</small>
            </code>
        </div>
        <div class="panel-body" style="padding: 10px 10px 10px 10px;">

            <form:form id="inputForm" modelAttribute="rawMaterial" action="${ctx}/tRawMaterial/insert" method="post" class="form-horizontal">
                <input name="id" id="id" type="hidden" value="${rawMaterialId}">
                <sys:message content="${message}"/>
                <div class="control-group">
                    <label class="control-label"><i style="color: red">*</i>&nbsp;原料编号:</label>
                    <div class="controls">
                        <form:input path="rawmCode" htmlEscape="false" maxlength="50" class="required" disabled="${rawMaterialId == null?'false':'true'}" />
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <i style="color: red">*</i>&nbsp;原料名称:&nbsp;&nbsp;&nbsp;&nbsp;
                        <form:input path="rawmName" htmlEscape="false" maxlength="50" class="required" disabled="${rawMaterialId == null?'false':'true'}"/>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label"><i style="color: red">*</i>&nbsp;原料规格:</label>
                    <div class="controls">
                        <form:input path="rawnSpecs" htmlEscape="false" maxlength="50" class="required"/>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;原料供应商:&nbsp;&nbsp;&nbsp;&nbsp;
                        <form:input path="rawnSupplier" htmlEscape="false" maxlength="50" />
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label">&nbsp;原料分类:</label>
                    <div class="controls">
                        <form:input path="rawnCtyCode" htmlEscape="false" maxlength="50"/>
                    </div>
                </div>
                <div class="">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <button class="btn btn-primary global-button-style" type="submit">保 存</button>&nbsp;&nbsp;&nbsp;

                        <button class="btn btn-white global-button-style" type="button"
                                onclick="history.go(-1)">返 回
                        </button>
                </div>
            </form:form>

        </div>
    </div>
</div>

<script>
    $(document).ready(function () {

        $("#inputForm").validate({
            rules: {
                rawmCode: {
                    required: true
                },
                rawmName: {
                    required: true
                },
                rawnSpecs: {
                    required: true
                }
            },
            messages: {
                rawmCode: {
                    required: "请输入原料编号"
                },
                rawmName: {
                    required: "请输入名称"
                },
                rawnSpecs: {
                    required: "请输入规格"
                }
            },
            ignore: ":hidden:not(select)",
            errorPlacement: function (error, element) {
                error.appendTo(element.parent());
            },
        });
    });
</script>





</body>
</html>