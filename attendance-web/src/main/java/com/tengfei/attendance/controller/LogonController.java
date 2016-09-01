package com.tengfei.attendance.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tengfei.attendance.dto.Menu;
import com.tengfei.attendance.tools.Utility;
import com.tengfei.attendance.util.UserUtil;

/**
 * 登录控制
 * @author jianfei.xu
 * @date   2016年8月25日
 *
 */
@Controller
public class LogonController {

	@RequestMapping("/logon")
	public ModelAndView logon() {
		ModelAndView mav = new ModelAndView("logon");
		if(UserUtil.isLogged()) {
			List<Menu> menuList = loadMenu();
			mav.addObject("menuList", menuList);
			mav.addObject("logOnUserName", UserUtil.getCurrentUserName());
			
			if(!Utility.isEmpty(menuList)) {//默认一级菜单名称
				mav.addObject("selTopMenuTitle", menuList.get(0).getMenuName());
			}
		}

		
		return mav;
	}
	
	protected List<Menu> loadMenu() {
		List<Menu> menuList = new LinkedList<Menu>();
		Menu menu = new Menu();
		menuList.add(menu);
		menu.setMenuId("firstMenu_01");
		menu.setMenuName("考勤管理");
		menu.setLeaf(false);
		menu.setOrderNum(1);
		List<Menu> secondMenuList = new LinkedList<Menu>();
		menu.setChildrenMenus(secondMenuList);
		menu = new Menu();
		secondMenuList.add(menu);
		menu.setParentMenuId("firstMenu_01");
		menu.setMenuId("secondMenu_01_01");
		menu.setMenuName("考勤周期管理");
		menu.setLeaf(true);
		menu.setMenuUrl("/attendanceManage/periodManage.do");
		menu.setOrderNum(1);
		menu = new Menu();
		secondMenuList.add(menu);
		menu.setParentMenuId("firstMenu_01");
		menu.setMenuId("secondMenu_01_02");
		menu.setMenuName("打卡记录查询");
		menu.setLeaf(true);
		menu.setMenuUrl("/attendanceManage/queryRecord.do");
		menu.setOrderNum(2);
		menu = new Menu();
		secondMenuList.add(menu);
		menu.setParentMenuId("firstMenu_01");
		menu.setMenuId("secondMenu_01_03");
		menu.setMenuName("异常打卡管理");
		menu.setLeaf(true);
		menu.setMenuUrl("/attendanceManage/execeptionRecord.do");
		menu.setOrderNum(3);
		menu = new Menu();
		secondMenuList.add(menu);
		menu.setParentMenuId("firstMenu_01");
		menu.setMenuId("secondMenu_01_04");
		menu.setMenuName("考勤统计");
		menu.setLeaf(true);
		menu.setMenuUrl("/attendanceManage/statistic.do");
		menu.setOrderNum(4);
		
		menu = new Menu();
		menuList.add(menu);
		menu.setMenuId("firstMenu_02");
		menu.setMenuName("导入管理");
		menu.setLeaf(false);
		secondMenuList = new LinkedList<Menu>();
		menu.setChildrenMenus(secondMenuList);
		menu = new Menu();
		secondMenuList.add(menu);
		menu.setParentMenuId("firstMenu_02");
		menu.setMenuId("secondMenu_02_01");
		menu.setMenuName("打卡记录导入");
		menu.setLeaf(true);
		menu.setMenuUrl("/importManage/clockRecordImport.do");
		menu.setOrderNum(1);
		menu = new Menu();
		secondMenuList.add(menu);
		menu.setParentMenuId("firstMenu_02");
		menu.setMenuId("secondMenu_02_02");
		menu.setMenuName("请假记录导入");
		menu.setLeaf(true);
		menu.setMenuUrl("/importManage/leafRecordImport.do");
		menu.setOrderNum(2);
		
		return menuList;
	}
	
}