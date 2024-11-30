


// #ifdef VUE3
import { createSSRApp } from 'vue'
import App from './App.vue'
import {Button, Search, Image as VanImage, Form, Field, CellGroup,Switch, Tab, Tabs, Tabbar, TabbarItem } from 'vant'
import 'bootstrap/dist/css/bootstrap.css'
import 'vant/lib/index.css'
import './index.css'
import {createPinia} from 'pinia'
import tabBottom from './components/tabBottom'
// import router from './router'

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
  app.use(Tab)
  app.use(Tabs)
  // app.use(router)
  app.use(Tabbar)
  app.use(TabbarItem)
  
  app.use(pinia)
  
  app.component('TabBottom',tabBottom)
  return {
    app
  }
}
// #endif