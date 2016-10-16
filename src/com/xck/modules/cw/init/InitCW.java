package com.xck.modules.cw.init;

import com.xck.modules.cw.init.config.Global;
import com.xck.modules.cw.service.UserNUISTWifiInfoService;

public class InitCW {
	public static void main(String[] args) {
		boolean flag = UserNUISTWifiInfoService.connectionNUIST(Global.user);
		while(!flag){
			try {
				Thread.currentThread().sleep(1000*60*Global.time_interval);
				flag = UserNUISTWifiInfoService.connectionNUIST(Global.user);
			} catch (InterruptedException e) {
				//e.printStackTrace();
			}
		}
	}
}
