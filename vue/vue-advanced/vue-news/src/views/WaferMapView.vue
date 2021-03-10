<template>
  <div>
    <svg width="500" height="500" id="target1"></svg>
    <svg width="500" height="500" id="target2"></svg>
    <svg width="500" height="500" id="target3"></svg>
    <svg width="500" height="500" id="target4"></svg>
    <svg width="500" height="500" id="target5"></svg>
    <wafer-map tagetid="target1"></wafer-map>
    <wafer-map tagetid="target2"></wafer-map>
    <wafer-map tagetid="target3"></wafer-map>
    <wafer-map tagetid="target4"></wafer-map>
    <wafer-map tagetid="target5"></wafer-map>
  </div>
</template>

<script>
import WaferMap from '../components/WaferMap.vue';
export default {
  components: {
    WaferMap,
  },
};
</script>
