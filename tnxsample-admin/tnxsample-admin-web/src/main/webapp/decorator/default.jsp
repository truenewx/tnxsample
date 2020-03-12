<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="csrf" content="${_csrf.token}" header="${_csrf.headerName}" parameter="${_csrf.parameterName}"/>
    <title><sitemesh:write property="title"/> - tnxsample</title>
    <jsp:include page="/pages/head-link.jsp"/>
    <sitemesh:write property="head"/>
</head>

<body component="<sitemesh:write property='body.component'/>"
        css="<sitemesh:write property='body.css'/>"
        js="<sitemesh:write property='body.js'/>">
<jsp:include page="/header"/>
<div class="container-full">
    <sitemesh:write property="body"/>
</div>
<jsp:include page="/pages/footer.jsp"/>
</body>
</html>