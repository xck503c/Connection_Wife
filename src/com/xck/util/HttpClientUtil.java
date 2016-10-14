package com.xck.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;

public class HttpClientUtil {
	
	/*
	 * 连接的主要逻辑代码
	 * @param url 想要连接的目的rul
	 * @return boolean
	 * */
	public static boolean connectionUrl(String url) {
		try {
			HttpClientConnectionManager httpClientConnectionManager = new BasicHttpClientConnectionManager();
			HttpClient httpClient = HttpClientBuilder.create().setConnectionManager(httpClientConnectionManager).build();
			
			HttpPost post = new HttpPost(url);
			post.addHeader("Host", "a.nuist.edu.cn");
			post.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:49.0) Gecko/20100101 Firefox/49.0");
			post.addHeader("Accept", "application/json, text/javascript, */*; q=0.01");
			post.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
			post.addHeader("Accept-Encoding", "gzip, deflate");
			post.addHeader("Content-Type", "application/x-www-form-urlencoded");
			post.addHeader("X-Requested-With", "XMLHttpRequest");
			post.addHeader("Referer", "http://a.nuist.edu.cn/");
			post.addHeader("Cookie", "pgv_pvi=7242963968; think_language=zh-CN; PHPSESSID=gse1qjgoohk3pob8aimridval0; sunriseUsername=02502325322; sunriseDomain=Unicom");
			post.addHeader("Connection", "keep-alive");
			
//			List formParams = new ArrayList();
//			formParams.add(new BasicNameValuePair("username", "02502325322"));
//			formParams.add(new BasicNameValuePair("password", "321123"));
//			formParams.add(new BasicNameValuePair("domain", "Unicom"));
//			formParams.add(new BasicNameValuePair("enablemacauth", "0"));
//			HttpEntity reqEntity = new UrlEncodedFormEntity(formParams, "UTF-8");
//			
//			post.setEntity(reqEntity);
			System.out.println("request ===========>");
			HttpEntity httpEntity;
			httpEntity = httpClient.execute(post).getEntity();
			boolean result = isRequestSuccess(httpEntity.getContent());
			return result;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	/*
	 * 通过请求url返回的数据检查是否请求成功
	 * @param is 连接的输入流
	 * @return boolean
	 * */
	public static boolean isRequestSuccess(InputStream is){
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String line = null;
			String jsonString = "";
			
			while((line = br.readLine())!=null){
				jsonString = line + jsonString;
			}
			Integer status = StringUtil.getValueOfJSON(jsonString, "status");
			if(status == 1){
				System.out.println("request success");
				System.out.println("response end ===========>");
				return true;
			}else{
				System.out.println("request fail");
				System.out.println("response end ===========>");
				return false;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
