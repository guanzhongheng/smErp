<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<%@ attribute name="id" type="java.lang.String" required="true" description="属性id" %>
<%@ attribute name="name" type="java.lang.String" required="false" description="名称" %>

<a type="button" id="${id}" name="${id}" class="btn btn-default" style="width: 80px;height: 23px">
    <i class="icon-refresh"></i>&nbsp;转移客户</a>

<script type="text/javascript">
    $("#toCustomer").click(function () {
        <!-- 针对选中客户进行操作 -->
        top.$.jBox.open("iframe:${ctx}/crm/formSubmit?ids=1,2,3,4,", "转移客户", 500, $(top.document).height() - 300, {
            buttons: {"确定": "ok", "关闭": true}, submit: function (v, h, f) {
                debugger;
                var ids = h.find("iframe")[0].contentWindow.ids;
                var cusContent = h.find("iframe")[0].contentWindow.cusContent;
                var remarks = h.find("iframe")[0].contentWindow.remarks;
                if (v == "ok") {
                    $.post('${ctx}/crmAjax/saveTransfer/', {
                        cusIds: ids.value,
                        userId: cusContent.value,
                        remarks: remarks.value
                    },function(data) {
                        if(data = "success"){
                            top.$.jBox.tip('保存成功');
                        }else{
                            top.$.jBox.tip('保存失败');
                        }
                    })
                }
            }, loaded: function (h) {
                debugger;
                $(".jbox-content", top.document).css("overflow-y", "hidden");
            }
        });
    });
</script>
