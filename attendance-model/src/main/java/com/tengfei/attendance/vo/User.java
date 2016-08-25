package com.tengfei.attendance.vo;

/**
 * 用户信息
 * @author jianfei.xu
 * @date   2016年8月25日
 *
 */
public class User {
    private String password;
    private String username;
    private boolean enabled;
    
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
    
}
