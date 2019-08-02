<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>

<link href="${ctxStatic}/hPlugs/css/plugins/bootstrap-table/bootstrap-table.css" rel="stylesheet">
<link href="${ctxStatic}/hPlugs/css/plugins/bootstrap-table/bootstrap-table-fixed-columns.css" rel="stylesheet">
<link rel="stylesheet" href="/static/common/customize.css">





<div class="tabs-container" style="padding: 20px 20px;">
    <div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
        <div class="panel-heading" style="background-color: #50B0E6">
            <h3 class="panel-title global-panel-title" >
                第一步：选择产品
            </h3>
        </div>
        <div class="panel-body" style="padding: 10px 10px 0px 10px;">

            <div class="row">
                <div class="col-sm-12">
                    <input type="hidden" id="ordCode" value="${ordCode}"/>
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">

                        <label class="col-md-2 control-label order-detail-label-margin" style="text-align: right"><i style="color: red"></i>
                            产品选择:
                        </label>
                        <label class="col-md-2 control-label">
                            <select data-placeholder="产品选择" class="chosen-select order-label-input-width global-input" id="prodInfo" onchange="getResChange(this)">
                                <option value="-1">请选择</option>
                                <c:forEach items="${prod}" var="p">
                                    <option
                                            data-prodName='${p.prodName}'
                                            data-prodcgycode='${p.prodCgyCode}' data-prodCgyCodeValue='${p.prodCgyCodeValue}'
                                            data-prodvariety='${p.prodVariety}' data-prodVarietyValue='${p.prodVarietyValue}'
                                            data-prodthick='${p.prodThick}'
                                            data-prodpricetype='${p.prodPriceType}'  data-prodPriceTypeValue='${p.prodPriceTypeValue}'
                                            data-prodguideprice='${p.prodGuidePrice}'
                                            data-produnit='${p.prodUnit}' data-prodUnitValue='${p.prodUnitValue}'
                                            data-color="${p.prodColor}" data-colorValue="${p.prodColorValue}"
                                            value='${p.prodCode}' > ${p.prodCode}</option>
                                </c:forEach>
                            </select>
                        </label>

                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12">
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">

                        <label class="col-md-2 control-label order-detail-label-margin" style="text-align: right"><i style="color: red"></i>
                            产品编码:
                        </label>
                        <label class="col-md-2 control-label order-label-input-width">
                            <input class="col-md-2 order-detail-input-readonly" id="itemCode" disabled>
                        </label>

                        <label class="col-md-2 control-label  order-detail-label-margin order-input-width" style="text-align: right">
                            产品名称:
                        </label>
                        <label class="col-md-2 control-label order-input-width " style="text-align: left">
                            <input class="col-md-2 order-detail-input-readonly" id="itemName" disabled>
                        </label>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12">
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">

                        <label class="col-md-2 control-label order-detail-label-margin" style="text-align: right"><i style="color: red"></i>
                            产品品种:
                        </label>
                        <label class="col-md-2 control-label order-label-input-width">
                            <input class="col-md-2 order-detail-input-readonly" id="itemCgyCode" disabled>
                        </label>

                        <label class="col-md-2 control-label  order-detail-label-margin order-input-width" style="text-align: right">
                            产品类别:
                        </label>
                        <label class="col-md-2 control-label order-input-width " style="text-align: left">
                            <input class="col-md-2 order-detail-input-readonly" id="itemVariety" disabled>
                        </label>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12">
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">

                        <label class="col-md-2 control-label order-detail-label-margin" style="text-align: right"><i style="color: red"></i>
                            产品厚度:
                        </label>
                        <label class="col-md-2 control-label order-label-input-width">
                            <input class="col-md-2 order-detail-input-readonly" id="itemThick" disabled>
                        </label>

                        <label class="col-md-2 control-label  order-detail-label-margin order-input-width" style="text-align: right">
                            计价方式:
                        </label>
                        <label class="col-md-2 control-label order-input-width " style="text-align: left">
                            <input class="col-md-2 order-detail-input-readonly" id="itemPriceType" disabled>
                        </label>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12">
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">

                        <label class="col-md-2 control-label order-detail-label-margin" style="text-align: right"><i style="color: red"></i>
                            指导价格:
                        </label>
                        <label class="col-md-2 control-label order-label-input-width">
                            <input class="col-md-2 order-detail-input-readonly" id="itemPrice" disabled>
                        </label>

                        <label class="col-md-2 control-label  order-detail-label-margin order-input-width" style="text-align: right">
                            单位:
                        </label>
                        <label class="col-md-2 control-label order-input-width " style="text-align: left">
                            <input class="col-md-2 order-detail-input-readonly" id="itemUnit" disabled>
                        </label>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12">
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">

                        <label class="col-md-2 control-label order-detail-label-margin" style="text-align: right"><i style="color: red"></i>
                            颜色:
                        </label>
                        <label class="col-md-2 control-label order-label-input-width">
                            <input class="col-md-2 order-detail-input-readonly" id="itemColor" disabled>
                        </label>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12">
                    <div class="hr-line-dashed"></div>
                    <div class="form-group" style="text-align: center">
                        <div class="row">
                            <div class="col-md-6 " >
                                <button class="btn btn-primary global-button-style" type="button"
                                        onclick="doProcess()">下一步
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<div class="tabs-container" style="padding: 20px 20px;">
    <div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
        <div class="panel-heading" style="background-color: #50B0E6">
            <h3 class="panel-title global-panel-title" >
                第二步：确认产品定制化属性
            </h3>
        </div>
        <div class="panel-body" style="padding: 10px 10px 0px 10px;">

            <div class="row">
                <div class="col-sm-12">
                    <%--<div class="hr-line-dashed"></div>--%>
                    <div class="form-group" style="text-align: center">
                        <div class="row">
                            <div class="col-md-6 " >
                                <button class="btn btn-primary global-button-style" type="button"
                                        onclick="saveProd()">确认添加
                                </button>
                            </div>
                            <div class="col-md-1 " >
                                <button class="btn btn-white global-button-style" type="button" style="margin-left: -220px"
                                        onclick="history.go(-1)">取消添加
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="control-group table-responsive" >
                <table id="cusProdDetail" data-height="300"  class="table table-striped table-bordered table-hover text-nowrap">
                    <thead>
                    <tr>
                        <th style="text-align: center" data-field="itemCode">编码</th>
                        <th style="text-align: center" data-field="itemName">名称</th>
                        <th style="text-align: center" data-field="itemCgyCodeValue">品种</th>
                        <th style="text-align: center" data-field="itemVaritemValue">类别</th>
                        <th style="text-align: center" data-field="itemLenth">长</th>
                        <th style="text-align: center" data-field="itemWidth">宽</th>
                        <th style="text-align: center" data-field="itemThick">厚度</th>
                        <th style="text-align: center" data-field="itemColorValue">颜色</th>
                        <th style="text-align: center" data-field="itemUnitValue">单位</th>
                        <th style="text-align: center" data-field="itemOwner">归属人</th>
                        <th style="text-align: center" data-field="itemPrice">单价</th>
                        <th style="text-align: center" data-field="itemNum">数量</th>
                        <th style="text-align: center" data-field="itemPriceTypeValue">计价方式</th>
                        <th style="text-align: center" data-field="itemWeight">重量</th>
                        <th style="text-align: center" data-field="itemTotalWeight">总重量</th>
                        <th style="text-align: center" data-field="itemTotalSq">总面积</th>
                        <th style="text-align: center" data-field="itemYcType">延长方式</th>
                        <th style="text-align: center" data-field="itemYbType">压边类型</th>
                        <th style="text-align: center" data-field="operator">操作</th>
                    </tr>
                    </thead>
                </table>
            </div>



        </div>
    </div>
