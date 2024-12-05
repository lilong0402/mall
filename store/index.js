
import { defineStore } from 'pinia'
 
export const useStore = defineStore('mall', {
	state: () => {
	  return {
	    BASEURL: "http://localhost:8080/",
		commodity: {
			type: Object
		}
	  }
	}
})