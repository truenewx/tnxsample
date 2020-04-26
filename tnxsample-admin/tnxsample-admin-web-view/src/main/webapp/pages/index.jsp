<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="zh-cn">
<meta charset="UTF-8">
<head>
    <title>首页</title>
</head>

<body js="index.js">
<h2 class="text-center pt-5">欢迎进入</h2>
<div class="form-group row mt-5">
    <label class="col-5 col-form-label">头像</label>
    <div class="col-5" id="headImageContainer"></div>
</div>
<div class="form-group row">
    <button type="button" class="btn btn-primary" @click="submit">确定</button>
</div>
</body>
</html>
