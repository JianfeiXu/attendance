package com.tengfei.attendance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 考勤管理
 * @author jianfei.xu
 * @date   2016年8月30日
 */
@Controller
@RequestMapping("/attendanceManage")
public class AttendanceManagerController {

	@RequestMapping("/periodManage")
	public ModelAndView periodManage() {
		ModelAndView mav = new ModelAndView("attendanceManage/periodManage");
		
		
		
		return mav;
	}
	
}
