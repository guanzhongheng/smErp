<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>

<!DOCTYPE html>
<html>


<!-- Mirrored from www.zi-han.net/theme/hplus/invoice_print.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:47 GMT -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>单据打印</title>
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
                <h2>青州市嘉润塑业有限公司生产单</h2>
            </div>
        </div>
        <div style="height: 5px"></div>
        <div class="row" style="text-align: left;">
            <label class="col-sm-4" style="width: 180px">品种：${fns:getValueByDictKey(prod.itemCgyCode)}</label>
            <label class="col-sm-4" style="width: 170px">类别：${fns:getValueByDictKey(prod.itemVariety)}</label>
            <label class="col-sm-4" style="width: 170px">颜色：${fns:getDictLabel(prod.itemColor,'prod_color','无')}</label>
        </div>
        <div style="height: 5px"></div>
        <div class="row" style="text-align: left;">
            <label class="col-sm-4" style="width: 180px">创单时间：<fmt:formatDate value="${time}" pattern="yyyy-MM-dd HH:mm:ss"/></label>
            <label class="col-sm-4" style="width: 170px">适配机台：${prod.macCode}</label>
        </div>
        <div style="height: 5px"></div>
        <div class="row" style="text-align: left;">
            <label class="col-sm-12" >备注: </label>
        </div>

        <!-- /table-responsive -->
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>归属人</th>
                <th>长</th>
                <th>宽</th>
                <th>厚</th>
                <th>面积</th>
                <th>延长米</th>
                <th>重量</th>
                <th>数量</th>
                <th>压边方式</th>
                <th>备注</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${details}" var="de">
                <tr>
                    <td>${de.itemOwner}</td>
                    <td>${de.itemLenth}</td>
                    <td>${de.itemWidth}</td>
                    <td>${de.itemThick}</td>
                    <td>${de.itemTotalSq}</td>
                    <td>${fns:getDictLabel(de.itemYcType,'prod_ycType','无')}</td>
                    <td>${de.itemTotalWeight}</td>
                    <td>${de.itemNum}</td>
                    <td>${fns:getDictLabel(de.itemYbType,'prod_ybType','无')}</td>
                    <td></td>
                </tr>
            </c:forEach>
            <tr>
                <td>合计:</td>
                <td colspan="3">${totalLength}</td>
                <td colspan="2">${totalMj} M&sup2</td>
                <td >${totalZl} kg</td>
                <td>${totalNum}</td>
                <td colspan="2"></td>
            </tr>
            </tbody>
        </table>

        <div class="well m-t">
            <div class="row">
                <label class="col-sm-3"> 制单人：${name}</label>
                <label class="col-sm-4"> 制单时间：<fmt:formatDate value="${time}" pattern="yyyy-MM-dd HH:mm:ss"/></label>
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


<!-- Mirrored from www.zi-han.net/theme/hplus/invoice_print.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:47 GMT -->
</html>
