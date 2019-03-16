package com.ssh.vo.dept;

import java.util.Date;

import com.ssh.vo.dclass.DClassVO;

public class DeptVO {
	private long deptId;

	private String deptAddress;

	private Date deptCreateDate;

	private String deptExplain;

	private String deptFuzeName;

	private String deptGrade;
	
	private String deptName;

	private Date deptPizhunDate;

	private String deptPizhunName;

	private String deptRemark;

	private Date deptShenheDate;

	private String deptShenheName;

	private String deptState;

	private DClassVO dclass;
	
	
	public DClassVO getDclass() {
		return dclass;
	}

	public void setDclass(DClassVO dclass) {
		this.dclass = dclass;
	}

	public long getDeptId() {
		return deptId;
	}

	public String getDeptAddress() {
		return deptAddress;
	}

	public Date getDeptCreateDate() {
		return deptCreateDate;
	}

	public String getDeptExplain() {
		return deptExplain;
	}

	public String getDeptFuzeName() {
		return deptFuzeName;
	}

	public String getDeptGrade() {
		return deptGrade;
	}

	public String getDeptName() {
		return deptName;
	}

	public Date getDeptPizhunDate() {
		return deptPizhunDate;
	}

	public String getDeptPizhunName() {
		return deptPizhunName;
	}

	public String getDeptRemark() {
		return deptRemark;
	}

	public Date getDeptShenheDate() {
		return deptShenheDate;
	}

	public String getDeptShenheName() {
		return deptShenheName;
	}

	public String getDeptState() {
		return deptState;
	}

	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}

	public void setDeptAddress(String deptAddress) {
		this.deptAddress = deptAddress;
	}

	public void setDeptCreateDate(Date deptCreateDate) {
		this.deptCreateDate = deptCreateDate;
	}

	public void setDeptExplain(String deptExplain) {
		this.deptExplain = deptExplain;
	}

	public void setDeptFuzeName(String deptFuzeName) {
		this.deptFuzeName = deptFuzeName;
	}

	public void setDeptGrade(String deptGrade) {
		this.deptGrade = deptGrade;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public void setDeptPizhunDate(Date deptPizhunDate) {
		this.deptPizhunDate = deptPizhunDate;
	}

	public void setDeptPizhunName(String deptPizhunName) {
		this.deptPizhunName = deptPizhunName;
	}

	public void setDeptRemark(String deptRemark) {
		this.deptRemark = deptRemark;
	}

	public void setDeptShenheDate(Date deptShenheDate) {
		this.deptShenheDate = deptShenheDate;
	}

	public void setDeptShenheName(String deptShenheName) {
		this.deptShenheName = deptShenheName;
	}

	public void setDeptState(String deptState) {
		this.deptState = deptState;
	}

	public DeptVO(long deptId, String deptAddress, Date deptCreateDate, String deptExplain, String deptFuzeName,
			String deptGrade, String deptName, Date deptPizhunDate, String deptPizhunName, String deptRemark,
			Date deptShenheDate, String deptShenheName, String deptState) {
		super();
		this.deptId = deptId;
		this.deptAddress = deptAddress;
		this.deptCreateDate = deptCreateDate;
		this.deptExplain = deptExplain;
		this.deptFuzeName = deptFuzeName;
		this.deptGrade = deptGrade;
		this.deptName = deptName;
		this.deptPizhunDate = deptPizhunDate;
		this.deptPizhunName = deptPizhunName;
		this.deptRemark = deptRemark;
		this.deptShenheDate = deptShenheDate;
		this.deptShenheName = deptShenheName;
		this.deptState = deptState;
	}

	public DeptVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeptVO(long deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "DeptVO [deptId=" + deptId + ", deptAddress=" + deptAddress + ", deptCreateDate=" + deptCreateDate
				+ ", deptExplain=" + deptExplain + ", deptFuzeName=" + deptFuzeName + ", deptGrade=" + deptGrade
				+ ", deptName=" + deptName + ", deptPizhunDate=" + deptPizhunDate + ", deptPizhunName=" + deptPizhunName
				+ ", deptRemark=" + deptRemark + ", deptShenheDate=" + deptShenheDate + ", deptShenheName="
				+ deptShenheName + ", deptState=" + deptState + ", dclass=" + dclass + "]";
	}
	
}
