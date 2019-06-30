<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<%@ attribute name="id" type="java.lang.String" required="true" description="属性id" %>
<%@ attribute name="name" type="java.lang.String" required="false" description="名称" %>


<button type="button" id="${id}" name="${id}" class="btn btn-default" style="width: 80px;height: 23px">
    <i class="icon-refresh"></i>&nbsp;${name}</button>


<script type="text/javascript">
    $("#${id}Button").click(function () {
        top.$.jBox.open("iframe:${ctx}/tag/iconselect?value=" + $("#${id}").val(), "选择图标", 700, $(top.document).height() - 180, {
            buttons: {"确定": "ok", "清除": "clear", "关闭": true}, submit: function (v, h, f) {
                if (v == "ok") {
                    var icon = h.find("iframe")[0].contentWindow.$("#icon").val();
                    icon = $.trim(icon).substr(5);
                    $("#${id}Icon").attr("class", "icon-" + icon);
                    $("#${id}IconLabel").text(icon);
                    $("#${id}").val(icon);
                } else if (v == "clear") {
                    $("#${id}Icon").attr("class", "icon- hide");
                    $("#${id}IconLabel").text("无");
                    $("#${id}").val("");
                }
            }, loaded: function (h) {
                $(".jbox-content", top.document).css("overflow-y", "hidden");
            }
        });
    });
</script>
