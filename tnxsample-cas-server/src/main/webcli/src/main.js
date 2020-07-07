import '@truenewx/tnxweb/components/jquery/bootstrap/base-4.5.0.css';
import 'element-ui/lib/theme-chalk/index.css';
import '@fortawesome/fontawesome-free/css/all.css';
import '@truenewx/tnxweb/components/vue/element/tnxel.css';
import tnxjq from '@truenewx/tnxweb/components/jquery/tnxjq'
import tnxel from '@truenewx/tnxweb/components/vue/element/tnxel';

const tnx = Object.assign({}, tnxjq, tnxel, {
    depends: Object.assign({}, tnxjq.depends, tnxel.depends)
});
tnx.depends.Vue.config.productionTip = false;
window.tnx = tnx;
