package com.xck.modules.util;


import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HttpClientUtil {
	
	protected static Logger logger;
	private static HttpClientConnectionManager httpClientConnectionManager;
	private static HttpClient httpClient;
	
	static{
		httpClientConnectionManager = new BasicHttpClientConnectionManager();
		httpClient = HttpClientBuilder.create().setConnectionManager(httpClientConnectionManager).build();
		logger = LoggerFactory.getLogger(HttpClientUtil.class);
	}
	
	/*
	 * 连接的主要逻辑代码
	 * @param url 想要连接的目的rul
	 * @return boolean
	 * */
	public static HttpResponse connectionUrl(String url) {
		try {
			
			HttpPost post = new HttpPost(url);
//			post.addHeader("Host", "a.nuist.edu.cn");
//			post.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:49.0) Gecko/20100101 Firefox/49.0");
//			post.addHeader("Accept", "application/json, text/javascript, */*; q=0.01");
//			post.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
//			post.addHeader("Accept-Encoding", "gzip, deflate");
//			post.addHeader("Content-Type", "application/x-www-form-urlencoded");
//			post.addHeader("X-Requested-With", "XMLHttpRequest");
//			post.addHeader("Referer", "http://a.nuist.edu.cn/");
//			post.addHeader("Cookie", "pgv_pvi=7242963968; think_language=zh-CN; PHPSESSID=gse1qjgoohk3pob8aimridval0; sunriseUsername=02502325322; sunriseDomain=Unicom");
//			post.addHeader("Connection", "keep-alive");
//			System.out.println("request ===========>");
			
			logger.debug("request ===========>");
			HttpResponse response = httpClient.execute(post);
			logger.debug("请求: " + response.getStatusLine().toString() + " ======>");
			
			return response;
		} catch (ClientProtocolException e) {
			logger.error("ClientProtocolException", e);
		} catch (IOException e) {
			logger.error("IOException", e);
		}
		
		return null;
	}
}
