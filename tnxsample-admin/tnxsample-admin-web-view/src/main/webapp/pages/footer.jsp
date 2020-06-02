<%@ page language="java" contentType="text/html; charset=utf-8" %>
<footer>
    <div class="container">
        <div class="row">
            <div class="offset-md-2 col-8 text-center">Copyright © 2020 truenewx 版权所有</div>
            <div class="col-2 text-right text-muted">v${version}</div>
        </div>
        <div class="row mt-2">
            <div class="col-12 text-center text-muted">Build with
                <a href="https://bootstrapious.com/p/admin-template" target="_blank">Bootstrap 4 Material Admin Template</a>
            </div>
        </div>
    </div>
</footer>
<script type="text/javascript">
    var app_config = {
        version: "${version}",
        locale: "${pageContext.request.locale}",
        path: "${context}",
        lib: "${tnxweb}",
        libVersion: "${tnxwebVersion}",
        min: "${resourceMin}",
    };
</script>
<script src="${tnxweb}/core/vendor/require-2.3.6/require.min.js"
    data-main="${context}/assets/js/main.js?v=${version}" type="text/javascript"></script>
