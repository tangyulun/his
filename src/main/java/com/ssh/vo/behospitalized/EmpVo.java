package com.ssh.vo.behospitalized;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class EmpVo {
	private long empId;

	private Date empDate;

	private String empLoginName;

	private String empName;

	private String empPwd;

	private String empSex;

	private BigDecimal empState;

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public Date getEmpDate() {
		return empDate;
	}

	public void setEmpDate(Date empDate) {
		this.empDate = empDate;
	}

	public String getEmpLoginName() {
		return empLoginName;
	}

	public void setEmpLoginName(String empLoginName) {
		this.empLoginName = empLoginName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPwd() {
		return empPwd;
	}

	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}

	public String getEmpSex() {
		return empSex;
	}

	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}

	public BigDecimal getEmpState() {
		return empState;
	}

	public void setEmpState(BigDecimal empState) {
		this.empState = empState;
	}

	public EmpVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpVo(long empId, Date empDate, String empLoginName, String empName, String empPwd, String empSex,
			BigDecimal empState) {
		super();
		this.empId = empId;
		this.empDate = empDate;
		this.empLoginName = empLoginName;
		this.empName = empName;
		this.empPwd = empPwd;
		this.empSex = empSex;
		this.empState = empState;
	}

	public EmpVo(long empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}

	
	
}
