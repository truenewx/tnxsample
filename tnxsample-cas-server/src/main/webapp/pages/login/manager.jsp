<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="tnxjee" uri="/tnxjee-tags" %>
<!DOCTYPE html>
<html lang="zh-cn">
<meta charset="UTF-8">
<head>
    <title>登录</title>
</head>

<body js="login/manager.js">
<div class="offset-5 col-2">
    <div class="h2 text-center py-5">登录</div>
    <tv-div class="alert alert-danger" mode="d" :class="{'d-none': <tnxjee:noerror/>}">
        <tnxjee:errors/>
    </tv-div>
    <form method="post" action="${context}/login" @submit="submit($event)">
        <input type="hidden" id="service" name="service" value="${service}">
        <div class="form-group">
            <label for="username">用户名</label>
            <input type="text" class="form-control" name="username" id="username"
                v-model="username">
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <input type="password" class="form-control" id="password" v-model="password"
                autocomplete="off">
            <input type="hidden" name="password" v-model="md5Password">
        </div>
        <button type="submit" class="btn btn-primary">登录</button>
    </form>
</div>
</body>
</html>