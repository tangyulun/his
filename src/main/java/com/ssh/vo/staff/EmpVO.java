package com.ssh.vo.staff;

import java.math.BigDecimal;
import java.util.Date;

import com.ssh.vo.dclass.DClassVO;
import com.ssh.vo.dept.DeptVO;



public class EmpVO {
	private long empId;

	private Date empDate;

	private String empLoginName;

	private String empName;

	private String empPwd;

	private BigDecimal empState;
	
	private DeptVO dept;
	
	private DClassVO dclass;
	
	private String empSex;
	
	private boolean isFrag;
	
	public boolean isFrag() {
		return isFrag;
	}

	public void setFrag(boolean isFrag) {
		this.isFrag = isFrag;
	}

	public String getEmpSex() {
		return empSex;
	}

	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}

	public DeptVO getDept() {
		return dept;
	}

	public void setDept(DeptVO dept) {
		this.dept = dept;
	}

	public DClassVO getDclass() {
		return dclass;
	}

	public void setDclass(DClassVO dclass) {
		this.dclass = dclass;
	}

	public EmpVO(long empId, Date empDate, String empLoginName, String empName
			, String empPwd, BigDecimal empState,String empSex) {
		super();
		this.empId = empId;
		this.empDate = empDate;
		this.empLoginName = empLoginName;
		this.empName = empName;
		this.empPwd = empPwd;
		this.empState = empState;
		this.empSex = empSex;
	}

	public Date getEmpDate() {
		return empDate;
	}

	public String getEmpLoginName() {
		return empLoginName;
	}

	public String getEmpName() {
		return empName;
	}

	public String getEmpPwd() {
		return empPwd;
	}

	public BigDecimal getEmpState() {
		return empState;
	}

	public void setEmpDate(Date empDate) {
		this.empDate = empDate;
	}

	public void setEmpLoginName(String empLoginName) {
		this.empLoginName = empLoginName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}

	public void setEmpState(BigDecimal empState) {
		this.empState = empState;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public EmpVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpVO(long empId) {
		super();
		this.empId = empId;
	}

	public EmpVO(long empId, String empLoginName) {
		super();
		this.empId = empId;
		this.empLoginName = empLoginName;
	}

	public EmpVO(long empId, String empLoginName, Date empDate) {
		super();
		this.empId = empId;
		this.empLoginName = empLoginName;
		this.empDate = empDate;
	}

	public EmpVO(long empId, String empLoginName, String empName) {
		super();
		this.empId = empId;
		this.empLoginName = empLoginName;
		this.empName = empName;
	}

	public EmpVO(long empId, String empLoginName, String empName, DClassVO dclass) {
		super();
		this.empId = empId;
		this.empLoginName = empLoginName;
		this.empName = empName;
		this.dclass = dclass;
	}


}
