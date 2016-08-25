package com.tengfei.attendance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录控制
 * @author jianfei.xu
 * @date   2016年8月25日
 *
 */
@Controller
public class LogonController {

	@RequestMapping("/logon")
	public String logon() {
		
		System.out.println("log on....");
		
		return "logon";
	}
	
}
