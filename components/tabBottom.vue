<template>
 <van-tabbar v-model="active">
   <van-tabbar-item name="home" icon="home-o">首页</van-tabbar-item>
   <van-tabbar-item name="search" icon="chat-o">消息</van-tabbar-item>
   <van-tabbar-item name="friends" icon="cart-o">购物车</van-tabbar-item>
   <van-tabbar-item name="/Login" icon="setting-o" @click="goto('Login')">我的</van-tabbar-item>
 </van-tabbar>
</template>

<script setup>
	import { ref } from 'vue';
	import router from '../router/index.js'
    const active = ref('Login');
	const pageUrl = '../login/login'
	const goto =(lvalue)=>{
		uni.navigateTo({
		            //保留当前页面，跳转到应用内的某个页面
		            url: '../login/login'
		        })
	}
	
	
</script>

