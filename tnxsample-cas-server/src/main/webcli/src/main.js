import $ from 'jquery';
import Vue from 'vue';
import ElementUI from 'element-ui';
import '@truenewx/tnxweb/components/jquery/bootstrap/base-4.5.0.css';
import 'element-ui/lib/theme-chalk/index.css';
import '@fortawesome/fontawesome-free/css/all.css';
import '@truenewx/tnxweb/components/vue/element/tnxel.css';
import tnxel from '@truenewx/tnxweb/components/vue/element/tnxel.js';

Vue.use(ElementUI);

Vue.config.productionTip = false;

window.modules = {
    $, Vue, tnx: tnxel
};
