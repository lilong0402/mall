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
				<button type="button" class="btn btn-danger" @click=" placeAnOrder">立即下单 ￥{{commodity.shoppingPrice}}</button>
			</van-tabbar>
		</view>
		<view>
			<van-popup
			  :show="showbottom"
			  closeable
			  position="bottom"
			  :style="{ height: '80%' }"
			  @click-close-icon="closepopup"
			>
			<view>
				<view>
					<van-radio-group v-model="payment.payStyle" direction="horizontal" class="mt-4 mx-2">
					  <van-radio name="0">支付宝</van-radio>
					  <van-radio name="1">微信</van-radio>
					</van-radio-group>	
				</view>
				<view class="mt-4 mx-2">
					<van-row>
						<van-col :span="18">
							商品数量
						</van-col>
						<van-col :span="6">
							<van-stepper v-model="payment.commodityNum" />	
						</van-col>
					</van-row>
					<van-row class="mt-4">
						<van-field v-model="payment.commoditydetail" label="商品描述" />
					</van-row>
				</view>

				
				<van-tabbar v-model="active">
					<button type="button" class="btn btn-danger component_width_100b" @click="immediatePayment">立即支付{{commodity.shoppingPrice}}</button>
				</van-tabbar>
			</view>
			</van-popup>
		</view>

	</view>
</template>

<script setup>
	import {defineProps, reactive, ref } from 'vue'
	import { useStore } from '../../store';
	import { showDialog } from 'vant';
	import axios from 'axios';
	const store = useStore()
	const commodity = store.commodity
	const showbottom = ref(false)
	
	const payment = reactive({
		userId: store.userId,
		shoppingId: commodity.id,
		payStyle:0,
		commodityNum: 1,
		discount:1.0,
		Logistics:""
	})
	const addshoppingcard =()=>{
		axios.post(store.BASEURL+"shopping/addShoppingCard",{
				userId: store.userId,
				shoppingId:commodity.id
		}).then(Response => {
			console.log(store.userId)
			showDialog({
				title: commodity.shoppingName,
				message: Response.data.msg
			})
		})
	}
	const placeAnOrder = () =>{
		showbottom.value = true
		console.log(commodity.shoppingPrice)

	}
	const closepopup = () =>{
		showbottom.value = false
	}
	const immediatePayment= () => {
		axios.post(store.BASEURL+"order/addOrder",payment)
		.then(response => {
			showDialog({
				message: response.data.data
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