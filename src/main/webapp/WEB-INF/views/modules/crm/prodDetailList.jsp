<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>

<link href="${ctxStatic}/hPlugs/css/plugins/bootstrap-table/bootstrap-table.css" rel="stylesheet">
<link href="${ctxStatic}/hPlugs/css/plugins/bootstrap-table/bootstrap-table-fixed-columns.css" rel="stylesheet">
<link rel="stylesheet" href="/static/common/customize.css">


<div class="tabs-container" style="padding: 0px 20px;">

    <div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
        <div class="panel-heading" style="background-color: #50B0E6">
            <h3 class="panel-title global-panel-title" >
                第一步：选择产品
                <a class="collapse-link" style="font-size: 13px;margin-left: 20px;    color: #337ab7;">
                    折叠/展开
                </a>
            </h3>

        </div>
        <div class="panel-body prod-hide" style="padding: 10px 10px 10px 10px;">
            <div class="row">
                <div class="col-sm-12">
                    <input type="hidden" id="ordCode" value="${ordCode}"/>
                    <div class="form-group">
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                产品选择:
                            </label>
                            <label class="col-md-8 control-label">
                                <select data-placeholder="产品选择" class="chosen-select order-label-input-width" style="width: 209px" id="prodInfo" onchange="getResChange(this)">
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
                                                data-density="${p.prodDensity}"
                                                value='${p.prodCode}' > ${p.prodCode}_${p.prodDensity==null?"0":p.prodDensity}</option>
                                    </c:forEach>
                                </select>
                            </label>
                        </div>
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                产品编码:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control" id="itemCode" disabled>
                            </label>
                        </div>
                        <div class="col-md-4">
                            <%--<label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">--%>
                                <%--产品名称:--%>
                            <%--</label>--%>
                            <%--<label class="col-md-8 control-label" style="text-align: left">--%>
                                <%--<input class="form-control" id="itemName" disabled>--%>
                            <%--</label>--%>
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                产品密度:
                            </label>
                            <label class="col-md-8 control-label" style="text-align: left">
                                <input class="form-control" id="itemDensity" disabled>
                            </label>
                        </div>
                    </div>
                    </br>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12">
                    <div class="form-group">
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right"><i style="color: red"></i>
                                颜色:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control" id="itemColor" disabled>
                            </label>
                        </div>

                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                产品品种:
                            </label>
                            <label class="col-md-8 control-label" style="text-align: left">
                                <input class="form-control" id="itemCgyCode" disabled>
                            </label>
                        </div>

                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                产品类别:
                            </label>
                            <label class="col-md-8 control-label" style="text-align: left">
                                <input class="form-control" id="itemVariety" disabled>
                            </label>
                        </div>

                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12">
                    <div class="form-group">
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right"><i style="color: red"></i>
                                产品厚度:
                            </label>
                            <label class="col-md-8 control-label">
                                <input class="form-control" id="itemThick" disabled>
                            </label>
                        </div>
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                计价方式:
                            </label>
                            <label class="col-md-8 control-label" style="text-align: left">
                                <input class="form-control" id="itemPriceType" disabled>
                            </label>
                        </div>
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                单位:
                            </label>
                            <label class="col-md-8 control-label" style="text-align: left">
                                <input class="form-control" id="itemUnit" disabled>
                            </label>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12">
                    <div class="form-group">
                        <div class="col-md-4">
                            <label class="col-md-4 control-label order-detail-label-margin" style="text-align: right">
                                指导价格:
                            </label>
                            <label class="col-md-8 control-label" style="text-align: left">
                                <input class="form-control" id="itemPrice" >
                            </label>
                        </div>

                        <div class="col-md-8">
                            <div class="col-md-1">
                                &nbsp;
                            </div>
                            <div class="col-md-11 " style="text-align: right;">
                                <button class="btn btn-primary global-button-style" type="button"
                                        onclick="doProcess()">添加产品
                                </button>&nbsp;&nbsp;&nbsp;&nbsp;
                                <button class="btn btn-primary global-button-style" type="button"
                                        onclick="oneTrimPrice()">一键调价
                                </button>&nbsp;&nbsp;&nbsp;&nbsp;
                                <button class="btn btn-primary global-button-style" type="button"
                                        onclick="history.go(-1)">返 回
                                </button>&nbsp;&nbsp;&nbsp;&nbsp;
                                <button class="btn btn-primary global-button-style" type="button"
                                        onclick="saveProd()">保存订单
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</div>
<div class="tabs-container" >
    <div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
        <div class="panel-heading" style="background-color: #50B0E6">
            <h3 class="panel-title global-panel-title" >
                第二步：确认产品定制化属性
            </h3>
        </div>
        <div class="panel-body" style="padding: 10px 10px 0px 10px;height: 100%">
            <div class="control-group table-responsive" >
                <table id="cusProdDetail" class="table table-striped table-bordered table-hover text-nowrap">
                </table>
            </div>
        </div>
    </div>
