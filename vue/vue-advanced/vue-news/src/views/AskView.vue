<template>
  <div>
    <span v-for="item in this.$store.state.ask">{{ item.title }}</span>
  </div>
</template>

<script>
export default {
  created() {
    this.$store.dispatch('FETCH_ASK_LIST');
  },
};
</script>

<style></style>
