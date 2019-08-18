<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>青州市嘉润塑业有限公司发货单</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="shortcut icon" href="favicon.ico">
    <link href="${ctxStatic}/hPlugs/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="${ctxStatic}/hPlugs/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${ctxStatic}/hPlugs/css/animate.min.css" rel="stylesheet">
    <link href="${ctxStatic}/hPlugs/css/style.min862f.css?v=4.1.0" rel="stylesheet">
</head>

<body class="white-bg">
<div class="wrapper wrapper-content p-xl">
    <!--startprint-->
    <div class="ibox-content p-xl">
        <div class="row">
            <div class="col-sm-12 text-center">
                <h2>青州市嘉润塑业有限公司发货单</h2>
            </div>
        </div>
        <div style="height: 5px"></div>
        <div class="row" style="text-align: left;">
            <label class="col-sm-4" style="width: 350px">单据编号：${stock.outCode}</label>
            <label class="col-sm-4 " style="width: 350px">发货日期：<fmt:formatDate value="${stock.createTime}" pattern="yyyy年MM月dd日"/></label>
        </div>
        <div style="height: 5px"></div>
        <div class="row" style="text-align: left;">
            <label class="col-sm-4" style="width: 350px">收货人：${stock.receiver}</label>
            <label class="col-sm-4" style="width: 350px">联系方式：${stock.phone}</label>
        </div>
        <div style="height: 5px"></div>
        <div class="row" style="text-align: left;">
            <label class="col-sm-12">收获地址：${stock.address}</label>
        </div>
        <div style="height: 5px"></div>
        <div class="row" style="text-align: left;">
            <label class="col-sm-12">备注: ${stock.remarks}</label>
        </div>

        <!-- /table-responsive -->
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>订单标题</th>
                <th>归属人</th>
                <th>品种</th>
                <th>类别</th>
                <th>颜色</th>
                <th>规格(长*宽*厚)</th>
                <th>总重量</th>
                <th>数量</th>
                <th>压边方式</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${stockDetails}" var="s">
                <tr>
                    <td>${s.ordTitle}</td>
                    <td>${s.itemOwner}</td>
                    <td>${fns:getValueByDictKey(s.itemVariety)}</td>
                    <td>${fns:getValueByDictKey(s.itemCgyCode)}</td>
                    <td>${fns:getDictLabel(s.itemColor,'prod_color','无')}</td>
                    <td>${s.itemLenth}*${s.itemWidth}*${s.itemThick}</td>
                    <td>${s.itemWeight}</td>
                    <td>${s.itemNum}</td>
                    <td>${fns:getDictLabel(s.itemYbType,'prod_ybType','无')}</td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="5">合计</td>
                <td>${totalMj} m&sup2</td>
                <td>${totalZl} kg</td>
                <td>${totalNum}</td>
                <td></td>
            </tr>
            </tbody>
        </table>

        <div class="well m-t">
            <div class="row">
                <label class="col-sm-3"> 制单人：${user}</label>
                <label class="col-sm-4"> 制单时间：${time}</label>
            </div>
        </div>
    </div>
    <!--endprint-->
    <div class="text-right">
        <button class="btn btn-primary" onclick="print2()">打印</button>
        &nbsp;&nbsp;
        <button class="btn btn-primary" onclick="javascript:history.go(-1);">返回</button>
    </div>
</div>


<script src="${ctxStatic}/hPlugs/js/jquery.min.js?v=2.1.4" type="text/javascript"></script>
<script src="${ctxStatic}/hPlugs/js/bootstrap.min.js?v=3.3.6" type="text/javascript"></script>
<script src="${ctxStatic}/hPlugs/js/content.min.js?v=1.0.0" type="text/javascript"></script>
<script type="text/javascript">
    function doPrint() {
        window.print();
    }
    function print2() {
        bdhtml = window.document.body.innerHTML;
        sprnstr = "<!--startprint-->";
        eprnstr = "<!--endprint-->";
        prnhtml = bdhtml.substring(bdhtml.indexOf(sprnstr) + 17);
        prnhtml = prnhtml.substring(0, prnhtml.indexOf(eprnstr));
        window.document.body.innerHTML = prnhtml;
        window.print();
        window.history.go(-1);
    }
</script>
</body>

</html>
