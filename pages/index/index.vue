<template>
	<view class="container">
		<view class="mt-0">
			<van-search v-model="value" 
			placeholder="请输入搜索关键词" 
			background="#4fc08d" 
			shape= 'round' 
			@search="onSearch"
			/>
		</view>
		<van-row class="font_size_12">
			<van-col span="5">
				<van-row>
					<van-col span="24">
						<van-image
						  width="50"
						  height="50"
						  src="../../static/index/seckkill.png"
						/>
					</van-col>
					<text class="mx-2">秒杀</text>
				</van-row>
			</van-col>
			<van-col span="5" class="mt-1">
				<van-row>
					<van-col span="24">
						<van-image
						  width="45"
						  height="45"
						  src="../../static/index/loan.png"
						/>
					</van-col>
					<text class="mx-2">借款</text>
				</van-row>
			</van-col>
			<van-col span="5" class="mt-1">
				<van-row>
					<van-col span="24" class="mt-1">
						<van-image
						  width="42"
						  height="42"
						  src="../../static/index/auction.png"
						/>
					</van-col>
					<text class="mx-2">拍卖</text>
				</van-row>
			</van-col>
			<van-col span="5" class="mt-1">
				<van-row>
					<van-col span="24">
						<van-image
						  width="50"
						  height="50"
						  src="../../static/index/second-hand.png"
						/>
					</van-col>
					<text class="mx-2">二手交易</text>
				</van-row>
			</van-col>
			<van-col span="4" class="mt-1">
				<van-row>
					<van-col span="24">
						<van-image
						  width="45"
						  height="45"
						  src="../../static/index/digimon.png"
						/>
					</van-col>
					<text class="mx-2">数码</text>
				</van-row>
			</van-col>
		</van-row>
		<van-row>
			<van-col v-for="commodity in commodityList" v-lazy="commodity" span='11' class="mx-1 mt-2">
				<commodity />
			</van-col>
		</van-row>

		<view>
			<TabBottom></TabBottom>
		</view>
	</view>
</template>

<script setup>
	import commodity from '../../components/commodity.vue'
	import {ref} from 'vue'
	const commodityList = ref(['sss','ddd','sss','ddd','sss','ddd','ddd','sss','ddd'])
	const value = ref('')
	// 用于处理搜索后的操作
	const onSearch = (val) => {
		console.log(val)
	};
</script>


