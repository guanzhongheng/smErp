<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>

<link href="${ctxStatic}/hPlugs/css/plugins/bootstrap-table/bootstrap-table.css" rel="stylesheet">
<link href="${ctxStatic}/hPlugs/css/plugins/bootstrap-table/bootstrap-table-fixed-columns.css" rel="stylesheet">

<div class="wrapper wrapper-content animated fadeInRight">
    <div class="tabs-container">
        <ul class="nav nav-tabs">
            <li class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true">出库单详情</a>
            </li>
        </ul>
        <div class="tab-content">
            <div id="tab-1" class="tab-pane active">
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-12">
                            <input type="hidden" id="outCode" value="${outCode}"/>
                            <div class="ibox float-e-margins">
                                <div class="ibox-content">
                                    <form method="get" class="form-horizontal">
                                        <div class="form-group">
                                            <label class="col-md-1">收货人:</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" name="" id="receiver"/>
                                            </div>
                                            <label class="col-md-1">联系方式:</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" name="" id="phone"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <label class="col-md-1">收货地址:</label>
                                                <div class="col-sm-8">
                                                    <input type="text" class="form-control" name="" id="address"/>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="form-group">
                                &nbsp;&nbsp;
                                <button class="btn btn-primary" type="button" onclick="saveAddress()">确认出库</button>
                                &nbsp;&nbsp;
                                <button class="btn btn-primary" type="button" onclick="getBack()">申请驳回</button>
                                &nbsp;&nbsp;
                                <button class="btn btn-white" type="button"
                                        onclick="javascript:window.location.replace(document.referrer);">返 回
                                </button>
                            </div>
                        </div>
                    </div>
                    </br>
                    <div class="row">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>出库产品列表</h5>
                            </div>
                            <div class="ibox-content">
                                <div class="col-sm-12" style="max-height: 350px">
                                    <table id="cusProdDetail" class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th>条形码号</th>
                                            <th>订单编号</th>
                                            <th>产品类别</th>
                                            <th>产品品种</th>
                                            <th>产品颜色</th>
                                            <th>产品规格</th>
                                            <th>归属人</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${stocks}" var="cus">
                                            <tr>
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
                </div>
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