<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();
const pinkDiv = ref(null);
const blueContainer = ref(null);

const toMain = () => {
  // 1. 粉色div绕上边缘翻转180度（显示反面）
  pinkDiv.value.style.transform = 'rotateX(-180deg)';
  pinkDiv.value.style.transformOrigin = 'top center';
  pinkDiv.value.style.transition = 'transform 0.8s ease';

  // 2. 延迟后淡出蓝色容器
  setTimeout(() => {
    blueContainer.value.style.opacity = '0';
    blueContainer.value.style.transition = 'opacity 0.5s ease';
  }, 800);

  // 3. 跳转路由
  setTimeout(() => {
    router.push('/main/home');
  }, 1300);
};
</script>

<template>
  <div class="w-screen h-screen bg-gray-200 flex justify-center items-center relative perspective-1000">
    <div
        ref="blueContainer"
        class="w-[80%] h-[60%] bg-blue-300 absolute top-[20%] flex flex-col overflow-visible"
        style="transform-style: preserve-3d;"
    >
      <!-- 粉色div（包含正反两面） -->
      <div
          ref="pinkDiv"
          class="h-1/3 relative transition-transform duration-800 ease-out"
          style="transform-style: preserve-3d;"
      >
        <!-- 正面（默认可见） -->
        <div class="absolute inset-0 bg-pink-300" style="backface-visibility: hidden;"></div>
        <!-- 反面（翻转后可见） -->
        <div class="absolute inset-0 bg-pink-500" style="transform: rotateX(180deg); backface-visibility: hidden;">
          <img
              alt="屠龙宝刀"
              src="/resources/dao.png"
              class="max-h-[80%] max-w-[80%] mx-auto"
              style="transform: rotateX(180deg);"
          >
        </div>
      </div>

      <div
          @click="toMain"
          class="cursor-pointer text-xl font-bold text-center py-4 hover:text-red-500 transition-colors relative z-20"
      >
        屠龙宝刀点击就送
      </div>
    </div>
  </div>
</template>
<style scoped>

/* 确保容器淡出平滑 */
.flex-col {
  will-change: opacity, transform;
}
</style>