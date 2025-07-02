import { createApp } from 'vue'
import { createPinia } from 'pinia'
import piniaPluginPersistence from 'pinia-plugin-persistedstate'
import './style.css'
import App from './App.vue'
import router from './router/index.ts'

const pinia = createPinia()
pinia.use(piniaPluginPersistence)
const app = createApp(App)

app.use(pinia)
app.use(router)
app.mount('#app')