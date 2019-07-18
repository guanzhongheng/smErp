<!DOCTYPE html>
<html>


<!-- Mirrored from www.zi-han.net/theme/hplus/invoice_print.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:47 GMT -->
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
            <div class="row" style="text-align: left;">
                <label class="col-sm-4" style="width: 250px">产品名称：${fns:getValueByDictKey(prod.itemCgyCode)}（${fns:getValueByDictKey(prod.itemVariety)}）</label>
                <label class="col-sm-4" style="width: 60px"></label>
                <label class="col-sm-4 " style="width: 150px">产品品种：${fns:getValueByDictKey(prod.itemCgyCode)}</label>
            </div>
            <div style="height: 5px"></div>
            <div class="row" style="text-align: left;">
                <label class="col-sm-4" style="width: 250px">产品类别：${fns:getValueByDictKey(prod.itemVariety)}</label>
                <label class="col-sm-4" style="width: 60px"></label>
                <label class="col-sm-4 " style="width: 150px">产品颜色：${fns:getDictLabel(prod.itemColor,'prod_color','无')}</label>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="row">
                <div class="table-bordered" style="height: 300px">
                    ${prod.formula}
                </div>
            </div>
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

<script src="js/jquery.min.js?v=2.1.4"></script>
<script src="js/bootstrap.min.js?v=3.3.6"></script>
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
