import Vue from 'vue';
import Vuex from 'vuex';
import { fetchNewsList, fetchAskList, fetchJobsList, fetchUser } from '../api/index.js';

Vue.use(Vuex);

export const store = new Vuex.Store({
  state: {
    news: [],
    ask: [],
    jobs: [],
    user: {},
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
  },
  actions: {
    FETCH_NEWS_LIST(context) {
      fetchNewsList()
        .then((response) => {
          context.commit('SET_NEWS', response.data);
        })
        .catch((error) => console.log(error));
    },
    FETCH_ASK_LIST({ commit }) {
      fetchAskList()
        .then(({ data }) => {
          commit('SET_ASK', data);
        })
        .catch((error) => console.log(error));
    },
    FETCH_JOBS_LIST({ commit }) {
      fetchJobsList()
        .then(({ data }) => {
          commit('SET_JOBS', data);
        })
        .catch((error) => console.log(error));
    },
    FETCH_USER({ commit }, userName) {
      fetchUser(userName)
        .then(({ data }) => {
          commit('SET_USER', data);
        })
        .catch((error) => console.log(error));
    },
  },
});
