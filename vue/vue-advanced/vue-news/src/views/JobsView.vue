<template>
  <div>
    <span v-for="item in this.$store.state.jobs">{{ item.title }}</span>
  </div>
</template>

<script>
export default {
  created() {
    this.$store.dispatch('FETCH_JOBS_LIST');
  },
};
</script>

<style></style>
