import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import Axios from 'axios'
import router from './router'
import store from './store'
Vue.config.productionTip = false
Vue.config.silent = true
Vue.use(ElementUI);
Vue.prototype.$axios = Axios


Axios.defaults.baseURL="http://127.0.0.1:8989"
new Vue({
  render: h => h(App),
  router,
  store
}).$mount('#app')
