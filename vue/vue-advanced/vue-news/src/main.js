import Vue from 'vue';
import App from './App.vue';
import { router } from './routes/index.js';
import { store } from './store/index.js';
import WaferMapPlugin from './plugins/WaferMapPlugin.js';

Vue.config.productionTip = false;

Vue.use(WaferMapPlugin);

new Vue({
  render: (h) => h(App),
  router,
  store,
}).$mount('#app');
