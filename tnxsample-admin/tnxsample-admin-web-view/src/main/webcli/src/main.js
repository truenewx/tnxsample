import Vue from 'vue';
import VueRouter from 'vue-router';
import Antd from 'ant-design-vue';
import '@/assets/bootstrap-base.css';
import 'ant-design-vue/dist/antd.css';
import '@/assets/app.css';
import App from './App.vue';

Vue.config.productionTip = false;

Vue.use(VueRouter);
Vue.use(Antd);

new Vue({
  render: h => h(App),
}).$mount('#app');
