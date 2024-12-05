


// #ifdef VUE3
import { createSSRApp } from 'vue'
import App from './App.vue'
import {Button, Search, Image as VanImage, Form, Field, CellGroup,Switch, Tab, Tabs, Tabbar, TabbarItem, Col, Row, Card, Lazyload , PullRefresh, Swipe, SwipeItem ,Dialog } from 'vant'
import 'bootstrap/dist/css/bootstrap.css'
import 'vant/lib/index.css'
import './index.css'
import {createPinia} from 'pinia'
import tabBottom from './components/tabBottom'
import {useStore} from './store/index.js';


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
  app.use(Col)
  app.use(Row)
  // app.use(router)
  app.use(Tabbar)
  app.use(TabbarItem)
  app.use(Card)
  app.use(Lazyload)
  app.use(PullRefresh)
  app.use(Swipe)
  app.use(SwipeItem)
  app.use(Dialog)
  
  app.use(pinia)
  app.use(useStore())
  
  
  app.component('TabBottom',tabBottom)
  return {
    app
  }
}
// #endif