<template>
	<view class="container bg-color-white ">
		<view class="mt-35b image_center bg-color-white">
		<van-image
		  width="100"
		  height="100"
		  src="../../static/login/icon.png"
		  round = true
		  position = 'center'
		  />
		</view>
		<view>
			<van-form @submit="onSubmit">
			  <van-cell-group inset>
			    <van-field
			      v-model="userName"
			      name="用户名"
			      label="用户名"
			      placeholder="用户名"
			      :rules="[{ required: true, message: '请填写用户名' }]"
			    />
			    <van-field
			      v-model="userPassword"
			      type="password"
			      name="密码"
			      label="密码"
			      placeholder="密码"
			      :rules="[{ required: true, message: '请填写密码' }]"
			    />
			  </van-cell-group>
			  <view class="px-3 mt-2">
				  <van-switch v-model="checked" >
						  自动登陆?
				  </van-switch>
				  <text>没有账号?</text>
			  </view>
			  <view style="margin: 16px;">
			    <van-button round block type="primary" native-type="submit">
			      提交
			    </van-button>
			  </view>
			</van-form>
		</view>
	</view>
</template>

<script setup>
	import { ref } from 'vue';
	import axios from 'axios';
	import {useStore} from '../../store/index.js';
	
	const userName = ref('');
	const userPassword = ref('');
	const checked = ref('')
	const onSubmit = (values) => {
		const store = useStore()
		axios.post(store.BASEURL,{
			"username" : userName,
			"password" : userPassword
		}).then(Response => {
			console.log(Response.data);
		}, error => {
			console.log('错误',error.message);
		})
		
	    console.log();
	};
</script>