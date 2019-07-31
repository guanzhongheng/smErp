<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>

<link href="${ctxStatic}/hPlugs/css/plugins/bootstrap-table/bootstrap-table.css" rel="stylesheet">
<link href="${ctxStatic}/hPlugs/css/plugins/bootstrap-table/bootstrap-table-fixed-columns.css" rel="stylesheet">
<link rel="stylesheet" href="/static/common/customize.css">





<div class="tabs-container" style="padding: 20px 20px;">
    <div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
        <div class="panel-heading" style="background-color: #50B0E6">
            <h3 class="panel-title global-panel-title" >
                出库单详情
            </h3>
        </div>
        <div class="panel-body" style="padding: 10px 10px 0px 10px;">
            <div class="row">
                <div class="col-sm-12">
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">

                        <label class="col-md-2 control-label order-detail-label-margin" style="text-align: right"><i style="color: red"></i>
                            收货人:
                        </label>
                        <label class="col-md-2 control-label order-label-input-width">
                            <input type="text" class="form-control" name="" id="receiver"/>
                        </label>

                        <label class="col-md-2 control-label  order-detail-label-margin order-input-width" style="text-align: right">
                            联系方式:
                        </label>
                        <label class="col-md-2 control-label order-input-width " style="text-align: left">
                            <input type="text" class="form-control" name="" id="phone"/>
                        </label>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12">
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">
                        <label class="col-md-2 control-label  order-detail-label-margin" style="text-align: right">
                            收货地址:
                        </label>
                        <label class="col-md-6 control-label order-input-width " style="text-align: left; width: 679px">
                            <input type="text" class="form-control" name="" id="address"/>
                        </label>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12">
                    <div class="hr-line-dashed"></div>
                    <div class="form-group" style="text-align: center">
                        <div class="row">
                            <div class="col-md-9 " >
                                <button class="btn btn-primary global-button-style" type="button"
                                        onclick="saveAddress()">确认出库
                                </button>
                                <button class="btn btn-danger global-button-style" type="button"
                                        onclick="getBack()">申请驳回
                                </button>
                                <button class="btn btn-white global-button-style" type="button"
                                        onclick="javascript:window.location.replace(document.referrer);">返回
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
                出库产品列表
            </h3>
        </div>
        <div class="panel-body" style="padding: 10px 10px 0px 10px;">
            <div class="control-group table-responsive">
                <table id="cusProdDetail" class="table table-striped table-bordered table-hover text-nowrap">
                    <thead>
                    <tr>
                        <th style="text-align: center">序号</th>
                        <th style="text-align: center">条形码号</th>
                        <th style="text-align: center">订单编号</th>
                        <th style="text-align: center">产品类别</th>
                        <th style="text-align: center">产品品种</th>
                        <th style="text-align: center">产品颜色</th>
                        <th style="text-align: center">产品规格</th>
                        <th style="text-align: center">归属人</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${stocks}" var="cus" varStatus="status">
                        <tr>
                            <td style="text-align: center">${status.index + 1}</td>
                            <td>${cus.barCode}</td>
                            <td>${cus.ordCode}</td>
                            <td>${fns:getValueByDictKey(cus.itemVariety)}</td>
                            <td>${fns:getValueByDictKey(cus.itemCgyCode)}</td>
                            <td>${fns:getDictLabel('prod_color',cus.itemColor,'无')}</td>
                            <td>${cus.itemLenth}*${cus.itemWidth}*${cus.itemThick}</td>
                            <td>${cus.itemOwner}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>





