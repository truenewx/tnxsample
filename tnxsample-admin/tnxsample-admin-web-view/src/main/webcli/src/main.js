import '../../../../../../../tnxweb/components/jquery/bootstrap/base-4.5.0.css';
import 'element-ui/lib/theme-chalk/index.css';
import '@fortawesome/fontawesome-free/css/all.css';
import '../../../../../../../tnxweb/components/vue/tnxvue.css';
import '../../../../../../../tnxweb/components/vue/element/tnxel.css';
import './assets/app.css';
import {Vue} from './app';
import VueRouter from 'vue-router';
import routerConfig from './router.config.js';
import App from './App.vue';

Vue.use(VueRouter);
Vue.config.productionTip = false;

new Vue({
    router: new VueRouter(routerConfig),
    render: h => h(App),
}).$mount('#app');
