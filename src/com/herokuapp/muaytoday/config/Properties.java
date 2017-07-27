package com.herokuapp.muaytoday.config;

import com.herokuapp.muaytoday.service.AesCipherService;

public class Properties {
	private AesCipherService aesCipherService;
	private String driverClassName;
	private String url;
	private String username;
	private String password;

	public void setAesCipherService(AesCipherService aesCipherService) {
		this.aesCipherService = aesCipherService;
	}
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public AesCipherService getAesCipherService() {
		return aesCipherService;
	}
	public String getDriverClassName() {
		return aesCipherService.decrypt(driverClassName, "ab5efe5b729cc525fd464c646accb523");
	}
	public String getUrl() {
		return aesCipherService.decrypt(url, "c6a73dc295d36589a28eb881389135c5");
	}
	public String getUsername() {
		return aesCipherService.decrypt(username, "2d9481acc47ad8fbe0f6a5f1a5b84ba6");
	}
	public String getPassword() {
		return aesCipherService.decrypt(password, "40ec2e9355a518224c6a44e8dc402814");
	}
}