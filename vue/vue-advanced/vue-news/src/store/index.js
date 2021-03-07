import Vue from 'vue';
import Vuex from 'vuex';
import { fetchNewsList } from '../api/index.js';

Vue.use(Vuex);

export const store = new Vuex.Store({
  state: {
    news: [],
  },
  actions: {
    FETCH_NEWS_LIST(context) {
      fetchNewsList()
        .then((response) => {
          context.commit('SET_NEWS', response.data);
        })
        .catch((error) => console.log(error));
    },
  },
  mutations: {
    SET_NEWS(state, news) {
      state.news = news;
    },
  },
  // getters,
});
