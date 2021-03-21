import { createLocalVue, mount } from '@vue/test-utils';
import Vuex, { Store } from 'vuex';
import { i18n } from '@/app/shared/plugins/i18n/i18n';
import Cof from './Cof.vue';
import { IState } from '@/app/state';
import { CofModule } from '../module';

const localVue = createLocalVue();

localVue.use(Vuex);

describe('Cof.vue', () => {
  let store: Store<IState>;

  beforeEach(() => {
    store = new Vuex.Store({
      modules: {
        cof: CofModule,
      },
    } as any);
  });

  test('renders component', () => {
    const wrapper = mount<any>(Cof, {
      store,
      localVue,
      i18n,
      stubs: ['router-link'],
    });

    Cof.prefetch({});

    expect(wrapper.find('h1').text()).toBe('Cof');
  });
});
