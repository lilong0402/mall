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
		<van-pull-refresh v-model="loading" @refresh="onRefresh">
		  <p>刷新次数: {{ count }}</p>
		</van-pull-refresh>
		<view>
			<TabBottom></TabBottom>
		</view>
	</view>
</template>

<script setup>
	import axios from 'axios';
	import commodity from '../../components/commodity.vue'
	import {onMounted, ref, reactive} from 'vue'
	import { useStore } from '../../store';
	const commodityList = ref([])
	const value = ref('')
	const loading = ref(false)
	const param=reactive({
		//设置页码
		currentPage: 0,
		//设置每页显示数量
		pageSize : 5
	})
	const store = useStore()

	// 用于处理搜索后的操作
	const onSearch = (val) => {
		console.log(val)
	};
	
	const onRefresh = ()=>{
		setTimeout(() => {
			showToast('刷新成功');
		    loading.value = false;
		    count.value++;
		}, 1000);
		getAllCommodity()
	} 
	
	const getAllCommodity = ()=>{
		if (store.IsIndexOne == 0)
			param.currentPage = 0 ;
		else 
			param.currentPage = commodityList.length / param.pageSize + 1
		var x
		axios.get(store.BASEURL+"shopping/selectAllCommodity?currentpage="+param.currentPage+"&pageSize="+param.pageSize)
		.then(response => {
			const data = response.data.data;
			console.log(data[0])
			for(x in data) {
			    commodityList.value.push(x)
			}
			console.log(commodityList)
		})
	}
	/**
	 * 通过onMounted实现预加载
	 */
	onMounted(()=>{
		getAllCommodity();
		store.IsIndexOne = 1
	})
</script>


