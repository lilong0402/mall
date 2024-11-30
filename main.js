


// #ifdef VUE3
import { createSSRApp } from 'vue'
import App from './App.vue'
import {Button} from 'vant'
import 'vant/lib/index.css'
export function createApp() {
  const app = createSSRApp(App)
  app.use(Button)
  return {
    app
  }
}
// #endif