<%--<div class="wrapper wrapper-content animated fadeInRight">--%>
    <%--<div class="tabs-container">--%>
        <%--&lt;%&ndash;<ul class="nav nav-tabs">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<li class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true">出库单详情</a>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</ul>&ndash;%&gt;--%>
        <%--<div class="tab-content">--%>
            <%--<div id="tab-1" class="tab-pane active">--%>
                <%--<div class="panel-body">--%>
                    <%--&lt;%&ndash;<div class="row">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<div class="col-sm-12">&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<input type="hidden" id="outCode" value="${outCode}"/>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<div class="ibox float-e-margins">&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<div class="ibox-content">&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<form method="get" class="form-horizontal">&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;<div class="form-group">&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;<label class="col-md-1">收货人:</label>&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;<div class="col-sm-5">&ndash;%&gt;--%>
                                                <%--&lt;%&ndash;<input type="text" class="form-control" name="" id="receiver"/>&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;<label class="col-md-1">联系方式:</label>&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;<div class="col-sm-5">&ndash;%&gt;--%>
                                                <%--&lt;%&ndash;<input type="text" class="form-control" name="" id="phone"/>&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;<div class="form-group">&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;<div class="col-md-12">&ndash;%&gt;--%>
                                                <%--&lt;%&ndash;<label class="col-md-1">收货地址:</label>&ndash;%&gt;--%>
                                                <%--&lt;%&ndash;<div class="col-sm-8">&ndash;%&gt;--%>
                                                    <%--&lt;%&ndash;<input type="text" class="form-control" name="" id="address"/>&ndash;%&gt;--%>
                                                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;</form>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<div class="row">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<div class="col-sm-12">&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<div class="form-group">&ndash;%&gt;--%>
                                <%--&lt;%&ndash;&nbsp;&nbsp;&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<button class="btn btn-primary" type="button" onclick="saveAddress()">确认出库</button>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;&nbsp;&nbsp;&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<button class="btn btn-primary" type="button" onclick="getBack()">申请驳回</button>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;&nbsp;&nbsp;&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<button class="btn btn-white" type="button"&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;onclick="javascript:window.location.replace(document.referrer);">返 回&ndash;%&gt;--%>
                                <%--&lt;%&ndash;</button>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                    <%--</br>--%>
                    <%--<div class="row">--%>
                        <%--<div class="ibox float-e-margins">--%>
                            <%--<div class="ibox-title">--%>
                                <%--<h5>出库产品列表</h5>--%>
                            <%--</div>--%>
                            <%--<div class="ibox-content">--%>
                                <%--<div class="col-sm-12" style="max-height: 350px">--%>
                                    <%--<table id="cusProdDetail" class="table table-bordered">--%>
                                        <%--<thead>--%>
                                        <%--<tr>--%>
                                            <%--<th>条形码号</th>--%>
                                            <%--<th>订单编号</th>--%>
                                            <%--<th>产品类别</th>--%>
                                            <%--<th>产品品种</th>--%>
                                            <%--<th>产品颜色</th>--%>
                                            <%--<th>产品规格</th>--%>
                                            <%--<th>归属人</th>--%>
                                        <%--</tr>--%>
                                        <%--</thead>--%>
                                        <%--<tbody>--%>
                                        <%--<c:forEach items="${stocks}" var="cus">--%>
                                            <%--<tr>--%>
                                                <%--<td>${cus.barCode}</td>--%>
                                                <%--<td>${cus.ordCode}</td>--%>
                                                <%--<td>${fns:getValueByDictKey(cus.itemVariety)}</td>--%>
                                                <%--<td>${fns:getValueByDictKey(cus.itemCgyCode)}</td>--%>
                                                <%--<td>${fns:getDictLabel('prod_color',cus.itemColor,'无')}</td>--%>
                                                <%--<td>${cus.itemLenth}*${cus.itemWidth}*${cus.itemThick}</td>--%>
                                                <%--<td>${cus.itemOwner}</td>--%>
                                            <%--</tr>--%>
                                        <%--</c:forEach>--%>
                                        <%--</tbody>--%>
                                    <%--</table>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
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
    function saveAddress() {
        var receiver = $("#receiver").val();
        var phone = $("#phone").val();
        var address = $("#address").val();

        if (address == null || receiver == null || phone == null || address == "" || receiver == "" || phone == "") {
            layer.msg('请完善好信息在提交！');
            return;
        }
        $.ajax({
            type: "POST",
            url: '/tOutStock/doOutStock',
            data: {
                outCode: $("#outCode").val(),
                receiver: $("#receiver").val(),
                phone: $("#phone").val(),
                address: $("#address").val()
            },
            dataType: 'json',
            cache: false,
            success: function (data) {
                if (data != null && data > 0) {
                    window.location.href = "/crm/inventory/outStockList";
                } else {
                    layer.msg("出库失败！");
                }
            }
        })
    }
    
    function getBack() {
        $.ajax({
            type: "POST",
            url: '/tOutStock/backOutStock',
            data: {
                outCode: $("#outCode").val()
            },
            dataType: 'json',
            cache: false,
            success: function (data) {
                if (data != null && data > 0) {
                    window.location.href = "/crm/inventory/outStockList";
                } else {
                    layer.msg("驳回失败！");
                }
            }
        })
    }
</script>