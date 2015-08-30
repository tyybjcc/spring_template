package com.tyy.spring.properties_placeholder;

public class DataSource {
	String driverClass;
	String url;
	String username;
	String password;
	public String getDriverClass() {
		return driverClass;
	}
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	
	@Override
	public String toString() {
		String str = "DataSource:\n-----------";
		str+="\ndriverClass:"+driverClass;
		str+="\nurl:"+url;
		str+="\nusername:"+username;
		str+="\npassword:"+password;
		return str;
	}
	

}
