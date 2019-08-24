<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>

<style>
    /*谷歌，去掉input type=number 时框内的加减按钮*/
    input::-webkit-outer-spin-button,
    input::-webkit-inner-spin-button {
        -webkit-appearance: none;
        appearance: none;
        margin: 0;
    }
    /* 火狐，去掉input type=number 时框内的加减按钮 */
    input{
        -moz-appearance:textfield;
    }

</style>

<link rel="stylesheet" href="/static/common/customize.css">
<link rel="stylesheet" href="${ctxStatic}/hPlugs/css/plugins/switch/bootstrap-switch.min.css">


<div class="tabs-container" style="padding: 20px 20px;">
    <div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
        <div class="panel-heading" style="background-color: #50B0E6">
            <h3 class="panel-title global-panel-title" >
                产品生产详情
            </h3>
        </div>
        <div class="panel-body" style="padding: 10px 10px 0px 10px;">
            <div class="row">
                <div class="col-sm-12">
                    <div class="box">
                        <%--<div class="box-header with-border">--%>
                            <%--<h3 class="box-title">计重设备</h3>--%>
                        <%--</div>--%>
                        <!-- /.box-header -->
                        <div class="box-body" >
                            <div style="float:left;    margin-bottom: 10px;">
                                <a class="btn btn-success" id="totalStart" style="width: 120px;">
                                    <i class="fa fa-play"></i> 毛重称重
                                </a>
                                <a class="btn btn-danger" id="wsStop" style="display: none;width: 120px;">
                                    <i class="fa fa-stop"></i> 停止称重
                                </a>
                                <a class="btn btn-warning" id="clear" style="width: 120px;">
                                    <i class="fa fa-repeat"></i> 归零
                                </a>
                                <a class="btn btn-info" id="tareStart" style="width: 120px;">
                                    <i class="fa fa-circle-o"></i> 去皮
                                </a>
                                <a class="btn btn-primary" id="weightHand" style="width: 120px;">
                                    <i class="fa fa-hand-pointer-o"></i> 手录重量
                                </a>
                                <a class="btn btn-primary" id="weightAuto" style="width: 120px;display: none;">
                                    <i class="fa fa-retweet"></i> 称量重量
                                </a>
                                <%--<a class="btn btn-primary" disabled="true">--%>
                                    <%--<i class="fa fa-balance-scale"></i> 标重--%>
                                <%--</a>--%>
                                <%--<a class="btn btn-inverse" disabled="true">--%>
                                    <%--<i class="fa fa-tachometer"></i> 刻度--%>
                                <%--</a>--%>
                                <%--<a class="btn btn-info" disabled="true">--%>
                                    <%--<i class="fa fa-save"></i> 存盘--%>
                                <%--</a>--%>
                            </div>

                            <div style="min-width: 270px;background-color: black;color:green; font-size: 30px;float:left;text-align: center;margin-left:15px;">
                                重量：<span id="totalWeightAuto">0.00</span>
                                <input id="totalWeightHand" hidden type="number" style="background-color: #4f4b19;width: 100px;height: 40px;"/>
                                KG
                            </div>
                            <div>
                                
                            </div>
                            <div style="min-width: 270px;background-color: black;color:green; font-size: 30px;float:left;text-align: center;margin-left:15px;">
                                皮：<span id="tareWeightAuto">0.00</span>
                                <input id="tareWeightHand" hidden type="number" style="background-color: #4f4b19;width: 100px;height: 40px;"/>
                                KG
                            </div>
                        </div>
                        <!-- /.box-body -->
                    </div>


                    <div class="ibox-content">
                        <div class="row">
                            <div class="col-sm-8 b-r">
                                <div class="ibox float-e-margins">
                                    <form method="get" class="form-horizontal">
                                        <div>
                                            <div style="width: 170px">
                                                <h3><i style="background-color: blue;width: 10px;">&nbsp;</i> &nbsp;&nbsp;基本信息</h3>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed" ></div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" style="margin-left: -25px;"><i style="color: red"></i>订单标题:</label>
                                            <div class="col-sm-4">
                                                <input id="prodPlanDetailId" value="${detail.prodPlanDetailId}" type="hidden">
                                                <input disabled="ture" placeholder="订单标题" value="${detail.orderTitle}"
                                                       class="form-control produceDetail-input-readonly" readonly="true"/>

                                            </div>
                                            <label class="col-sm-2 control-label"><i style="color: red"></i>所属人:</label>
                                            <div class="col-sm-4 ">
                                                <input disabled="ture" placeholder="所属人" value="${detail.itemOwner}"
                                                       class="form-control produceDetail-input-readonly" readonly="true"/>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" style="margin-left: -25px;"><i style="color: red"></i>机台编号:</label>
                                            <div class="col-sm-4">
                                                <input disabled="ture" placeholder="机台编号" value="${detail.macCode}" id="macCode"
                                                       class="form-control produceDetail-input-readonly" readonly="true"/>
                                            </div>
                                            <label class="col-sm-2 control-label"><i style="color: red"></i>产品编号:</label>
                                            <div class="col-sm-4">
                                                <input disabled="ture" placeholder="产品编号" value="${detail.itemCode}"
                                                       class="form-control produceDetail-input-readonly" readonly="true"/>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" style="margin-left: -25px;"><i style="color: red"></i>品种:</label>
                                            <div class="col-sm-4">
                                                <input disabled="ture" placeholder="品种" value="${fns:getValueByDictKey(detail.itemVariety)}"
                                                       class="form-control produceDetail-input-readonly" readonly="true"/>
                                            </div>
                                            <label class="col-sm-2 control-label">颜色:</label>
                                            <div class="col-sm-4">
                                                <input disabled="ture" placeholder="颜色" value="${fns:getDictValue(detail.itemColor, 'prod_color', defaultValue)}"
                                                       class="form-control produceDetail-input-readonly" readonly="true"/>
                                            </div>
                                        </div>

                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" style="margin-left: -25px;">长度(m):</label>
                                            <div class="col-sm-4">
                                                <input disabled="ture" placeholder="长度" value="${detail.itemLenth}" id="itemLenth"
                                                       class="form-control produceDetail-input-readonly" readonly="true"/>
                                            </div>
                                            <label class="col-sm-2 control-label"><i style="color: red"></i>宽度(m):</label>
                                            <div class="col-sm-4">
                                                <input disabled="ture" placeholder="宽度" value="${detail.itemWidth}"
                                                       class="form-control produceDetail-input-readonly" readonly="true"/>
                                            </div>
                                        </div>

                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" style="margin-left: -25px;">厚度(mm):</label>
                                            <div class="col-sm-4">
                                                <input disabled="ture" placeholder="厚度" value="${detail.itemThick}"
                                                       class="form-control produceDetail-input-readonly" readonly="true"/>
                                            </div>
                                            <label class="col-sm-2 control-label">数量:</label>
                                            <div class="col-sm-4">
                                                <input disabled="ture" placeholder="数量" value="${detail.itemNum}" id="itemNum"
                                                       class="form-control produceDetail-input-readonly" readonly="true"/>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" style="margin-left: -25px;">重量:</label>
                                            <div class="col-sm-4">
                                                <input disabled="ture" placeholder="重量" value="${detail.itemTotalWeight}"
                                                       class="form-control produceDetail-input-readonly" readonly="true"/>
                                            </div>
                                            <label class="col-sm-2 control-label">面积(m&sup2):</label>
                                            <div class="col-sm-4">
                                                <input disabled="ture" placeholder="面积" value="${detail.itemTotalSq}"
                                                       class="form-control produceDetail-input-readonly" readonly="true"/>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" style="margin-left: -25px;">压边类型:</label>
                                            <div class="col-sm-4">
                                                <input disabled="ture" placeholder="压边类型" value="${fns:getDictValue(detail.itemYbType, 'prod_ybType', defaultValue)}"
                                                       class="form-control produceDetail-input-readonly" readonly="true"/>
                                            </div>
                                            <label class="col-sm-2 control-label"  style="padding-left: inherit;">延长米计算方式:</label>
                                            <div class="col-sm-4">
                                                <input disabled="ture" placeholder="延长米计算方式" value="${fns:getDictValue(detail.itemYcType, 'prod_ycType', defaultValue)}"
                                                       class="form-control produceDetail-input-readonly" readonly="true"/>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" style="margin-left: -25px;">起止码:</label>
                                            <div class="col-sm-4">
                                                <input type="checkbox" checked class="checkbox" />
                                                <input type="number" placeholder="起码" id="seCode_s" style="width: 65px;display: inline"
                                                       class="form-control produceDetail-input-readonly">
                                                 一
                                                <input disabled="ture" placeholder="止码" style="width: 65px;display:inline" id="seCode_e"
                                                       class="form-control produceDetail-input-readonly" readonly="true"/>
                                            </div>
                                            <label class="col-sm-2 control-label"  style="padding-left: inherit;">计价方式:</label>
                                            <div class="col-sm-4">
                                                <input type="hidden" value="${detail.itemPriceType}" id="itemPriceType">
                                                <input disabled="ture" placeholder="计价方式" value="${fns:getValueByDictKey(detail.itemPriceType)}"
                                                       class="form-control produceDetail-input-readonly" readonly="true"/>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-md-12 " >
                                                    <button class="btn btn-primary global-button-style" type="button" id="inStock">入 库</button>
                                                    <button class="btn btn-warning global-button-style" type="button" id="rePrint" disabled="true">重新打签</button>
                                                    <button class="btn btn-warning global-button-style" type="button" id="printCertNew" disabled="true">合格证(新版)</button>
                                                    <button class="btn btn-warning global-button-style" type="button" id="printCertRed" disabled="true">合格证(红)</button>
                                                    <button class="btn btn-warning global-button-style" type="button" id="printCertGreen" disabled="true">合格证(绿)</button>
                                                    <button class="btn btn-warning global-button-style" type="button" id="printCertYellow" disabled="true">合格证(黄)</button>
                                                    <button class="btn btn-white global-button-style" type="button" onclick="javascript:window.location.replace(document.referrer); ">返回</button>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div>
                                    <div class="col-sm-1" style="text-align: right">
                                        <i style="background-color: blue;width: 10px;">&nbsp;</i>
                                    </div>
                                    <div style="width: 150px">
                                        <h3>配方信息</h3>
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div style="height: 640px;OVERFLOW-Y: auto;OVERFLOW-X:hidden;">

                                        <div class="row" style="text-align: center;">
                                            <label class="control-label">外层配比(<span id="outTemp">0</span>℃)</label>
                                        </div>
                                        <div class="form-group" style="text-align: -webkit-center;">
                                            <div class="control-group table-responsive" style="text-align: center;" >
                                                <table id="outerTable" class="table table-striped table-bordered table-hover text-nowrap" >
                                                    <thead>
                                                    <tr>
                                                    <th style="text-align: center">原料</th>
                                                    <th style="text-align: center">数量</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>

                                        <div class="row" style="text-align: center;">
                                            <label class="control-label">中层配比(<span id="midTemp">0</span>℃)</label>
                                        </div>
                                        <div class="form-group"  style="text-align: -webkit-center;">
                                            <div class="control-group table-responsive" style="text-align: center;" >
                                                <table id="midderTable" data-height="300" class="table table-striped table-bordered table-hover text-nowrap" >
                                                    <thead>
                                                    <tr>
                                                    <th style="text-align: center">原料</th>
                                                    <th style="text-align: center">数量</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>

                                        <div class="row" style="text-align: center;">
                                            <label class="control-label">内层配比(<span id="inTemp">0</span>℃)</label>
                                        </div>
                                        <div class="form-group"  style="text-align: -webkit-center;">
                                            <div class="control-group table-responsive" style="text-align: center;" >
                                                <table id="innerTable" data-height="300" class="table table-striped table-bordered table-hover text-nowrap" >
                                                    <thead>
                                                    <tr>
                                                    <th style="text-align: center">原料</th>
                                                    <th style="text-align: center">数量</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
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

    var FormuInfo = '${detail.formula}';

    function getTableInfo(){
        debugger;
        var outerTable = "";
        var midderTable = "";
        var innerTable = "";

        if(FormuInfo != null && FormuInfo != undefined){

            var obj = JSON.parse(FormuInfo);
            if(obj.outer != null){
                $("#outTemp").text(obj.outer.temperature);
                $.each(obj.outer.rawMaterialVos,function (index,o) {
                    outerTable += "<tr><td>" + o.rawmName + "</td><td>" + o.weight + "</td></tr>";
                })
            }
            if(obj.midder != null){
                $("#midTemp").text(obj.midder.temperature);
                if(obj.midder!=null && obj.midder.rawMaterialVos != null) {
                    $.each(obj.midder.rawMaterialVos, function (index, o) {
                        midderTable += "<tr><td>" + o.rawmName + "</td><td>" + o.weight + "</td></tr>";
                    })
                }
            }
            if(obj.inner != null){
                $("#inTemp").text(obj.inner.temperature);
                if(obj.inner!=null && obj.inner.rawMaterialVos != null){
                    $.each(obj.inner.rawMaterialVos,function (index,o) {
                        innerTable += "<tr><td>" + o.rawmName + "</td><td>" + o.weight + "</td></tr>";
                    })
                }
            }
            debugger;
            $("#outerTable").append(outerTable);
            $("#midderTable").append(midderTable);
            $("#innerTable").append(innerTable);
        }

    }

    $(document).ready(function () {

        /*计重相关逻辑*/
        var weightType ;
        var weightFlag = 'auto';
        var openFlag = false;
        $("#totalStart").click(function () {
            debugger;
            weightType = 'total';
            // if(!openFlag){
                send("start");
            // }
            $("#totalStart").hide();
            $("#wsStop").show();
            $("#tareStart").attr('disabled',"true");
        });
        $("#wsStop").click(function () {
            send("stop");
            $("#totalStart").show();
            $("#wsStop").hide();
        });
        $("#clear").click(function () {
            weightType ='';
            send("stop");
            $("#totalWeightAuto").text("0.00");
            $("#tareWeightAuto").text("0.00");
            $("#tareStart").removeAttr('disabled');
            $("#totalStart").show();
            $("#wsStop").hide();
        });
        $("#tareStart").click(function () {
            weightType = 'tare';
            // if(!openFlag){
                send("start");
            // }
            $("#tareStart").attr('disabled',"true");
        });

        $("#weightHand").click(function () {
            weightFlag = 'hand';
            $("#totalWeightHand").show();
            $("#totalWeightAuto").hide();

            $("#tareWeightHand").show();
            $("#tareWeightAuto").hide();
            if(parseInt($("#totalWeightAuto").text()) != 0 && $("#totalWeightAuto").text() != null){
                $("#tareWeightHand").val($("#tareWeightAuto").text());
            }

            $("#weightAuto").show();
            $("#weightHand").hide();
        });
        $("#weightAuto").click(function () {
            weightFlag = 'auto';
            $("#totalWeightHand").hide();
            $("#totalWeightAuto").show();

            $("#tareWeightHand").hide();
            $("#tareWeightAuto").show();
            if(parseInt($("#tareWeightHand").val()) != 0 && $("#tareWeightHand").val() != null){
                $("#tareWeightAuto").text($("#tareWeightHand").val());
            }

            $("#weightAuto").hide();
            $("#weightHand").show();
        });

        // 起止码逻辑
        $(".checkbox").bootstrapSwitch({
            onText : "开启",      // 设置ON文本  
            offText : "关闭",    // 设置OFF文本  
            onColor : "success",// 设置ON文本颜色     (info/success/warning/danger/primary)  
            offColor : "danger",  // 设置OFF文本颜色        (info/success/warning/danger/primary)  
            size : "normal",    // 设置控件大小,从小到大  (mini/small/normal/large)  
            handleWidth:"30",//设置控件宽度
            // 当开关状态改变时触发  
            onSwitchChange : function(event, state) {
                if (state == true) {
                    $("#seCode_s").removeAttr('disabled');
                } else {
                    $("#seCode_s").attr('disabled',"true");
                    $("#seCode_s").val("");
                    $("#seCode_e").val("");
                }
            }
        });  

        $("#seCode_s").bind('input propertychange', function(){
            var itemLenth = $("#itemLenth").val();
            if(itemLenth != null){
                if($("#seCode_s").val() == null || $("#seCode_s").val() == ''){
                    $("#seCode_e").val('');
                }else{
                    $("#seCode_e").val(parseFloat(itemLenth)+parseFloat($("#seCode_s").val()));
                }
            }
        });

        $("#inStock").click(function () {
            if($("#itemPriceType").val() == 141001){
                if(weightFlag == 'auto'){
                    if(parseInt($("#totalWeightAuto").text()) == 0 || $("#totalWeightAuto").text() == null){
                        top.$.jBox.tip('当前计价方式必须称重后才能入库！');
                        return;
                    }
                }else{
                    if(parseInt($("#totalWeightHand").text()) == 0 || $("#totalWeightHand").text() == null){
                        top.$.jBox.tip('当前计价方式必须称重后才能入库！');
                        return;
                    }
                }
            }

            $("#inStock").attr('disabled',"true");

            var totalWeight = weightFlag == 'auto' ? $("#totalWeightAuto").text():$("#totalWeightHand").val();
            var tareWeight = weightFlag == 'auto' ? $("#tareWeightAuto").text():$("#tareWeightHand").val();
            var seCode;
            if($("#seCode_s").val() != null && $("#seCode_s").val() != ''){
                seCode = $("#seCode_s").val()+'-'+ $("#seCode_e").val();
            }

            $.ajax({
                url: "/produce/produce/inStock",
                type: 'POST',
                data: {id:$("#prodPlanDetailId").val(),weight:totalWeight,tare:tareWeight,seCode:seCode},
                dataType: 'json',
                success: function (result) {
                    if (result.itemNum>0) {
                        top.$.jBox.tip('入库成功');
                        $("#inStock").removeAttr('disabled');
                    } else if (result.itemNum == 0) {
                        top.$.jBox.tip('入库成功,请在完成打印操作后点击返回按钮');
                        // var path = 'window.location.href = "/produce/producePlan/info?prodPlanCode='+prodPlanCode+'"';
                    }
                    $("#itemNum").val(result.itemNum);
                    doPrint($("#macCode").val());
                }
            });

            $("#rePrint").removeAttr('disabled');
            $("#printCertNew").removeAttr('disabled');
            $("#printCertRed").removeAttr('disabled');
            $("#printCertGreen").removeAttr('disabled');
            $("#printCertYellow").removeAttr('disabled');
        });


        // 打印逻辑
        $("#rePrint").click(function () {
            doPrint($("#macCode").val());
        });
        function doPrint(macCode){
            layer.open({
                type: 2,
                title: '打印标签确认',
                skin: 'layui-layer-rim', //加上边框
                area: ['450px', '350px'],
                content: ['/produce/produce/doPrint?macCode='+macCode, 'yes'] //iframe的url，no代表不显示滚动条
            });
        }
        $("#printCertNew").click(function () {
            layer.open({
                type: 2,
                title: '打印合格证确认',
                skin: 'layui-layer-rim', //加上边框
                area: ['800px', '800px'],
                content: ['/produce/produce/printCert?type=new&macCode='+$("#macCode").val(), 'yes'] //iframe的url，no代表不显示滚动条
            });
        });
        $("#printCertRed").click(function () {
            layer.open({
                type: 2,
                title: '打印合格证确认',
                skin: 'layui-layer-rim', //加上边框
                area: ['800px', '800px'],
                content: ['/produce/produce/printCert?type=red&macCode='+$("#macCode").val(), 'yes'] //iframe的url，no代表不显示滚动条
            });
        });
        $("#printCertGreen").click(function () {

            layer.open({
                type: 2,
                title: '打印合格证确认',
                skin: 'layui-layer-rim', //加上边框
                area: ['800px', '800px'],
                content: ['/produce/produce/printCert?type=green&macCode='+$("#macCode").val(), 'yes'] //iframe的url，no代表不显示滚动条
            });
        });
        $("#printCertYellow").click(function () {
            layer.open({
                type: 2,
                title: '打印合格证确认',
                skin: 'layui-layer-rim', //加上边框
                area: ['800px', '800px'],
                content: ['/produce/produce/printCert?type=yellow&macCode='+$("#macCode").val(), 'yes'] //iframe的url，no代表不显示滚动条
            });
        });

        // 连接电子秤逻辑
        var socket;
        if(!window.WebSocket){
            window.WebSocket = window.MozWebSocket;
        }
        if(window.WebSocket){
            debugger;
            socket = new WebSocket("ws://127.0.0.1:12345/ws");
            socket.onmessage = function(event){
                debugger;
                var data = event.data.replace(" ","").replace("+","").replace("kg","");
                if(weightType == 'total'){
                    $("#totalWeight").text(data);
                }else if(weightType == 'tare'){
                    $("#tareWeight").text(data);
                }
            };
            socket.onopen = function(event){
                openFlag = true;
                // var ta = document.getElementById('responseText');
                // document.getElementById('ttt').value = ta;
                // ta.value = "Netty-WebSocket服务器。。。。。。连接  \r\n";
            };
            socket.onclose = function(event){
                openFlag = false;
                // var ta = document.getElementById('responseText');
                //document.getElementById('ttt').value = ta;
                // ta.value = "Netty-WebSocket服务器。。。。。。关闭 \r\n";
            };
        }else{
            alert("您的浏览器不支持WebSocket协议！");
        }
        function send(message){
            debugger;
            if(!window.WebSocket){return;}
            if(socket.readyState == WebSocket.OPEN){
                socket.send(message);
            }else{
                alert("电子秤连接失败！");
            }
        }
        getTableInfo();
    });
</script>
<script src="${ctxStatic}/hPlugs/js/jquery.min.js?v=2.1.4" type="text/javascript"></script>
<script src="${ctxStatic}/hPlugs/js/bootstrap.min.js?v=3.3.6" type="text/javascript"></script>
<script src="${ctxStatic}/hPlugs/js/content.min.js?v=1.0.0" type="text/javascript"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/chosen/chosen.jquery.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/peity/jquery.peity.min.js"></script>
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
<script src="${ctxStatic}/hPlugs/js/plugins/JsBarcode/JsBarcode.all.min.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/layer/layer.min.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/switch/bootstrap-switch.min.js"></script>