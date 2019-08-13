<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<link href="${ctxStatic}/hPlugs/css/plugins/bootstrap-table/bootstrap-table.css" rel="stylesheet">
<link href="${ctxStatic}/hPlugs/css/plugins/bootstrap-table/bootstrap-table-fixed-columns.css" rel="stylesheet">
<link rel="stylesheet" href="/static/common/customize.css">


<div class="">
    <div class="tab-content">
        <div id="tab-1" class="tab-pane active">
            <div class="panel-body">
                <div class="row">
                    <div class="col-sm-12">
                        <div style="padding: 15px 20px 20px;">
                            <form class="form-horizontal" >
                                <input type="hidden" id="prodPlanId" value="${prodPlan.prodPlanCode}">
                                <div class="row">
                                    <div class="panel panel-default"
                                         style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
                                        <div class="panel-heading" style="background-color: #50B0E6">
                                            <h3 class="panel-title global-panel-title">
                                                生产计划详情
                                            </h3>
                                        </div>
                                        <div class="panel-body">
                                            <div class="col-sm-6 b-r">
                                                <div>
                                                    <div class="col-sm-1" style="text-align: right">
                                                        <i style="background-color: blue;width: 10px;">&nbsp;</i>
                                                    </div>
                                                    <div style="width: 150px">
                                                        <h3>基本信息</h3>
                                                    </div>
                                                </div>
                                                <div class="hr-line-dashed"></div>
                                                <div class="form-group">
                                                    <label class="col-md-4" style="text-align: right;font-size: 17px;">产品品种:</label>
                                                    <label class="col-md-5"
                                                           style="font-size: 17px;">${fns:getValueByDictKey(prodPlan.prodVariety)}</label>
                                                </div>
                                                <div class="hr-line-dashed"></div>
                                                <div class="form-group">
                                                    <label class="col-md-4" style="text-align: right;font-size: 17px;">产品种类:</label>
                                                    <label class="col-md-5"
                                                           style="font-size: 17px;">${fns:getValueByDictKey(prodPlan.prodCgyCode)}</label>
                                                </div>
                                                <div class="hr-line-dashed"></div>
                                                <div class="form-group">
                                                    <label class="col-md-4" style="text-align: right;font-size: 17px;">产品颜色:</label>
                                                    <label class="col-md-5"
                                                           style="font-size: 17px;">${fns:getDictValue(prodPlan.prodColor, 'prod_color', defaultValue)}</label>
                                                </div>
                                                <div class="hr-line-dashed"></div>
                                                <div class="form-group">
                                                    <label class="col-md-4" style="text-align: right;font-size: 17px;">总数量:</label>
                                                    <label class="col-md-5"
                                                           style="font-size: 17px;">${prodPlan.totalQuantity}</label>
                                                </div>
                                                <div class="hr-line-dashed"></div>
                                                <div class="form-group">
                                                    <label class="col-md-4" style="text-align: right;font-size: 17px;">已下发生产数量:</label>
                                                    <label class="col-md-5"
                                                           style="font-size: 17px;">${prodPlan.quantity}</label>
                                                </div>
                                                <div class="hr-line-dashed"></div>
                                                <div class="form-group">
                                                    <label class="col-md-4" style="text-align: right;font-size: 17px;">生产机台:</label>
                                                    <label class="col-md-5"
                                                           style="font-size: 17px;">${prodPlan.macCode}</label>
                                                </div>
                                            </div>
                                            <div class="col-sm-6" style="border-left: 1px solid #e7eaec;">
                                                <div>
                                                    <div class="col-sm-1" style="text-align: right">
                                                        <i style="background-color: blue;width: 10px;">&nbsp;</i>
                                                    </div>
                                                    <div style="width: 150px">
                                                        <h3>配方信息</h3>
                                                    </div>
                                                </div>
                                                <div class="hr-line-dashed"></div>
                                                <div class="form-group">
                                                    <label class="col-md-2 control-label"
                                                           style="width: 160px;text-align: right;font-size: 17px;"><i
                                                            style="color: red"></i>
                                                        请选择配方:
                                                    </label>
                                                    <div class="col-md-2" style="text-align: left;width:150px ">
                                                        <select data-placeholder="请选择配方"
                                                                class="chosen-select"
                                                                id="formulaSelect" onchange="loadTableData(this)"
                                                                style="width: 100%">
                                                            <option value="-1" selected>请选择</option>
                                                            <c:forEach items="${formulaList}" var="formula">
                                                                <option value="${formula.fCode}">${formula.fName}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="col-md-2 " style="text-align: left">
                                                        <button class="btn btn-primary"
                                                                type="button" style="width: 85px" onclick="saveFormu()">保存配方
                                                        </button>
                                                    </div>

                                                </div>
                                                <div class="hr-line-dashed"></div>
                                                <div class="tabs-container">
                                                    <ul class="nav nav-tabs">
                                                        <li class="active"><a data-toggle="tab" href="#tab-out"
                                                                              aria-expanded="true">外层配比</a>
                                                        </li>
                                                        <li class=""><a data-toggle="tab" href="#tab-middle"
                                                                        aria-expanded="false">中层配比</a>
                                                        </li>
                                                        <li class=""><a data-toggle="tab" href="#tab-in"
                                                                        aria-expanded="false">内层配比</a>
                                                        </li>
                                                    </ul>
                                                    <div class="tab-content">
                                                        <div id="tab-out" class="tab-pane active">
                                                            <div class="panel-body" style="min-height: 300px">
                                                                <div class="row" style="height: 20px;">
                                                                    <div class="col-sm-7" style="text-align: right">
                                                                        <h3>摄氏温度(<span id="outTemp">0</span>度)</h3>
                                                                    </div>
                                                                    <div class="col-sm-5" style="text-align: right">
                                                                        <button class="btn btn-primary" type="button" onclick="insertOutTable('outer')">新增</button>
                                                                    </div>
                                                                </div>
                                                                <div class="hr-line-dashed"></div>
                                                                <table id="outerTable"
                                                                       class="table table-bordered" style="height: 100%">
                                                                </table>
                                                            </div>
                                                        </div>
                                                        <div id="tab-middle" class="tab-pane">
                                                            <div class="panel-body" style="min-height: 300px">
                                                                <div class="row" style="height: 20px;">
                                                                    <div class="col-sm-7" style="text-align: right">
                                                                        <h3>摄氏温度(<span id="midTemp">0</span>度)</h3>
                                                                    </div>
                                                                    <div class="col-sm-5" style="text-align: right">
                                                                        <button class="btn btn-primary" type="button" onclick="insertOutTable('midder')">新增</button>
                                                                    </div>
                                                                </div>
                                                                <div class="hr-line-dashed"></div>
                                                                <table id="midderTable"
                                                                       class="table table-bordered"  style="height: 100%">
                                                                </table>
                                                            </div>
                                                        </div>
                                                        <div id="tab-in" class="tab-pane">
                                                            <div class="panel-body" style="min-height: 300px">
                                                                <div class="row" style="height: 20px;">
                                                                    <div class="col-sm-7" style="text-align: right">
                                                                        <h3>摄氏温度(<span id="inTemp">0</span>度)</h3>
                                                                    </div>
                                                                    <div class="col-sm-5" style="text-align: right">
                                                                        <button class="btn btn-primary" type="button" onclick="insertOutTable('inner')">新增</button>
                                                                    </div>
                                                                </div>
                                                                <div class="hr-line-dashed"></div>
                                                                <table id="innerTable"
                                                                       class="table table-bordered"  style="height: 100%">
                                                                </table>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="tabs-container" style="padding: 0px 5px;">
                    <div class="panel panel-default"
                         style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
                        <div class="panel-heading" style="background-color: #50B0E6">
                            <h3 class="panel-title global-panel-title">
                                生产计划详情-产品列表
                            </h3>
                        </div>
                        <div class="panel-body" style="padding: 10px 10px 0px 10px;">
                            <%--<div class="ibox-content timeline" style="overflow-x: auto; overflow-y: auto;">--%>
                            <div class="control-group table-responsive">
                                <table id="contentTable" data-height="300"
                                       class="table table-striped table-bordered table-hover text-nowrap">
                                    <thead>
                                    <tr>
                                        <th style="text-align: center"><input type="checkbox" id="checkAll"
                                                                              onchange="checkedAll(this)"/></th>
                                        <th style="text-align: center">订单号</th>
                                        <th style="text-align: center">产品编号</th>
                                        <th style="text-align: center">所属人</th>
                                        <th style="text-align: center">机台编号</th>
                                        <th style="text-align: center">品种</th>
                                        <th style="text-align: center">类别</th>
                                        <th style="text-align: center">颜色</th>
                                        <th style="text-align: center">长度(m)</th>
                                        <th style="text-align: center">宽度(m)</th>
                                        <th style="text-align: center">厚度(cm)</th>
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
                                            <td>${fns:getDictValue(vo.itemYbType, 'prod_ybType', defaultValue)}</td>
                                            <td>${fns:getDictValue(vo.itemYcType, 'prod_ycType', defaultValue)}</td>
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
                                <button class="btn btn-primary global-button-style"
                                        style="margin-left: 100px;margin-bottom: 10px;" type="button"
                                        id="distribution">下发生产
                                </button>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <button class="btn btn-white global-button-style" style="margin-bottom: 10px;"
                                        type="button" onclick="history.go(-1)">返回
                                </button>
                                <br/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    var outFormuList = [];
    var midderFormuList = [];
    var innerFormuList = [];

    var maxOutDataIndex = 1;
    var maxMidDataIndex = 1;
    var maxInDataIndex = 1;

    var FormuInfo = '${prodPlan.formula}';

    function tranDate(target) {
        var indexInfo = 1;
        if(target == "outer"){
            maxOutDataIndex = maxOutDataIndex + 1;
            indexInfo = maxOutDataIndex;
        }else if(target == "midder"){
            maxMidDataIndex = maxMidDataIndex + 1;
            indexInfo = maxMidDataIndex;
        }else if(target == "inner"){
            maxInDataIndex = maxInDataIndex + 1;
            indexInfo = maxInDataIndex;
        }

        var formu = {
            "ckId":indexInfo,
            "rawmCode":"",
            "rawmName":"",
            "weight":"",
        }
        return formu;
    }

    var rawList = new Array();

    $.ajax({
        type: "POST",
        url: '/formula/ajaxRmList',
        dataType:'json',
        cache: false,
        success: function(data){
            if(data != null){
                rawList = data;
            }
        }
    });

    function doProcessData(){

        if(FormuInfo != null && FormuInfo.length > 0){
            var obj = JSON.parse(FormuInfo);
            if(obj.outer != null){
                $("#outTemp").text(obj.outer.temperature);
                $("#outerTable").bootstrapTable("load",obj.outer.rawMaterialVos);
                outFormuList = obj.outer.rawMaterialVos;
                $('#outerTable .chosen-select').chosen();
                document.getElementsByName("fixed-table-body01")[0].setAttribute("class","");
            }
            if(obj.midder != null){
                $("#midTemp").text(obj.midder.temperature);
                $("#midderTable").bootstrapTable("load",obj.midder.rawMaterialVos);
                midderFormuList = obj.midder.rawMaterialVos;
                $('#midderTable .chosen-select').chosen();
                document.getElementsByName("fixed-table-body01")[1].setAttribute("class","");
            }
            if(obj.inner != null){
                $("#inTemp").text(obj.inner.temperature);
                $("#innerTable").bootstrapTable("load",obj.inner.rawMaterialVos);
                innerFormuList = obj.inner.rawMaterialVos;
                $('#innerTable .chosen-select').chosen();
                document.getElementsByName("fixed-table-body01")[2].setAttribute("class","");
            }
            $(".chosen-container").css('width',"100%");
            $(".loading-text").hide();
        }
    }

    $(document).ready(function () {
        $(".i-checks").iCheck({checkboxClass: "icheckbox_square-green", radioClass: "iradio_square-green",})
        $("#outerTable").bootstrapTable({
            url: '',
            pagination: false,  //表格底部显示分页条
            sidePagination: "server",
            escape: false, //启动转义字符
            queryParamsType: '',//设置请求参数格式
            columns: [
                {
                    field: 'ckId',
                    title: '序号',
                    width: '60px',
                    formatter:function (value,row,index){
                        if(index == 0){
                            maxOutDataIndex = 1;
                        }else{
                            maxOutDataIndex = maxOutDataIndex + 1;
                        }
                        row.ckId = maxOutDataIndex;
                        return maxOutDataIndex;
                    }
                },
                {
                    field: 'rawmCode',
                    title: '原料',
                    align: 'center',
                    valign: 'middle',
                    width: '30%',
                    formatter:rawOutFormater
                }, {
                    field: 'weight',
                    title: '数量',
                    align: 'center',
                    width: '30%',
                    valign: 'middle',
                    formatter:function (value,row,index) {
                        return ['<input type="text" style="width: 100%;" onchange="inserNumData(\'weight\','+row.ckId+',this,\'outer\')" class="form-control" value="'+value+'"/>'].join('');
                    }
                },{
                    field: 'oper',
                    title: '操作',
                    align: 'center',
                    events: operatePdEvents,
                    formatter:operForOutFormatter
                }
            ],
            onLoadSuccess: function (res) {  //加载成功时执行
                outFormuList = $("#outerTable").bootstrapTable("getData");
            },
            onLoadError: function () {  //加载失败时执行
                console.info("加载数据失败");
                toastr.error("加载数据失败");
            }
        });
        $("#midderTable").bootstrapTable({
            url: '',
            pagination: false,  //表格底部显示分页条
            sidePagination: "server",
            escape: false, //启动转义字符
            queryParamsType: '',//设置请求参数格式
            columns: [
                {
                    field: 'ckId',
                    title: '序号',
                    width: '60px',
                    formatter:function (value,row,index){
                        if(index == 0){
                            maxMidDataIndex = 1;
                        }else{
                            maxMidDataIndex = maxMidDataIndex + 1;
                        }
                        row.ckId = maxMidDataIndex;
                        return maxMidDataIndex;
                    }
                },
                {
                    field: 'rawmCode',
                    title: '原料',
                    align: 'center',
                    width: '30%',
                    valign: 'middle',
                    formatter:rawMidFormater
                }, {
                    field: 'weight',
                    title: '数量',
                    align: 'center',
                    width: '30%',
                    valign: 'middle',
                    formatter:function (value,row,index) {
                        return ['<input type="text" style="width: 100%;" onchange="inserNumData(\'weight\','+row.ckId+',this,\'midder\')" class="form-control" value="'+value+'"/>'].join('');
                    }
                },{
                    field: 'oper',
                    title: '操作',
                    align: 'center',
                    events: operatePdEvents,
                    formatter:operForMidFormatter
                }
            ],
            onLoadSuccess: function (res) {  //加载成功时执行

                midderFormuList = $("#outerTable").bootstrapTable("getData");
            },
            onLoadError: function () {  //加载失败时执行
                console.info("加载数据失败");
                toastr.error("加载数据失败");
            }
        });
        $("#innerTable").bootstrapTable({
            url: '',
            pagination: false,  //表格底部显示分页条
            sidePagination: "server",
            escape: false, //启动转义字符
            queryParamsType: '',//设置请求参数格式
            columns: [
                {
                    field: 'ckId',
                    title: '序号',
                    width: '60px',
                    formatter:function (value,row,index){
                        if(index == 0){
                            maxInDataIndex = 1;
                        }else{
                            maxInDataIndex = maxInDataIndex + 1;
                        }
                        row.ckId = maxInDataIndex;
                        return maxInDataIndex;
                    }
                },
                {
                    field: 'rawmCode',
                    title: '原料',
                    align: 'center',
                    width: '30%',
                    valign: 'middle',
                    formatter:rawInFormater
                }, {
                    field: 'weight',
                    title: '数量',
                    align: 'center',
                    width: '30%',
                    valign: 'middle',
                    formatter:function (value,row,index) {
                        return ['<input type="text" style="width: 100%;" onchange="inserNumData(\'weight\','+row.ckId+',this,\'inner\')" class="form-control" value="'+value+'"/>'].join('');
                    }
                },{
                    field: 'oper',
                    title: '操作',
                    align: 'center',
                    events: operatePdEvents,
                    formatter:operForInnerFormatter
                }
            ],
            onLoadSuccess: function (res) {  //加载成功时执行
                innerFormuList = $("#outerTable").bootstrapTable("getData");
            },
            onLoadError: function () {  //加载失败时执行
                console.info("加载数据失败");
                toastr.error("加载数据失败");
            }
        });
        setTimeout("doProcessData()",600); //();
    });

    window.operatePdEvents = {
        "click #outTableRowdelete" : function(e,value,row,index){

            for(var i=0;i<outFormuList.length;i++){
                if(outFormuList[i].ckId == row.ckId){
                    outFormuList.splice(i,1);
                    break;
                }
            }
            $("#outerTable").bootstrapTable("load",outFormuList);
            $('#outerTable .chosen-select').chosen();
            document.getElementsByName("fixed-table-body01")[0].setAttribute("class","");
        },
        "click #midTableRowdelete" : function(e,value,row,index){

            for(var i=0;i<midderFormuList.length;i++){
                if(midderFormuList[i].ckId == row.ckId){
                    midderFormuList.splice(i,1);
                    break;
                }
            }
            $("#midderTable").bootstrapTable("load",midderFormuList);
            $('#midderTable .chosen-select').chosen();
            document.getElementsByName("fixed-table-body01")[1].setAttribute("class","");
        },
        "click #innerTableRowdelete" : function(e,value,row,index){

            for(var i=0;i<innerFormuList.length;i++){
                if(innerFormuList[i].ckId == row.ckId){
                    innerFormuList.splice(i,1);
                    break;
                }
            }
            $("#innerTable").bootstrapTable("load",innerFormuList);
            $('#innerTable .chosen-select').chosen();
            document.getElementsByName("fixed-table-body01")[2].setAttribute("class","");
        }
    }

    <!--  下拉封装开始  -->

    function rawOutFormater(value,row,index) {

        var option;
        var headOption = "<option value =''>请选择</option>";

        if(rawList == null || rawList.length == 0){
            $.ajax({
                type: "POST",
                url: '/formula/ajaxRmList',
                dataType:'json',
                cache: false,
                success: function(data){
                    if(data != null){
                        rawList = data;
                        if(rawList != null || rawList != undefined){
                            $.each(rawList,function(i,obj){
                                if(value == obj.rawmCode){
                                    headOption = headOption + "<option value='"+obj.rawmCode+"' selected>"+obj.rawmName+"</option>";
                                }else{
                                    headOption = headOption + "<option value='"+obj.rawmCode+"'>"+obj.rawmName+"</option>";
                                }
                            });
                        }
                        option  = '<select class="chosen-select" id="rawmCode"'+row.ckId+' onchange="inserNumData(\'rawmCode\','+row.ckId+',this,\'outer\')" style="width: 150px;height:33px;">'+
                            headOption + '</select>';

                        return [option].join('');
                    }
                }
            });
        }else{
            $.each(rawList,function(i,obj){
                if(value == obj.rawmCode){
                    headOption = headOption + "<option value='"+obj.rawmCode+"' selected>"+obj.rawmName+"</option>";
                }else{
                    headOption = headOption + "<option value='"+obj.rawmCode+"'>"+obj.rawmName+"</option>";
                }
            });
            option  = '<select class="chosen-select" id="rawmCode"'+row.ckId+' onchange="inserNumData(\'rawmCode\','+row.ckId+',this,\'outer\')" style="width: 150px;height:33px;">'+
                headOption + '</select>';

            return [option].join('');
        }
    }

    function rawMidFormater(value,row,index) {

        var option;
        var headOption = "<option value =''>请选择</option>";
        if(rawList == null || rawList.length == 0){
            $.ajax({
                type: "POST",
                url: '/formula/ajaxRmList',
                dataType:'json',
                cache: false,
                success: function(data){
                    if(data != null){
                        rawList = data;
                        if(rawList != null || rawList != undefined){
                            $.each(rawList,function(i,obj){
                                if(value == obj.rawmCode){
                                    headOption = headOption + "<option value='"+obj.rawmCode+"' selected>"+obj.rawmName+"</option>";
                                }else{
                                    headOption = headOption + "<option value='"+obj.rawmCode+"'>"+obj.rawmName+"</option>";
                                }
                            });
                        }
                        option  = '<select class="chosen-select" id="rawmCode"'+row.ckId+' onchange="inserNumData(\'rawmCode\','+row.ckId+',this,\'midder\')" style="width: 150px;height:33px;">'+
                            headOption + '</select>';
                        return [option].join('');
                    }
                }
            });
        }else{
            $.each(rawList,function(i,obj){
                if(value == obj.rawmCode){
                    headOption = headOption + "<option value='"+obj.rawmCode+"' selected>"+obj.rawmName+"</option>";
                }else{
                    headOption = headOption + "<option value='"+obj.rawmCode+"'>"+obj.rawmName+"</option>";
                }
            });
            option  = '<select class="chosen-select" id="rawmCode"'+row.ckId+' onchange="inserNumData(\'rawmCode\','+row.ckId+',this,\'midder\')" style="width: 150px;height:33px;">'+
                headOption + '</select>';

            return [option].join('');
        }
    }

    function rawInFormater(value,row,index) {

        var option;
        var headOption = "<option value =''>请选择</option>";
        if(rawList == null || rawList.length == 0){
            $.ajax({
                type: "POST",
                url: '/formula/ajaxRmList',
                dataType:'json',
                cache: false,
                success: function(data){
                    if(data != null){
                        rawList = data;
                        if(rawList != null || rawList != undefined){
                            $.each(rawList,function(i,obj){
                                if(value == obj.rawmCode){
                                    headOption = headOption + "<option value='"+obj.rawmCode+"' selected>"+obj.rawmName+"</option>";
                                }else{
                                    headOption = headOption + "<option value='"+obj.rawmCode+"'>"+obj.rawmName+"</option>";
                                }
                            });
                        }
                        option  = '<select class="chosen-select" id="rawmCode"'+row.ckId+' onchange="inserNumData(\'rawmCode\','+row.ckId+',this,\'inner\')" style="width: 150px;height:33px;">'+
                            headOption + '</select>';

                        return [option].join('');
                    }
                }
            });
        }else{

            $.each(rawList,function(i,obj){
                if(value == obj.rawmCode){
                    headOption = headOption + "<option value='"+obj.rawmCode+"' selected>"+obj.rawmName+"</option>";
                }else{
                    headOption = headOption + "<option value='"+obj.rawmCode+"'>"+obj.rawmName+"</option>";
                }
            });
            option  = '<select class="chosen-select" id="rawmCode"'+row.ckId+' onchange="inserNumData(\'rawmCode\','+row.ckId+',this,\'inner\')" style="width: 150px;height:33px;">'+
                headOption + '</select>';

            return [option].join('');
        }

    }

    function inserNumData(name,index,obj,target) {

        if(target == "outer"){
            for(var i=0;i<outFormuList.length;i++){
                if(outFormuList[i].ckId == index){
                    for(var key in outFormuList[i]){
                        if(key == name){
                            if(name == 'rawmCode' && obj.value.length > 0){
                                outFormuList[i]['rawmCode'] = obj.value;
                                outFormuList[i]['rawmName'] = obj.selectedOptions[0].text;
                            }else{
                                outFormuList[i][key] = obj.value;
                            }
                        }

                    }
                }
            }
            $("#outerTable").bootstrapTable("load",outFormuList);
            $('#outerTable .chosen-select').chosen();
            document.getElementsByName("fixed-table-body01")[0].setAttribute("class","");
        }else if(target == "midder"){
            for(var i=0;i<midderFormuList.length;i++){
                if(midderFormuList[i].ckId == index){
                    for(var key in midderFormuList[i]){
                        if(key == name){
                            if(name == 'rawmCode' && obj.value.length > 0){
                                midderFormuList[i]['rawmCode'] = obj.value;
                                midderFormuList[i]['rawmName'] = obj.selectedOptions[0].text;
                            }else{
                                midderFormuList[i][key] = obj.value;
                            }
                        }
                    }
                }
            }
            $("#midderTable").bootstrapTable("load",midderFormuList);
            $('#midderTable .chosen-select').chosen();
            document.getElementsByName("fixed-table-body01")[1].setAttribute("class","");
        }else if(target == "inner"){
            for(var i=0;i<innerFormuList.length;i++){
                if(innerFormuList[i].ckId == index){
                    for(var key in innerFormuList[i]){
                        if(key == name){
                            if(name == 'rawmCode' && obj.value.length > 0){
                                innerFormuList[i]['rawmCode'] = obj.value;
                                innerFormuList[i]['rawmName'] = obj.selectedOptions[0].text;
                            }else{
                                innerFormuList[i][key] = obj.value;
                            }
                        }
                    }
                }
            }
            $("#innerTable").bootstrapTable("load",innerFormuList);
            $('#innerTable .chosen-select').chosen();
            document.getElementsByName("fixed-table-body01")[2].setAttribute("class","");
        }
    }


    function operForOutFormatter(){
        return [
            ' <button id="outTableRowdelete" type="button" class="btn-primary" style="height: 28px;">删除</button>'
        ].join('');
    }

    function operForMidFormatter(){
        return [
            ' <button id="midTableRowdelete" type="button" class="btn-primary" style="height: 28px;">删除</button>'
        ].join('');
    }

    function operForInnerFormatter(){
        return [
            ' <button id="innerTableRowdelete" type="button" class="btn-primary" style="height: 28px;">删除</button>'
        ].join('');
    }

    function saveFormu(){
        var outTem = $("#outTemp").text();
        var midTem = $("#midTemp").text();
        var inTem = $("#inTemp").text();
        var prodPlanId = $("#prodPlanId").val();

        if(prodPlanId != null){
            var formula =
                {
                    "outer": {
                        "temperature": outTem,
                        "rawMaterialVos": outFormuList
                    },
                    "midder": {
                        "temperature": midTem,
                        "rawMaterialVos": midderFormuList
                    },
                    "inner": {
                        "temperature": inTem,
                        "rawMaterialVos": innerFormuList
                    }

                };
            var reqData = {
                "prodPlanCode":prodPlanId,
                "formula": JSON.stringify(formula)
            }
            $.ajax({
                type: "post",
                url: "/produce/producePlan/update",
                data: JSON.stringify(reqData),
                dataType: "json",
                contentType:"application/json",
                success: function (msg) {

                    if(msg == "1"){
                        top.$.jBox.tip('保存成功！');
                    }else{
                        top.$.jBox.tip('保存失败！');
                    }
                }
            });
        }
    }

    function insertOutTable(target){

        if(target == "outer"){
            outFormuList.push(tranDate(target));
            $("#outerTable").bootstrapTable("load",outFormuList);
            $('#outerTable .chosen-select').chosen();
            document.getElementsByName("fixed-table-body01")[0].setAttribute("class","");
        }else if(target == "midder"){
            midderFormuList.push(tranDate(target));
            $("#midderTable").bootstrapTable("load",midderFormuList);
            $('#midderTable .chosen-select').chosen();
            document.getElementsByName("fixed-table-body01")[1].setAttribute("class","");
        }else if(target == "inner"){
            innerFormuList.push(tranDate(target));
            $("#innerTable").bootstrapTable("load",innerFormuList);
            $('#innerTable .chosen-select').chosen();
            document.getElementsByName("fixed-table-body01")[2].setAttribute("class","");
        }
    }

    $("#distribution").click(function () {
        <!-- 针对选中客户进行操作 -->
        var str = getCheckValue();
        var prodPlanCode = $("#prodPlanCode").val();
        var path = 'window.location.href = "/produce/producePlan/info?prodPlanCode=' + prodPlanCode + '"';
        if (str.length > 0) {
            $.ajax({
                url: "/produce/producePlanDetail/updateBatch",
                type: 'POST',
                data: {ids: str},
                dataType: 'json',
                success: function (result) {
                    if (result > 0) {
                        top.$.jBox.tip('下发成功');
                        self.setTimeout(path, 2000);
                    } else {
                        top.$.jBox.tip('下发失败，请联系管理员');
                    }

                }
            });

        } else {
            top.$.jBox.tip('最少选中一条记录');
        }

    });

    function getCheckValue() {
        var obj = document.getElementsByName("detailId");
        var check_val = '';
        for (k in obj) {
            if (obj[k].checked)
                check_val = check_val + obj[k].value + ",";
        }
        check_val = check_val.replace(",,", ",");
        return check_val;
    }

    function checkedAll(obj) {
        var codes = document.getElementsByName("detailId")
        if (obj.checked) {
            for (var i = 0; i < codes.length; i++) {
                codes[i].checked = true;
            }
        } else {
            for (var i = 0; i < codes.length; i++) {
                codes[i].checked = false;
            }
        }
    }
    function loadTableData(obj) {

        $("#outerTable").bootstrapTable({});
        $("#midderTable").bootstrapTable({});
        $("#innerTable").bootstrapTable({});
        if(obj != null && obj.value != -1){
            $.ajax({
                url: "/tRawMaterial/getByFormula",
                type: 'POST',
                data:{
                    "fCode": obj.value
                },
                dataType: 'json',
                success: function (result) {

                    if(result.outer != null && result.outer != undefined){
                        $("#outTemp").text(result.outer.temperature);
                        $("#outerTable").bootstrapTable("load",result.outer.rawMaterialVos);
                        outFormuList = result.outer.rawMaterialVos;
                        $('#outerTable .chosen-select').chosen();
                        document.getElementsByName("fixed-table-body01")[0].setAttribute("class","");
                    }
                    if(result.midder != null && result.midder != undefined){
                        $("#midTemp").text(result.midder.temperature);
                        $("#midderTable").bootstrapTable("load",result.midder.rawMaterialVos);
                        midderFormuList = result.midder.rawMaterialVos;
                        $('#midderTable .chosen-select').chosen();
                        document.getElementsByName("fixed-table-body01")[1].setAttribute("class","");
                    }
                    if(result.inner != null && result.inner != undefined){
                        $("#inTemp").text(result.inner.temperature);
                        $("#innerTable").bootstrapTable("load",result.inner.rawMaterialVos);
                        innerFormuList = result.inner.rawMaterialVos;
                        $('#innerTable .chosen-select').chosen();
                        document.getElementsByName("fixed-table-body01")[2].setAttribute("class","");
                    }
                    $(".chosen-container").css('width',"100%");
                    $(".loading-text").hide();
                }
            })
        }


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