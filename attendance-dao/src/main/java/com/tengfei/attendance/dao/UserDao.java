package com.tengfei.attendance.dao;

import com.tengfei.attendance.vo.User;

/**
 * 用户dao
 * @author jianfei.xu
 * @date   2016年8月25日
 *
 */
public interface UserDao {
	
	public String prefix = "com.tengfei.attendance.dao.UserDao";
			
	public User getByUsername(String username);
	
}
