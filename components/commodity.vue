<template>
	<view class="card">
	  <img src="../static/commodity/mobile.jpg" class="card-img-top" alt="...">
	  <view class="mx-1">
		<view class="font_size_16 ">{{commodity.shoppingName}}</view>
		<view><text class="font_size_16 mt-">商品价格</text><text class="font_size_14">多少人付款</text></view>
	  </view>
	</view>
</template>

<script setup>
import {defineProps } from 'vue'
	const props = defineProps ({
		commodity: {
			type: Object,
			required: true,
		}
	})
	  // created(()=>{
	  //   console.log("Received commodity:", this.commodity);
	  // })
 
</script>
