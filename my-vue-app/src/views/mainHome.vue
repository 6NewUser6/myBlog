<script setup lang="ts">
import MainHomeContent from "@/views/MainHomeContent.vue";
import { ref, onMounted, onBeforeUnmount } from 'vue';

// 轮播图相关
const currentIndex = ref(0);
const images = [
  { id: 0, src: '/resources/img_0.png' },
  { id: 1, src: '/resources/img_1.png' },
  { id: 2, src: '/resources/img_2.png' },
];
let intervalId: number;

// 可见性检测相关
const isContentVisible = ref(false);
const contentRef = ref<HTMLElement | null>(null);

// 轮播图控制
const startCarousel = () => {
  intervalId = window.setInterval(() => {
    nextSlide();
  }, 3000);
};

const stopCarousel = () => {
  clearInterval(intervalId);
};

// 新增：上一张
const prevSlide = () => {
  currentIndex.value = (currentIndex.value - 1 + images.length) % images.length;
  resetInterval();
};

// 新增：下一张
const nextSlide = () => {
  currentIndex.value = (currentIndex.value + 1) % images.length;
  resetInterval();
};

// 新增：重置定时器
const resetInterval = () => {
  stopCarousel();
  startCarousel();
};

onMounted(() => {
  startCarousel();

  const observer = new IntersectionObserver(
      ([entry]) => {
        isContentVisible.value = entry.intersectionRatio >= 0.33;
      },
      { threshold: [0, 0.33, 1] }
  );

  if (contentRef.value) {
    observer.observe(contentRef.value);
  }
});

onBeforeUnmount(() => {
  stopCarousel();
});
</script>

<template>
  <div class="centered-container bg-blue-200 relative overflow-hidden">
    <!-- 轮播图 -->
    <div
        v-for="(image, index) in images"
        :key="image.id"
        class="absolute inset-0 transition-opacity duration-1000 flex items-center justify-center"
        :class="{ 'opacity-100 z-10': index === currentIndex, 'opacity-0': index !== currentIndex }"
    >
      <img
          :src="image.src"
          :alt="'Image ' + image.id"
          class="max-w-full max-h-full object-contain"
      />
    </div>

    <button
        @click="prevSlide"
        class="arrow-btn left-4"
        aria-label="Previous"
    >
      <
    </button>

    <button
        @click="nextSlide"
        class="arrow-btn right-4"
        aria-label="Next"
    >
      >
    </button>

    <!-- 导航点 -->
    <div class="absolute bottom-4 left-0 right-0 flex justify-center gap-2 z-20">
      <button
          v-for="(_, index) in images"
          :key="index"
          @click="currentIndex = index; resetInterval()"
          class="w-3 h-3 rounded-full transition-all"
          :class="index === currentIndex ? 'bg-white w-6' : 'bg-white bg-opacity-50'"
      ></button>
    </div>
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
  box-sizing: border-box;
  display: flex;
  justify-content: center;
  align-items: center;
}

.arrow-btn {
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  width: 40px;
  height: 40px;
  color: white;
  font-size: 24px;
  font-weight: bold;
  display: flex;
  align-items: center;
  justify-content: center;
  border: none;
  border-radius: 50%;
  cursor: pointer;
  z-index: 20;
  transition: background 0.3s;
}

.arrow-btn:hover {
  background: rgba(255,255,255,0.6);
}

</style>