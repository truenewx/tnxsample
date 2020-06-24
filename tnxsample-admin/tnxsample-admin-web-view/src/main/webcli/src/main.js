import Vue from 'vue';
import VueRouter from 'vue-router';
import routerConfig from './router.config.js';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import '@fortawesome/fontawesome-free/css/all.css';
import tnx from '@truenewx/tnxweb';
import './assets/tnxel.css';
import './assets/app.css';
import App from './App.vue';


console.info(tnx.context);
Vue.config.productionTip = false;

Vue.use(VueRouter);
Vue.use(ElementUI);

new Vue({
    router: new VueRouter(routerConfig),
    render: h => h(App),
}).$mount('#app');