</div>

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
    $(document).ready(function () {
        $(".collapse-link").click(function() {
            var o = $(this).closest("div.panel"),
                i = o.find("div.prod-hide");
            i.slideToggle(200),
                o.toggleClass("").toggleClass("border-bottom"),
                setTimeout(function() {
                        o.resize(),
                            o.find("[id^=map-]").resize()
                    },
                    50)
        })
    })


    var prodList = [];
    var cusProdList = [];
    var indexCkId = 1;
    var maxDataIndex = 1;
    var prodCgyCodes = new Array();

    var ycType;
    var ybType

    $.ajax({
        type: "POST",
        url: '/crmAjax/ajaxDictInfo',
        dataType:'json',
        cache: false,
        success: function(data){
            if(data != null){
                ycType = data.ycType;
                ybType = data.ybType;
            }
        }
    });

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
        "itemNum":1,
        "itemPriceType":"",
        "itemPriceTypeValue":"",
        "itemWeight":0.000,
        "itemTotalWeight":0.000,
        "itemTotalSq":0.000,
        "itemYcType":"",
        "itemYbType":"",
        "itemRemarks":""
    }
    function getResChange(obj) {
        if($(obj).find("option:selected").val() != -1){

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

            // $("#itemName").val($(obj).find("option:selected").attr("data-prodName"));
            $("#itemCode").val($(obj).find("option:selected").val());
            $("#itemCgyCode").val($(obj).find("option:selected").attr("data-prodCgyCodeValue"));
            $("#itemVariety").val($(obj).find("option:selected").attr("data-prodVarietyValue"));
            $("#itemThick").val($(obj).find("option:selected").attr("data-prodthick"));
            $("#itemPriceType").val($(obj).find("option:selected").attr("data-prodPriceTypeValue"));
            $("#itemPrice").val($(obj).find("option:selected").attr("data-prodguidePrice"));
            $("#itemUnit").val($(obj).find("option:selected").attr("data-prodUnitValue"));
            $("#itemColor").val($(obj).find("option:selected").attr("data-colorValue"));

            $("#itemDensity").val($(obj).find("option:selected").attr("data-density"));


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
        if(prodObj.itemCode != ""){
            cusProdList.push(tranObject(prodObj));
            $("#cusProdDetail").bootstrapTable("load",cusProdList);
            $('#cusProdDetail .chosen-select').trigger("chosen:updated");
            $('#cusProdDetail .chosen-select').chosen();
        }else{
            layer.msg("请先选中一个产品！");
        }

    }

    function initTableInfo(){
        debugger;
        $("#cusProdDetail").bootstrapTable({
            url:'/order/item/findItemsById',
            pagination: false,  //表格底部显示分页条
            sidePagination: "server",
            escape:false, //启动转义字符
            queryParamsType:'',//设置请求参数格式
            queryParams: function queryParams(params) {

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
                    title: '产品编码'
                },{
                    field: 'ordCode',
                    title: '合同编码'
                },{
                    field: 'itemName',
                    title: '名称',
                    width: '150px'
                },{
                    field: 'itemVaritemValue',
                    title: '品种',
                    width: '80px'
                },{
                    field: 'itemCgyCodeValue',
                    title: '类别',
                    width: '100px'
                },{
                    field: 'itemColorValue',
                    title: '颜色',
                    width: '80px'
                },{
                    field: 'itemLenth',
                    title: '长(m)',
                    width: '80px',
                    formatter:function (value,row,index) {
                        return ['<input type="number" min="0" style="width: 80px" step="0.01" onchange="inserData(\'itemLenth\','+row.ckId+',this,'+index+')" class="form-control" value="'+value+'"/>'].join('');
                    }
                },{
                    field: 'itemWidth',
                    title: '宽(m)',
                    width: '60px',
                    formatter:function (value,row,index) {
                        return ['<input type="number" min="0" style="width: 80px" step="0.01" onchange="inserData(\'itemWidth\','+row.ckId+',this,'+index+')" class="form-control" value="'+value+'"/>'].join('');
                    }
                },{
                    field: 'itemThick',
                    title: '厚度(mm)',
                    width: '60px'
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
                    width: '90px',
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
                    field: 'itemYbType',
                    title: '压边类型',
                    width: '150px',
                    formatter:operYbType
                },{
                    field: 'itemYcType',
                    title: '延长米方式',
                    width: '150px',
                    formatter:operYcType
                },{
                    field: 'itemRemarks',
                    title: '备注',
                    width: '150px',
                    formatter:function (value,row,index) {
                        return ['<input type="text"  style="width: 150px" onchange="inserData(\'itemRemarks\','+row.ckId+',this,'+index+')" class="form-control" value="'+value+'"/>'].join('');
                    }
                },{
                    field: 'itemPriceType',
                    title: '计价方式',
                    width: '130px',
                    formatter:operPriceType
                },{
                    field: 'itemUnitValue',
                    title: '单位',
                    width: '50px'
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
                cusProdList = $('#cusProdDetail').bootstrapTable("getData");
                $('#cusProdDetail .chosen-select').trigger("chosen:updated");
                $('#cusProdDetail .chosen-select').chosen();
            }
        })
        // $(".fixed-table-border")[1].style.height = '230px';
        $(".fixed-table-border").hide();
        // $('#cusProdDetail').bootstrapTable('hideColumn', 'itemCode');
        $('#cusProdDetail').bootstrapTable('hideColumn', 'ordCode');
    }

    $(document).ready(function(){
        if(ybType == null || ybType == undefined){
            $.ajax({
                type: "POST",
                url: '/crmAjax/ajaxDictInfo',
                dataType:'json',
                cache: false,
                success: function(data){
                    if(data != null){
                        ycType = data.ycType;
                        ybType = data.ybType;
                        initTableInfo();
                    }
                },
                error:function () {
                    initTableInfo();
                }
            });
        }else{
            initTableInfo();
        }

    });

    function operPriceType(value,row,index) {
        var option;
        if(value == 141001 || value == 141003 || value == 141005){
            return "按重量";
        }else if(value == 141002 || value == 141004 || value == 141006){
            return "按面积";
        }
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
        option  = '<select class="chosen-select" id="itemYbType"'+row.ckId+' onchange="inserData(\'itemYbType\','+row.ckId+',this)" style="width: 150px;height:33px;">'+
            headOption + '</select>';

        return [option].join('');
    }

    function operYcType(value,row,index){
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
        option  = '<select class="chosen-select" id="itemYcType"'+row.ckId+' onchange="inserData(\'itemYcType\','+row.ckId+',this)" style="width: 150px;height:33px;">'+
            headOption + '</select>';
        return [option].join('');
    }

    function operProdFormatter(value, row, index) {
        return [
            ' <button id="tableRowdelete" type="button" class="btn btn-primary" ">删除</button>'
        ].join('');
    };


    window.operateEvents = {

        "click #tableRowdelete" : function(e,value,row,index){
            for(var i=0;i<cusProdList.length;i++){
                if(cusProdList[i].ckId == row.ckId){
                    cusProdList.splice(i,1);
                    break;
                }
            }
            $("#cusProdDetail").bootstrapTable("load",cusProdList);
        }
    }
    
    function oneTrimPrice() {
        debugger;
        if(prodObj.itemCode != "" && cusProdList.length > 0){
            var flag = false;
            var price = $("#itemPrice").val();
            if(price == null || price == undefined){
                layer.msg("价格不能为空！");
                return;
            }
            $.each(cusProdList,function(index,item){
            		if(prodObj.itemCode == item.itemCode && prodObj.itemName == item.itemName &&
	            		prodObj.itemVariety == item.itemVariety && prodObj.itemCgyCode == item.itemCgyCode &&
	            		prodObj.itemThick == item.itemThick && prodObj.itemColor == item.itemColor){
            			item.itemPrice = price;
                        flag = true;
            		}
            })
            if(flag){
                $("#cusProdDetail").bootstrapTable("load",cusProdList);
                $('#cusProdDetail .chosen-select').trigger("chosen:updated");
                $('#cusProdDetail .chosen-select').chosen();
            }
        }else{
            layer.msg("请先选中一个产品！");
        }
    }
    
    
    function tranObject(data) {
        debugger;
        indexCkId = indexCkId + 1;
        var price = $("#itemPrice").val();
        if(price != null && price != undefined){
            data.itemPrice = price;
        }
        var width = '';
        if(data.itemWidth != null && data.itemWidth != ''){
            width = data.itemWidth;
        }
        var obj = {
            "ckId":indexCkId,
            "ordCode":$("#ordCode").val(),
            "itemCode":data.itemCode,
            "itemName":data.itemName,
            "itemLenth":'',
            "itemVariety":data.itemVariety,
            "itemVaritemValue":data.itemVaritemValue,
            "itemCgyCode":data.itemCgyCode,
            "itemCgyCodeValue":data.itemCgyCodeValue,
            "itemWidth":width,
            "itemThick":data.itemThick,
            "itemColor":data.itemColor,
            "itemColorValue":data.itemColorValue,
            "itemUnit":data.itemUnit,
            "itemUnitValue":data.itemUnitValue,
            "itemOwner":"",
            "itemPrice":data.itemPrice,
            "itemNum":1,
            "itemPriceType":data.itemPriceType,
            "itemPriceTypeValue":data.itemPriceTypeValue,
            "itemWeight":0.000,
            "itemTotalWeight":0,
            "itemTotalSq":0,
            "itemYcType":"",
            "itemYbType":"",
            "itemRemarks":""
        }
        return obj;
    }

    function inserData(name,index,obj,tIndex) {

        for(var i=0;i<cusProdList.length;i++){
            if(cusProdList[i].ckId == index){
                for(var key in cusProdList[i]){
                    if(key == name){
                        debugger;
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
                        if(name =='itemWidth'){
                            var totalMj = obj.value * cusProdList[i]['itemLenth'] * cusProdList[i]['itemNum'];
                            cusProdList[i]["itemTotalSq"] = totalMj;
                        }
                        cusProdList[i][key] = obj.value;

                    }
                }
            }
        }

        // $("#cusProdDetail").bootstrapTable("load",cusProdList);
        $('#cusProdDetail .chosen-select').trigger("chosen:updated");
        $('#cusProdDetail .chosen-select').chosen();

    }

    
    function saveProd() {
        debugger;
        var flag = false;
        if($("#ordCode").val() == ''){
            return;
        }
        if(cusProdList.length > 0){
            $.each(cusProdList,function (i,obj) {
                if(obj.itemWidth <= 0 || obj.itemLenth <= 0){
                    layer.msg("订单产品未填写完整，长宽不能为0！");
                    flag = true;
                    return
                }
            });
            if(!flag){
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

                        if(r.res == "success"){
                            window.location.href = "/crm/order/list"
                        }else{
                            layer.msg("保存失败！")
                        }
                    }
                });
            }
        }
    }
</script>