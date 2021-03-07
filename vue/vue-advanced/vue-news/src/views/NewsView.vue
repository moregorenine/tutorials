<template>
  <div>
    <p v-for="item in getNews" v-bind:key="item.id">
      <a v-bind:href="item.url">{{ item.title }}</a>
      <small>
        {{ item.time_ago }} by
        <router-link v-bind:to="`/user/${item.user}`">{{ item.user }}</router-link>
      </small>
    </p>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  computed: {
    ...mapGetters(['getNews']),
    // // ver.3
    // ...mapGetters({
    //   news: 'getNews',
    // }),
    // // ver.2
    // ...mapState({
    //   news: (state) => state.news,
    // }),
    // // ver.1
    // news() {
    //   return this.$store.state.news;
    // },
  },
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
