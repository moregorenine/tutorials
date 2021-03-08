<template>
  <div>
    <list-item></list-item>
    <!-- <ul class="news-list">
      <li v-for="item in getJobs" v-bind:key="item.id" class="post">
        <div class="points">
          {{ item.points || 0 }}
        </div>
        <div>
          <p class="news-title">
            <a v-bind:href="item.url">{{ item.title }}</a>
          </p>
          <small class="link-text">
            {{ item.time_ago }} by
            <a v-bind:href="item.url">{{ item.domain }}</a>
          </small>
        </div>
      </li>
    </ul> -->
  </div>
</template>

<script>
import ListItem from '../components/ListItem.vue';

export default {
  components: {
    ListItem,
  },
};
// import { mapGetters } from 'vuex';

// export default {
//   computed: {
//     ...mapGetters(['getJobs']),
//   },
//   created() {
//     this.$store.dispatch('FETCH_JOBS_LIST');
//   },
// };
</script>