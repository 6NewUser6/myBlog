import { createRouter, createWebHistory } from 'vue-router'
import First from "@/views/First.vue";


const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            name: 'first',
            component: First
        }
    ]


})

// router.beforeEach((to, _from, next) => {
//     const userStore = useUserStore()
//
//     if (to.path !== '/login'&&to.path!=='/register' && !userStore.token) {
//         next('/login')
//         toast.error('用户未登录')
//     } else if (to.path === '/login' && userStore.token) {
//         next('/main/chat')
//     } else {
//         next()
//     }
// })

export default router