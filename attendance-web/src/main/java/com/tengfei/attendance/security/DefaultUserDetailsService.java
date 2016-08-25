package com.tengfei.attendance.security;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tengfei.attendance.service.UserService;
import com.tengfei.attendance.tools.Utility;


/**
 * 用户信息提取
 * @author jianfei.xu
 * @date   2016年8月24日
 *
 */
@Service
public class DefaultUserDetailsService implements UserDetailsService {
	@Autowired
	private UserService userService;
	
	/**
	 * 按用户名找查当前用户的信息
	 * @param username 用户名
	 * @throws UsernameNotFoundException
	 * 		   LoginAuthenticationException
	 * @return 用户信息实体类
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, LoginAuthenticationException {
		com.tengfei.attendance.vo.User user = this.userService.getByUsername(username); //从用户表查找
		if (null == user || Utility.isEmpty(user.getUsername())) {
			if(null == user || Utility.isEmpty(user.getUsername())) {
				throw new UsernameNotFoundException("用户名或密码不正确!");
			}
		}
		
		User retUser = new User(user.getUsername(), user.getPassword(), user.isEnabled()
				, true, true, true, new ArrayList<SimpleGrantedAuthority>(0));
		
		return retUser;
    }

}
