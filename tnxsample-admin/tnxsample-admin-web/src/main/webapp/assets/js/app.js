// app.js
require.config({
    paths: {
        "jquery": app_config.lib + "/jq/vendor/jquery-3.4.1/jquery" + app_config.min,
        "tnxvue": app_config.lib + "/vue/tnxvue/js/tnxvue",
        "bootstrap-vue": app_config.lib + "/vue/vendor/bootstrap-vue-2.0.4/js/bootstrap-vue" + app_config.min,
    }
});

define(["tnxvue", "bootstrap-vue"], function(tnx, BootstrapVue) {
    tnx.app.Vue.use(BootstrapVue);
    tnx.app.BootstrapVue = BootstrapVue;

    return tnx.app;
});
