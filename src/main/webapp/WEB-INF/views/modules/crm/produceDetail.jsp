<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>

<style>
    /*.btn-app{    background-color: #f4f4f4;    font-size: 20px;}*/
</style>

<link rel="stylesheet" href="/static/common/customize.css">






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
                                <a class="btn btn-success" id="wsStart" >
                                    <i class="fa fa-play"></i> 启动
                                </a>
                                <a class="btn btn-danger" id="wsStop" style="display: none;">
                                    <i class="fa fa-stop"></i> 停止
                                </a>
                                <a class="btn btn-warning" disabled="true">
                                    <i class="fa fa-repeat"></i> 归零
                                </a>
                                <a class="btn" disabled="true">
                                    <i class="fa fa-circle-o"></i> 去皮
                                </a>
                                <a class="btn btn-primary" disabled="true">
                                    <i class="fa fa-balance-scale"></i> 标重
                                </a>
                                <a class="btn btn-inverse" disabled="true">
                                    <i class="fa fa-tachometer"></i> 刻度
                                </a>
                                <a class="btn btn-info" disabled="true">
                                    <i class="fa fa-save"></i> 存盘
                                </a>
                            </div>

                            <div style="min-width: 270px;background-color: black;color:green; font-size: 30px;float:left;text-align: center;margin-left:15px;">
                                毛重：<span id="totalWeight">0.00</span> KG
                            </div>
                            <div style="min-width: 270px;background-color: black;color:green; font-size: 30px;float:left;text-align: center;margin-left:15px;">
                                皮：0.00 KG
                            </div>
                        </div>
                        <!-- /.box-body -->
                    </div>


                    <div class="ibox-content">
                        <div class="row">
                            <div class="col-sm-6 b-r">
                                <div class="ibox float-e-margins">
                                    <form method="get" class="form-horizontal">
                                        <div class="form-group">
                                            <label class="col-sm-5 control-label"> 订单标题：</label>
                                            <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                ${detail.orderTitle}
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group">
                                            <label class="col-sm-5 control-label"> 所属人：</label>
                                            <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                ${detail.itemOwner}
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group">
                                            <label class="col-sm-5 control-label"> 机台编号：</label>
                                            <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                ${detail.macCode}
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group">
                                            <label class="col-sm-5 control-label"> 长度：</label>
                                            <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                ${detail.itemLenth}m
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group">
                                            <label class="col-sm-5 control-label"> 厚度：</label>
                                            <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                ${detail.itemThick}m
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group">
                                            <label class="col-sm-5 control-label"> 重量：</label>
                                            <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                ${detail.itemTotalWeight}
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group">
                                            <label class="col-sm-5 control-label"> 压边类型：</label>
                                            <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                ${fns:getValueByDictKey(detail.itemYbType)}
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group">
                                            <label class="col-sm-5 control-label"> 配方：</label>
                                            <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                <textarea style="width: 250px;height: 200px;" readonly>${detail.formula}</textarea>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                    </form>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <form method="get" class="form-horizontal">
                                    <div class="form-group">
                                        <label class="col-sm-5 control-label"> 产品编号：</label>
                                        <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                            ${detail.itemCode}
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
                                    <div class="form-group">
                                        <label class="col-sm-5 control-label"> 品种：</label>
                                        <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                            ${fns:getValueByDictKey(detail.itemVariety)}
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
                                    <div class="form-group">
                                        <label class="col-sm-5 control-label"> 颜色：</label>
                                        <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                            ${fns:getDictValue(detail.itemColor, 'prod_color', defaultValue)}
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
                                    <div class="form-group">
                                        <label class="col-sm-5 control-label"> 宽度：</label>
                                        <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                            ${detail.itemWidth}m
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
                                    <div class="form-group">
                                        <label class="col-sm-5 control-label"> 数量：</label>
                                        <div class="col-sm-5" style="text-align:center;padding-top: 7px;" id="itemNum">
                                            ${detail.itemNum}
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
                                    <div class="form-group">
                                        <label class="col-sm-5 control-label"> 面积：</label>
                                        <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                            ${detail.itemTotalSq}㎡
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
                                    <div class="form-group">
                                        <label class="col-sm-5 control-label"> 延长米计算方式：</label>
                                        <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                            ${fns:getValueByDictKey(detail.itemYcType)}
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
                                    <div class="form-group">
                                        <label class="col-sm-5 control-label"> 操作：</label>
                                        <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                            <button class="btn btn-primary" type="button" id="inStock">入库</button>
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
                                    <input id="prodPlanDetailId" value="${detail.prodPlanDetailId}" type="hidden">
                                </form>
                            </div>

                        </div>
                        <div class="row">
                            <div class="form-group">
                                <button class="btn btn-primary" type="button" id="rePrint">重新打签</button>
                                <a class="btn btn-white"  href="${ctx}/crm/produce/list">返回</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>





