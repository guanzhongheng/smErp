<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<link href="${ctxStatic}/hPlugs/css/plugins/bootstrap-table/bootstrap-table.css" rel="stylesheet">
<link href="${ctxStatic}/hPlugs/css/plugins/bootstrap-table/bootstrap-table-fixed-columns.css" rel="stylesheet">
<link rel="stylesheet" href="/static/common/customize.css">








<div class="">
    <div class="">


        <%--<ul class="nav nav-tabs">--%>
            <%--<li class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true">生产计划详情</a>--%>
            <%--</li>--%>
        <%--</ul>--%>
        <div class="tab-content">
            <div id="tab-1" class="tab-pane active">
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-12">
                            <%--<div class="ibox-content">--%>








                                <div style="padding: 15px 20px 20px;">

                                    <form:form id="inputForm" modelAttribute="vo" action="${ctx}/produce/producePlan/update"
                                               method="post" class="form-horizontal">
                                        <div class="row">

                                            <div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
                                                <div class="panel-heading" style="background-color: #50B0E6">
                                                    <h3 class="panel-title global-panel-title" >
                                                        生产计划详情
                                                    </h3>
                                                </div>
                                                <div class="panel-body">


                                                    <div class="col-sm-6 b-r" style="border-right: 0px solid #e7eaec;">
                                                        <div class="ibox float-e-margins">
                                                            <form method="get" class="form-horizontal">
                                                                <div class="ibox-title" style="border-width: 4px 0px 0px 4px; border-color: #eaeaea; background-color: #f1f5f7">
                                                                    <h3>基本信息</h3>
                                                                </div>
                                                                <div class="hr-line-dashed" ></div>
                                                                <div class="form-group">
                                                                    <label class="col-sm-3 control-label" style="width: 200px"><i style="color: red"></i> 品种：</label>
                                                                    <div class="col-sm-8">
                                                                        <input class="form-control global-input-readonly" disabled placeholder="品种" readonly="readonly"
                                                                               value="${fns:getValueByDictKey(prodPlan.prodVariety)}"/>

                                                                    </div>
                                                                </div>
                                                                <div class="hr-line-dashed"></div>
                                                                <div class="form-group">
                                                                    <label class="col-sm-3 control-label" style="width: 200px"><i style="color: red"></i> 种类：</label>
                                                                    <div class="col-sm-8 ">
                                                                        <input class="form-control global-input-readonly" disabled placeholder="种类" readonly="readonly"
                                                                               value="${fns:getValueByDictKey(prodPlan.prodCgyCode)}"/>
                                                                    </div>
                                                                </div>
                                                                <div class="hr-line-dashed"></div>
                                                                <div class="form-group">
                                                                    <label class="col-sm-3 control-label" style="width: 200px"><i style="color: red"></i> 颜色：</label>
                                                                    <div class="col-sm-8">
                                                                        <input class="form-control global-input-readonly" disabled placeholder="种类" readonly="readonly"
                                                                               value="${fns:getDictValue(prodPlan.prodColor, 'prod_color', defaultValue)}"/>
                                                                    </div>
                                                                </div>
                                                                <div class="hr-line-dashed"></div>
                                                                <div class="form-group">
                                                                    <label class="col-sm-3 control-label" style="width: 200px"><i style="color: red"></i> 总数量：</label>
                                                                    <div class="col-sm-8">
                                                                        <input class="form-control global-input-readonly" disabled placeholder="种类" readonly="readonly"
                                                                               value="${prodPlan.totalQuantity}"/>
                                                                    </div>
                                                                </div>
                                                                <div class="hr-line-dashed"></div>
                                                                <div class="form-group">
                                                                    <label class="col-sm-3 control-label" style="width: 200px"><i style="color: red"></i> 已下发生产数量：</label>
                                                                    <div class="col-sm-8">
                                                                        <input class="form-control global-input-readonly" disabled placeholder="种类" readonly="readonly"
                                                                               value="${prodPlan.quantity}"/>
                                                                    </div>
                                                                </div>
                                                                <div class="hr-line-dashed"></div>

                                                                <div class="form-group">
                                                                    <label class="col-sm-3 control-label" style="width: 200px">机台：</label>
                                                                    <div class="col-sm-8">
                                                                        <input class="form-control global-input-readonly" disabled placeholder="种类" readonly="readonly"
                                                                               value="${prodPlan.macCode}"/>
                                                                    </div>
                                                                </div>
                                                            </form>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-6" style="border-left: 1px solid #e7eaec;">
                                                        <div class="ibox-title" style="border-width: 4px 0px 0px 4px; border-color: #eaeaea; background-color: #f1f5f7">
                                                            <h3>配方信息</h3>
                                                        </div>

                                                        <div class="hr-line-dashed"></div>
                                                        <div class="form-group">
                                                            <label class="col-md-2 control-label order-detail-label-margin" style="width: 200px;text-align: right"><i style="color: red"></i>
                                                                请选择配方:
                                                            </label>
                                                            <label class="col-md-2 control-label" style="text-align: left">
                                                                <select data-placeholder="请选择配方"  class="chosen-select order-label-input-width global-input" id="formulaSelect" onchange="loadTableData(this)">
                                                                    <option value="-1" selected>请选择</option>
                                                                    <c:forEach items="${formulaList}" var="formula">

                                                                        <option value="${formula.fCode}" >${formula.fName}</option>
                                                                    </c:forEach>
                                                                </select>
                                                            </label>
                                                        </div>
                                                        <div class="hr-line-dashed"></div>



                                                        <div class="row" style="text-align: center;">
                                                            <label class="control-label">外层配比(190℃)</label>
                                                        </div>
                                                        <div class="form-group" style="text-align: -webkit-center;">
                                                            <div class="control-group table-responsive" style="width:400px;text-align: center;" >
                                                                <table id="outerTable" class="table table-striped table-bordered table-hover text-nowrap" >
                                                                    <%--<thead>--%>
                                                                    <%--<tr>--%>
                                                                        <%--<th style="text-align: center">原料</th>--%>
                                                                        <%--<th style="text-align: center">数量</th>--%>
                                                                    <%--</tr>--%>
                                                                    <%--</thead>--%>
                                                                    <%--<tbody>--%>
                                                                    <%--<c:forEach items="${list}" var="vo">--%>
                                                                        <%--<tr>--%>
                                                                            <%--<td>${vo.ordCode}</td>--%>
                                                                            <%--<td>${vo.itemCode}</td>--%>
                                                                        <%--</tr>--%>
                                                                    <%--</c:forEach>--%>
                                                                    <%--</tbody>--%>
                                                                </table>
                                                            </div>
                                                        </div>

                                                        <div class="row" style="text-align: center;">
                                                            <label class="control-label">中层配比(195℃)</label>
                                                        </div>
                                                        <div class="form-group"  style="text-align: -webkit-center;">
                                                            <div class="control-group table-responsive" style="width:400px;text-align: center;" >
                                                                <table id="midderTable" data-height="300" class="table table-striped table-bordered table-hover text-nowrap" >
                                                                    <%--<thead>--%>
                                                                    <%--<tr>--%>
                                                                        <%--<th style="text-align: center">原料</th>--%>
                                                                        <%--<th style="text-align: center">数量</th>--%>
                                                                    <%--</tr>--%>
                                                                    <%--</thead>--%>
                                                                    <%--<tbody>--%>
                                                                    <%--<c:forEach items="${list}" var="vo">--%>
                                                                        <%--<tr>--%>
                                                                            <%--<td>${vo.ordCode}</td>--%>
                                                                            <%--<td>${vo.itemCode}</td>--%>
                                                                        <%--</tr>--%>
                                                                    <%--</c:forEach>--%>
                                                                    <%--<tr>--%>
                                                                        <%--<td>南方一年长寿母料（5%）</td>--%>
                                                                        <%--<td>0.5袋（12.5公斤）</td>--%>
                                                                    <%--</tr>--%>
                                                                    <%--</tbody>--%>
                                                                </table>
                                                            </div>
                                                        </div>

                                                        <div class="row" style="text-align: center;">
                                                            <label class="control-label">内层配比(210℃)</label>
                                                        </div>
                                                        <div class="form-group"  style="text-align: -webkit-center;">
                                                            <div class="control-group table-responsive" style="width:400px;text-align: center;" >
                                                                <table id="innerTable" data-height="300" class="table table-striped table-bordered table-hover text-nowrap" >
                                                                    <%--<thead>--%>
                                                                    <%--<tr>--%>
                                                                        <%--<th style="text-align: center">原料</th>--%>
                                                                        <%--<th style="text-align: center">数量</th>--%>
                                                                    <%--</tr>--%>
                                                                    <%--</thead>--%>
                                                                    <%--<tbody>--%>
                                                                    <%--<c:forEach items="${list}" var="vo">--%>
                                                                        <%--<tr>--%>
                                                                            <%--<td>${vo.ordCode}</td>--%>
                                                                            <%--<td>${vo.itemCode}</td>--%>
                                                                        <%--</tr>--%>
                                                                    <%--</c:forEach>--%>
                                                                    <%--</tbody>--%>
                                                                </table>
                                                            </div>
                                                        </div>


                                                        <div class="hr-line-dashed"></div>
                                                        <div class="form-group" style="text-align: center;">
                                                            <button class="btn btn-primary global-button-style" type="submit" style="width: 180px" >保 存</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </form:form>
                                </div>
                        </div>
                    </div>
                    <div class="tabs-container" style="padding: 0px 5px;">
                        <div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
                            <div class="panel-heading" style="background-color: #50B0E6">
                                <h3 class="panel-title global-panel-title" >
                                    生产计划详情-产品列表
                                </h3>
                            </div>
                            <div class="panel-body" style="padding: 10px 10px 0px 10px;">
                                <%--<div class="ibox-content timeline" style="overflow-x: auto; overflow-y: auto;">--%>
                                <div class="control-group table-responsive" >
                                    <table id="contentTable" data-height="300" class="table table-striped table-bordered table-hover text-nowrap" >
                                        <thead>
                                        <tr>
                                            <th style="text-align: center"><input type="checkbox" id="checkAll" onchange="checkedAll(this)" /></th>
                                            <th style="text-align: center">订单号</th>
                                            <th style="text-align: center">产品编号</th>
                                            <th style="text-align: center">所属人</th>
                                            <th style="text-align: center">机台编号</th>
                                            <th style="text-align: center">品种</th>
                                            <th style="text-align: center">类别</th>
                                            <th style="text-align: center">颜色</th>
                                            <th style="text-align: center">长度(m)</th>
                                            <th style="text-align: center">宽度(m)</th>
                                            <th style="text-align: center">厚度(m)</th>
                                            <th style="text-align: center">数量</th>
                                            <th style="text-align: center">重量</th>
                                            <th style="text-align: center">面积(㎡)</th>
                                            <th style="text-align: center">压边类型</th>
                                            <th style="text-align: center">延长米计算方式</th>
                                            <th style="text-align: center">状态</th>
                                            <%--<th style="width: 50px">操作</th>--%>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${list}" var="vo">
                                            <tr>
                                                <td>
                                                    <c:if test="${vo.itemStatus eq '48'}">
                                                        <input type="checkbox" name="detailId" value="${vo.id}">
                                                    </c:if>
                                                </td>
                                                <td>${vo.ordCode}</td>
                                                <td>${vo.itemCode}</td>
                                                <td>${vo.itemOwner}</td>
                                                <td>${vo.macCode}</td>
                                                <td>${fns:getValueByDictKey(vo.itemVariety)}</td>
                                                <td>${fns:getValueByDictKey(vo.itemCgyCode)}</td>
                                                <td>${fns:getDictValue(vo.itemColor, 'prod_color', defaultValue)}</td>
                                                <td>${vo.itemLenth}</td>
                                                <td>${vo.itemWidth}</td>
                                                <td>${vo.itemThick}</td>
                                                <td>${vo.itemNum}</td>
                                                <td>${vo.itemTotalWeight}</td>
                                                <td>${vo.itemTotalSq}</td>
                                                <td>${fns:getValueByDictKey(vo.itemYbType)}</td>
                                                <td>${fns:getValueByDictKey(vo.itemYcType)}</td>
                                                <td style="color: #08c;">
                                                    <c:if test="${vo.itemStatus eq '48'}">待确认</c:if>
                                                    <c:if test="${vo.itemStatus eq '49'}">已下发</c:if>
                                                    <c:if test="${vo.itemStatus eq '50'}">已完成</c:if>
                                                </td>
                                                    <%--<td>按钮：移出机台</td>--%>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="row">
                                    <br/>
                                            <button class="btn btn-primary global-button-style" style="margin-left: 100px;margin-bottom: 10px;" type="button" id="distribution">下发生产</button>
                                            <button class="btn btn-white global-button-style" style="margin-bottom: 10px;" type="button" onclick="history.go(-1)">返回</button>
                                    <br/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function () {
        $(".i-checks").iCheck({checkboxClass: "icheckbox_square-green", radioClass: "iradio_square-green",})

        // $("#formulaSelect").change(function(){
        //
        //     $("#product_type option[value='"+$('#product_name option:selected').val()+"']").prop("selected",true);
        //
        // });
    });

    $("#distribution").click(function () {
        <!-- 针对选中客户进行操作 -->
        var str = getCheckValue();
        var prodPlanCode = $("#prodPlanCode").val();
        var path = 'window.location.href = "/produce/producePlan/info?prodPlanCode='+prodPlanCode+'"';
        if (str.length > 0) {
            $.ajax({
                url: "/produce/producePlanDetail/updateBatch",
                type: 'POST',
                data: {ids:str },
                dataType: 'json',
                success: function (result) {
                    if(result >0){
                        top.$.jBox.tip('下发成功');
                        self.setTimeout(path, 2000);
                    }else {
                        top.$.jBox.tip('下发失败，请联系管理员');
                    }

                }
            });

        }else{
            top.$.jBox.tip('最少选中一条记录');
        }

    });

    function getCheckValue(){
        debugger;
        var obj = document.getElementsByName("detailId");
        var check_val = '';
        for(k in obj){
            if(obj[k].checked)
                check_val = check_val + obj[k].value + ",";
        }
        check_val = check_val.replace(",,",",");
        return check_val;
    }

    function checkedAll(obj){
        var codes = document.getElementsByName("detailId")
        if(obj.checked){
            for(var i=0;i<codes.length;i++){
                codes[i].checked = true;
            }
        }else{
            for(var i=0;i<codes.length;i++){
                codes[i].checked = false;
            }
        }
    }

    // $("#formulaSelect").change(
    //     function(){
    //         $("#outerTable").bootstrapTable({
    //             url:'/tRawMaterial/get',
    //             pagination: false,  //表格底部显示分页条
    //             sidePagination: "server",
    //             escape:false, //启动转义字符
    //             queryParamsType:'',//设置请求参数格式
    //             queryParams: function queryParams(params) {
    //                 debugger;
    //                 var fCode = $("#formulaSelect").val()
    //                 if(fCode != null && fCode != '' && fCode != 'undefined'){
    //                     var params = {
    //                         fCode : fCode,
    //                         key : "outer"
    //                     }
    //                 }
    //                 return params;
    //             },
    //             columns: [
    //                 {
    //                     field: 'Number',
    //                     title: '序号',
    //                     align: 'center',
    //                     valign: 'middle',
    //                     width: 50,
    //                     formatter: function (value, row, index) {
    //                         return index + 1;
    //                     }
    //                 }, {
    //                     field: 'rawmName',
    //                     title: '原料',
    //                     align: 'center',
    //                     valign: 'middle',
    //                     width: 300,
    //                 }, {
    //                     field: 'weight',
    //                     title: '数量',
    //                     align: 'center',
    //                     valign: 'middle',
    //                     width: 100,
    //                 }
    //             ],
    //             onLoadSuccess: function (res) {  //加载成功时执行
    //                 console.log(res);
    //             },
    //             onLoadError: function () {  //加载失败时执行
    //                 console.info("加载数据失败");
    //                 toastr.error("加载数据失败");
    //             }
    //         });
    //     }
    // )

    function loadTableData() {
        $("#outerTable").bootstrapTable('destroy');
        $("#outerTable").bootstrapTable({
            url:'/tRawMaterial/getByFormula',
            pagination: false,  //表格底部显示分页条
            sidePagination: "server",
            escape:false, //启动转义字符
            queryParamsType:'',//设置请求参数格式
            queryParams: function queryParams(params) {
                debugger;
                var fCode = $("#formulaSelect").val()
                if(fCode != null && fCode != '' && fCode != 'undefined'){
                    var params = {
                        fCode : fCode,
                        key : "outer"
                    }
                }
                return params;
            },
            columns: [
                {
                    field: 'Number',
                    title: '序号',
                    align: 'center',
                    valign: 'middle',
                    width: 50,
                    formatter: function (value, row, index) {
                        return index + 1;
                    }
                }, {
                    field: 'rawmName',
                    title: '原料',
                    align: 'center',
                    valign: 'middle',
                    width: 300,
                }, {
                    field: 'weight',
                    title: '数量',
                    align: 'center',
                    valign: 'middle',
                    width: 100,
                }
            ],
            onLoadSuccess: function (res) {  //加载成功时执行
                console.log(res);
            },
            onLoadError: function () {  //加载失败时执行
                console.info("加载数据失败");
                toastr.error("加载数据失败");
            }
        });

        $("#midderTable").bootstrapTable('destroy');
        $("#midderTable").bootstrapTable({
            url:'/tRawMaterial/getByFormula',
            pagination: false,  //表格底部显示分页条
            sidePagination: "server",
            escape:false, //启动转义字符
            queryParamsType:'',//设置请求参数格式
            queryParams: function queryParams(params) {
                debugger;
                var fCode = $("#formulaSelect").val()
                if(fCode != null && fCode != '' && fCode != 'undefined'){
                    var params = {
                        fCode : fCode,
                        key : "inner"
                    }
                }
                return params;
            },
            columns: [
                {
                    field: 'Number',
                    title: '序号',
                    align: 'center',
                    valign: 'middle',
                    width: 50,
                    formatter: function (value, row, index) {
                        return index + 1;
                    }
                }, {
                    field: 'rawmName',
                    title: '原料',
                    align: 'center',
                    valign: 'middle',
                    width: 300,
                }, {
                    field: 'weight',
                    title: '数量',
                    align: 'center',
                    valign: 'middle',
                    width: 100,
                }
            ],
            onLoadSuccess: function (res) {  //加载成功时执行
                console.log(res);
            },
            onLoadError: function () {  //加载失败时执行
                console.info("加载数据失败");
                toastr.error("加载数据失败");
            }
        });

        $("#innerTable").bootstrapTable('destroy');
        $("#innerTable").bootstrapTable({
            url:'/tRawMaterial/getByFormula',
            pagination: false,  //表格底部显示分页条
            sidePagination: "server",
            escape:false, //启动转义字符
            queryParamsType:'',//设置请求参数格式
            queryParams: function queryParams(params) {
                debugger;
                var fCode = $("#formulaSelect").val()
                if(fCode != null && fCode != '' && fCode != 'undefined'){
                    var params = {
                        fCode : fCode,
                        key : "inner"
                    }
                }
                return params;
            },
            columns: [
                {
                    field: 'Number',
                    title: '序号',
                    align: 'center',
                    valign: 'middle',
                    width: 50,
                    formatter: function (value, row, index) {
                        return index + 1;
                    }
                }, {
                    field: 'rawmName',
                    title: '原料',
                    align: 'center',
                    valign: 'middle',
                    width: 300,
                }, {
                    field: 'weight',
                    title: '数量',
                    align: 'center',
                    valign: 'middle',
                    width: 100,
                }
            ],
            onLoadSuccess: function (res) {  //加载成功时执行
                console.log(res);
            },
            onLoadError: function () {  //加载失败时执行
                console.info("加载数据失败");
                toastr.error("加载数据失败");
            }
        });
    }

</script>

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