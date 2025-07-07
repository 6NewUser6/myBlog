<script setup lang="ts">
import MainHomeContent from "@/views/MainHomeContent.vue";
import { ref, onMounted } from 'vue';

const isContentVisible = ref(false);
const contentRef = ref<HTMLElement | null>(null);

onMounted(() => {
  const observer = new IntersectionObserver(
      ([entry]) => {
        // 当元素1/3可见时更新状态
        isContentVisible.value = entry.intersectionRatio >= 0.33;
      },
      { threshold: [0, 0.33, 1] } // 监听33%可见性
  );

  if (contentRef.value) {
    observer.observe(contentRef.value);
  }
});
</script>

<template>
  <div class="centered-container bg-blue-200">
  </div>
  <div class="mt-[10%]"></div>
  <div ref="contentRef" class="w-full overflow-hidden">
    <MainHomeContent :is-visible="isContentVisible" />
  </div>
</template>

<style scoped>
.centered-container {
  width: 90vw;
  height: 80vh;
  margin: 40px auto;
  padding: 20px; /* 可选内边距 */
  box-sizing: border-box; /* 确保padding不影响总尺寸 */
}
</style>