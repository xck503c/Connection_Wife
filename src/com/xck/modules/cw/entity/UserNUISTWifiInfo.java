package com.xck.modules.cw.entity;

import com.xck.common.persistence.BaseEntity;

public class UserNUISTWifiInfo extends BaseEntity{
	private String URL;  //��Ҫ����ĵ�ַ
	private Integer time_interval;  //��Ҫ���Ե�ʱ����
	private String username;
	private String password;
	private String type;  //��Ӫ������
	
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public Integer getTime_interval() {
		return time_interval;
	}
	public void setTime_interval(Integer time_interval) {
		this.time_interval = time_interval;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
