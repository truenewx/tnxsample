<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title><sitemesh:write property="title"/> - tnxsample</title>
    <jsp:include page="/pages/head-link.jsp"/>
    <sitemesh:write property="head"/>
</head>

<body>
<jsp:include page="/header"/>
<div class="container-full">
    <sitemesh:write property="body"/>
</div>
<jsp:include page="/pages/footer.jsp"/>
</body>
</html>