</div>







<%--<div class="wrapper wrapper-content animated fadeInRight">--%>
    <%--<div class="row">--%>
      <%--<input type="hidden" id="ordCode" value="${ordCode}"/>--%>
        <%--<div class="ibox float-e-margins">--%>
            <%--<div class="ibox-title">--%>
                <%--<label class="col-sm-3 control-label">&nbsp;产品选择:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
                    <%--<select data-placeholder="产品选择" class="chosen-select" style="width:120px;" id="prodInfo" onchange="getResChange(this)">--%>
                        <%--<option value="-1">请选择</option>--%>
                        <%--<c:forEach items="${prod}" var="p">--%>
                            <%--<option data-prodcode='${p.prodCode}'--%>
                                    <%--data-prodcgycode='${p.prodCgyCode}' data-prodCgyCodeValue='${p.prodCgyCodeValue}'--%>
                                    <%--data-prodvariety='${p.prodVariety}' data-prodVarietyValue='${p.prodVarietyValue}'--%>
                                    <%--data-prodthick='${p.prodThick}'--%>
                                    <%--data-prodpricetype='${p.prodPriceType}'  data-prodPriceTypeValue='${p.prodPriceTypeValue}'--%>
                                    <%--data-prodguideprice='${p.prodGuidePrice}'--%>
                                    <%--data-produnit='${p.prodUnit}' data-prodUnitValue='${p.prodUnitValue}'--%>
                                    <%--data-color="${p.prodColor}" data-colorValue="${p.prodColorValue}"--%>
                                    <%--value='${p.prodName}' > ${p.prodName}</option>--%>
                        <%--</c:forEach>--%>
                    <%--</select>--%>
                <%--</label>--%>
            <%--</div>--%>
            <%--<div class="ibox-content">--%>
                <%--<form method="get" class="form-horizontal">--%>
                    <%--<div class="form-group">--%>
                        <%--<div class="col-md-4">--%>
                            <%--<label class="col-md-3">产品编码:</label>--%>
                            <%--<label class="col-md-3" id="itemCode"></label>--%>
                        <%--</div>--%>
                        <%--<div class="col-md-4">--%>
                            <%--<label class="col-md-3">产品名称:</label>--%>
                            <%--<label class="col-md-3" id="itemName"></label>--%>
                        <%--</div>--%>
                        <%--<div class="col-md-4">--%>
                            <%--<label class="col-md-3">产品品种:</label>--%>
                            <%--<label class="col-md-3" id="itemCgyCode"></label>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<div class="col-md-4">--%>
                            <%--<label class="col-md-3">产品类别:</label>--%>
                            <%--<label class="col-md-3" id="itemVariety"></label>--%>
                        <%--</div>--%>
                        <%--<div class="col-md-4">--%>
                            <%--<label class="col-md-3">产品厚度:</label>--%>
                            <%--<label class="col-md-3" id="itemThick"></label>--%>
                        <%--</div>--%>
                        <%--<div class="col-md-4">--%>
                            <%--<label class="col-md-3">计价方式:</label>--%>
                            <%--<label class="col-md-3" id="itemPriceType"></label>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<div class="col-md-4">--%>
                            <%--<label class="col-md-3">指导价格:</label>--%>
                            <%--<label class="col-md-3" id="itemPrice"></label>--%>
                        <%--</div>--%>
                        <%--<div class="col-md-4">--%>
                            <%--<label class="col-md-3">单位:</label>--%>
                            <%--<label class="col-md-3" id="itemUnit"></label>--%>
                        <%--</div>--%>
                        <%--<div class="col-md-4" >--%>
                            <%--<label class="col-md-3">颜色:</label>--%>
                            <%--<label class="col-md-3" id="itemColor"></label>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--&lt;%&ndash;<div class="form-group">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<div class="col-md-4">&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<label class="col-md-3">宽度&nbsp;(m):</label>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<label class="col-md-3">&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<input type="text" class="form-control" style="width: 120px" id="itemWidth" name="itemWidth" />&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</label>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                <%--</form>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="row">--%>
        <%--<div class="form-group">--%>
            <%--&nbsp;&nbsp;--%>
            <%--<button class="btn btn-primary" type="button" onclick="doProcess()">确认产品</button>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</br>--%>
    <%--<div class="row">--%>
        <%--<div class="ibox float-e-margins">--%>
            <%--<div class="ibox-title">--%>
                <%--<h5>订单产品列表</h5>--%>
            <%--</div>--%>
            <%--<div class="ibox-content">--%>
                <%--<div class="" style="max-height: 350px">--%>
                    <%--<table id="cusProdDetail" data-height="300" style="min-width: 1500px">--%>
                        <%--<thead>--%>
                        <%--<tr>--%>
                            <%--<th data-field="itemCode">编码</th>--%>
                            <%--<th data-field="itemName">名称</th>--%>
                            <%--<th data-field="itemCgyCodeValue">品种</th>--%>
                            <%--<th data-field="itemVaritemValue">类别</th>--%>
                            <%--<th data-field="itemLenth">长</th>--%>
                            <%--<th data-field="itemWidth">宽</th>--%>
                            <%--<th data-field="itemThick">厚度</th>--%>
                            <%--<th data-field="itemColorValue">颜色</th>--%>
                            <%--<th data-field="itemUnitValue">单位</th>--%>
                            <%--<th data-field="itemOwner">归属人</th>--%>
                            <%--<th data-field="itemPrice">单价</th>--%>
                            <%--<th data-field="itemNum">数量</th>--%>
                            <%--<th data-field="itemPriceTypeValue">计价方式</th>--%>
                            <%--<th data-field="itemWeight">重量</th>--%>
                            <%--<th data-field="itemTotalWeight">总重量</th>--%>
                            <%--<th data-field="itemTotalSq">总面积</th>--%>
                            <%--<th data-field="itemYcType">延长方式</th>--%>
                            <%--<th data-field="itemYbType">压边类型</th>--%>
                            <%--<th data-field="operator">操作</th>--%>
                        <%--</tr>--%>
                        <%--</thead>--%>
                    <%--</table>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--</br>--%>
    <%--<div class="row">--%>
        <%--<div class="form-group">--%>
                <%--&nbsp;&nbsp;--%>
                <%--<button class="btn btn-primary" type="submit" onclick="saveProd()">保存详情</button>--%>
                <%--&nbsp;&nbsp;--%>
                <%--<button class="btn btn-white" type="button" onclick="history.go(-1)">返回</button>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
