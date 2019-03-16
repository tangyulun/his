package com.ssh.vo.login;

import java.util.Date;

import com.ssh.pojos.Emp;
import com.ssh.vo.staff.EmpVO;

public class LoginLoggerVO {

	private long loginLogger;

	private Date loginDate;

	private String loginTimes;

	private EmpVO emp;

	public long getLoginLogger() {
		return loginLogger;
	}

	public void setLoginLogger(long loginLogger) {
		this.loginLogger = loginLogger;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getLoginTimes() {
		return loginTimes;
	}

	public void setLoginTimes(String loginTimes) {
		this.loginTimes = loginTimes;
	}

	
	
	
	public EmpVO getEmp() {
		return emp;
	}

	public void setEmp(EmpVO emp) {
		this.emp = emp;
	}

	public LoginLoggerVO(long loginLogger, Date loginDate, String loginTimes) {
		super();
		this.loginLogger = loginLogger;
		this.loginDate = loginDate;
		this.loginTimes = loginTimes;
	}

	public LoginLoggerVO() {
		super();
	}
	
}
