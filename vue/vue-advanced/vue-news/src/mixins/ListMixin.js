import bus from '../utils/bus.js';

export default {
  // 재사용할 컴포넌트 옵션
  created() {
    const start = new Date();
    bus.$emit('start:spinner');
    this.$store
      .dispatch('FETCH_LIST', this.$route.name)
      .then(() => {
        const end = new Date();
        bus.$emit('end:spinner');
        console.log(`${end - start} ms`);
      })
      .catch((error) => console.log(error));
  },
};
