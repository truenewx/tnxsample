<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<footer>
    <div class="container">
        <div class="row">
            <div class="offset-md-2 col-md-8 text-center">Copyright © 2020 truenewx 版权所有</div>
            <div class="col-md-2 text-right text-muted">v${version}</div>
        </div>
    </div>
</footer>
<script type="text/javascript">
    var app_config = {
        version: "${version}",
        locale: "${pageContext.request.locale}",
        path: "${context}",
        lib: "${tnxweb}",
        min: "${resourceMin}",
    };
</script>
<script src="${tnxweb}/core/vendor/require-2.3.6/require.min.js"
        data-main="${context}/assets/js/main.js?v=${version}" type="text/javascript"></script>
