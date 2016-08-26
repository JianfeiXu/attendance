package com.tengfei.attendance.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import com.tengfei.attendance.vo.User;

/**
 * 用户工具类
 * @author jianfei.xu
 *
 */
public class UserUtil {
	/**
	 * 得到当前用户信息
	 * @return 用户信息类名
	 */
	public static User getCurrentUser(){
		Authentication au = SecurityContextHolder.getContext().getAuthentication();
		User user = new User();
		user.setUsername(((org.springframework.security.core.userdetails.User)au.getPrincipal()).getUsername());
		return user;
	}
	
	/**
	 * 得到当前用户ID
	 * @return 用户ID
	 */
	public static String getCurrentUserId(){
		User user = getCurrentUser();
		if (user == null) return null;
		return user.getUsername();
	}
	
	/**
	 * 得到当前用户名（非帐号）
	 * @return 账号名称
	 */
	public static String getCurrentUserName(){
		User user = getCurrentUser();
		if(user == null) return "";
		return user.getUsername();
	}
	
	/**
	 * 判断当前用户是否登陆
	 * @return 判断结果
	 */
	public static boolean isLogged(){
		Authentication au = SecurityContextHolder.getContext().getAuthentication();
		if(au == null) return false;
		if(au.getPrincipal() == null) return false;
		return true;
	}
	
	/**
	 * 获取用户的登陆IP
	 * @return IP地址
	 */
	public static String getLonginIp() { 
		Authentication au = SecurityContextHolder.getContext().getAuthentication();
		if (au == null) return null;
		String ip = ((WebAuthenticationDetails) au.getDetails()).getRemoteAddress();
	    return ip; 
	}
	
}
