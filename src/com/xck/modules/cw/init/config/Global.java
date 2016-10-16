package com.xck.modules.cw.init.config;

import com.xck.modules.cw.entity.UserNUISTWifiInfo;
import com.xck.modules.util.PropertiesUtil;

public class Global {
	
	public static UserNUISTWifiInfo user;
	public static int time_interval;

	static{
		user = (UserNUISTWifiInfo)PropertiesUtil.readProperties();
		time_interval = user.getTime_interval();
	}
}