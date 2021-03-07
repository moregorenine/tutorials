<template>
  <div>
    <section>
      <div class="user-container">
        <div>
          <i class="fas fa-user"></i>
        </div>
        <div class="user-description">
          <router-link v-bind:to="`/user/${getItem.user}`">
            {{ getItem.user }}
          </router-link>
          <div class="time-ago">
            {{ getItem.time_ago }}
          </div>
        </div>
      </div>
    </section>
    <section>
      <h2>{{ getItem.title }}</h2>
      <div v-html="getItem.content"></div>
    </section>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  computed: {
    ...mapGetters(['getItem']),
  },
  created() {
    const itemId = this.$route.params.id;
    this.$store.dispatch('FETCH_ITEM', itemId);
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
