// app.js
require.config({
    paths: {
        "tnxbs": app_config.lib + "/bs/tnx/js/tnxbs",
        "tnxvue": app_config.lib + "/vue/tnx/js/tnxvue",
        "header": app_config.path + "/pages/header"
    }
});

define(["tnxbs", "tnxvue", "header"], function(tnxbs, tnxvue, header) {
    var tnx = Object.assign({}, tnxbs, tnxvue);
    header(tnx.app);
    return tnx.app;
});
