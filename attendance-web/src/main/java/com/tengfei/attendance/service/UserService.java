package com.tengfei.attendance.service;

import com.tengfei.attendance.vo.User;

/**
 * 用户服务
 * @author jianfei.xu
 * @date   2016年8月24日
 *
 */
public interface UserService {

	public User getByUsername(String username);

}
