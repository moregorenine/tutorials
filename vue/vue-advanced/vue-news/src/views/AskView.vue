<template>
  <div>
    <p v-for="item in getAsk" v-bind:key="item.id">
      <!-- <a v-bind:href="item.url">{{ item.title }}</a> -->
      <router-link v-bind:to="`/item/${item.id}`">{{ item.title }}</router-link>
      <small> {{ item.time_ago }} by {{ item.user }}</small>
    </p>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  computed: {
    ...mapGetters(['getAsk']),
  },
  created() {
    this.$store.dispatch('FETCH_ASK_LIST');
  },
};
</script>

<style></style>
