<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>配方信息</title>
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
                <h2>配方单</h2>
            </div>
            <div style="height: 5px"></div>
            <div class="row" style="text-align: center;">
                <label class="control-label">外层配比(<span id="outTemp">0</span>℃)</label>
            </div>
            <div class="form-group" style="text-align: -webkit-center;">
                <div class="control-group table-responsive" style="text-align: center;" >
                    <table id="outerTable" class="table table-striped table-bordered table-hover text-nowrap" >
                        <thead>
                        <tr>
                            <th style="text-align: center">原料</th>
                            <th style="text-align: center;width: 40%;">数量</th>
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
                            <th style="text-align: center;width: 40%;">数量</th>
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
                            <th style="text-align: center;width: 40%;">数量</th>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <br>
        <div class="row">
            <p>注意：</p>
            <p>（随幅宽增减而增减高压和线性的比例！其他比例不变！）</p>
            <p>1.以上温度仅供参考，随时注意塑化情况，开口情况，</p>
            <p>2.电晕，涂覆，烘干等严密观察，</p>
            <p>3.折叠机铺平棍严禁速度过快，以防将涂覆液擦掉！</p>
            <p>4.注意观察颜色，比去年要深，但不可过深。</p>
            <p>5.严格检查造粒，严禁添加不合格的造粒（随时汇报）！</p>

        </div>
        <!--endprint-->
        <div class="text-right">
            <button class="btn btn-primary" onclick="print2()">打印</button>
            &nbsp;&nbsp;
            <button class="btn btn-primary" onclick="javascript:history.go(-1);">返回</button>
        </div>
    </div>

</div>

<script src="${ctxStatic}/hPlugs/js/jquery.min.js?v=2.1.4" type="text/javascript"></script>
<script src="${ctxStatic}/hPlugs/js/bootstrap.min.js?v=3.3.6" type="text/javascript"></script>
<script src="${ctxStatic}/hPlugs/js/content.min.js?v=1.0.0" type="text/javascript"></script>
<script type="text/javascript">

    var FormuInfo = '${prod.formula}';
    $(document).ready(function () {
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
    })

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
