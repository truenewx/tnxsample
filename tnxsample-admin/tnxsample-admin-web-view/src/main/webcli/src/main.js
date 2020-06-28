import Vue from 'vue';
import VueRouter from 'vue-router';
import routerConfig from './router.config.js';
import ElementUI from 'element-ui';
import '@truenewx/tnxweb/components/bootstrap/base-4.5.0.css';
import 'element-ui/lib/theme-chalk/index.css';
import '@fortawesome/fontawesome-free/css/all.css';
import '@truenewx/tnxweb/components/element/tnxel.css';
import './assets/app.css';
import App from './App.vue';

Vue.config.productionTip = false;

Vue.use(VueRouter);
Vue.use(ElementUI);

new Vue({
    router: new VueRouter(routerConfig),
    render: h => h(App),
}).$mount('#app');
