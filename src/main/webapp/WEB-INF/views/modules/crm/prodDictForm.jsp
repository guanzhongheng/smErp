<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>产品操作</title>

    <link rel="stylesheet" href="/static/common/customize.css">
    <script type="text/javascript">

    </script>
</head>
<body>
<%--<ul class="nav nav-tabs">--%>
    <%--<li><a href="${ctx}/tProduct/list/">产品列表</a></li>--%>
    <%--<li class="active"><a href="${ctx}/tProduct/get?id=">产品操作</a></li>--%>
<%--</ul><br/>--%>



<div class="tabs-container" style="padding: 20px 20px;">
    <div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
        <div class="panel-heading" style="background-color: #50B0E6">
            <h3 class="panel-title global-panel-title" >
                产品操作
            </h3>
            <code class="pull-right" style="margin-top: -33px; margin-right: 8px"><span style="color: red; ">*</span>
                <small>为必填项</small>
            </code>
        </div>
        <div class="panel-body" style="padding: 10px 10px 0px 10px;">

            <form:form id="inputForm" modelAttribute="tProduct" action="${ctx}/tProduct/insert" method="post" class="form-horizontal">
                <input name="id" id="id" type="hidden" value="${prodId}">
                <sys:message content="${message}"/>

                <div class="control-group">
                    <label class="control-label"><i style="color: red">*</i>&nbsp;产品编码:</label>
                    <div class="controls">
                        <form:input path="prodCode" htmlEscape="false" maxlength="50" class="required" disabled="${prodId == null?'false':'true'}" onblur="checkInfo(this)"/>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <i style="color: red">*</i>&nbsp;产品名称:&nbsp;&nbsp;&nbsp;&nbsp;
                        <form:input path="prodName" htmlEscape="false" maxlength="50" class="required" disabled="${prodId == null?'false':'true'}"/>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label"><i style="color: red"></i>&nbsp;产品品种</label>
                    <div class="controls">
                        <form:select path="prodVariety" class="input-medium" cssStyle="width: 220px" placeholder="产品品种"  disabled="${prodId == null?'false':'true'}" >
                            <form:option value="" label=""/>
                            <form:options items="${fns:getCusDictList(148000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                        </form:select>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <i style="color: white">*</i>&nbsp;产品类别:&nbsp;&nbsp;&nbsp;&nbsp;
                        <form:select path="prodCgyCode" class="input-medium" cssStyle="width: 220px" placeholder="产品类别"  disabled="${prodId == null?'false':'true'}" >
                            <form:option value="" label=""/>
                            <form:options items="${fns:getCusDictList(149000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                        </form:select>
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label"><i style="color: red"></i>&nbsp;产品颜色:</label>
                    <div class="controls">
                        <form:select path="prodColor" class="input-medium" cssStyle="width: 220px" placeholder="颜色" disabled="${prodId == null?'false':'true'}">
                            <form:option value="" label=""/>
                            <form:options items="${fns:getDictList('prod_color')}" itemLabel="label" itemValue="value" htmlEscape="false" />
                        </form:select>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <i style="color: white">*</i>&nbsp;产品厚度:&nbsp;&nbsp;&nbsp;&nbsp;
                        <form:input path="prodThick" htmlEscape="false" maxlength="100" class="required"/>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label"><i style="color: red"></i>&nbsp;产品单位:</label>
                    <div class="controls">
                        <form:select path="prodUnit" class="input-medium" cssStyle="width: 220px" placeholder="产品单位">
                            <form:option value="" label=""/>
                            <form:options items="${fns:getCusDictList(142000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                        </form:select>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <i style="color: white">*</i>&nbsp;计价方式:&nbsp;&nbsp;&nbsp;&nbsp;
                        <form:select path="prodPriceType" class="input-medium" cssStyle="width: 220px" placeholder="计价方式"  disabled="${prodId == null?'false':'true'}">
                            <form:option value="" label=""/>
                            <form:options items="${fns:getCusDictList(141000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                        </form:select>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label"><i style="color: red"></i>&nbsp;参考单价:</label>
                    <div class="controls">
                        <form:input path="prodGuidePrice" htmlEscape="false" maxlength="100" class="required"/>

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
    function checkInfo(obj){
        debugger;
        if(obj.length > 0){
            $.post('${ctx}/crmAjax/checkProdCode', {
                code: obj.value
            }, function (data) {
                if (data == "1") {
                    top.$.jBox.tip('当前编码存在重复');
                    $("#prodCode").val("");
                }
            })
        }

    }
    $("select").change(function(){
        $("#inputForm").valid();
    })
    $("#inputForm").validate({
        rules: {
            prodCode: {
                required: true
            },
            prodName:{
                required: true
            },
            prodCgyCode: {
                required: true
            },
            prodVariety: {
                required: true
            },
            prodColor: {
                required: true
            },
            prodPriceType: {
                required: true
            },
            prodUnit: {
                required: true
            }
        },
        messages: {
            prodCode: {
                required: "请填写产品编号"
            },
            prodName: {
                required: "请填写产品名称"
            },
            prodCgyCode: {
                required: "请选择产品品种"
            },
            prodVariety: {
                required: "请选择产品类别"
            },
            prodColor: {
                required: "请选择产品颜色"
            },
            prodPriceType: {
                required: "请选择计价方式"
            },
            prodUnit: {
                required: "请选择单位"
            }
        },
        ignore:":hidden:not(select)",
        errorPlacement:function(error,element) {
            error.appendTo(element.parent());
        },
    });
</script>

</body>
</html>