import { createRouter, createWebHistory } from 'vue-router'
import First from "@/views/First.vue";
import Main from "@/views/Main.vue";
import mainHome from "@/views/mainHome.vue";
import mainDiary from "@/views/mainDiary.vue";


const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            name: 'first',
            component: First
        },{
            path:'/main',
            name: 'main',
            component: Main,
            children: [
                {
                    path: 'home',
                    name: 'TopWrapper-home',
                    component: mainHome,
                },
                {
                    path: 'diary',
                    name: 'TopWrapper-diary',
                    component: mainDiary,
                }
            ]
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
//         next('/TopWrapper/chat')
//     } else {
//         next()
//     }
// })

export default router