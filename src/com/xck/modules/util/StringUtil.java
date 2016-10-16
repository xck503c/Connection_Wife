package com.xck.modules.util;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

public class StringUtil {
	
	protected static Logger logger;
	
	static{
		logger = LoggerFactory.getLogger(StringUtil.class);
	}
	
	/*
	 * 检查字符串是否为空
	 * @param info 传进来的字符串
	 * @param boolean
	 * */
	public static boolean checkUserInfo(String... info){
		for(int i=0; i<info.length; i++){
			if(info[i] == null || info[i] == ""){
				logger.error("用户信息不完整");
				return false;
			}
		}
		return true;
	}
	
	/*
	 * 将password编码为base64
	 * @param password
	 * @return String 返回编码过后的字符串
	 * */
	public static String codePassword(String password){
		try {
			byte [] b = password.getBytes("UTF-8");
			if(b != null){
				return new Base64().encodeAsString(b);
			}
		} catch (UnsupportedEncodingException e) {
			logger.error("UnsupportedEncodingException", e);
		}
		return null;
	}
	
	/*
	 * 通过字符串转换为json获取key对应的value,打印json中的内容
	 * @param json
	 * @param keyStr 想要获取的key
	 * @return 将查找value返回
	 * */
	public static Integer getValueOfJSON(String json, String keyStr){
		JSONObject jsonObject = JSONObject.fromObject(json);
		for(Iterator iter = jsonObject.keys(); iter.hasNext();){   
            String key = (String)iter.next();   
            System.out.println(key + " : " + jsonObject.get(key));
        }    
		return (Integer)jsonObject.get(keyStr);
	}
}
