<template>
  <div class="child-container">
    <div class="left-section">左侧内容 (30%)</div>
    <div class="right-section">右侧内容 (70%)</div>
  </div>
</template>

<script setup>
// 使用 script setup 语法
</script>

<style scoped>
.child-container {
  width: 80%; /* 占据父组件80%宽度 */
  margin: 0 auto; /* 水平居中 */
  display: flex; /* 使用flex布局 */
  height: 80vh; /* 根据需要设置高度 */
  border: 1px solid #ccc; /* 可选，用于可视化边界 */
}

.left-section {
  flex: 2; /* 按3份分配 */
  padding: 10px;
  background-color: #f0f0f0; /* 可选，用于区分 */

}

.right-section {
  flex: 8; /* 按7份分配 */
  padding: 10px;
  background-color: #e0e0e0; /* 可选，用于区分 */
}
</style>