import { createRouter, createWebHistory } from "vue-router";
import Index from "../pages/index/index";
import Login from "../pages/login/login";
// 项目其他页面路由（推荐使用）

// vue项目自带路由
const routes = [
  {
    path: "/",
    name: "Index",
    component: Index
  },
  {
    path: "/Login",
    name: "Login",
	component: Login
    // component: () =>
    //   import( "../pages/login/login.vue")
  }
];

const routers = [...routes];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;

