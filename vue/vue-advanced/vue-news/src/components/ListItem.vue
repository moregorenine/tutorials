<template>
  <div>
    <ul class="news-list">
      <li v-for="item in listItems" v-bind:key="item.id" class="post">
        <div class="points">
          {{ item.points || 0 }}
        </div>
        <div>
          <p class="news-title">
            <template v-if="item.domain">
              <a v-bind:href="item.url">
                {{ item.title }}
              </a>
            </template>
            <template v-else>
              <router-link v-bind:to="`/item/${item.id}`">
                {{ item.title }}
              </router-link>
            </template>
          </p>
          <small class="link-text">
            {{ item.time_ago }} by
            <template v-if="item.user">
              <router-link v-bind:to="`/user/${item.user}`" class="link-text">
                {{ item.user }}
              </router-link>
            </template>
            <template v-else>
              <a v-bind:href="item.url">{{ item.domain }}</a>
            </template>
          </small>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
// import { mapGetters } from 'vuex';

export default {
  computed: {
    listItems() {
      return this.$store.state.list;
      // const routeName = this.$route.name;
      // if ('news' === routeName) {
      //   return this.$store.state.news;
      // } else if ('ask' === routeName) {
      //   return this.$store.state.ask;
      // } else if ('jobs' === routeName) {
      //   return this.$store.state.jobs;
      // }
      // return null;
    },

    // // ver.4
    // ...mapGetters(['getNews']),
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

    // // store 적용 후
    // this.$store.dispatch('FETCH_NEWS_LIST');

    // 1.component 적용 후
    // 2.CreateListView.js로 하이 오더 컴포넌트화
    // const routeName = this.$route.name;
    // switch (routeName) {
    //   case 'news':
    //     this.$store.dispatch('FETCH_NEWS_LIST');
    //     break;
    //   case 'ask':
    //     this.$store.dispatch('FETCH_ASK_LIST');
    //     break;
    //   case 'jobs':
    //     this.$store.dispatch('FETCH_JOBS_LIST');
    //     break;
    //   default:
    //     break;
    // }
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
