package com.ssh.vo.login;


public class EmpVo {

	private long empId;
	private String empLoginName;
	private String empName;
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
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
	public EmpVo(long empId, String empLoginName, String empName) {
		super();
		this.empId = empId;
		this.empLoginName = empLoginName;
		this.empName = empName;
	}
	
	
	 public EmpVo(long empId, String empLoginName) {
		super();
		this.empId = empId;
		this.empLoginName = empLoginName;
	}
	public EmpVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	  
}
