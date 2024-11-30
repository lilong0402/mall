


// #ifdef VUE3
import { createSSRApp } from 'vue'
import App from './App.vue'
import {Button, Search, Image as VanImage, Form, Field, CellGroup,Switch } from 'vant'

import 'bootstrap/dist/css/bootstrap.css'
import 'vant/lib/index.css'
import './index.css'
import {createPinia} from 'pinia'
export function createApp() {
  const app = createSSRApp(App)
  const pinia = createPinia()
  app.use(Button)
  app.use(Search)
  app.use(VanImage)
  app.use(Form)
  app.use(Field)
  app.use(CellGroup)
  app.use(Switch)
  
  app.use(pinia)
  return {
    app
  }
}
// #endif