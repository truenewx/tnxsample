// app.js
let $, Vue, tnx, util, app;

const appInitIntervalNo = setInterval(function() {
    if (window.tnx) {
        clearInterval(appInitIntervalNo);
        tnx = window.tnx;
        $ = tnx.libs.$;
        Vue = tnx.libs.Vue;
        util = tnx.util;
        app = tnx.app;
        app.init(() => {
            app.rpc.setConfig({
                baseUrl: app.context
            });
        });
    }
}, 500);
