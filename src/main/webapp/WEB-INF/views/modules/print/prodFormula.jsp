<!DOCTYPE html>
<html>


<!-- Mirrored from www.zi-han.net/theme/hplus/invoice_print.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:47 GMT -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>H+ 后台主题UI框架 - 单据打印</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">

    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">

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
                <label class="col-sm-4" style="width: 250px">产品名称：普通PO膜（小膜）</label>
                <label class="col-sm-4" style="width: 60px"></label>
                <label class="col-sm-4 " style="width: 150px">产品品种：干膜</label>
            </div>
            <div style="height: 5px"></div>
            <div class="row" style="text-align: left;">
                <label class="col-sm-4" style="width: 250px">产品类别：大膜</label>
                <label class="col-sm-4" style="width: 60px"></label>
                <label class="col-sm-4 " style="width: 150px">产品颜色：红色</label>
            </div>
        </div>
        <br>
        <!-- /table-responsive -->

        <!-- <div class="row">
            <div class="table-bordered" style="height: 300px">
                内容宽度
            </div>
        </div> -->

        <div class="row">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th colspan="2" style="text-align: center;">外层配比（190℃）/中层配比（195℃）/内层配比（210℃）</th>
                </tr>
                <tr>
                    <th>材料名称</th>
                    <th>长</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>原料</td>
                    <td>1袋</td>
                </tr>
                <tr>
                    <td>高压M21</td>
                    <td>1袋</td>
                </tr>
                <tr>
                    <td>茂金属1018MA</td>
                    <td>1袋</td>
                </tr>
                <tr>
                    <td>线性1018N</td>
                    <td>8袋</td>
                </tr>
                <tr>
                    <td>南方1年长寿母料（5%）</td>
                    <td>0.5袋（12.5公斤）</td>
                </tr>
                <tr>
                    <td>蓝色母</td>
                    <td>50克</td>
                </tr>
                <tr>
                    <td>PPA</td>
                    <td>0.5公斤</td>
                </tr>
                </tbody>
            </table>
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
    }
</script>
</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/invoice_print.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:47 GMT -->
</html>
