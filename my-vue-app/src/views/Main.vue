<script setup lang="ts">
import topWrapper from "@/components/layout/topWrapper.vue";
</script>

<template>
  <div class="app-container">
    <topWrapper class="sticky-header bg-green-500/30" />
    <div class="router-view-container">
      <router-view></router-view>
    </div>
  </div>
</template>

<style scoped>
.app-container {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}

.sticky-header {
  position: sticky;
  top: 0;
  z-index: 100;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); /* 可选阴影，增强固定效果 */
}

.router-view-container {
  flex: 1;
  width: 100%;
  overflow: auto;
  padding-top: 16px; /* 可选：避免内容紧贴导航栏 */
}
</style>