package com.tengfei.attendance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 退出控制
 * @author jianfei.xu
 * @date   2016年8月25日
 *
 */
@Controller
public class LogoutController {

	@RequestMapping("/logout")
	public void logon() {
		
		System.out.println("log out....");
	}
	
}
