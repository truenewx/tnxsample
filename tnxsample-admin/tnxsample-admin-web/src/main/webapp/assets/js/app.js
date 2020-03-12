// app.js
require.config({
    paths: {
        "tnxbs": app_config.lib + "/bs/tnx/js/tnxbs",
        "tnxvue": app_config.lib + "/vue/tnx/js/tnxvue",
    }
});

define(["tnxbs", "tnxvue"], function(tnxbs, tnxvue) {
    var tnx = Object.assign({}, tnxbs, tnxvue);
    return tnx.app;
});
