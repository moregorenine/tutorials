import Vue from 'vue';
import VueRouter from 'vue-router';
import NewsView from '../views/NewsView.vue';
import AskView from '../views/AskView.vue';
import JobsView from '../views/JobsView.vue';
import UserView from '../views/UserView.vue';
import ItemView from '../views/ItemView.vue';
import WaferMapView from '../views/WaferMapView.vue';
import { store } from '../store/index.js';
import bus from '../utils/bus.js';
// import createListView from '../views/CreateListView.js';

Vue.use(VueRouter);

const routes = [
  { path: '/', redirect: '/news' },
  // { path: '/news', name: 'news', component: createListView('NewsView') },
  // { path: '/ask', name: 'ask', component: createListView('AskView') },
  // { path: '/jobs', name: 'jobs', component: createListView('JobsView') },
  {
    path: '/news',
    name: 'news',
    component: NewsView,
    beforeEnter: (to, from, next) => {
      const start = new Date();
      bus.$emit('start:spinner');
      store
        .dispatch('FETCH_LIST', to.name)
        .then(() => {
          const end = new Date();
          console.log(`${end - start} ms`);
          next();
        })
        .catch((error) => console.log(error));
    },
  },
  {
    path: '/ask',
    name: 'ask',
    component: AskView,
    beforeEnter: (to, from, next) => {
      const start = new Date();
      bus.$emit('start:spinner');
      store
        .dispatch('FETCH_LIST', to.name)
        .then(() => {
          const end = new Date();
          console.log(`${end - start} ms`);
          next();
        })
        .catch((error) => console.log(error));
    },
  },
  { path: '/jobs', name: 'jobs', component: JobsView },
  { path: '/user/:id', component: UserView },
  { path: '/item/:id', component: ItemView },
  { path: '/wafer-map', component: WaferMapView },
];

export const router = new VueRouter({
  mode: 'history',
  routes, // `routes: routes`의 줄임
});
