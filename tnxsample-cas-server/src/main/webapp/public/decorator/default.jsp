<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
<c:if test="${not empty _csrf}">
    <meta name="csrf" content="${_csrf.token}" header="${_csrf.headerName}" parameter="${_csrf.parameterName}"/>
</c:if>
    <meta name="app.context" content="${context}">
    <meta name="app.version" content="${version}">
    <title><sitemesh:write property="title"/> - tnxsample</title>
    <sitemesh:write property="head"></sitemesh:write>
    <link href="${context}/assets/css/app.css?v=${version}" rel="stylesheet">
</head>

<body>
<div id="app" class="d-flex flex-column">
    <jsp:include page="/header"/>
    <div class="flex-grow-1 page-container">
        <div css="<sitemesh:write property='body.css'/>" js="<sitemesh:write property='body.js'/>">
            <sitemesh:write property="body"/>
        </div>
    </div>
    <jsp:include page="../pages/footer.jsp"/>
</div>
<script src="${context}/vendor/require-2.3.6/require.min.js"
    data-main="${context}/assets/js/app.js?v=${version}" type="text/javascript"></script>
</body>
</html>