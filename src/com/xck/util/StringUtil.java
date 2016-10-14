package com.xck.util;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import org.apache.commons.codec.binary.Base64;

import net.sf.json.JSONObject;

public class StringUtil {
	
	/*
	 * ����ַ����Ƿ�Ϊ��
	 * @param info ���������ַ���
	 * @param boolean
	 * */
	public static boolean checkUserInfo(String... info){
		for(int i=0; i<info.length; i++){
			if(info[i] == null || info[i] == ""){
				return false;
			}
		}
		return true;
	}
	
	/*
	 * ��password����Ϊbase64
	 * @param password
	 * @return String ���ر��������ַ���
	 * */
	public static String codePassword(String password){
		try {
			byte [] b = password.getBytes("UTF-8");
			if(b != null){
				return new Base64().encodeAsString(b);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * ͨ���ַ���ת��Ϊjson��ȡkey��Ӧ��value,��ӡjson�е�����
	 * @param json
	 * @param keyStr ��Ҫ��ȡ��key
	 * @return ������value����
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
