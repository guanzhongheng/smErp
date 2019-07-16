<!DOCTYPE html>
<html>


<!-- Mirrored from www.zi-han.net/theme/hplus/invoice_print.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:47 GMT -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>单据打印</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
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
                <h2>青州市嘉润塑业有限公司发货单</h2>
            </div>
        </div>
        <div style="height: 5px"></div>
        <div class="row" style="text-align: left;">
            <label class="col-sm-4" style="width: 180px">单据编号：SNS7.14</label>
            <label class="col-sm-4" style="width: 170px"></label>
            <label class="col-sm-4 " style="width: 170px">发货日期：2019-07-14</label>
        </div>
        <div style="height: 5px"></div>
        <div class="row" style="text-align: left;">
            <label class="col-sm-4" style="width: 180px">客户名称：SNS</label>
            <label class="col-sm-4"style="width:170px">收货人：2019-07-14</label>
            <label class="col-sm-4" style="width: 180px">联系方式：13841256598</label>
        </div>
        <div style="height: 5px"></div>
        <div class="row" style="text-align: left;">
            <label class="col-sm-12" >收获地址：青州小县城下面的大地区某农户家10011</label>
        </div>
        <div style="height: 5px"></div>
        <div class="row" style="text-align: left;">
            <label class="col-sm-12" >备注: 用户备注一些注意信息</label>
        </div>

        <!-- /table-responsive -->
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>归属人</th>
                <th>品种</th>
                <th>类别</th>
                <th>规格(长*宽*厚)</th>
                <th>重量</th>
                <th>数量</th>
                <th>压边方式</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>SNS</td>
                <td>干膜</td>
                <td>大膜</td>
                <td>23*10*0.2</td>
                <td>1,263.0</td>
                <th>20</th>
                <th>不压边</th>
            </tr>
            <tr>
                <td>SNS</td>
                <td>双防</td>
                <td>大膜</td>
                <td>213*10*0.2</td>
                <td>1,263.0</td>
                <th>30</th>
                <th>不压边</th>
            </tr>
            <tr>
                <td>黄总</td>
                <td>干膜</td>
                <td>大膜</td>
                <td>231*10*0.2</td>
                <td>1,263.0</td>
                <th>21</th>
                <th>不压边</th>
            </tr>
            <tr>
                <td>孙总</td>
                <td>双防</td>
                <td>大膜</td>
                <td>213*10*0.2</td>
                <td>1,263.0</td>
                <th>30</th>
                <th>不压边</th>
            </tr>
            <tr>
                <td colspan="3">合计</td>
                <td>12542.02 M&sup2</td>
                <td>5234.12 kg</td>
                <td>120</td>
                <td></td>
            </tr>
            </tbody>
        </table>

        <div class="well m-t">
            <div class="row">
                <label class="col-sm-3"> 制单人：王某</label>
                <label class="col-sm-4"> 制单时间：2019-07-11</label>
            </div>
        </div>
    </div>
    <!--endprint-->
    <div class="text-right">
        <button class="btn btn-primary" onclick="print2()">打印</button>
    </div>
</div>



<script src="js/jquery.min.js?v=2.1.4"></script>
<script src="js/bootstrap.min.js?v=3.3.6"></script>
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


<!-- Mirrored from www.zi-han.net/theme/hplus/invoice_print.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:47 GMT -->
</html>
