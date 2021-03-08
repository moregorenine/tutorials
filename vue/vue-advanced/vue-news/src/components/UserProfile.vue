<template>
  <div class="user-container">
    <div>
      <i class="fas fa-user"></i>
    </div>
    <div class="user-description">
      <slot name="username"></slot>
      <div class="time-ago">
          <slot name="time"></slot>
          <slot name="karma"></slot>
      </div>
      <!-- <div>
        {{ user.id }}
      </div>
      <div class="time-ago">
        {{ user.created }}
      </div> -->
    </div>
  </div>
</template>

<script>
export default {
  props: {
    info: Object,
  },
  computed: {
    user() {
      return this.$store.state.user;
    },
  },
};
</script>

<style scoped>
.user-container {
  display: flex;
  align-items: center;
  padding: 0.5rem;
}

.fa-user {
  font-size: 2.5rem;
}

.user-description {
  padding-left: 8px;
}

.time-ago {
  font-size: 0.7rem;
}
</style>
