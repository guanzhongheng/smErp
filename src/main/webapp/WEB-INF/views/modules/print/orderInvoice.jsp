<!DOCTYPE html>
<html>


<!-- Mirrored from www.zi-han.net/theme/hplus/invoice.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:47 GMT -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title></title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico">

    <link href="${ctxStatic}/hPlugs/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="${ctxStatic}/hPlugs/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${ctxStatic}/hPlugs/css/animate.min.css" rel="stylesheet">
    <link href="${ctxStatic}/hPlugs/css/style.min862f.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">

    <div class="row">
        <div class="col-sm-12">
            <div class="ibox-content p-xl">
                <!--startprint-->
                <div class="row">
                    <div class="col-sm-12 text-center">
                        <h2>青州市嘉润塑业有限公司收据</h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-6">
                        <address>
                            <strong>青州市嘉润塑业有限公司</strong><br>
                            青州市十街10号<br>
                            <abbr title="Phone">联系方式：</abbr> (+123) 123 11111
                        </address>
                    </div>

                    <div class="col-sm-6 text-right">
                        <h4>单据编号：</h4>
                        <h4 class="text-navy">H-000567F7-00</h4>
                        <address>
                            <strong>客户:SNS(现金结算)</strong>

                        </address>
                        <p>
                            <span><strong>收货日期：</strong> 2019-07-15</span>
                        </p>
                    </div>
                </div>

                <div class="table-responsive m-t">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>归属人</th>
                            <th>名称</th>
                            <th>类别</th>
                            <th>品种</th>
                            <th>颜色</th>
                            <th>规格(长*宽*厚)</th>
                            <th>重量</th>
                            <th>数量</th>
                            <th>总面积(M&sup2)</th>
                            <th>总重量(kg)</th>
                            <th>单价</th>
                            <th>总价</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>SNS</td>
                            <td>黑白膜</td>
                            <td>大膜</td>
                            <td>干膜</td>
                            <td>红色</td>
                            <td>2000.00 * 9.0 * 0.1</td>
                            <td>0.00</td>
                            <td>1</td>
                            <td>1400.00</td>
                            <td>0</td>
                            <td>&yen;1.240</td>
                            <td>&yen;22,320.00</td>
                        </tr>
                        <tr>
                            <td>SNS</td>
                            <td>黑白膜</td>
                            <td>大膜</td>
                            <td>干膜</td>
                            <td>红色</td>
                            <td>1000.00 * 12.0 * 0.1</td>
                            <td>0.00</td>
                            <td>1</td>
                            <td>1400.00</td>
                            <td>0</td>
                            <td>&yen;1.240</td>
                            <td>&yen;14,880.00</td>
                        </tr>
                        <tr>
                            <td>SNS</td>
                            <td>黑白膜</td>
                            <td>大膜</td>
                            <td>干膜</td>
                            <td>红色</td>
                            <td>1000.00 * 14.0 * 0.1</td>
                            <td>0.00</td>
                            <td>1</td>
                            <td>0.00</td>
                            <td>0</td>
                            <td>&yen;1.240</td>
                            <td>&yen;17,360.00</td>
                        </tr>

                        </tbody>
                    </table>
                </div>
                <!-- /table-responsive -->

                <table class="table invoice-total">
                    <tbody>
                    <tr>
                        <td><strong>总面积：</strong>
                        </td>
                        <td>1026.00 M&sup2</td>
                    </tr>
                    <tr>
                        <td><strong>总重量：</strong>
                        </td>
                        <td>0 kg</td>
                    </tr>
                    <tr>
                        <td><strong>订单总价：</strong>
                        </td>
                        <td>&yen;54560.00</td>
                    </tr>
                    </tbody>
                </table>

                <div class="well m-t">

                    <div class="row">
                        <div class="col-sm-2"> 应收金额：&yen;54560.00</div>
                        <div class="col-sm-2"> 实收金额：&yen;54560.00</div>
                        <div class="col-sm-2"> 制单人：王某</div>
                        <div class="col-sm-2"> 制单时间：2019-07-11</div>
                    </div>
                </div>
                <!--endprint-->
                <div class="text-right">
                    <button class="btn btn-primary" onclick="print2()">打印</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${ctxStatic}/hPlugs/js/jquery.min.js?v=2.1.4" type="text/javascript"></script>
<script src="${ctxStatic}/hPlugs/js/bootstrap.min.js?v=3.3.6" type="text/javascript"></script>
<script src="${ctxStatic}/hPlugs/js/content.min.js?v=1.0.0" type="text/javascript"></script>
<script type="text/javascript">
    function doPrint(){
        window.print();
    }
    function print2(){
        bdhtml=window.document.body.innerHTML;
        sprnstr="<!--startprint-->";
        eprnstr="<!--endprint-->";
        prnhtml=bdhtml.substring(bdhtml.indexOf(sprnstr)+17);
        prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));
        window.document.body.innerHTML=prnhtml;
        window.print();
    }
</script>
</body>

</html>
