<template>
  <div>
    <span v-for="item in ask">{{ item.title }}</span>
  </div>
</template>

<script>
import { fetchAskList } from '../api/index.js';

export default {
  data() {
    return {
      ask: [],
    };
  },
  created() {
    fetchAskList()
      .then((response) => (this.ask = response.data))
      .catch((error) => console.log(error));
  },
};
</script>

<style></style>
