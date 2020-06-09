<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <c:if test="${not empty _csrf}">
        <meta name="csrf" content="${_csrf.token}" header="${_csrf.headerName}"
            parameter="${_csrf.parameterName}"/>
    </c:if>
    <title>tnxsample</title>
    <jsp:include page="/pages/head-link.jsp"/>
    <sitemesh:write property="head"/>
</head>

<body css="<sitemesh:write property='body.css'/>" js="<sitemesh:write property='body.js'/>">
<jsp:include page="/header"/>
<div class="page-container d-flex">
    <div class="menu-container">
        <jsp:include page="/menu"/>
    </div>
    <div class="main-container flex-grow-1">
    </div>
</div>
<jsp:include page="/pages/footer.jsp"/>
</body>
</html>