<%--<div class="wrapper wrapper-content animated fadeInRight">--%>
    <%--<div class="tabs-container">--%>


        <%--&lt;%&ndash;<ul class="nav nav-tabs">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<li class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true">产品生产详情</a>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</ul>&ndash;%&gt;--%>


        <%--<div class="tab-content">--%>
            <%--<div id="tab-1" class="tab-pane active">--%>
                <%--<div class="panel-body">--%>

                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>


<script>
    $(document).ready(function () {

        $(".i-checks").iCheck({checkboxClass: "icheckbox_square-green", radioClass: "iradio_square-green",})
        $("#inStock").click(function () {
            $("#inStock").attr('disabled',"true");

            var totalWeight = $("#totalWeight").text();
            // if(totalWeight == null || parseFloat(totalWeight)<=0){
            //     top.$.jBox.tip('入库失败！原因：重量为0，请开启电子秤并称重后再行入库');
            //     $("#inStock").removeAttr('disabled');
            //     return;
            // }

            $.ajax({
                url: "/produce/produce/inStock",
                type: 'POST',
                data: {id:$("#prodPlanDetailId").val(),weight:totalWeight},
                dataType: 'json',
                success: function (result) {
                    if (result.itemNum>0) {
                        top.$.jBox.tip('入库成功');
                        $("#itemNum").text(result.itemNum);
                        doPrint();
                    } else if (result.itemNum == 0) {
                        top.$.jBox.tip('入库成功');
                        doPrint();
                        // var path = 'window.location.href = "/produce/producePlan/info?prodPlanCode='+prodPlanCode+'"';

                    }
                }
            });
            $("#inStock").removeAttr('disabled');
        });

        $("#rePrint").click(function () {
            doPrint();
        });
        function doPrint(){
            layer.open({
                type: 2,
                title: '打印标签确认',
                skin: 'layui-layer-rim', //加上边框
                area: ['300px', '300px'],
                content: ['/produce/produce/doPrint', 'yes'] //iframe的url，no代表不显示滚动条
            });
        }


        $("#wsStart").click(function () {
            send("start");
            $("#wsStart").hide();
            $("#wsStop").show();
        });
        $("#wsStop").click(function () {
            send("stop");
            $("#wsStart").show();
            $("#wsStop").hide();
        });

        var socket;
        if(!window.WebSocket){
            window.WebSocket = window.MozWebSocket;
        }
        if(window.WebSocket){
            socket = new WebSocket("ws://127.0.0.1:12345/ws");
            socket.onmessage = function(event){
                // document.getElementById('ttt').value =  event.data;
                var data = event.data.replace(" ","").replace("+","").replace("kg","");
                console.log(event.data);

                $("#totalWeight").text(data);
            };
            socket.onopen = function(event){
                // var ta = document.getElementById('responseText');
                // document.getElementById('ttt').value = ta;
                // ta.value = "Netty-WebSocket服务器。。。。。。连接  \r\n";
            };
            socket.onclose = function(event){
                // var ta = document.getElementById('responseText');
                //document.getElementById('ttt').value = ta;
                // ta.value = "Netty-WebSocket服务器。。。。。。关闭 \r\n";
            };
        }else{
            alert("您的浏览器不支持WebSocket协议！");
        }
        function send(message){
            if(!window.WebSocket){return;}
            if(socket.readyState == WebSocket.OPEN){
                socket.send(message);
            }else{
                alert("WebSocket 连接没有建立成功！");
            }

        }

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