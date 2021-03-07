<template>
  <div id="app">
    <nav-top></nav-top>
    <transition name="fade">
      <router-view></router-view>
    </transition>
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

.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.5s;
}
.fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
  opacity: 0;
}
</style>