<script src="${ctxStatic}/hPlugs/js/jquery.min.js?v=2.1.4" type="text/javascript"></script>
<script src="${ctxStatic}/hPlugs/js/bootstrap.min.js?v=3.3.6" type="text/javascript"></script>
<script src="${ctxStatic}/hPlugs/js/content.min.js?v=1.0.0" type="text/javascript"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/chosen/chosen.jquery.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/jsKnob/jquery.knob.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/jasny/jasny-bootstrap.min.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/datapicker/bootstrap-datepicker.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/prettyfile/bootstrap-prettyfile.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/switchery/switchery.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/ionRangeSlider/ion.rangeSlider.min.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/iCheck/icheck.min.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/clockpicker/clockpicker.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/cropper/cropper.min.js"></script>
<script src="${ctxStatic}/hPlugs/js/demo/form-advanced-demo.min.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/layer/layer.min.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/bootstrap-table/bootstrap-table.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/bootstrap-table/bootstrap-table-fixed-columns.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script>

    var prodList = [];
    var cusProdList = [];
    var indexCkId = 1;
    var maxDataIndex = 1;
    var prodCgyCodes = new Array();

    var prodObj = {
        "ckId":"",
        "itemCode":"",
        "itemName":"",
        "itemLenth":0.00,
        "itemVariety":"",
        "itemVaritemValue":"",
        "itemCgyCode":"",
        "itemCgyCodeValue":"",
        "itemWidth":0.00,
        "itemThick":"",
        "itemColor":"",
        "itemColorValue":"",
        "itemUnit":"",
        "itemUnitValue":"",
        "itemOwner":"",
        "itemPrice":0.00,
        "itemNum":0,
        "itemPriceType":"",
        "itemPriceTypeValue":"",
        "itemWeight":0.000,
        "itemTotalWeight":0.000,
        "itemTotalSq":0.000,
        "itemYcType":"",
        "itemYbType":""
    }
    function getResChange(obj) {
        if($(obj).find("option:selected").val() != -1){
            debugger;
            prodObj.itemName = $(obj).find("option:selected").attr("data-prodName");
            prodObj.itemCode = $(obj).find("option:selected").val();
            prodObj.itemCgyCode = $(obj).find("option:selected").attr("data-prodcgyCode");
            prodObj.itemCgyCodeValue = $(obj).find("option:selected").attr("data-prodCgyCodeValue");
            prodObj.itemVariety = $(obj).find("option:selected").attr("data-prodvariety");
            prodObj.itemVaritemValue = $(obj).find("option:selected").attr("data-prodVarietyValue");
            prodObj.itemThick = $(obj).find("option:selected").attr("data-prodthick");
            prodObj.itemPriceType = $(obj).find("option:selected").attr("data-prodpriceType");
            prodObj.itemPriceTypeValue = $(obj).find("option:selected").attr("data-prodPriceTypeValue");
            prodObj.itemPrice = $(obj).find("option:selected").attr("data-prodguidePrice");
            prodObj.itemUnit = $(obj).find("option:selected").attr("data-produnit");
            prodObj.itemUnitValue = $(obj).find("option:selected").attr("data-prodUnitValue");
            prodObj.itemColor = $(obj).find("option:selected").attr("data-color");
            prodObj.itemColorValue = $(obj).find("option:selected").attr("data-colorValue");

            $("#itemName").val($(obj).find("option:selected").attr("data-prodName"));
            $("#itemCode").val($(obj).find("option:selected").val());
            $("#itemCgyCode").val($(obj).find("option:selected").attr("data-prodCgyCodeValue"));
            $("#itemVariety").val($(obj).find("option:selected").attr("data-prodVarietyValue"));
            $("#itemThick").val($(obj).find("option:selected").attr("data-prodthick"));
            $("#itemPriceType").val($(obj).find("option:selected").attr("data-prodPriceTypeValue"));
            $("#itemPrice").val($(obj).find("option:selected").attr("data-prodguidePrice"));
            $("#itemUnit").val($(obj).find("option:selected").attr("data-prodUnitValue"));
            $("#itemColor").val($(obj).find("option:selected").attr("data-colorValue"));

        }else{
            $("#itemCode").val("");
            $("#itemName").val("");
            $("#itemCgyCode").val("");
            $("#itemVariety").val("");
            $("#itemThick").val("");
            $("#itemPriceType").val("");
            $("#itemPrice").val("");
            $("#itemUnit").val("");
            $("#itemColor").val("");
        }
    }

    function doProcess() {
        debugger;
        cusProdList.push(tranObject(prodObj));
        $("#cusProdDetail").bootstrapTable("load",cusProdList);
        $('#cusProdDetail .chosen-select').trigger("chosen:updated");
        $('#cusProdDetail .chosen-select').chosen();
    }

    var ycType;
    var ybType

    $.ajax({
        type: "POST",
        url: '/crmAjax/ajaxDictInfo',
        dataType:'json',
        cache: false,
        success: function(data){
            debugger;
            if(data != null){
                ycType = data.ycType;
                ybType = data.ybType;
            }
        }
    });

    $(document).ready(function(){
       // getItemType();
        $("#cusProdDetail").bootstrapTable({
            url:'/order/item/findItemsById',
            pagination: false,  //表格底部显示分页条
            sidePagination: "server",
            escape:false, //启动转义字符
            queryParamsType:'',//设置请求参数格式
            queryParams: function queryParams(params) {
                debugger;
                var ordCode = $("#ordCode").val()
                if(ordCode != null && ordCode != '' && ordCode != 'undefined'){
                    var params = {
                        ordCode : ordCode
                    }
                }
                return params;
            },
            columns :[
                {
                    field: 'ckId',
                    title: '序号',
                    width: '0px',
                    formatter:function (value,row,index){
                        debugger;
                        if(index == 0){
                            maxDataIndex = 1;
                        }else{
                            maxDataIndex = maxDataIndex + 1;
                        }
                        row.ckId = maxDataIndex;
                        return maxDataIndex;
                    }
                },{
                    field: 'itemCode',
                    title: '编号'
                },{
                    field: 'ordCode',
                    title: '合同编码'
                },{
                    field: 'itemName',
                    title: '名称',
                    width: '150px'
                },{
                    field: 'itemCgyCodeValue',
                    title: '品种',
                    width: '80px'
                },{
                    field: 'itemVaritemValue',
                    title: '类别',
                    width: '100px'
                },{
                    field: 'itemLenth',
                    title: '长',
                    width: '80px',
                    formatter:function (value,row,index) {
                        return ['<input type="number" min="0" style="width: 80px" step="0.01" onchange="inserData(\'itemLenth\','+row.ckId+',this,'+index+')" class="form-control" value="'+value+'"/>'].join('');
                    }
                },{
                    field: 'itemWidth',
                    title: '宽',
                    width: '60px',
                    formatter:function (value,row,index) {
                        return ['<input type="number" min="0" style="width: 80px" step="0.01" onchange="inserData(\'itemWidth\','+row.ckId+',this,'+index+')" class="form-control" value="'+value+'"/>'].join('');
                    }
                },{
                    field: 'itemThick',
                    title: '厚',
                    width: '60px',
                    formatter:function (value,row,index){
                        return ['<input type="text"  style="width: 80px" onchange="inserData(\'itemThick\','+row.ckId+',this,'+index+')" class="form-control" value="'+value+'"/>'].join('');
                    }
                },{
                    field: 'itemColorValue',
                    title: '颜色',
                    width: '80px'
                },{
                    field: 'itemUnitValue',
                    title: '单位',
                    width: '50px'
                },{
                    field: 'itemOwner',
                    title: '归属人',
                    width: '80px',
                    formatter:function (value,row,index) {
                        return ['<input type="text"  style="width: 80px" onchange="inserData(\'itemOwner\','+row.ckId+',this,'+index+')" class="form-control" value="'+value+'"/>'].join('');
                    }
                },{
                    field: 'itemPrice',
                    title: '单价',
                    width: '80px',
                    formatter:function (value,row,index) {
                        return ['<input type="number" min="0" style="width: 80px" step="0.01" onchange="inserData(\'itemPrice\','+row.ckId+',this,'+index+')" class="form-control" value="'+value+'"/>'].join('');
                    }
                },{
                    field: 'itemNum',
                    title: '数量',
                    width: '80px',
                    formatter:function (value,row,index) {
                        return ['<input type="number" min="0" style="width: 80px" onchange="inserData(\'itemNum\','+row.ckId+',this,'+index+')" class="form-control" value="'+value+'"/>'].join('');
                    }
                },{
                    field: 'itemPriceType',
                    title: '计价方式',
                    width: '100px',
                    formatter:operPriceType
                },
                {
                    field: 'itemWeight',
                    title: '重量',
                    width: '55px',
                    formatter:function (value,row,index) {
                        return ['<input type="number" min="0" step="0.001" style="width: 55px" onchange="inserData(\'itemWeight\','+row.ckId+',this,'+index+')" class="form-control" value="'+value+'"/>'].join('');
                    }
                },{
                    field: 'itemYcType',
                    title: '延长米方式',
                    width: '150px',
                    formatter:operYcType
                },{
                    field: 'itemYbType',
                    title: '压边类型',
                    width: '150px',
                    formatter:operYbType
                },{
                    field: 'itemTotalWeight',
                    title: '总重量',
                    width: '100px'
                },{
                    field: 'itemTotalSq',
                    title: '总面积',
                    width: '100px'
                },
                {
                    field: 'oper',
                    title: '操作',
                    events: operateEvents,
                    formatter: operProdFormatter
                }
            ],
            onLoadSuccess:function (data) {
                debugger;
                cusProdList = $('#cusProdDetail').bootstrapTable("getData");
                $('#cusProdDetail .chosen-select').trigger("chosen:updated");
                $('#cusProdDetail .chosen-select').chosen();
            }
        })
        // $(".fixed-table-border")[1].style.height = '230px';
         $(".fixed-table-border").hide();
        $('#cusProdDetail').bootstrapTable('hideColumn', 'itemCode');
        $('#cusProdDetail').bootstrapTable('hideColumn', 'ordCode');
    });

    function operPriceType(value,row,index) {
        var option;
        var headOption = "<option value =''>请选择</option>";
        if(value == 141001){
            headOption = headOption + "<option value='141001' selected>重量</option>";
        }else{
            headOption = headOption + "<option value='141001'>重量</option>";
        }
        if(value == 141002){
            headOption = headOption + "<option value='141002' selected>面积</option>";
        }else{
            headOption = headOption + "<option value='141002'>面积</option>";
        }
        option  = '<select class="chosen-select" id="itemPriceType"'+row.ckId+' onchange="inserData(\'itemPriceType\','+row.ckId+',this)" style="width: 80px;height:33px;">'+
            headOption + '</select>';

        return [option].join('');
    }
    
    function operYbType(value,row,index){
        debugger;
        var option;
        var headOption = "<option value =''>请选择</option>";
        if(ybType != null || ybType != undefined){
            $.each(ybType,function(i,obj){
                if(value == obj.value){
                    headOption = headOption + "<option value='"+obj.value+"' selected>"+obj.label+"</option>";
                }else{
                    headOption = headOption + "<option value='"+obj.value+"'>"+obj.label+"</option>";
                }
            });
        }
        option  = '<select class="chosen-select" id="itemYbType"'+row.ckId+' onchange="inserData(\'itemYbType\','+row.ckId+',this)" style="height:33px;">'+
            headOption + '</select>';

        return [option].join('');
    }


    function operYcType(value,row,index){
        debugger;
        var option;
        var headOption = "<option value =''>请选择</option>";
        if(ycType != null || ycType != undefined){
            $.each(ycType,function(i,obj){
                if(value == obj.value){
                    headOption = headOption + "<option value='"+obj.value+"' selected>"+obj.label+"</option>";
                }else{
                    headOption = headOption + "<option value='"+obj.value+"'>"+obj.label+"</option>";
                }
            });
        }
        option  = '<select class="chosen-select" id="itemYcType"'+row.ckId+' onchange="inserData(\'itemYcType\','+row.ckId+',this)" style="height:33px;">'+
            headOption + '</select>';
        return [option].join('');
    }

    function operFormatter(value, row, index) {
        return [
            ' <button id="tableRowAdd" type="button" class="btn btn-default" ">添加</button>'
        ].join('');
    };

    function operProdFormatter(value, row, index) {
        return [
            // ' <button id="tableRowCope" type="button" class="btn btn-default" ">复制</button>'+
            ' <button id="tableRowdelete" type="button" class="btn btn-primary" ">删除</button>'
        ].join('');
    };


    window.operateEvents = {
        "click #tableRowAdd" : function(e,value,row,index){
            debugger;
            cusProdList.push(tranObject(row));
            $("#cusProdDetail").bootstrapTable("load",cusProdList);
        },

        "click #tableRowdelete" : function(e,value,row,index){
            for(var i=0;i<cusProdList.length;i++){
                if(cusProdList[i].ckId == row.ckId){
                    cusProdList.splice(i,1);
                    break;
                }
            }
            $("#cusProdDetail").bootstrapTable("load",cusProdList);
            debugger;
        },
        "click #tableRowCope" : function(e,value,row,index){
            cusProdList.push(tranObject(row));
            $("#cusProdDetail").bootstrapTable("load",cusProdList);
        }
    }
    
    function tranObject(data) {
        indexCkId = indexCkId + 1;
        debugger;
        var obj = {
            "ckId":indexCkId,
            "ordCode":$("#ordCode").val(),
            "itemCode":data.itemCode,
            "itemName":data.itemName,
            "itemLenth":0.00,
            "itemVariety":data.itemVariety,
            "itemVaritemValue":data.itemVaritemValue,
            "itemCgyCode":data.itemCgyCode,
            "itemCgyCodeValue":data.itemCgyCodeValue,
            "itemWidth":data.itemWidth,
            "itemThick":data.itemThick,
            "itemColor":data.itemColor,
            "itemColorValue":data.itemColorValue,
            "itemUnit":data.itemUnit,
            "itemUnitValue":data.itemUnitValue,
            "itemOwner":"",
            "itemPrice":data.itemPrice,
            "itemNum":0,
            "itemPriceType":data.itemPriceType,
            "itemPriceTypeValue":data.itemPriceTypeValue,
            "itemWeight":0.000,
            "itemTotalWeight":0,
            "itemTotalSq":0,
            "itemYcType":"",
            "itemYbType":""
        }
        return obj;
    }

    function inserData(name,index,obj,tIndex) {

        debugger
        for(var i=0;i<cusProdList.length;i++){
            if(cusProdList[i].ckId == index){
                for(var key in cusProdList[i]){
                    console.log(key,cusProdList[i][key]);
                    if(key == name){
                        if(name == "itemNum"){
                            var totalWeigth = cusProdList[i]['itemWeight'] * obj.value;
                            var totalMj = cusProdList[i]['itemLenth'] * cusProdList[i]['itemWidth'] * obj.value;
                            cusProdList[i]["itemTotalWeight"] = totalWeigth;
                            cusProdList[i]["itemTotalSq"] = totalMj;
                        }
                        if(name == "itemWeight"){
                            var totalWeigth = obj.value * cusProdList[i]['itemNum'];
                            cusProdList[i]["itemTotalWeight"] = totalWeigth;
                        }
                        if(name =='itemLenth'){
                            var totalMj = obj.value * cusProdList[i]['itemWidth'] * cusProdList[i]['itemNum'];
                            cusProdList[i]["itemTotalSq"] = totalMj;
                        }
                        cusProdList[i][key] = obj.value;

                    }
                }
            }
        }
        debugger;
        $("#cusProdDetail").bootstrapTable("load",cusProdList);
        $('#cusProdDetail .chosen-select').trigger("chosen:updated");
        $('#cusProdDetail .chosen-select').chosen();

    }

    function mathWeightValue(row) {

    }

    function mathMjValue(row) {

    }
    
    function saveProd() {

        if($("#ordCode").val() == ''){
            return;
        }
        if(cusProdList.length > 0){
            $.ajax({
                url:'${ctx}/order/orderDetailBatchSave/',
                data: JSON.stringify(cusProdList),
                dataType:"json",
                type:"post",
                contentType:"application/json",
                error: function(r) {
                    layer.msg("保存失败！")
                },
                success: function(r) {
                    debugger;
                    if(r.res == "success"){
                        window.location.href = "/crm/order/list"
                    }else{
                        layer.msg("保存失败！")
                    }
                }
            })
        }
    }
</script>