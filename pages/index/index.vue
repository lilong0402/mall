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
		
	</view>
</template>

<script setup>
	import {ref} from 'vue'
	const value = ref('')
	// 用于处理搜索后的操作
	const onSearch = (val) => {
		console.log(val)
	};
</script>


