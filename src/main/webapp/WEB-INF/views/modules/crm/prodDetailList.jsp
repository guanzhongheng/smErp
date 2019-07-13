<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>

<link href="${ctxStatic}/hPlugs/css/plugins/bootstrap-table/bootstrap-table.css" rel="stylesheet">
<link href="${ctxStatic}/hPlugs/css/plugins/bootstrap-table/bootstrap-table-fixed-columns.css" rel="stylesheet">

<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <input type="hidden" id="ordCode" value="${ordCode}"/>
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <label class="col-sm-3 control-label">产品选择:
                    <select data-placeholder="产品选择" class="chosen-select" style="width:200px;" id="prodInfo" onchange="getResChange(this)">
                        <option value="-1">请选择</option>
                        <c:forEach items="${prod}" var="p">
                            <option data-prodcode='${p.prodCode}' data-prodcgycode='${p.prodCgyCode}'
                                    data-prodvariety='${p.prodVariety}' data-prodthick='${p.prodThick}'
                                    data-prodpricetype='${p.prodPriceType}'
                                    data-prodguideprice='${p.prodGuidePrice}'
                                    data-produnit='${p.prodUnit}'
                                    value='${p.prodName}' > ${p.prodName}</option>
                        </c:forEach>
                    </select>
                </label>
            </div>
            <div class="ibox-content">
                <form method="get" class="form-horizontal">
                    <div class="form-group">
                        <div class="col-md-4">
                            <label class="col-md-3">产品编码:</label>
                            <label class="col-md-3" id="itemCode"></label>
                        </div>
                        <div class="col-md-4">
                            <label class="col-md-3">产品名称:</label>
                            <label class="col-md-3" id="itemName">AAA</label>
                        </div>
                        <div class="col-md-4">
                            <label class="col-md-3">产品品种:</label>
                            <label class="col-md-3" id="itemVariety">AAA</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-4">
                            <label class="col-md-3">产品类别:</label>
                            <label class="col-md-3" id="itemCgyCode">AAA</label>
                        </div>
                        <div class="col-md-4">
                            <label class="col-md-3">产品厚度:</label>
                            <label class="col-md-3" id="itemThick">AAA</label>
                        </div>
                        <div class="col-md-4">
                            <label class="col-md-3">计价方式:</label>
                            <label class="col-md-3" id="itemPriceType">AAA</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-4">
                            <label class="col-md-3">指导价格:</label>
                            <label class="col-md-3" id="itemPrice">AAA</label>
                        </div>
                        <div class="col-md-4">
                            <label class="col-md-3">单位:</label>
                            <label class="col-md-3" id="itemUnit"></label>
                        </div>
                        <div class="col-md-4" style="padding-left: 30px;">
                            <select data-placeholder="选择颜色" class="chosen-select" style="width: 250px">
                                <option value="-1">颜色选择</option>
                                <c:forEach items="${color}" var="c">
                                    <option value='${c.value}' > ${c.label}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <%--<div class="form-group">--%>
                        <%--<div class="col-md-4">--%>
                            <%--<label class="col-md-2">备注:</label>--%>
                            <%--<label class="col-md-2">--%>
                                <%--<textarea rows="5" cols="8" style="width: 300px" id="remark" name="remark">--%>
                                <%--</textarea>--%>
                            <%--</label>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                </form>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="form-group">
            &nbsp;&nbsp;
            <button class="btn btn-primary" type="button" onclick="doProcess()">确认产品</button>
        </div>
    </div>
