<script setup lang="ts">
import {useRoute, useRouter} from "vue-router";

const router = useRouter();
const route = useRoute();
const tabs= [
    {
     title:'首页',
     route:'/main/home'
    },
    {
     title:'日记',
     route:'/main/diary'
    }
]
//跳转路由
const navigateTo = (route: string) => {
  router.push(route);
};
//判断路由
const isActiveTab = (tabRoute: string) => {
  return route.path.startsWith(tabRoute);
};
</script>

<template>
  <div class="bg-green-500/20 p-4">
    <div class="flex items-center justify-between">

      <div class="flex items-center  w-[30%]">
        <div class="bg-blue-200 p-3 rounded-md flex items-center justify-center w-full">
          <span class="text-white font-bold">LOGO</span>
          <!-- <img src="@/assets/logo.png" alt="Logo" class="h-8"> -->
        </div>
      </div>

      <div class="flex-1 flex justify-center">
        <div class="flex border-b">
          <button
              v-for="tab in tabs"
              :key="tab.route"
              @click="navigateTo(tab.route)"
              class="px-6 py-3 text-center relative"
              :class="{ 'active': isActiveTab(tab.route) }"
          >
            {{ tab.title }}
          </button>
        </div>
      </div>
    </div>

  </div>
</template>

<style scoped>
/*选中样式*/
.active {
  color: #1890ff;
  border-bottom: 2px solid #1890ff;
}
</style>