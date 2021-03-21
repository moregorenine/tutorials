import { AppDefaultState, IAppState } from './app/state';
import { AuthDefaultState, IAuthState } from './shared/modules/auth/state';
import { ICounterState } from './example/counter/state';
import { ICofState } from './cof/state';

export interface IState {
  [key: string]: any;

  app?: IAppState;
  auth?: IAuthState;
  counter?: ICounterState;
  cof?: ICofState;
}

export const DefaultState: IState = {
  app: {
    ...AppDefaultState(),
    ...AuthDefaultState(),
  },
};
