<template>
  <div id="app">
    <nav-top></nav-top>
    <router-view></router-view>
  </div>
</template>

<script>
import NavTop from './components/NavTop.vue';
export default {
  components: {
    NavTop,
  },
};
</script>

<style>
body {
  padding: 0;
  margin: 0;
}
</style>
