package com.tengfei.attendance.vo;

/**
 * 打卡记录
 * @author jianfei.xu
 * @date   2016年8月30日
 */
public class ClockRecord {

	private String name;
	
	private String empno;
	
	private String department;
	
	private String date;
	
	private String clockIn;
	
	private String clockOff;
	
	private String type;
	
	private boolean isInCompany = true;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getClockIn() {
		return clockIn;
	}

	public void setClockIn(String clockIn) {
		this.clockIn = clockIn;
	}

	public String getClockOff() {
		return clockOff;
	}

	public void setClockOff(String clockOff) {
		this.clockOff = clockOff;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isInCompany() {
		return isInCompany;
	}

	public void setInCompany(boolean isInCompany) {
		this.isInCompany = isInCompany;
	}
	
}
