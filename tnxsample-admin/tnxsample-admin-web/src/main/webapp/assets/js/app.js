// app.js
require.config({
    paths: {
        "tnxbs": app_config.lib + "/bs/tnx/js/tnxbs",
        "tnxvue": app_config.lib + "/vue/tnx/js/tnxvue",
        "validator": app_config.lib + "/vue/tnx/js/tnxvue-validator",
        "header": app_config.path + "/pages/header"
    }
});

define(["tnxbs", "tnxvue", "header"], function(tnxbs, tnxvue, header) {
    tnx = Object.assign({}, tnxbs, tnxvue);
    header(tnx.app);
    return tnx.app;
});
