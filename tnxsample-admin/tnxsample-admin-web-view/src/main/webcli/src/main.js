import Vue from 'vue';
import VueRouter from 'vue-router';
import ElementUI from 'element-ui';
import './assets/bootstrap-base.css';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/tnxel.css';
import './assets/app.css';
import App from './App.vue';

Vue.config.productionTip = false;

Vue.use(VueRouter);
Vue.use(ElementUI);

new Vue({
  render: h => h(App),
}).$mount('#app');
