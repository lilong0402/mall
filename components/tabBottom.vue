<template>
 <van-tabbar v-model="active">
   <van-tabbar-item name="home" icon="home-o" @click="goto('index/index')">首页</van-tabbar-item>
   <van-tabbar-item name="search" icon="chat-o" @click="goto('massage')">消息</van-tabbar-item>
   <van-tabbar-item name="friends" icon="cart-o" @click="goto('detail/commodityDetail')">购物车</van-tabbar-item>
   <van-tabbar-item name="/Login" icon="setting-o" @click="goto('login/login')">我的</van-tabbar-item>
 </van-tabbar>
</template>

<script setup>
	import { ref } from 'vue';

    const active = ref('Login');
	const pageUrl = '../login/login'
	const goto =(lvalue)=>{
		uni.navigateTo({
		            //保留当前页面，跳转到应用内的某个页面
		            url: '../'+lvalue
		        })
	}
	
	
</script>

