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
		
		<scroll-view @scrolltolower="handelLower" style="height: 70vh;" scroll-y="true">
			<view>
				<van-row>
					<van-col v-for="commodity in commodityList" v-lazy="commodity" span='11' class="mx-1 mt-2" >
						{{console.log(commodity)}}
						<commodity :commodity = "commodity" v-if="commodity" @click="clickNum(commodity.id)" ></commodity>
					</van-col>
				</van-row>	
			</view>
			<view class="mb-4">{{isBottom?'没有更多数据了~~':'下拉加载更多~~'}}</view>
		</scroll-view>

		<view >
			<TabBottom></TabBottom>
		</view>
	</view>
</template>

<script setup>
	import axios from 'axios';
	import commodity from '../../components/commodity.vue'
	import {onBeforeMount , ref, reactive} from 'vue'
	import { useStore } from '../../store';
	const commodityList = ref([])
	const value = ref('')
	const loading = ref(false)
	const param=reactive({
		//设置页码
		currentPage: 1, 
		//设置每页显示数量
		pageSize : 10
	})
	const isBottom = ref(false)
	
	const store = useStore()
	// 用于处理搜索后的操作
	const onSearch = (val) => {
		console.log(val)
	};
	
	const getAllCommodity = () =>{
		console.log(param)
		var x
		axios.get(store.BASEURL+"shopping/selectAllCommodity",{
			params:{
				"currentPage":param.currentPage,
				"pageSize":param.pageSize,
			}
		})
		.then(response => {
			const data = response.data.data;
			console.log(data)
			if(data.length == 0){
				isBottom.value = true
			}else{
				for(x in data) {
				    commodityList.value.push(data[x])
				}
			}
		})
	}
	const handelLower= () =>{
		console.log(!isBottom.value)
		if(!isBottom.value){
			console.log("滚动到底部操作");
			param.currentPage  = param.currentPage + 1
			getAllCommodity();			
		}else 
			console.log("无数据了");
	}
	const clickNum = (id) => {
		console.log(id)
		axios.post(store.BASEURL + "redis/setAndTime",{
			"commodityKey" : id
		})
	}
	/**
	 * 通过onMounted实现预加载
	 */ 
	onBeforeMount (()=>{
		getAllCommodity();
		// store.IsIndexOne = 1
	})
</script>


