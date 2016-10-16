package com.xck.modules.cw.mapper;

import java.util.Properties;

import com.xck.common.persistence.BaseEntity;
import com.xck.modules.cw.entity.UserNUISTWifiInfo;
import com.xck.modules.util.StringUtil;

public class ObjectMapper {
	
	/*
	 *对象映射
	 *@param properties 配置对象
	 *@return
	 * */
	public static BaseEntity userNUISTWifeInfoMapper(Properties properties){
		String url = properties.getProperty("task.url");
		String time_interval = properties.getProperty("task.time_interval");
		String username = properties.getProperty("task.username");
		String password = properties.getProperty("task.password");
		String type = properties.getProperty("task.type");
		if(StringUtil.checkUserInfo(url, time_interval, username, password, type)){
			UserNUISTWifiInfo user = new UserNUISTWifiInfo();
			user.setURL(url);
			user.setTime_interval(Integer.valueOf(time_interval));
			user.setUsername(username);
			user.setPassword(StringUtil.codePassword(password));
			user.setType(type);
			return user;
		}
		return null;
	}
}
