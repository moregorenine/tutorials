<template>
  <div>
    <svg ref="waferMap" width="500" height="500"></svg>
  </div>
</template>

<script>
export default {
  mounted() {
    const waferMap = [
      { x: 189, y: 185, value: 0 },
      { x: 189, y: 186, value: 2 },
      { x: 189, y: 187, value: 2 },
      { x: 189, y: 188, value: 0 },
      { x: 189, y: 189, value: 3 },
      { x: 189, y: 190, value: 0 },
      { x: 190, y: 182, value: 3 },
      { x: 190, y: 183, value: 3 },
      { x: 190, y: 184, value: 0 },
      { x: 190, y: 185, value: 0 },
      { x: 190, y: 186, value: 0 },
      { x: 190, y: 187, value: 0 },
      { x: 190, y: 188, value: 0 },
      { x: 190, y: 189, value: 0 },
      { x: 190, y: 190, value: 0 },
      { x: 190, y: 191, value: 0 },
      { x: 190, y: 192, value: 0 },
      { x: 190, y: 193, value: 3 },
      { x: 191, y: 180, value: 3 },
      { x: 191, y: 181, value: 0 },
      { x: 191, y: 182, value: 0 },
      { x: 191, y: 183, value: 0 },
      { x: 191, y: 184, value: 0 },
      { x: 191, y: 185, value: 0 },
      { x: 191, y: 186, value: 0 },
      { x: 191, y: 187, value: 3 },
      { x: 191, y: 188, value: 0 },
      { x: 191, y: 189, value: 3 },
      { x: 191, y: 190, value: 3 },
      { x: 191, y: 191, value: 3 },
      { x: 191, y: 192, value: 0 },
      { x: 191, y: 193, value: 0 },
      { x: 191, y: 194, value: 0 },
      { x: 191, y: 195, value: 3 },
      { x: 192, y: 179, value: 3 },
      { x: 192, y: 180, value: 0 },
      { x: 192, y: 181, value: 3 },
      { x: 192, y: 182, value: 0 },
      { x: 192, y: 183, value: 0 },
      { x: 192, y: 184, value: 0 },
      { x: 192, y: 185, value: 0 },
      { x: 192, y: 186, value: 0 },
      { x: 192, y: 187, value: 3 },
      { x: 192, y: 188, value: 3 },
      { x: 192, y: 189, value: 0 },
      { x: 192, y: 190, value: 3 },
      { x: 192, y: 191, value: 0 },
      { x: 192, y: 192, value: 0 },
      { x: 192, y: 193, value: 0 },
      { x: 192, y: 194, value: 0 },
      { x: 192, y: 195, value: 3 },
      { x: 192, y: 196, value: 3 },
      { x: 193, y: 178, value: 3 },
      { x: 193, y: 179, value: 0 },
      { x: 193, y: 180, value: 0 },
      { x: 193, y: 181, value: 0 },
      { x: 193, y: 182, value: 0 },
      { x: 193, y: 184, value: 0 },
      { x: 193, y: 185, value: 0 },
      { x: 193, y: 186, value: 0 },
      { x: 193, y: 187, value: 0 },
      { x: 193, y: 188, value: 3 },
      { x: 193, y: 189, value: 3 },
      { x: 193, y: 190, value: 0 },
      { x: 193, y: 191, value: 3 },
      { x: 193, y: 192, value: 3 },
      { x: 193, y: 193, value: 0 },
      { x: 193, y: 194, value: 0 },
      { x: 193, y: 195, value: 0 },
      { x: 193, y: 196, value: 0 },
      { x: 193, y: 197, value: 0 },
      { x: 194, y: 177, value: 3 },
      { x: 194, y: 178, value: 3 },
      { x: 194, y: 179, value: 0 },
      { x: 194, y: 180, value: 0 },
      { x: 194, y: 181, value: 0 },
      { x: 194, y: 182, value: 0 },
      { x: 194, y: 183, value: 0 },
      { x: 194, y: 184, value: 3 },
      { x: 194, y: 185, value: 0 },
      { x: 194, y: 186, value: 0 },
      { x: 194, y: 187, value: 3 },
      { x: 194, y: 188, value: 3 },
      { x: 194, y: 189, value: 3 },
      { x: 194, y: 190, value: 3 },
      { x: 194, y: 191, value: 3 },
      { x: 194, y: 192, value: 3 },
      { x: 194, y: 193, value: 0 },
      { x: 194, y: 194, value: 0 },
      { x: 194, y: 195, value: 0 },
      { x: 194, y: 196, value: 3 },
      { x: 194, y: 197, value: 0 },
      { x: 194, y: 198, value: 3 },
      { x: 195, y: 177, value: 3 },
      { x: 195, y: 178, value: 3 },
      { x: 195, y: 179, value: 0 },
      { x: 195, y: 180, value: 0 },
      { x: 195, y: 181, value: 0 },
      { x: 195, y: 182, value: 0 },
      { x: 195, y: 183, value: 0 },
      { x: 195, y: 184, value: 0 },
      { x: 195, y: 185, value: 3 },
      { x: 195, y: 186, value: 0 },
      { x: 195, y: 187, value: 3 },
      { x: 195, y: 188, value: 3 },
      { x: 195, y: 189, value: 3 },
      { x: 195, y: 190, value: 3 },
      { x: 195, y: 191, value: 3 },
      { x: 195, y: 192, value: 0 },
      { x: 195, y: 193, value: 0 },
      { x: 195, y: 194, value: 0 },
      { x: 195, y: 195, value: 2 },
      { x: 195, y: 196, value: 0 },
      { x: 195, y: 197, value: 0 },
      { x: 195, y: 198, value: 3 },
      { x: 196, y: 176, value: 0 },
      { x: 196, y: 177, value: 3 },
      { x: 196, y: 178, value: 0 },
      { x: 196, y: 179, value: 3 },
      { x: 196, y: 180, value: 0 },
      { x: 196, y: 181, value: 3 },
      { x: 196, y: 182, value: 3 },
      { x: 196, y: 183, value: 0 },
      { x: 196, y: 184, value: 3 },
      { x: 196, y: 185, value: 0 },
      { x: 196, y: 186, value: 0 },
      { x: 196, y: 187, value: 0 },
      { x: 196, y: 188, value: 0 },
      { x: 196, y: 189, value: 3 },
      { x: 196, y: 190, value: 3 },
      { x: 196, y: 191, value: 0 },
      { x: 196, y: 192, value: 2 },
      { x: 196, y: 193, value: 3 },
      { x: 196, y: 194, value: 3 },
      { x: 196, y: 195, value: 0 },
      { x: 196, y: 196, value: 0 },
      { x: 196, y: 197, value: 3 },
      { x: 196, y: 198, value: 3 },
      { x: 196, y: 199, value: 2 },
      { x: 197, y: 176, value: 3 },
      { x: 197, y: 177, value: 0 },
      { x: 197, y: 178, value: 0 },
      { x: 197, y: 179, value: 0 },
      { x: 197, y: 180, value: 0 },
      { x: 197, y: 181, value: 0 },
      { x: 197, y: 182, value: 3 },
      { x: 197, y: 183, value: 0 },
      { x: 197, y: 184, value: 0 },
      { x: 197, y: 185, value: 0 },
      { x: 197, y: 186, value: 3 },
      { x: 197, y: 187, value: 0 },
      { x: 197, y: 188, value: 0 },
      { x: 197, y: 189, value: 0 },
      { x: 197, y: 190, value: 2 },
      { x: 197, y: 191, value: 0 },
      { x: 197, y: 192, value: 3 },
      { x: 197, y: 193, value: 0 },
      { x: 197, y: 194, value: 0 },
      { x: 197, y: 195, value: 0 },
      { x: 197, y: 196, value: 0 },
      { x: 197, y: 197, value: 0 },
      { x: 197, y: 198, value: 3 },
      { x: 197, y: 199, value: 3 },
      { x: 198, y: 175, value: 3 },
      { x: 198, y: 176, value: 3 },
      { x: 198, y: 177, value: 0 },
      { x: 198, y: 178, value: 0 },
      { x: 198, y: 179, value: 3 },
      { x: 198, y: 180, value: 0 },
      { x: 198, y: 181, value: 0 },
      { x: 198, y: 182, value: 0 },
      { x: 198, y: 183, value: 0 },
      { x: 198, y: 184, value: 0 },
      { x: 198, y: 185, value: 0 },
      { x: 198, y: 186, value: 0 },
      { x: 198, y: 187, value: 3 },
      { x: 198, y: 188, value: 0 },
      { x: 198, y: 189, value: 0 },
      { x: 198, y: 190, value: 0 },
      { x: 198, y: 191, value: 0 },
      { x: 198, y: 192, value: 0 },
      { x: 198, y: 193, value: 0 },
      { x: 198, y: 194, value: 3 },
      { x: 198, y: 195, value: 0 },
      { x: 198, y: 196, value: 0 },
      { x: 198, y: 197, value: 0 },
      { x: 198, y: 198, value: 0 },
      { x: 198, y: 199, value: 3 },
      { x: 199, y: 175, value: 3 },
      { x: 199, y: 176, value: 3 },
      { x: 199, y: 177, value: 3 },
      { x: 199, y: 178, value: 3 },
      { x: 199, y: 179, value: 3 },
      { x: 199, y: 180, value: 0 },
      { x: 199, y: 181, value: 0 },
      { x: 199, y: 182, value: 0 },
      { x: 199, y: 183, value: 0 },
      { x: 199, y: 184, value: 0 },
      { x: 199, y: 185, value: 0 },
      { x: 199, y: 186, value: 0 },
      { x: 199, y: 187, value: 3 },
      { x: 199, y: 188, value: 3 },
      { x: 199, y: 189, value: 3 },
      { x: 199, y: 190, value: 0 },
      { x: 199, y: 191, value: 2 },
      { x: 199, y: 192, value: 3 },
      { x: 199, y: 193, value: 0 },
      { x: 199, y: 194, value: 0 },
      { x: 199, y: 195, value: 0 },
      { x: 199, y: 196, value: 0 },
      { x: 199, y: 197, value: 3 },
      { x: 199, y: 198, value: 0 },
      { x: 199, y: 199, value: 0 },
      { x: 199, y: 200, value: 3 },
      { x: 200, y: 175, value: 3 },
      { x: 200, y: 176, value: 3 },
      { x: 200, y: 177, value: 3 },
      { x: 200, y: 178, value: 3 },
      { x: 200, y: 179, value: 3 },
      { x: 200, y: 180, value: 0 },
      { x: 200, y: 181, value: 3 },
      { x: 200, y: 182, value: 0 },
      { x: 200, y: 183, value: 3 },
      { x: 200, y: 184, value: 0 },
      { x: 200, y: 185, value: 3 },
      { x: 200, y: 186, value: 0 },
      { x: 200, y: 187, value: 0 },
      { x: 200, y: 188, value: 3 },
      { x: 200, y: 189, value: 0 },
      { x: 200, y: 190, value: 3 },
      { x: 200, y: 191, value: 0 },
      { x: 200, y: 192, value: 0 },
      { x: 200, y: 193, value: 0 },
      { x: 200, y: 194, value: 3 },
      { x: 200, y: 195, value: 0 },
      { x: 200, y: 196, value: 0 },
      { x: 200, y: 197, value: 0 },
      { x: 200, y: 198, value: 0 },
      { x: 200, y: 199, value: 3 },
      { x: 200, y: 200, value: 3 },
      { x: 201, y: 175, value: 3 },
      { x: 201, y: 176, value: 3 },
      { x: 201, y: 177, value: 3 },
      { x: 201, y: 178, value: 3 },
      { x: 201, y: 179, value: 3 },
      { x: 201, y: 180, value: 0 },
      { x: 201, y: 181, value: 0 },
      { x: 201, y: 182, value: 0 },
      { x: 201, y: 183, value: 0 },
      { x: 201, y: 184, value: 0 },
      { x: 201, y: 185, value: 0 },
      { x: 201, y: 186, value: 0 },
      { x: 201, y: 187, value: 0 },
      { x: 201, y: 188, value: 3 },
      { x: 201, y: 189, value: 0 },
      { x: 201, y: 190, value: 0 },
      { x: 201, y: 191, value: 0 },
      { x: 201, y: 192, value: 3 },
      { x: 201, y: 193, value: 0 },
      { x: 201, y: 194, value: 0 },
      { x: 201, y: 195, value: 3 },
      { x: 201, y: 197, value: 0 },
      { x: 201, y: 198, value: 0 },
      { x: 201, y: 199, value: 0 },
      { x: 201, y: 200, value: 3 },
      { x: 202, y: 175, value: 3 },
      { x: 202, y: 176, value: 3 },
      { x: 202, y: 177, value: 3 },
      { x: 202, y: 178, value: 3 },
      { x: 202, y: 179, value: 3 },
      { x: 202, y: 180, value: 0 },
      { x: 202, y: 181, value: 0 },
      { x: 202, y: 182, value: 0 },
      { x: 202, y: 183, value: 0 },
      { x: 202, y: 184, value: 0 },
      { x: 202, y: 185, value: 0 },
      { x: 202, y: 186, value: 3 },
      { x: 202, y: 187, value: 0 },
      { x: 202, y: 188, value: 0 },
      { x: 202, y: 189, value: 3 },
      { x: 202, y: 190, value: 0 },
      { x: 202, y: 191, value: 0 },
      { x: 202, y: 192, value: 0 },
      { x: 202, y: 193, value: 0 },
      { x: 202, y: 194, value: 0 },
      { x: 202, y: 195, value: 0 },
      { x: 202, y: 196, value: 3 },
      { x: 202, y: 197, value: 0 },
      { x: 202, y: 198, value: 0 },
      { x: 202, y: 199, value: 0 },
      { x: 202, y: 200, value: 3 },
      { x: 203, y: 175, value: 3 },
      { x: 203, y: 176, value: 0 },
      { x: 203, y: 177, value: 0 },
      { x: 203, y: 178, value: 0 },
      { x: 203, y: 179, value: 3 },
      { x: 203, y: 180, value: 0 },
      { x: 203, y: 181, value: 0 },
      { x: 203, y: 182, value: 0 },
      { x: 203, y: 183, value: 0 },
      { x: 203, y: 184, value: 0 },
      { x: 203, y: 185, value: 0 },
      { x: 203, y: 186, value: 3 },
      { x: 203, y: 187, value: 0 },
      { x: 203, y: 188, value: 3 },
      { x: 203, y: 189, value: 0 },
      { x: 203, y: 190, value: 0 },
      { x: 203, y: 191, value: 0 },
      { x: 203, y: 192, value: 3 },
      { x: 203, y: 193, value: 0 },
      { x: 203, y: 194, value: 0 },
      { x: 203, y: 195, value: 1 },
      { x: 203, y: 196, value: 0 },
      { x: 203, y: 197, value: 0 },
      { x: 203, y: 198, value: 3 },
      { x: 203, y: 199, value: 0 },
      { x: 203, y: 200, value: 3 },
      { x: 204, y: 176, value: 0 },
      { x: 204, y: 177, value: 3 },
      { x: 204, y: 178, value: 0 },
      { x: 204, y: 179, value: 3 },
      { x: 204, y: 180, value: 0 },
      { x: 204, y: 181, value: 3 },
      { x: 204, y: 182, value: 0 },
      { x: 204, y: 183, value: 3 },
      { x: 204, y: 184, value: 0 },
      { x: 204, y: 185, value: 3 },
      { x: 204, y: 186, value: 3 },
      { x: 204, y: 187, value: 0 },
      { x: 204, y: 188, value: 0 },
      { x: 204, y: 189, value: 3 },
      { x: 204, y: 190, value: 0 },
      { x: 204, y: 191, value: 0 },
      { x: 204, y: 192, value: 0 },
      { x: 204, y: 193, value: 0 },
      { x: 204, y: 194, value: 0 },
      { x: 204, y: 195, value: 0 },
      { x: 204, y: 196, value: 0 },
      { x: 204, y: 197, value: 0 },
      { x: 204, y: 198, value: 3 },
      { x: 204, y: 199, value: 0 },
      { x: 205, y: 176, value: 0 },
      { x: 205, y: 177, value: 0 },
      { x: 205, y: 178, value: 0 },
      { x: 205, y: 179, value: 3 },
      { x: 205, y: 180, value: 3 },
      { x: 205, y: 181, value: 3 },
      { x: 205, y: 182, value: 0 },
      { x: 205, y: 183, value: 3 },
      { x: 205, y: 184, value: 0 },
      { x: 205, y: 185, value: 0 },
      { x: 205, y: 186, value: 0 },
      { x: 205, y: 187, value: 0 },
      { x: 205, y: 188, value: 0 },
      { x: 205, y: 189, value: 0 },
      { x: 205, y: 190, value: 3 },
      { x: 205, y: 191, value: 0 },
      { x: 205, y: 192, value: 0 },
      { x: 205, y: 193, value: 0 },
      { x: 205, y: 194, value: 0 },
      { x: 205, y: 195, value: 0 },
      { x: 205, y: 196, value: 0 },
      { x: 205, y: 197, value: 0 },
      { x: 205, y: 198, value: 0 },
      { x: 205, y: 199, value: 3 },
      { x: 206, y: 177, value: 0 },
      { x: 206, y: 178, value: 0 },
      { x: 206, y: 179, value: 3 },
      { x: 206, y: 180, value: 0 },
      { x: 206, y: 181, value: 0 },
      { x: 206, y: 182, value: 0 },
      { x: 206, y: 183, value: 0 },
      { x: 206, y: 184, value: 0 },
      { x: 206, y: 185, value: 0 },
      { x: 206, y: 186, value: 0 },
      { x: 206, y: 187, value: 0 },
      { x: 206, y: 188, value: 0 },
      { x: 206, y: 189, value: 0 },
      { x: 206, y: 190, value: 0 },
      { x: 206, y: 191, value: 0 },
      { x: 206, y: 192, value: 0 },
      { x: 206, y: 193, value: 0 },
      { x: 206, y: 194, value: 0 },
      { x: 206, y: 195, value: 0 },
      { x: 206, y: 196, value: 0 },
      { x: 206, y: 197, value: 0 },
      { x: 206, y: 198, value: 0 },
      { x: 207, y: 177, value: 3 },
      { x: 207, y: 178, value: 3 },
      { x: 207, y: 179, value: 0 },
      { x: 207, y: 180, value: 3 },
      { x: 207, y: 181, value: 0 },
      { x: 207, y: 183, value: 0 },
      { x: 207, y: 184, value: 0 },
      { x: 207, y: 185, value: 0 },
      { x: 207, y: 186, value: 0 },
      { x: 207, y: 187, value: 2 },
      { x: 207, y: 188, value: 0 },
      { x: 207, y: 189, value: 0 },
      { x: 207, y: 190, value: 3 },
      { x: 207, y: 191, value: 3 },
      { x: 207, y: 192, value: 0 },
      { x: 207, y: 193, value: 0 },
      { x: 207, y: 194, value: 0 },
      { x: 207, y: 195, value: 0 },
      { x: 207, y: 196, value: 0 },
      { x: 207, y: 197, value: 3 },
      { x: 207, y: 198, value: 3 },
      { x: 208, y: 178, value: 3 },
      { x: 208, y: 179, value: 3 },
      { x: 208, y: 180, value: 0 },
      { x: 208, y: 181, value: 0 },
      { x: 208, y: 182, value: 0 },
      { x: 208, y: 183, value: 0 },
      { x: 208, y: 184, value: 0 },
      { x: 208, y: 185, value: 0 },
      { x: 208, y: 186, value: 0 },
      { x: 208, y: 187, value: 0 },
      { x: 208, y: 188, value: 3 },
      { x: 208, y: 189, value: 0 },
      { x: 208, y: 190, value: 0 },
      { x: 208, y: 191, value: 2 },
      { x: 208, y: 192, value: 0 },
      { x: 208, y: 193, value: 3 },
      { x: 208, y: 194, value: 3 },
      { x: 208, y: 195, value: 0 },
      { x: 208, y: 196, value: 0 },
      { x: 208, y: 197, value: 3 },
      { x: 209, y: 179, value: 3 },
      { x: 209, y: 180, value: 0 },
      { x: 209, y: 181, value: 0 },
      { x: 209, y: 182, value: 0 },
      { x: 209, y: 185, value: 0 },
      { x: 209, y: 186, value: 0 },
      { x: 209, y: 187, value: 0 },
      { x: 209, y: 188, value: 0 },
      { x: 209, y: 189, value: 0 },
      { x: 209, y: 190, value: 3 },
      { x: 209, y: 191, value: 2 },
      { x: 209, y: 192, value: 0 },
      { x: 209, y: 193, value: 0 },
      { x: 209, y: 194, value: 0 },
      { x: 209, y: 195, value: 0 },
      { x: 209, y: 196, value: 3 },
      { x: 210, y: 180, value: 3 },
      { x: 210, y: 181, value: 0 },
      { x: 210, y: 182, value: 0 },
      { x: 210, y: 183, value: 3 },
      { x: 210, y: 184, value: 3 },
      { x: 210, y: 185, value: 3 },
      { x: 210, y: 186, value: 0 },
      { x: 210, y: 187, value: 0 },
      { x: 210, y: 188, value: 0 },
      { x: 210, y: 189, value: 0 },
      { x: 210, y: 190, value: 0 },
      { x: 210, y: 191, value: 3 },
      { x: 210, y: 192, value: 0 },
      { x: 210, y: 193, value: 0 },
      { x: 210, y: 194, value: 0 },
      { x: 210, y: 195, value: 3 },
      { x: 211, y: 182, value: 3 },
      { x: 211, y: 183, value: 0 },
      { x: 211, y: 184, value: 0 },
      { x: 211, y: 185, value: 3 },
      { x: 211, y: 186, value: 0 },
      { x: 211, y: 187, value: 3 },
      { x: 211, y: 188, value: 0 },
      { x: 211, y: 189, value: 0 },
      { x: 211, y: 190, value: 0 },
      { x: 211, y: 191, value: 0 },
      { x: 211, y: 192, value: 0 },
      { x: 211, y: 193, value: 3 },
      { x: 212, y: 184, value: 3 },
      { x: 212, y: 185, value: 3 },
      { x: 212, y: 186, value: 0 },
      { x: 212, y: 187, value: 0 },
      { x: 212, y: 189, value: 2 },
      { x: 212, y: 190, value: 0 },
      { x: 212, y: 191, value: 3 },
    ];
    const svg = this.$_WaferMap.select(this.$refs.waferMap);
    const width = +svg.attr('width');
    const height = +svg.attr('height');

    const render = (waferMap) => {
      console.log('1');
      console.log(waferMap);
      const xValue = (d) => d.x;
      const xValueMin = this.$_WaferMap.min(waferMap, xValue);
      console.log(xValueMin);
      const xValueMax = this.$_WaferMap.max(waferMap, xValue);
      console.log(xValueMax);
      const yValue = (d) => d.y;
      const yValueMin = this.$_WaferMap.min(waferMap, yValue);
      const yValueMax = this.$_WaferMap.max(waferMap, yValue);
      const margin = {
        top: 20,
        right: 20,
        bottom: 50,
        left: 50,
      };
      const innerWidth = width - margin.left - margin.right;
      const innerHeight = height - margin.top - margin.bottom;
      const xScale = this.$_WaferMap.scaleLinear()
        .domain([this.$_WaferMap.min(waferMap, xValue) - 1, this.$_WaferMap.max(waferMap, xValue) + 1])
        .range([0, innerWidth]);
      const yScale = this.$_WaferMap.scaleLinear()
        .domain([this.$_WaferMap.max(waferMap, yValue) + 1, this.$_WaferMap.min(waferMap, yValue) - 1])
        .range([0, innerHeight]);
      console.log(xScale.domain());
      console.log(yScale.domain());
      const g = svg
        .append('g')
        .attr('transform', `translate(${margin.left},${margin.top})`);
      g.append('g').call(this.$_WaferMap.axisLeft(yScale));
      g.append('g')
        .call(this.$_WaferMap.axisBottom(xScale))
        .attr('transform', `translate(0,${innerHeight})`);
      g.selectAll('rect')
        .data(waferMap)
        .enter()
        .append('rect')
        .attr('x', (d) => xScale(xValue(d) - 0.5))
        .attr('y', (d) => yScale(yValue(d) + 0.5))
        .attr('width', innerWidth / (xValueMax - xValueMin + 3))
        .attr('height', innerHeight / (yValueMax - yValueMin + 3));
    };

    render(waferMap);
  },
};
</script>

<style></style>
