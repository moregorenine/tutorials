<template>
  <div>
    <section>
      <user-profile v-bind:info="getItem">
        <!-- <div slot="username">{{ getItem.user }}</div> -->
        <router-link slot="username" v-bind:to="`/user/${getItem.user}`">
          {{ getItem.user }}
        </router-link>
        <div slot="time">{{ 'Posted ' + getItem.time_ago }}</div>
      </user-profile>
      <!-- <div class="user-container">
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
      </div> -->
    </section>
    <section>
      <h2>{{ getItem.title }}</h2>
    </section>
    <section>
      <div v-html="getItem.content"></div>
    </section>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
import UserProfile from '../components/UserProfile.vue';

export default {
  components: {
    UserProfile,
  },
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
