<template>
  <div>
    <list-item></list-item>
    <!-- <ul class="news-list">
      <li v-for="item in getAsk" v-bind:key="item.id" class="post">
        <div class="points">
          {{ item.points }}
        </div>
        <div>
          <p class="news-title">
            <router-link v-bind:to="`/item/${item.id}`">
              {{ item.title }}
            </router-link>
          </p>
          <small class="link-text">
            {{ item.time_ago }} by
            <router-link v-bind:to="`/user/${item.user}`" class="link-text">
              {{ item.user }}
            </router-link>
          </small>
        </div>
      </li>
    </ul> -->
  </div>
</template>

<script>
import ListItem from '../components/ListItem.vue';
import bus from '../utils/bus.js';

export default {
  components: {
    ListItem,
  },
  mounted() {
    bus.$emit('end:spinner');
  },
};
// import { mapGetters } from 'vuex';

// export default {
//   computed: {
//     ...mapGetters(['getAsk']),
//   },
//   created() {
//     this.$store.dispatch('FETCH_ASK_LIST');
//   },
// };
</script>
