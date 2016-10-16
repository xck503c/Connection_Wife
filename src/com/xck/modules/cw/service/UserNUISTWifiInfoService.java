package com.xck.modules.cw.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xck.common.service.BaseService;
import com.xck.modules.cw.entity.UserNUISTWifiInfo;
import com.xck.modules.util.HttpClientUtil;
import com.xck.modules.util.StringUtil;

public class UserNUISTWifiInfoService extends BaseService{
	
	protected static Logger logger;
	
	static{
		logger = LoggerFactory.getLogger(UserNUISTWifiInfoService.class);
	}
	
	/*
	 * 通过user拼接URL连接
	 * @param user
	 * @return boolean
	 * */
	public static boolean connectionNUIST(UserNUISTWifiInfo user){
		try {
			String url = user.getURL() + "?username=" + user.getUsername()
			+ "&domain=" + user.getType()+ "&password="
			+ user.getPassword() + "&enablemacauth=0";
			
			boolean result = false;
			
			HttpResponse response = HttpClientUtil.connectionUrl(url);
			if(null != response){
				result = isRequestSuccess(response);
				if(result){
					logger.debug("request success");
					logger.debug("response end ===========>");
					return true;
				}
			}
		} catch (UnsupportedOperationException e) {
			logger.error("UnsupportedOperationException", e);
		}
		logger.debug("request fail");
		logger.debug("response end ===========>");
		
		return false;
	}
	
	/*
	 * 通过请求url返回的数据检查是否请求成功
	 * @param is 连接的输入流
	 * @return boolean
	 * */
	private static boolean isRequestSuccess(HttpResponse response){
		try {
			InputStream is = response.getEntity().getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String line = null;
			String jsonString = "";
			
			while((line = br.readLine())!=null){
				jsonString = line + jsonString;
			}
			Integer status = StringUtil.getValueOfJSON(jsonString, "status");
			if(status == 1){
				return true;
			}else{
				return false;
			}
		} catch (UnsupportedEncodingException e) {
			logger.error("UnsupportedEncodingException", e);
		} catch (IOException e) {
			logger.error("IOException", e);
		}
		
		return false;
	}
}
