// app.js
require.config({
    map: {
        "*": {
            "validator": app_config.lib + "/core/tnx/js/tnx-validator.js?v=" + app_config.libVersion,
            "tnxbs": app_config.lib + "/bs/tnx/js/tnxbs.js?v=" + app_config.libVersion,
            "fssUpload": app_config.lib + "/bs/tnx/js/tnx-fss-upload.js?v=" + app_config.libVersion,
            "tnxvue": app_config.lib + "/vue/tnx/js/tnxvue.js?v=" + app_config.libVersion,
            "header": app_config.path + "/pages/header.js?v=" + app_config.version,
            "menu": app_config.path + "/pages/menu.js?v=" + app_config.version,
        }
    }
});

define(["tnxbs", "tnxvue", "header", "menu"], function(tnxbs, tnxvue, header, menu) {
    tnx = Object.assign({}, tnxbs, tnxvue);
    header(tnx.app);
    menu(tnx.app);
    return tnx.app;
});
