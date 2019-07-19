<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>

<style>
    .btn-app{    background-color: #f4f4f4;    font-size: 20px;}
</style>

<div class="wrapper wrapper-content animated fadeInRight">
    <div class="tabs-container">


        <ul class="nav nav-tabs">
            <li class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true">产品生产详情</a>
            </li>
        </ul>
        <div class="tab-content">
            <div id="tab-1" class="tab-pane active">
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="box">
                                <div class="box-header with-border">
                                    <h3 class="box-title">计重设备</h3>
                                </div>
                                <!-- /.box-header -->
                                <div class="box-body" >
                                    <div style="float:left;    margin-bottom: 10px;">
                                        <a class="btn btn-app" id="wsStart" >
                                            <i class="fa fa-play"></i> 启动
                                        </a>
                                        <a class="btn btn-app" id="wsStop" style="display: none;">
                                            <i class="fa fa-stop"></i> 停止
                                        </a>
                                        <a class="btn btn-app" disabled="true">
                                            <i class="fa fa-repeat"></i> 归零
                                        </a>
                                        <a class="btn btn-app" disabled="true">
                                            <i class="fa fa-circle-o"></i> 去皮
                                        </a>
                                        <a class="btn btn-app" disabled="true">
                                            <i class="fa fa-balance-scale"></i> 标重
                                        </a>
                                        <a class="btn btn-app" disabled="true">
                                            <i class="fa fa-tachometer"></i> 刻度
                                        </a>
                                        <a class="btn btn-app" disabled="true">
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
                                                        <label class="col-sm-5 control-label"> 订单号：</label>
                                                        <div class="col-sm-5" style="text-align:center;padding-top: 7px;">
                                                                ${detail.ordCode}
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
                                            <button class="btn btn-primary" type="button" onclick="doPrint()">重新打签</button>
                                            <button class="btn btn-primary" type="button" onclick="history.go(-1)">返回</button>
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

<!--startprint-->
<div <%--style="display: none"--%>>
    <div style="width:100%;">
        <table  border="1" cellspacing="0" style="width:80%;height:180px;">
            <tr>
                <td colspan="2" style="height:1px;"></td>
            </tr>
            <tr>
                <td colspan="2" ><img id="imgcode" /></td>
            </tr>
            <tr>
                <td colspan="2"><font size=2 id="print_itemOwner">长寿莫-经销商-农户</font></td>
            </tr>
            <tr>
                <td style="width:50%"><font size=1 id="print_itemWidth">幅宽：13M</font></td>
                <td><font size=1 id="print_itemThick">厚度：0.08mm</font></td>
            </tr>
            <tr>
                <td><font size=1 id="print_itemLength">长度：188m</font></td>
                <td><font size=1 id="print_itemColor">颜色：白色</font></td>
            </tr>
            <tr>
                <td colspan="2"><font size=1 id="print_itemWeight">重量：188.8 kg</font></td>
            </tr>
            <tr>
                <td colspan="2"><font size=1 id="print_createTime">生产时间：2019-08-09 10:25:22</font></td>
            </tr>
            <tr>
                <td colspan="2"><font size=1 >联系人：纪经理 131 2547 8852</font></td>
            </tr>
        </table>
    </div>
</div>
<!--endprint-->

<script>
    $(document).ready(function () {
        $(".i-checks").iCheck({checkboxClass: "icheckbox_square-green", radioClass: "iradio_square-green",})
        $("#inStock").click(function () {
            $("#inStock").attr('disabled',"true");

            var totalWeight = $("#totalWeight").text();
            if(totalWeight == null || parseFloat(totalWeight)<=0){
                top.$.jBox.tip('入库失败！原因：重量为0，请开启电子秤并称重后再行入库');
                $("#inStock").removeAttr('disabled');
                return;
            }

            $.ajax({
                url: "/produce/produce/inStock",
                type: 'POST',
                data: {id:$("#prodPlanDetailId").val(),weight:totalWeight},
                dataType: 'json',
                success: function (result) {
                    if (result.itemNum>0) {
                        top.$.jBox.tip('入库成功');
                        $("#itemNum").text(result.itemNum);
                    } else if (result.itemNum == 0) {
                        top.$.jBox.tip('入库成功');
                        // 关闭ws
                        // 吊起打印
                    }
                    $("#imgcode").JsBarcode(result.barCode);
                }
            });
            $("#inStock").removeAttr('disabled');
        });

        function printPrepare(detail){

        }
        function doPrint(){
            JsBarcode("#imgcode", "051190330001111",{
                format: "CODE128",//选择要使用的条形码类型
                height:50,//高度
                displayValue:true,//是否在条形码下方显示文字
                fontSize:3,//设置文本的大小
                textPosition:"top",//设置文本的垂直位置
                background:"#eee",//设置条形码的背景
            });

            bdhtml = window.document.body.innerHTML;
            sprnstr = "<!--startprint-->";
            eprnstr = "<!--endprint-->";
            prnhtml = bdhtml.substring(bdhtml.indexOf(sprnstr) + 17);
            prnhtml = prnhtml.substring(0, prnhtml.indexOf(eprnstr));
            window.document.body.innerHTML = prnhtml;
            window.print();
            window.history.go(-1);
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