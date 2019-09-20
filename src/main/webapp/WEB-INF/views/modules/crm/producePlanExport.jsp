<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <style>
        .breadcrumb{
            background-color:#FFFFFF;
        }
    </style>
</head>
<body>
<form:form id="exportForm" modelAttribute="exportVo" action="${ctx}/export/prodPlan" method="get"
           class="breadcrumb form-search form-horizontal">
<div class="panel-body" style="padding: 10px 10px 0px 10px;">
    <ul class="ul-form" style="margin-bottom: 10px">
        <li>
            &nbsp;&nbsp;
            <form:select path="prodVariety" class="input-medium" placeholder="选择品种">
                <form:option value="" label=""/>
                <form:options items="${fns:getCusDictList(148000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
            </form:select>
        </li>
        <li>
            &nbsp;&nbsp;
            <form:select path="prodCgyCode" class="input-medium" placeholder="选择类别">
                <form:option value="" label=""/>
                <form:options items="${fns:getCusDictList(149000)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
            </form:select>
        </li>
    </ul>
    <ul class="ul-form" style="margin-bottom: 10px">
        <li>
            &nbsp;&nbsp;
            <form:select path="prodColor" class="input-medium" placeholder="选择颜色">
                <form:option value="" label=""/>
                <form:options items="${fns:getDictList('prod_color')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
            </form:select>
        </li>
        <li>
            <label class="col-md-2 control-label order-input-width " style="text-align: left">
                <select id="cusCode" name="cusCode" class="chosen-select global-input order-input-width" style="width: 150px;" >
                    <option class="order-input-width" value='' style="width: 150px;" > 选择客户</option>
                    <c:forEach  items="${customers}" var="s">
                        <option class="order-input-width" value='${s.cusCode}' style="width: 150px;" > ${s.cusName}</option>
                    </c:forEach>
                </select>
            </label>
        </li>
    </ul>

    <ul class="ul-form" style="margin-bottom: 10px">
    <li>
        &nbsp;&nbsp;
        <form:input path="startDate" htmlEscape="false" readonly="readonly" class="input-small Wdate" cssStyle="width: 150px"
                    placeholder="开始时间" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
        ～
        <form:input path="endDate" htmlEscape="false" readonly="readonly" class="input-small Wdate" cssStyle="width: 150px"
                    placeholder="结束时间" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
    </li>
    <li>

    </li>
</ul>
    <ul class="ul-form" style="margin-bottom: 10px">
        <input  type="number" placeholder="最小宽度" name="widthMin" id="widthMin" style="margin-left: 12px;width: 140px;display: inline"
               class="form-control produceDetail-input-readonly">
        -
        <input  type="number" placeholder="最大宽度" name="widthMax" id="widthMax" style="width: 140px;display:inline"
               class="form-control produceDetail-input-readonly" />
    </ul>
    <ul class="ul-form">
        <input class="btn btn-primary" type="submit" style="margin-left: 12px;width: 80px" value="导出"/>
        &nbsp;&nbsp;
        <input class="btn btn-primary" type="button" style="width: 80px" onclick="prodFormReset()" value="重置"/>
    </ul>
</div>

</form:form>
<script>
    function prodFormReset() {
        $("#prodVariety").val("").select2();
        $("#prodCgyCode").val("").select2();
        $("#prodColor").val("").select2();
        $("#cusCode").val("").select2();
        $("#widthMin").val("");
        $("#widthMax").val("");
        $("#startDate").val("");
        $("#endDate").val("");
    }
</script>
</body>
</html>