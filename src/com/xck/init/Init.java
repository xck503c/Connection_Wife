package com.xck.init;

import com.xck.entity.UserNUISTWifeInfo;
import com.xck.service.UserNUISTWifeInfoService;
import com.xck.util.PropertiesUtil;

public class Init {
	public static void main(String[] args) {
		UserNUISTWifeInfo user = (UserNUISTWifeInfo)PropertiesUtil.readProperties();
		boolean flag = false;
		while(!flag){
			try {
				flag = UserNUISTWifeInfoService.connection(user);
				Thread.currentThread().sleep(1000*60*user.getTime_interval());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
	}
}
