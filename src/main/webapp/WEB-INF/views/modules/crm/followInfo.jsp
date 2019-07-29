<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<body>
<form method="post" class="form-horizontal" id="transferInfo">
    <input type="hidden" id="cusCode" name="cusCode" value="${cusCode}">
    <br/><br/>
    <div class="control-group" style="margin-left: -30px">
        <label class="col-sm-1 control-label">跟进标题:</label>
        <div class="col-sm-8 controls">
            <input type="text" name="followTitle" id="followTitle" />
        </div>
    </div>
    <div class="control-group" style="margin-left: -30px">
        <label class="col-sm-1 control-label">跟进内容:</label>
        <div class="col-sm-8 controls">
            <textarea id="remarks" name="remarks" rows="5" maxlength="200" class="input-xlarge"></textarea>
        </div>
    </div>
</form>
</body>
</html>