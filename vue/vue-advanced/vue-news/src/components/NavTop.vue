<template>
  <div class="navtop">
    <router-link to="/news">News</router-link> |
    <router-link to="/ask">Ask</router-link> |
    <router-link to="/jobs">Jobs</router-link> |
    <router-link to="/wafer-map">Wafer Map</router-link>
  </div>
</template>

<style scoped>
.navtop {
  color: white;
  background: #42b883;
  display: flex;
  padding: 8px;
}

.navtop .router-link-exact-active {
    color: #35495e;
}

.navtop a {
    color: white;
}
</style>
