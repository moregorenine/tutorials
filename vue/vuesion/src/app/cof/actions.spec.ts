import { ActionContext, Commit, Dispatch } from 'vuex';
import MockAdapter from 'axios-mock-adapter';
import { CofDefaultState, ICofState } from './state';
import { IState } from '@/app/state';
import { CofActions } from './actions';
import { HttpService } from '@/app/shared/services/HttpService/HttpService';

describe('CofActions', () => {
  let testContext: ActionContext<ICofState, IState>;
  let mockAxios: MockAdapter;

  beforeEach(() => {
    testContext = {
      dispatch: jest.fn() as Dispatch,
      commit: jest.fn() as Commit,
      state: CofDefaultState(),
    } as ActionContext<ICofState, IState>;

    mockAxios = new MockAdapter(HttpService);
  });

  test('Please write the tests for the actions here', () => {
    // here is an example: https://github.com/vuesion/vuesion/blob/master/src/app/counter/actions.spec.ts
    expect(true).toBeFalsy();
  });
});
