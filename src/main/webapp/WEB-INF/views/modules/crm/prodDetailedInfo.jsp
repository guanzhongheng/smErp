<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>

<link href="${ctxStatic}/hPlugs/css/plugins/bootstrap-table/bootstrap-table.css" rel="stylesheet">
<link href="${ctxStatic}/hPlugs/css/plugins/bootstrap-table/bootstrap-table-fixed-columns.css" rel="stylesheet">

<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <input type="hidden" id="ordCode" value="${ordCode}"/>
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <label class="col-sm-3 control-label">订单信息

                </label>
            </div>
            <div class="ibox-content">

            </div>
        </div>
    </div>
    </br>
    <div class="row">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>订单详情列表</h5>
            </div>
            <div class="ibox-content">
                <div class="" style="max-height: 350px">
                    <table id="cusProdDetail" data-height="300" style="min-width: 1500px">
                    </table>
                </div>
            </div>
        </div>
    </div>
    </br>
    <div class="row">
        <div class="form-group">
            &nbsp;&nbsp;
            <button class="btn btn-primary" type="submit" onclick="saveProd()">保存详情</button>
            &nbsp;&nbsp;
            <button class="btn btn-white" type="button" onclick="history.go(-1)">返回</button>
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
            prodObj.itemCode = $(obj).find("option:selected").attr("data-prodcode");
            prodObj.itemName = $(obj).find("option:selected").val();
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

            $("#itemCode").text($(obj).find("option:selected").attr("data-prodcode"));
            $("#itemName").text($(obj).find("option:selected").val());
            $("#itemCgyCode").text($(obj).find("option:selected").attr("data-prodCgyCodeValue"));
            $("#itemVariety").text($(obj).find("option:selected").attr("data-prodVarietyValue"));
            $("#itemThick").text($(obj).find("option:selected").attr("data-prodthick"));
            $("#itemPriceType").text($(obj).find("option:selected").attr("data-prodPriceTypeValue"));
            $("#itemPrice").text($(obj).find("option:selected").attr("data-prodguidePrice"));
            $("#itemUnit").text($(obj).find("option:selected").attr("data-prodUnitValue"));
        }else{
            $("#itemCode").text("");
            $("#itemName").text("");
            $("#itemCgyCode").text("");
            $("#itemVariety").text("");
            $("#itemThick").text("");
            $("#itemPriceType").text("");
            $("#itemPrice").text("");
            $("#itemUnit").text("");
        }
    }

    function doProcess() {
        debugger;
        var color = $("#prodColor").val();
        var itemWidth =  $("#itemWidth").val();
        if(color == -1){
            layer.msg('请选择颜色');
            return;
        }
        if($("#prodInfo").find("option:selected").val() != -1){
            debugger;
            prodObj.itemColor = color;
            prodObj.itemColorValue = $("#prodColor").find("option:selected").attr("data-label");
            prodObj.itemWidth = itemWidth;
            cusProdList.push(tranObject(prodObj));
            $("#cusProdDetail").bootstrapTable("load",cusProdList);
            $('#cusProdDetail .chosen-select').trigger("chosen:updated");
            $('#cusProdDetail .chosen-select').chosen();

        }
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

    function getItemType() {

    }


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
                    width: '80px'
                },{
                    field: 'itemWidth',
                    title: '宽',
                    width: '60px'
                },{
                    field: 'itemThick',
                    title: '厚',
                    width: '60px'
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
                    width: '80px'
                },{
                    field: 'itemPrice',
                    title: '单价',
                    width: '80px'
                },{
                    field: 'itemNum',
                    title: '数量',
                    width: '80px'
                },{
                    field: 'itemPriceType',
                    title: '计价方式',
                    width: '100px',
                    formatter:operPriceType
                },
                {
                    field: 'itemWeight',
                    title: '重量',
                    width: '55px'
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
                }
            ]
        })
        $(".fixed-table-border").hide();
        $('#cusProdDetail').bootstrapTable('hideColumn', 'itemCode');
        $('#cusProdDetail').bootstrapTable('hideColumn', 'ordCode');
    });

    function operPriceType(value,row,index) {
        var option;
        var headOption = "";
        if(value == 141001){
            headOption = "重量";
        }
        if(value == 141002){
            headOption = "面积";
        }
        return [headOption].join('');
    }

    function operYbType(value,row,index){
        debugger;
        var headOption = "";
        if(ybType != null || ybType != undefined){
            $.each(ybType,function(i,obj){
                if(value == obj.value){
                    headOption = obj.label
                }
            });
        }
        return [headOption].join('');
    }

    function operYcType(value,row,index){
        debugger;
        var headOption = "";
        if(ycType != null || ycType != undefined){
            $.each(ycType,function(i,obj){
                if(value == obj.value){
                    headOption = headOption + "<option value='"+obj.value+"' selected>"+obj.label+"</option>";
                }
            });
        }
        return [headOption].join('');
    }


</script>