<template>
  <div>
    <span v-for="item in news">{{ item.title }}</span>
  </div>
</template>

<script>
import { fetchNewsList } from '../api/index.js';

export default {
  data() {
    return {
      news: [],
    };
  },
  created() {
    fetchNewsList()
      .then((response) => (this.news = response.data))
      .catch((error) => console.log(error));
  },
};
</script>

<style></style>
