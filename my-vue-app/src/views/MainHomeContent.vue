<script setup lang="ts">
defineProps<{
  isVisible: boolean;
}>();

</script>

<template>
  <div class="centered-container bg-blue-200">
    <!-- 红色：左淡入左淡出 -->
    <Transition name="fade-left">
      <div v-if="isVisible" class="child red"></div>
    </Transition>

    <!-- 黄色：旋转出现/消失 -->
    <Transition name="rotate">
      <div v-if="isVisible" class="child yellow"></div>
    </Transition>

    <!-- 绿色：右淡入右淡出 -->
    <Transition name="fade-right">
      <div v-if="isVisible" class="child green"></div>
    </Transition>
  </div>
</template>

<style scoped>
/* 布局样式（同上） */
.centered-container {
  width: 90vw;
  height: 80vh;
  margin: 40px auto;
  display: flex;
  gap: 10px;
}
.child {
  flex: 1;
  height: 100%;
  border-radius: 8px;
}
.red { background: #ff6b6b; }
.yellow { background: #ffd166; }
.green { background: #06d6a0; }

/* 动画定义 */
/* 红色：左淡入左淡出 */
.fade-left-enter-active,
.fade-left-leave-active {
  transition: all 0.8s ease;
}
.fade-left-enter-from {
  opacity: 0;
  transform: translateX(-100%);
}
.fade-left-leave-to {
  opacity: 0;
  transform: translateX(-100%);
}

/* 绿色：右淡入右淡出 */
.fade-right-enter-active,
.fade-right-leave-active {
  transition: all 0.8s ease;
}
.fade-right-enter-from {
  opacity: 0;
  transform: translateX(100%);
}
.fade-right-leave-to {
  opacity: 0;
  transform: translateX(100%);
}

/* 黄色：旋转出现/消失 */
.rotate-enter-active,
.rotate-leave-active {
  transition: all 0.8s ease;
}
.rotate-enter-from {
  opacity: 0;
  transform: rotateX(-90deg);
}
.rotate-leave-to {
  opacity: 0;
  transform: rotateX(90deg);
}
</style>