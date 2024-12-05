<template>
	<view class="container">
		<view>
			<van-swipe class="my-swipe" :autoplay="3000" indicator-color="white">
			  <van-swipe-item>1</van-swipe-item>
			  <van-swipe-item>2</van-swipe-item>
			  <van-swipe-item>3</van-swipe-item>
			  <van-swipe-item>4</van-swipe-item>
			</van-swipe>
		</view>
		<view>
			价格:{{commodity.shoppingPrice}}
		</view>
		<view>
			{{commodity.shoppingNote}}
		</view>
		<view>
			...
		</view>
		<view>
			<van-tabbar v-model="active">
			  <van-tabbar-item name="home" icon="gem-o" @click="goto('index/index')">首页</van-tabbar-item>
			  <van-tabbar-item name="search" icon="contact-o" @click="goto('massage')">消息</van-tabbar-item>
			  <van-tabbar-item name="friends" icon="cart-circle-o" @click="goto('detail/commodityDetail')">购物车</van-tabbar-item>
			  <!-- <van-tabbar-item name="/Login" icon="setting-o" @click="goto('login/login')">我的</van-tabbar-item> -->
				<button type="button" class="btn btn-primary" @click="addshoppingcard">加入购物车</button>
				<button type="button" class="btn btn-danger">立即下单 ￥{{}}</button>
			</van-tabbar>
		</view>
	</view>
</template>

<script setup>
	import {defineProps } from 'vue'
	import { useStore } from '../../store';
	import { showDialog } from 'vant';
	const store = useStore()
	const commodity = store.commodity
	
	const addshoppingcard =()=>{
		axios.get(store.BASEURL+"/shopping/addShoppingCard",{
			userId: store.userId,
			shoppingId:commodity.id
		}).then(Response => {
			showDialog({
				title: commodity.shoppingName,
				message: Response.data.data
			})
		})
	}
</script>

<style>
	  .my-swipe .van-swipe-item {
	    color: #fff;
	    font-size: 20px;
	    line-height: 150px;
	    text-align: center;
	    background-color: #39a9ed;
	  }
</style>