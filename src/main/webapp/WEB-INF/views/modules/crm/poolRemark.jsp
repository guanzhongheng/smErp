<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<body>
<form method="post" class="form-horizontal" id="transferInfo">
    <input type="hidden" id="ids" name="ids" value="${ids}">
    <br/><br/>
    <div class="from-group">
        <label class="control-label">备注信息:</label>
        <div class="controls">
            <textarea id="remarks" name="remarks" rows="5" maxlength="200" class="input-xlarge"></textarea>
        </div>
    </div>
    <div class="from-group">
        <label class="control-label"></label>
        <div class="controls">
            <p><small>* 转移到公海后此客户数据将属于公共资源，原归属人员不能再维护跟进和更新此客户数据。</small></p>
        </div>
    </div>

</form>
</body>
</html>