<template>
  <!-- 根容器，通常包含全局布局（如导航栏、页脚） -->
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App',
  created() {
    console.log('App 初始化');
  }
}
</script>
