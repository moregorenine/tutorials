import ListView from './ListView.vue';
import bus from '../utils/bus.js';

export default function createListView(name) {
  return {
    // 재사용할 인스턴스(컴포넌트) 옵션들이 들어갈 자리
    name: name,
    created() {
      const start = new Date();
      bus.$emit('start:spinner');
      setTimeout(() => {
        this.$store
          .dispatch('FETCH_LIST', this.$route.name)
          .then(() => {
            const end = new Date();
            alert(`${end - start} ms`);
            bus.$emit('end:spinner');
          })
          .catch((error) => console.log(error));
      }, 3000);
    },
    render(createElement) {
      return createElement(ListView);
    },
  };
}
