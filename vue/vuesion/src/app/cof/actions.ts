import { ActionContext } from 'vuex';
import { ICofState } from './state';
import { IState } from '@/app/state';
import { HttpService } from '@/app/shared/services/HttpService/HttpService';

export interface ICofActions {
  /**
   * put your action names, parameters and return values here, for example:
   * myAction(context: ActionContext<ICofState, IState>, param: any): Promise<any>;
   */
}

export const CofActions: ICofActions = {
  /**
   * here comes the implementation of your actions, for example:
   * myAction({ commit }, param) {
   *   commit('MY_MUTATION);
   * }
   */
};
