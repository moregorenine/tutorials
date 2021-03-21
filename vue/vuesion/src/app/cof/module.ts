import { Module } from 'vuex';
import { IState } from '@/app/state';
import { CofDefaultState, ICofState } from './state';
import { CofActions } from './actions';
import { CofGetters } from './getters';
import { CofMutations } from './mutations';

export const CofModule: Module<ICofState, IState> = {
  namespaced: true,
  actions: {
    ...CofActions,
  },
  getters: {
    ...CofGetters,
  },
  state: {
    ...CofDefaultState(),
  },
  mutations: {
    ...CofMutations,
  },
};
