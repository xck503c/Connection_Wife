package com.xck.service;

import com.xck.entity.UserNUISTWifeInfo;
import com.xck.util.HttpClientUtil;

public class UserNUISTWifeInfoService {
	
	/*
	 * 通过user拼接URL连接
	 * @param user
	 * @return boolean
	 * */
	public static boolean connection(UserNUISTWifeInfo user){
		String url = user.getURL() + "?username=" + user.getUsername()
		+ "&domain=" + user.getType()+ "&password="
		+ user.getPassword() + "&enablemacauth=0";
		
		return HttpClientUtil.connectionUrl(url);
	}
}
