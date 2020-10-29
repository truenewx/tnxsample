// app.js
let $, Vue, tnx, util, app;

const appInitIntervalNo = setInterval(function() {
    if (window.tnx) {
        clearInterval(appInitIntervalNo);
        tnx = window.tnx;
        $ = tnx.libs.$;
        Vue = tnx.libs.Vue_UMD;
        util = tnx.util;
        app = tnx.app;
        app.init(() => {
            app.rpc.setBaseUrl(app.context);
        });
    }
}, 500);
