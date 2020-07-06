// app.js
require.config({
    paths: {
        "validator": app_config.lib + "/core/tnx/js/tnx-validator",
        "tnxbs": app_config.lib + "/bs/tnx/js/tnxbs",
        "tnxvue": app_config.lib + "/vue/tnx/js/tnxvue",
    }
});

define(["tnxbs", "tnxvue"], function(tnxbs, tnxvue) {
    tnx = Object.assign({}, tnxbs, tnxvue);
    return tnx.app;
});
