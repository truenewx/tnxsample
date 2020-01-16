<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="zh-cn">
<meta charset="UTF-8">
<head>
    <meta name="csrf" content="${_csrf.token}" header="${_csrf.headerName}" parameter="${_csrf.parameterName}"/>
    <title><sitemesh:write property="title"/> - tnxsample</title>
    <jsp:include page="/pages/head-link.jsp"/>
    <sitemesh:write property="head"/>
</head>

<body component="<sitemesh:write property='body.component'/>"
        css="<sitemesh:write property='body.css'/>"
        js="<sitemesh:write property='body.js'/>">
<div class="container-full">
    <sitemesh:write property="body"/>
</div>
<jsp:include page="/pages/footer.jsp"/>
</body>
</html>