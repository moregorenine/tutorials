<template>
  <div>
    <span v-for="item in this.$store.state.news">{{ item.title }}</span>
  </div>
</template>

<script>
export default {
  // // store 적용 전
  // data() {
  //   return {
  //     news: [],
  //   };
  // },
  created() {
    // // store 적용 전
    // fetchNewsList()
    //   .then((response) => (this.news = response.data))
    //   .catch((error) => console.log(error));// store 적용 전
    // store 적용 후
    this.$store.dispatch('FETCH_NEWS_LIST');
  },
};
</script>

<style></style>
