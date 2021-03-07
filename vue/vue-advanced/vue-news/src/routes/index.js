import Vue from 'vue';
import VueRouter from 'vue-router';
import NewsView from '../views/NewsView.vue';
import AskView from '../views/AskView.vue';
import JobsView from '../views/JobsView.vue';
import UserView from '../views/UserView.vue';

Vue.use(VueRouter);

const routes = [
  { path: '/', redirect: '/news' },
  { path: '/news', component: NewsView },
  { path: '/ask', component: AskView },
  { path: '/jobs', component: JobsView },
  { path: '/user/:id', component: UserView },
];

export const router = new VueRouter({
  mode: 'history',
  routes, // `routes: routes`의 줄임
});
