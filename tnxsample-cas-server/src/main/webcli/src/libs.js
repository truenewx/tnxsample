import '../../../../../../tnxweb/components/jquery/bootstrap/base-4.5.3.css';
import '../../../../../../tnxweb/components/jquery/bootstrap/tnxbs.css';
import 'element-ui/lib/theme-chalk/index.css';
import '@fortawesome/fontawesome-free/css/all.css';
import '../../../../../../tnxweb/components/vue/tnxvue.css';
import '../../../../../../tnxweb/components/vue/element/tnxel.css';
import tnxjq from '../../../../../../tnxweb/components/jquery/tnxjq';
import tnxel from '../../../../../../tnxweb/components/vue/element/tnxel';

const tnx = Object.assign({}, tnxjq, tnxel, {
    libs: Object.assign({}, tnxjq.libs, tnxel.libs)
});
tnx.libs.Vue.config.productionTip = false;
window.tnx = tnx;
