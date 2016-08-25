package com.tengfei.attendance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tengfei.attendance.dao.UserDao;
import com.tengfei.attendance.service.UserService;
import com.tengfei.attendance.tools.Utility;
import com.tengfei.attendance.vo.User;

/**
 * 用户服务
 * @author jianfei.xu
 * @date   2016年8月25日
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User getByUsername(String username) {
		if(Utility.isEmpty(username)) return null;
		
		return userDao.getByUsername(username);
	}

}
