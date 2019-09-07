<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>

    <link rel="stylesheet" href="/static/common/customize.css">
</head>
<body>

<div class="tabs-container" style="padding: 0px 20px;">
    <div class="panel panel-default" style="border-color: #50B0E6; border-style: solid; border-width: 1px; border-radius:5px 5px 5px 5px;">
        <div class="panel-heading" style="background-color: #50B0E6">
            <h3 class="panel-title global-panel-title" >
                出库单详情
            </h3>
        </div>
        <div class="panel-body" style="padding: 10px 10px 0px 10px;">
            <div class="row">
                <div class="col-sm-12">
                    <div class="form-group">
                        <input type="hidden" id="outCode" value="${outStock.outCode}"/>
                        <label class="col-md-2 control-label order-detail-label-margin" style="text-align: right"><i style="color: red"></i>
                            收货人:
                        </label>
                        <label class="col-md-2 control-label order-label-input-width">
                            <input type="text" class="form-control" value="${outStock.receiver}" maxlength="20" id="receiver"/>
                        </label>

                        <label class="col-md-2 control-label  order-detail-label-margin order-input-width" style="text-align: right">
                            联系方式:
                        </label>
                        <label class="col-md-2 control-label order-label-input-width " style="text-align: left">
                            <input type="text" class="form-control" value="${outStock.phone}" maxlength="20" id="phone"/>
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
                            <input type="text" class="form-control" value="${outStock.address}" maxlength="100" id="address"/>
                        </label>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12">
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-1">
                                &nbsp;
                            </div>
                            <div class="col-md-11 " style="text-align: right;">
                                <c:if test="${outStock.outStatus eq '49'}">
                                    <button class="btn btn-primary global-button-style" type="button" onclick="saveAddress()">审核通过</button>
                                    <button class="btn btn-danger global-button-style" type="button" onclick="getBack()">审核驳回</button>
                                </c:if>
                                <button class="btn btn-primary global-button-style" type="button"
                                        onclick="javascript:window.location.replace(document.referrer);">返回
                                </button>
                                &nbsp;
                                <div class="btn-group dropdown" style="height: 40px;">
                                    <button class="btn btn-primary" style="height: 100%;" onclick="detailPrintInfo(0)" >无价格打印</button>
                                    <button class="btn btn-primary dropdown-toggle" style="height: 100%;" data-toggle="dropdown">
                                        <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <a href="#" onclick="detailPrintInfo(0)">无价格打印</a>
                                        </li>
                                        <li>
                                            <a href="#" onclick="detailPrintInfo(1)">有价格打印</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

<div class="tabs-container" style="padding: 0px 20px;">
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
                        <th style="text-align: center">订单标题</th>
                        <th style="text-align: center">产品品种</th>
                        <th style="text-align: center">产品类别</th>
                        <th style="text-align: center">产品颜色</th>
                        <th style="text-align: center">产品规格</th>
                        <th style="text-align: center">厚度</th>
                        <th style="text-align: center">重量</th>
                        <th style="text-align: center">单价</th>
                        <th style="text-align: center">金额</th>
                        <th style="text-align: center">计价方式</th>
                        <th style="text-align: center">归属人</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="cus" varStatus="status">
                        <tr>
                            <td style="text-align: center">${status.index + 1}</td>
                            <td>${cus.barCode}</td>
                            <td><a href="/cus/order/info?ordCode=${cus.ordCode}">${cus.ordTitle}</a></td>
                            <td>${fns:getValueByDictKey(cus.itemVariety)}</td>
                            <td>${fns:getValueByDictKey(cus.itemCgyCode)}</td>
                            <td>${fns:getDictLabel(cus.itemColor, 'prod_color', defaultValue)}</td>
                            <td>${cus.itemLenth}*${cus.itemWidth}</td>
                            <td>${cus.itemThick}</td>
                            <td>${cus.itemWeight}</td>
                            <td>${cus.itemPrice}</td>
                            <td>${cus.price}</td>
                            <td>${fns:getValueByDictKey(cus.itemPriceType)}</td>
                            <td>${cus.itemOwner}</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="8">总计:</td>
                        <td colspan="2">总重量:${totalWeight}</td>
                        <td colspan="3">总金额:${totalPrice}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<script>
    function detailPrintInfo(type) {
        window.location.href = "/print/outStockDetailInfo_print?outCode=" + $("#outCode").val() + "&isPrice=" + type;
    }
    
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
            url: '/tOutStock/outStockAccept',
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
                    layer.msg("出库单审核通过！");
                    window.location.href = "/crm/inventory/outStockList";
                } else {
                    layer.msg("出库单审核失败！");
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
                    layer.msg("驳回成功！");
                    window.location.href = "/crm/inventory/outStockList";
                } else {
                    layer.msg("驳回失败！");
                }
            }
        })
    }
</script>
</body>
</html>