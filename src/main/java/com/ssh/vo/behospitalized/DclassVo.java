package com.ssh.vo.behospitalized;

import java.util.Date;

import com.ssh.vo.dept.DeptVO;

public class DclassVo {
	private long dclassId;

	private String dclassAddress;

	private Date dclassCreateDate;

	private String dclassExplain;

	private String dclassGrade;

	private String dclassName;

	private String dclassRemark;

	private String dclassState;
	
	private String dclassFuzeName;
	
	private DeptVO dept;

	public long getDclassId() {
		return dclassId;
	}

	public void setDclassId(long dclassId) {
		this.dclassId = dclassId;
	}

	public String getDclassAddress() {
		return dclassAddress;
	}

	public void setDclassAddress(String dclassAddress) {
		this.dclassAddress = dclassAddress;
	}

	public Date getDclassCreateDate() {
		return dclassCreateDate;
	}

	public void setDclassCreateDate(Date dclassCreateDate) {
		this.dclassCreateDate = dclassCreateDate;
	}

	public String getDclassExplain() {
		return dclassExplain;
	}

	public void setDclassExplain(String dclassExplain) {
		this.dclassExplain = dclassExplain;
	}

	public String getDclassGrade() {
		return dclassGrade;
	}

	public void setDclassGrade(String dclassGrade) {
		this.dclassGrade = dclassGrade;
	}

	public String getDclassName() {
		return dclassName;
	}

	public void setDclassName(String dclassName) {
		this.dclassName = dclassName;
	}

	public String getDclassRemark() {
		return dclassRemark;
	}

	public void setDclassRemark(String dclassRemark) {
		this.dclassRemark = dclassRemark;
	}

	public String getDclassState() {
		return dclassState;
	}

	public void setDclassState(String dclassState) {
		this.dclassState = dclassState;
	}

	public String getDclassFuzeName() {
		return dclassFuzeName;
	}

	public void setDclassFuzeName(String dclassFuzeName) {
		this.dclassFuzeName = dclassFuzeName;
	}

	public DeptVO getDept() {
		return dept;
	}

	public void setDept(DeptVO dept) {
		this.dept = dept;
	}

	public DclassVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DclassVo(long dclassId, String dclassAddress, Date dclassCreateDate, String dclassExplain,
			String dclassGrade, String dclassName, String dclassRemark, String dclassState, String dclassFuzeName,
			DeptVO dept) {
		super();
		this.dclassId = dclassId;
		this.dclassAddress = dclassAddress;
		this.dclassCreateDate = dclassCreateDate;
		this.dclassExplain = dclassExplain;
		this.dclassGrade = dclassGrade;
		this.dclassName = dclassName;
		this.dclassRemark = dclassRemark;
		this.dclassState = dclassState;
		this.dclassFuzeName = dclassFuzeName;
		this.dept = dept;
	}

	public DclassVo(String dclassName) {
		super();
		this.dclassName = dclassName;
	}

	public DclassVo(long dclassId, String dclassName) {
		super();
		this.dclassId = dclassId;
		this.dclassName = dclassName;
	}

	
	
	
}
