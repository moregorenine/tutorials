import { RouteConfig } from 'vue-router/types/router';

export const CofRoutes: RouteConfig[] = [
  {
    path: '/cof',
    name: 'cof',
    component: () => import(/* webpackChunkName: "cof" */ './Cof/Cof.vue').then((m: any) => m.default),
  },
];
