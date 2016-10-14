package com.xck.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.xck.mapper.ObjectMapper;

public class PropertiesUtil {
	
	/*
	 * 读取classpath的配置文件
	 * @param
	 * @return
	 * */
	public static Object readProperties(){
		try {
			InputStream is = ClassLoader.getSystemResourceAsStream("config.properties");
			Properties properties = new Properties();
			properties.load(is);
			return ObjectMapper.userNUISTWifeInfoMapper(properties);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
