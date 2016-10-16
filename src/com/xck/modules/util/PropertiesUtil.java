package com.xck.modules.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xck.modules.cw.mapper.ObjectMapper;
import com.xck.modules.cw.service.UserNUISTWifiInfoService;

public class PropertiesUtil {
	
	protected static Logger logger;
	
	static{
		logger = LoggerFactory.getLogger(PropertiesUtil.class);
	}
	
	/*
	 * 读取classpath的配置文件
	 * @param
	 * @return
	 * */
	public static Object readProperties(){
		try {
			InputStream is = ClassLoader.getSystemResourceAsStream("connectionWIFI.properties");
			Properties properties = new Properties();
			properties.load(is);
			return ObjectMapper.userNUISTWifeInfoMapper(properties);
		} catch (IOException e) {
			logger.error("IOException", e);
		}
		return null;
	}
}
