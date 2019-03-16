package com.ssh.vo.operation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class DclasssVo {
	private long dclassId;

	private String dclassAddress;

	private Date dclassCreateDate;

	private String dclassExplain;

	private String dclassFuzeName;

	private String dclassGrade;

	private String dclassName;

	private String dclassRemark;

	private String dclassState;

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

	public String getDclassFuzeName() {
		return dclassFuzeName;
	}

	public void setDclassFuzeName(String dclassFuzeName) {
		this.dclassFuzeName = dclassFuzeName;
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

	public DclasssVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DclasssVo(long dclassId, String dclassAddress, Date dclassCreateDate, String dclassExplain,
			String dclassFuzeName, String dclassGrade, String dclassName, String dclassRemark, String dclassState) {
		super();
		this.dclassId = dclassId;
		this.dclassAddress = dclassAddress;
		this.dclassCreateDate = dclassCreateDate;
		this.dclassExplain = dclassExplain;
		this.dclassFuzeName = dclassFuzeName;
		this.dclassGrade = dclassGrade;
		this.dclassName = dclassName;
		this.dclassRemark = dclassRemark;
		this.dclassState = dclassState;
	}

	public DclasssVo(long dclassId, String dclassName) {
		super();
		this.dclassId = dclassId;
		this.dclassName = dclassName;
	}
	
}
