package com.tengfei.attendance.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import com.tengfei.attendance.dao.UserDao;
import com.tengfei.attendance.tools.Utility;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public User getByUsername(String username) {
		List<User> userList = sqlSessionTemplate.selectList(UserDao.prefix + ".getByUsername", username);
		if(Utility.isEmpty(userList)) return null;
		
		return userList.get(0);
	}

}
