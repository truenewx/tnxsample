// main.js
let $, Vue, tnx, util, app;

const appInitIntervalNo = setInterval(function() {
    if (window.tnx) {
        clearInterval(appInitIntervalNo)
        $ = window.$;
        Vue = window.Vue;
        tnx = window.tnx;
        util = tnx.util;
        app = tnx.app;
        app.init(() => {
            app.rpc.setConfig({
                baseUrl: app.context
            });
        });
    }
}, 500);
