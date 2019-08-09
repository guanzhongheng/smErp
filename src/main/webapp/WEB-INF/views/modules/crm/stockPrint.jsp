<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<link rel="stylesheet" href="/static/common/customize.css">

<style>
    td {
        text-align:center;
    }
</style>

<div class="gray-bg" >
    <div style="width:100%;">
        <table  border="1" cellspacing="0" style="width:100%;">
            <tr>
                <td colspan="2" style="height:1px;"></td>
            </tr>
            <tr>
                <td colspan="2" ><img id="imgcode" /></td>
            </tr>
            <tr>
                <td colspan="2"><font size4>${vo.proxyName}-${vo.itemOwner}-${fns:getValueByDictKey(vo.itemVariety)}</font></td>
            </tr>
            <tr>
                <td style="width:50%"><font size=2>幅宽：${vo.itemWidth}m</font></td>
                <td><font size=2>厚度：${vo.itemThick}m</font></td>
            </tr>
            <tr>
                <td><font size=2>长度：${vo.itemLenth}m</font></td>
                <td><font size=2>颜色：${vo.itemColorValue}</font></td>
            </tr>
            <tr>
                <td colspan="2"><font size=2>重量：${vo.itemWeight} kg</font></td>
            </tr>
            <tr>
                <td colspan="2"><font size=2>生产时间：<fmt:formatDate value="${vo.createTime}" pattern="yyyy年MM月dd日"/></font></td>
            </tr>

        </table>
        <div style="text-align: center;    margin-top: 5px;" id="btnArea">
            <button class="btn btn-primary " type="button" id="bth" >打印</button>
        </div>
    </div>
</div>
<script src="${ctxStatic}/hPlugs/js/jquery.min.js?v=2.1.4" type="text/javascript"></script>
<script src="${ctxStatic}/hPlugs/js/bootstrap.min.js?v=3.3.6" type="text/javascript"></script>
<script src="${ctxStatic}/hPlugs/js/content.min.js?v=1.0.0" type="text/javascript"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/chosen/chosen.jquery.js"></script>
<script src="${ctxStatic}/hPlugs/js/plugins/peity/jquery.peity.min.js"></script>
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
<script src="${ctxStatic}/hPlugs/js/plugins/JsBarcode/JsBarcode.all.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        // var LODOP = getLodop();
        // console.log(LODOP);
        // LODOP.SET_PRINT_MODE("TRYLINKPRINTER_NOALERT",true);//这个语句设置网络共享打印机连接不通时是否提示一下
        // if (LODOP.SET_PRINTER_INDEX(0)){
        //     LODOP.PRINT();
        // }//这里指定第0号打印机打印


        var barCode = '${vo.barCode}';
        var jump = '${jump}';
        JsBarcode("#imgcode", barCode,{
            format: "CODE128",//选择要使用的条形码类型
            height:26,//高度
            width:1.5,
            displayValue:true,//是否在条形码下方显示文字
            fontSize:12,//设置文本的大小
            textPosition:"top",//设置文本的垂直位置
        });

        $("#bth").click(function () {
            $("#btnArea").hide();
            window.print();
            // if(jump == 0) {
            //     parent.setTimeout('window.location.href = "/crm/produce/list"', 100);
            // }
            parent.layer.closeAll();
        });
    });


    function print33(){

    }
</script>