</br>
    <div class="row">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>订单产品列表</h5>
            </div>
            <div class="ibox-content">
                <div class="col-sm-12" style="max-height: 350px">
                    <table id="cusProdDetail" data-height="300" style="min-width: 1300px">
                        <thead>
                        <tr>
                            <th data-field="itemCode">编码</th>
                            <th data-field="itemName">名称</th>
                            <th data-field="itemCgyCode">类别</th>
                            <th data-field="itemVariety">品种</th>
                            <th data-field="itemLenth">长</th>
                            <th data-field="itemWidth">宽</th>
                            <th data-field="itemThick">厚度</th>
                            <th data-field="itemColor">颜色</th>
                            <th data-field="itemUnit">单位</th>
                            <th data-field="itemOwner">归属人</th>
                            <th data-field="itemPrice">单价</th>
                            <th data-field="itemNum">数量</th>
                            <th data-field="itemPriceType">计价方式</th>
                            <th data-field="itemWeight">重量</th>
                            <th data-field="itemTotalWeight">总重量</th>
                            <th data-field="itemTotalSq">总面积</th>
                            <th data-field="itemYcType">延长方式</th>
                            <th data-field="itemYbType">压边类型</th>
                            <th data-field="operator">操作</th>
                        </tr>
                        </thead>
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
</body>
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
        "itemCode":"",
        "itemName":"",
        "itemLenth":"",
        "itemVariety":"",
        "itemCgyCode":"",
        "itemWidth":"",
        "itemThick":"",
        "itemColor":"",
        "itemUnit":"",
        "itemOwner":"",
        "itemPrice":"",
        "itemNum":"",
        "itemPriceType":"",
        "itemWeight":"",
        "itemTotalWeight":"",
        "itemTotalSq":"",
        "itemYcType":"",
        "itemYbType":""
    }
    function getResChange(obj) {

        if($(obj).find("option:selected").val() != -1){
            prodObj.itemCode = $(obj).find("option:selected").attr("data-prodcode");
            prodObj.itemName = $(obj).find("option:selected").val();
            prodObj.prodCgyCode = $(obj).find("option:selected").attr("data-prodcgyCode");
            prodObj.prodVariety = $(obj).find("option:selected").attr("data-prodvariety");
            prodObj.prodThick = $(obj).find("option:selected").attr("data-prodthick");
            prodObj.prodPriceType = $(obj).find("option:selected").attr("data-prodpriceType");
            prodObj.itemPrice = $(obj).find("option:selected").attr("data-prodguidePrice");
            prodObj.itemUnit = $(obj).find("option:selected").attr("data-produnit");

            $("#itemCode").text($(obj).find("option:selected").attr("data-prodcode"));
            $("#itemName").text($(obj).find("option:selected").val());
            $("#itemCgyCode").text($(obj).find("option:selected").attr("data-prodcgyCode"));
            $("#itemVariety").text($(obj).find("option:selected").attr("data-prodvariety"));
            $("#itemThick").text($(obj).find("option:selected").attr("data-prodthick"));
            $("#itemPriceType").text($(obj).find("option:selected").attr("data-prodpriceType"));
            $("#itemPrice").text($(obj).find("option:selected").attr("data-prodguidePrice"));
            $("#itemUnit").text($(obj).find("option:selected").attr("data-produnit"));
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
        if($("#prodInfo").find("option:selected").val() != -1){
            debugger;
            cusProdList.push(prodObj);
            $("#cusProdDetail").bootstrapTable("load",cusProdList);
        }
    }

    var ycType;
    var ybType
    function getItemType() {
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
    }


    $(document).ready(function(){
        getItemType();
        prodCgyCodes = "${fns:getDictList('prod_cgy_code')}";
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
                    formatter:function (value,row,index){
                        debugger;
                        if(index == 0){
                            maxDataIndex = 1;
                        }else{
                            maxDataIndex = maxDataIndex + 1;
                        }
                        return maxDataIndex;
                    }
                },{
                    field: 'itemCode',
                    title: '编号'
                },{
                    field: 'itemName',
                    title: '名称',
                    width: '110px'
                },{
                    field: 'itemCgyCode',
                    title: '类别',
                    width: '80px'
                },{
                    field: 'itemVariety',
                    title: '品种',
                    width: '100px'
                },{
                    field: 'itemLenth',
                    title: '长',
                    width: '100px',
                    formatter:function (value,row,index) {
                        return ['<input trpe="text" onchange="inserData(\'itemLenth\','+row.ckId+',this)" class="form-control" value="'+value+'"/>'].join('');
                    }
                },{
                    field: 'itemWidth',
                    title: '宽',
                    width: '60px'
                },{
                    field: 'itemThick',
                    title: '厚',
                    width: '60px'
                },{
                    field: 'itemColor',
                    title: '颜色',
                    width: '80px'
                },{
                    field: 'itemUnit',
                    title: '单位',
                    width: '50px'
                },{
                    field: 'itemOwner',
                    title: '归属人',
                    width: '120px',
                    formatter:function (value,row,index) {
                        return ['<input trpe="text" onchange="inserData(\'itemOwner\','+row.ckId+',this)" class="form-control" value="'+value+'"/>'].join('');
                    }
                },{
                    field: 'itemPrice',
                    title: '单价',
                    width: '120px',
                    formatter:function (value,row,index) {
                        return ['<input trpe="text" onchange="inserData(\'itemPrice\','+row.ckId+',this)" class="form-control" value="'+value+'"/>'].join('');
                    }
                },{
                    field: 'itemNum',
                    title: '数量',
                    width: '120px',
                    formatter:function (value,row,index) {
                        return ['<input trpe="text" onchange="inserData(\'itemOwner\','+row.ckId+',this)" class="form-control" value="'+value+'"/>'].join('');
                    }
                },{
                    field: 'itemPriceType',
                    title: '计价方式',
                    width: '120px',
                    formatter:function (value,row,index) {
                        debugger;
                        var obj = '<select trpe="text" onchange="inserData(\'itemPriceType\','+row.ckId+',this)" class="form-control">';
                        if(value == 141001){
                            obj = obj +  '<option value="141001" checked>重量</option>';
                        }else{
                            obj = obj + '<option value="141001">重量</option>';
                        }
                        if(value == 141002){
                            obj = obj + '<option value="141002" checked>体积</option>';
                        }else{
                            obj = obj + '<option value="141002">体积</option>';
                        }
                        obj =obj + '</select>'

                        return [obj].join('');
                    }
                },
                {
                    field: 'itemWeight',
                    title: '重量',
                    width: '120px',
                    formatter:function (value,row,index) {
                        return ['<input trpe="text" onchange="inserData(\'itemWeight\','+row.ckId+',this)" class="form-control" value="'+value+'"/>'].join('');
                    }
                },{
                    field: 'itemTotalWeight',
                    title: '总重量',
                    width: '100px'
                },{
                    field: 'itemTotalSq',
                    title: '总面积',
                    width: '100px'
                },{
                    field: 'itemYcType',
                    title: '延长米方式',
                    width: '120px',
                    formatter:function (value,row,index) {
                        return ['<input trpe="text" onchange="inserData(\'itemYcType\','+row.ckId+',this)" class="form-control" value="'+value+'"/>'].join('');
                    }
                },{
                    field: 'itemYbType',
                    title: '压边类型',
                    width: '120px',
                    formatter: operYbType
                },
                {
                    field: 'oper',
                    title: '操作',
                    events: operateEvents,
                    formatter: operProdFormatter
                }
            ]
        })
        // $(".fixed-table-border")[1].style.height = '230px';
         $(".fixed-table-border").hide();
        $('#cusProdDetail').bootstrapTable('hideColumn', 'ckId');
        $('#cusProdDetail').bootstrapTable('hideColumn', 'itemCode');
    });

    function operYbType(value,row,index){
        var option;
        var headOption = "<option value =''>请选择</option>";

        $.each(ybType,function(i,obj){
            if(value == obj.value){
                headOption = headOption + "<option value='"+obj.value+"' selected>"+obj.label+"</option>";
            }else{
                headOption = headOption + "<option value='"+obj.value+"'>"+obj.label+"</option>";
            }
        });
        option  = '<select class="form-control" id="itemYbType"'+row.ckId+' name="itemYbType" style="height:33px;">'+
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
            ' <button id="tableRowdelete" type="button" class="btn btn-default" ">删除</button>'
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
        debugger;
        indexCkId = indexCkId + 1;
        debugger;
        var obj = {
            "ckId":indexCkId,
            "itemCode":data.prodCode,
            "itemName":data.prodCgyCode,
            "itemCode":"",
            "itemName":"",
            "itemLenth":"",
            "itemVariety":"",
            "itemCgyCode":"",
            "itemWidth":"",
            "itemThick":"",
            "itemColor":"",
            "itemUnit":"",
            "itemOwner":"",
            "itemPrice":"",
            "itemNum":"",
            "itemPriceType":"",
            "itemWeight":"",
            "itemTotalWeight":"",
            "itemTotalSq":"",
            "itemYcType":"",
            "itemYbType":""
        }
        return obj;
    }

    function inserData(name,index,obj) {
        debugger
        for(var i=0;i<cusProdList.length;i++){
            if(cusProdList[i].ckId == index){
                for(var key in cusProdList[i]){
                    console.log(key,cusProdList[i][key]);
                    if(key == name){
                        cusProdList[i][key] = obj.value;
                    }
                }
            }
        }
    }

    function saveProd() {

        debugger;
    }
</script>