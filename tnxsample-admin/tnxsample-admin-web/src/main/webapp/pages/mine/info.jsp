<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cn">
<meta charset="UTF-8">
<head>
    <title>修改个人资料</title>
</head>

<body js="true">
<form action="${context}/mine/info" method="post">
    <div class="form-group row">
        <label class="col-sm-4 col-form-label">用户名</label>
        <div class="col-sm-8">
            <p class="form-control-plaintext">${manager.username}</p>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-4 col-form-label">是否超管</label>
        <div class="col-sm-8">
            <p class="form-control-plaintext">
            <c:if test="${manager.top}">
                <i class="fa fa-check text-primary"></i>
            </c:if><c:if test="${not manager.top}">
                <i class="fa fa-ban text-muted"></i>
            </c:if>
            </p>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-4 col-form-label">头像</label>
        <div class="col-sm-8">

        </div>
    </div>
    <div class="form-group row">
        <label for="fullName" class="col-sm-4 col-form-label">姓名</label>
        <div class="col-sm-7">
            <input type="text" class="form-control" id="fullName" name="fullName" value="${manager.fullName}">
        </div>
    </div>
</form>
</body>
</html>
