import Vue from 'vue';
import VueRouter from 'vue-router';
import NewsView from '../views/NewsView.vue';
import AskView from '../views/AskView.vue';
import JobsView from '../views/JobsView.vue';

Vue.use(VueRouter);

const routes = [
  { path: '/', redirect: '/news' },
  { path: '/news', component: NewsView },
  { path: '/ask', component: AskView },
  { path: '/jobs', component: JobsView },
];

export const router = new VueRouter({
  routes, // `routes: routes`의 줄임
});
