<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>

<style>
    td {
        text-align:center;
    }
</style>

<div class="gray-bg">
    <div style="width:100%;">
        <table  border="1" cellspacing="0" style="width:80%;height:180px;">
            <tr>
                <td colspan="2" style="height:1px;"></td>
            </tr>
            <tr>
                <td colspan="2" ><img id="imgcode" /></td>
            </tr>
            <tr>
                <td colspan="2"><font size=2>${vo.itemOwner}</font></td>
            </tr>
            <tr>
                <td style="width:50%"><font size=1>幅宽：${vo.itemWidth}m</font></td>
                <td><font size=1>厚度：${vo.itemThick}mm</font></td>
            </tr>
            <tr>
                <td><font size=1>长度：${vo.itemLenth}m</font></td>
                <td><font size=1>颜色：${vo.itemColorValue}</font></td>
            </tr>
            <tr>
                <td colspan="2"><font size=1>重量：${vo.itemWeight} kg</font></td>
            </tr>
            <tr>
                <td colspan="2"><font size=1>生产时间：<fmt:formatDate value="${vo.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></font></td>
            </tr>
            <tr>
                <td colspan="2"><font size=1 >联系人：纪经理 131 2547 8852</font></td>
            </tr>
            <tr>
                <td colspan="2" >
                    <button class="btn btn-primary" type="button" id="bth" >打印</button>
                </td>
            </tr>
        </table>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        var barCode = '${vo.barCode}';
        var jump = '${jump}';
        JsBarcode("#imgcode", barCode,{
            format: "CODE128",//选择要使用的条形码类型
            height:28,//高度
            width:1.5,
            displayValue:true,//是否在条形码下方显示文字
            fontSize:3,//设置文本的大小
            textPosition:"top",//设置文本的垂直位置
        });

        $("#bth").click(function () {
            $("#bth").hide();
            window.print();
            if(jump == 0) {
                parent.setTimeout('window.location.href = "/crm/produce/list"', 100);
            }
            parent.layer.closeAll();
        });
    });


    function print33(){

    }
</script>

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