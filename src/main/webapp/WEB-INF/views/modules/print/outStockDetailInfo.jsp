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
                <h2>青州市嘉润塑业有限公司发货单详情</h2>
            </div>
        </div>
        <!-- /table-responsive -->
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>序号</th>
                <th>条形码</th>
                <th>归属人</th>
                <th>品种</th>
                <th>颜色</th>
                <th>规格(长*宽)</th>
                <th>厚度</th>
                <th>重量</th>
                <th>数量</th>
                <c:if test="${isPrice eq '1'}" >
                    <th>单价</th>
                    <th>金额</th>
                </c:if>
                <th>计价方式</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${stockDetails}" var="s" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${s.barCode}</td>
                    <td>${s.itemOwner}</td>
                    <td>${fns:getValueByDictKey(s.itemVariety)}</td>
                    <td>${fns:getDictLabel(s.itemColor,'prod_color','无')}</td>
                    <td>${s.itemLenth}*${s.itemWidth}</td>
                    <td>${s.itemThick}</td>
                    <td>${s.itemWeight}</td>
                    <td>1</td>
                    <c:if test="${isPrice eq '1'}" >
                        <td>${s.itemPrice}</td>
                        <td>${s.price}</td>
                    </c:if>
                    <c:if test="${s.itemPriceType eq '141001'}" >
                        <td>按重量</td>
                    </c:if>
                    <c:if test="${s.itemPriceType eq '141003'}" >
                        <td>按重量</td>
                    </c:if>
                    <c:if test="${s.itemPriceType eq '141005'}" >
                        <td>按重量</td>
                    </c:if>
                    <c:if test="${s.itemPriceType eq '141002'}" >
                        <td>按面积</td>
                    </c:if>
                    <c:if test="${s.itemPriceType eq '141004'}" >
                        <td>按面积</td>
                    </c:if>
                    <c:if test="${s.itemPriceType eq '141006'}" >
                        <td>按面积</td>
                    </c:if>
                    <c:if test="${s.itemPriceType eq ''}" >
                        <td></td>
                    </c:if>
                </tr>
            </c:forEach>
                <tr>
                    <td>总计:</td>
                    <td colspan="2">数量:${total}</td>
                    <td colspan="2">计价总面积:${totalMj}</td>
                    <td colspan="2">计价总重量:${totalZl}</td>
                    <c:if test="${isPrice eq '1'}" >
                        <td colspan="5">总价:${totalPrice}</td>
                    </c:if>

                    <c:if test="${isPrice ne '1'}" >
                        <td colspan="3"></td>
                    </c:if>
                </tr>
            </tbody>
        </table>
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
