<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="tnxjee" uri="/tnxjee-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cn">
<meta charset="UTF-8">
<head>
    <title>登录</title>
</head>

<body js="/pages/login/manager.js">
<div class="offset-5 col-2">
    <div class="h2 text-center py-5">登录</div>
    <tv-div class="alert alert-danger" mode="d" :class="{'d-none': <tnxjee:noerror/>}">
        <tnxjee:errors/>
    </tv-div>
    <form method="post" action="${context}/login" @submit="submit($event)">
        <c:forEach var="parameter" items="${param}">
            <c:if test="${parameter.key != 'username' && parameter.key != 'password'}">
                <input type="hidden" id="${parameter.key}" name="${parameter.key}"
                    value="${parameter.value}">
            </c:if>
        </c:forEach>
        <div class="form-group">
            <label for="username">用户名</label>
            <input type="text" class="form-control" name="username" id="username"
                init-value="${param.username}" v-model="username">
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <input type="password" class="form-control" id="password" init-value="${param.password}"
                v-model="password" autocomplete="off">
            <input type="hidden" name="password" v-model="md5Password">
        </div>
        <button type="submit" class="btn btn-primary">登录</button>
    </form>
</div>
</body>
</html>