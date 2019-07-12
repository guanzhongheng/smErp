<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>


<link href="${ctxStatic}/hPlugs/css/plugins/bootstrap-table/bootstrap-table.css" rel="stylesheet">

<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <input type="hidden" id="ordCode" value="${ordCode}"/>
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <label class="col-sm-3 control-label">产品选择:</label>
                <select data-placeholder="产品选择" class="chosen-select" style="width:200px;">
                    <c:forEach items="${prod}" var="p">
                        <option data-prodCode='${p.prodCode}' data-prodCgyCode='${p.prodCgyCode}'
                                data-prodVariety='${p.prodVariety}' data-prodThick='${p.prodThick}'
                                data-prodPriceType='${p.prodPriceType}' value='${p.prodName}' > ${p.prodName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="ibox-content">
                <form method="get" class="form-horizontal">
                    <div class="form-group">
                        <div class="col-md-4">
                            <label class="col-md-2">产品编码:</label>
                            <label class="col-md-2">AAA</label>
                        </div>
                        <div class="col-md-4">
                            <label class="col-md-2">产品名称:</label>
                            <label class="col-md-2">AAA</label>
                        </div>
                        <div class="col-md-4">
                            <label class="col-md-2">产品品种:</label>
                            <label class="col-md-2">AAA</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-4">
                            <label class="col-md-2">产品类别:</label>
                            <label class="col-md-2">AAA</label>
                        </div>
                        <div class="col-md-4">
                            <label class="col-md-2">产品厚度:</label>
                            <label class="col-md-2">AAA</label>
                        </div>
                        <div class="col-md-4">
                            <label class="col-md-2">计重方式:</label>
                            <label class="col-md-2">AAA</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-4">
                            <select data-placeholder="选择颜色" class="chosen-select" tabindex="2">
                                <c:forEach items="${color}" var="c">
                                    <option value='${c.value}' > ${c.label}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-4">
                            <label class="col-md-2">备注:</label>
                            <label class="col-md-2">AAA</label>
                        </div>
                    </div>
                </form>
            </div>
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
                    <table id="cusProdDetail" data-height="300" data-mobile-responsive="true">
                        <thead>
                        <tr>
                            <th data-field="itemCode">产品编码</th>
                            <th data-field="itemName">产品名称</th>
                            <th data-field="itemLenth">长</th>
                            <th data-field="itemWidth">宽</th>
                            <th data-field="itemThick">厚度</th>
                            <th data-field="itemNum">计量方式</th>
                            <th data-field="itemColor">颜色</th>
                            <th data-field="itemUnit">单位</th>
                            <th data-field="itemOwner">收货人</th>
                            <th data-field="itemOwner">单价</th>
                            <th data-field="itemOwner">数量</th>
                            <th data-field="itemOwner">重量</th>
                            <th data-field="itemOwner">面积</th>
                            <th data-field="itemOwner">延长米方式</th>
                            <th data-field="blankPressTypeValue">压边类型</th>
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
<script src="${ctxStatic}/hPlugs/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script>
    var prodList = [];
    var cusProdList = [];
    var indexCkId = 1;
    var maxDataIndex = 1;
    var data = [{"prodCode":"1","prodName":"1_n","prodCgyCode":"1_p","prodSpec":"1_c"},
        {"prodCode":"2","prodName":"12_n","prodCgyCode":"12_p","prodSpec":"12_c"},
        {"prodCode":"3","prodName":"13_n","prodCgyCode":"13_p","prodSpec":"13_c"},
        {"prodCode":"4","prodName":"14_n","prodCgyCode":"14_p","prodSpec":"4_c"},
        {"prodCode":"4","prodName":"14_n","prodCgyCode":"14_p","prodSpec":"4_c"},
        {"prodCode":"4","prodName":"14_n","prodCgyCode":"14_p","prodSpec":"4_c"},
        {"prodCode":"4","prodName":"14_n","prodCgyCode":"14_p","prodSpec":"4_c"},
        {"prodCode":"4","prodName":"14_n","prodCgyCode":"14_p","prodSpec":"4_c"}]
    $(document).ready(function(){
        debugger;
        // $("#productTables").bootstrapTable({
        //     url:'',
        //     classes: 'table table-hover',
        //     pagination: false,  //表格底部显示分页条
        //     sidePagination: "server",
        //     escape:false, //启动转义字符
        //     queryParamsType:'',//设置请求参数格式
        //     columns :[
        //         {
        //             field: 'prodCode',
        //             title: '产品编号'
        //         }, {
        //             field: 'prodName',
        //             title: '产品名称'
        //         }, {
        //             field: 'prodCgyCode',
        //             title: '产品类型'
        //         },{
        //             field: 'prodSpec',
        //             title: '产品规格'
        //         },{
        //             field: 'oper',
        //             title: '操作',
        //             events: operateEvents,
        //             formatter: operFormatter
        //         }
        //     ],onLoadSuccess:function () {
        //
        //         debugger;
        //     }
        // });
        // $("#productTables").bootstrapTable("load",data);
        $("#cusProdDetail").bootstrapTable({
            url:'/order/item/findItemsById',
            pagination: false,  //表格底部显示分页条
            sidePagination: "server",
            escape:false, //启动转义字符
            queryParamsType:'',//设置请求参数格式
            queryParams: function queryParams(params) {
                var params = {
                    ordCode : $("#ordCode").val()
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
                    title: '产品编号'
                },{
                    field: 'itemName',
                    title: '产品名称'
                },{
                    field: 'itemSpec',
                    title: '产品规格'
                },{
                    field: 'itemLenth',
                    title: '长',
                    formatter:function (value,row,index) {
                        debugger;
                        return ['<input trpe="text" onchange="inserData(\'itemLenth\','+row.ckId+',this)" class="form-control" value="'+value+'"/>'].join('');
                    }
                },{
                    field: 'itemWidth',
                    title: '宽',
                    formatter:function (value,row,index) {
                        return ['<input trpe="text" onchange="inserData(\'itemWidth\','+row.ckId+',this)" class="form-control" value="'+value+'"/>'].join('');
                    }
                },{
                    field: 'itemThick',
                    title: '高',
                    formatter:function (value,row,index) {
                        return ['<input trpe="text" onchange="inserData(\'itemThick\','+row.ckId+',this)" class="form-control" value="'+value+'"/>'].join('');
                    }
                },{
                    field: 'itemNum',
                    title: '计量',
                    formatter:function (value,row,index) {
                        return ['<input trpe="text" onchange="inserData(\'itemNum\','+row.ckId+',this)" class="form-control" value="'+value+'"/>'].join('');
                    }
                },{
                    field: 'itemColor',
                    title: '产品颜色',
                    formatter:function (value,row,index) {
                        return ['<input trpe="text" onchange="inserData(\'itemColor\','+row.ckId+',this)" class="form-control" value="'+value+'"/>'].join('');
                    }
                },{
                    field: 'itemUnit',
                    title: '单位',
                    formatter:function (value,row,index) {
                        return ['<input trpe="text" onchange="inserData(\'itemUnit\','+row.ckId+',this)" class="form-control" value="'+value+'"/>'].join('');
                    }
                },{
                    field: 'itemOwner',
                    title: '收货人',
                    formatter:function (value,row,index) {
                        return ['<input trpe="text" onchange="inserData(\'itemOwner\','+row.ckId+',this)" class="form-control" value="'+value+'"/>'].join('');
                    }
                },{
                    field: 'blankPressTypeValue',
                    title: '压编',
                    formatter:function (value,row,index) {
                        return ['<input trpe="text" onchange="inserData(\'blankPressTypeValue\','+row.ckId+',this)" class="form-control" value="'+value+'"/>'].join('');
                    }
                },{
                    field: 'oper',
                    title: '操作',
                    events: operateEvents,
                    formatter: operProdFormatter
                }
            ]
        })
        $(".fixed-table-border")[1].style.height = '230px';
    });

    function operFormatter(value, row, index) {
        return [
            ' <button id="tableRowAdd" type="button" class="btn btn-default" ">添加</button>'
        ].join('');
    };

    function operProdFormatter(value, row, index) {
        return [
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
            "itemSpec":data.prodSpec,
            "itemLenth":"",
            "itemWidth":"",
            "itemThick":"",
            "itemUnit":"",
            "itemNum":"",
            "itemColor":"",
            "itemOwner":"",
            "blankPressTypeValue":""
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