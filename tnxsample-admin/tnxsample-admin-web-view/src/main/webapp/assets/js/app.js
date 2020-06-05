// app.js
require.config({
    map: {
        "*": {
            "validator": app_config.lib + "/core/tnx/js/tnx-validator.js?v=" + app_config.libVersion,
            "router": app_config.lib + "/jq/tnx/js/tnx-router.js?v=" + app_config.libVersion,
            "tnxbs": app_config.lib + "/bs/tnx/js/tnxbs.js?v=" + app_config.libVersion,
            "fssUpload": app_config.lib + "/bs/tnx/js/tnx-fss-upload.js?v=" + app_config.libVersion,
            "tnxvue": app_config.lib + "/vue/tnx/js/tnxvue.js?v=" + app_config.libVersion,
        }
    }
});

define(["tnxbs", "tnxvue"], function(tnxbs, tnxvue) {
    tnx = Object.assign({}, tnxbs, tnxvue);
    return tnx.app;
});
