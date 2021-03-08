<template>
  <div>
    <ul class="news-list">
      <li v-for="item in getNews" v-bind:key="item.id" class="post">
        <div class="points">
          {{ item.points }}
        </div>
        <div>
          <p class="news-title">
            <a v-bind:href="item.url">
              {{ item.title }}
            </a>
          </p>
          <small class="link-text">
            {{ item.time_ago }} by
            <router-link v-bind:to="`/user/${item.user}`" class="link-text">
              {{ item.user }}
            </router-link>
          </small>
        </div>
      </li>
    </ul>
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

<style scoped>
.news-list {
  margin: 0;
  padding: 0;
}

.post {
  list-style: none;
  display: flex;
  align-items: center;
  border-bottom: 1px solid #eee;
}

.points {
  width: 80px;
  height: 60px;
  display: flex;
  align-items: center;
  justify-content: center;
  color: #42b883;
}

.news-title {
  margin: 0;
}

.link-text {
  color: #828282;
}
</style>
