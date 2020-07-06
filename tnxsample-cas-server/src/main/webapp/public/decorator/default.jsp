<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
<c:if test="${not empty _csrf}">
    <meta name="csrf" content="${_csrf.token}" header="${_csrf.headerName}" parameter="${_csrf.parameterName}"/>
</c:if>
    <title><sitemesh:write property="title"/></title>
</head>

<body css="<sitemesh:write property='body.css'/>" js="<sitemesh:write property='body.js'/>">
<link href="${context}/assets/css/app.css?v=${version}" rel="stylesheet">
<jsp:include page="/header"/>
<div class="flex-grow-1 page-container">
    <sitemesh:write property="body"/>
</div>
<jsp:include page="../pages/footer.jsp"/>
</body>
</html>