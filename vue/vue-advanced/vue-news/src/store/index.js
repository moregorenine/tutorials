import Vue from 'vue';
import Vuex from 'vuex';
import {
  fetchNewsList,
  fetchAskList,
  fetchJobsList,
  fetchList,
  fetchUser,
  fetchItem,
} from '../api/index.js';

Vue.use(Vuex);

export const store = new Vuex.Store({
  state: {
    news: [],
    ask: [],
    jobs: [],
    user: {},
    item: {},
    list: {},
  },
  getters: {
    getNews(state) {
      return state.news;
    },
    getAsk(state) {
      return state.ask;
    },
    getJobs(state) {
      return state.jobs;
    },
    getUser(state) {
      return state.user;
    },
    getItem(state) {
      return state.item;
    },
    getList(state) {
      return state.list;
    },
  },
  mutations: {
    SET_NEWS(state, data) {
      state.news = data;
    },
    SET_ASK(state, data) {
      state.ask = data;
    },
    SET_JOBS(state, data) {
      state.jobs = data;
    },
    SET_USER(state, data) {
      state.user = data;
    },
    SET_ITEM(state, data) {
      state.item = data;
    },
    SET_LIST(state, data) {
      state.list = data;
    },
  },
  actions: {
    // FETCH_NEWS_LIST(context) {
    //   return fetchNewsList()
    //     .then((response) => {
    //       context.commit('SET_NEWS', response.data);
    //     })
    //     .catch((error) => console.log(error));
    // },
    async FETCH_NEWS_LIST(context) {
      const response = await fetchNewsList();
      context.commit('SET_NEWS', response.data);
      return response;
    },
    FETCH_ASK_LIST({ commit }) {
      return fetchAskList()
        .then(({ data }) => {
          commit('SET_ASK', data);
        })
        .catch((error) => console.log(error));
    },
    FETCH_JOBS_LIST({ commit }) {
      return fetchJobsList()
        .then(({ data }) => {
          commit('SET_JOBS', data);
        })
        .catch((error) => console.log(error));
    },
    FETCH_USER({ commit }, userName) {
      return fetchUser(userName)
        .then(({ data }) => {
          commit('SET_USER', data);
        })
        .catch((error) => console.log(error));
    },
    FETCH_ITEM({ commit }, itemId) {
      return fetchItem(itemId)
        .then(({ data }) => {
          commit('SET_ITEM', data);
        })
        .catch((error) => console.log(error));
    },
    FETCH_LIST({ commit }, pageName) {
      return fetchList(pageName)
        .then((response) => {
          commit('SET_LIST', response.data);
          return response;
        })
        .catch((error) => console.log(error));
    },
  },
});
