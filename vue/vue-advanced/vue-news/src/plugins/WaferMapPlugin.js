import { select, csv, scaleLinear, min, max, axisLeft, axisBottom } from 'd3';

export default {
  install(Vue) {
    console.log('WaferMap plugin loaded');
    Vue.prototype.$_WaferMap = {
      select,
      csv,
      scaleLinear,
      min,
      max,
      axisLeft,
      axisBottom,
    };
  },
};
