package com.ssh.vo.operation;

import java.util.Date;


public class JianyanVo {
	private String jianyanId;
	
	private String jianyanBetween;
	
	private Date jianyanCreateDate;
	
	private String jianyanName;
	
	private String jianyanRemark;

	private JianyanTypeVo jianyantype;
	
	private UnitsVo units;
	
	private EmpsVo emp;

	public String getJianyanId() {
		return jianyanId;
	}

	public void setJianyanId(String jianyanId) {
		this.jianyanId = jianyanId;
	}

	public String getJianyanBetween() {
		return jianyanBetween;
	}

	public void setJianyanBetween(String jianyanBetween) {
		this.jianyanBetween = jianyanBetween;
	}

	public Date getJianyanCreateDate() {
		return jianyanCreateDate;
	}

	public void setJianyanCreateDate(Date jianyanCreateDate) {
		this.jianyanCreateDate = jianyanCreateDate;
	}

	public String getJianyanName() {
		return jianyanName;
	}

	public void setJianyanName(String jianyanName) {
		this.jianyanName = jianyanName;
	}

	public String getJianyanRemark() {
		return jianyanRemark;
	}

	public void setJianyanRemark(String jianyanRemark) {
		this.jianyanRemark = jianyanRemark;
	}

	public JianyanTypeVo getJianyantype() {
		return jianyantype;
	}

	public void setJianyantype(JianyanTypeVo jianyantype) {
		this.jianyantype = jianyantype;
	}

	public UnitsVo getUnits() {
		return units;
	}

	public void setUnits(UnitsVo units) {
		this.units = units;
	}

	public EmpsVo getEmp() {
		return emp;
	}

	public void setEmp(EmpsVo emp) {
		this.emp = emp;
	}

	public JianyanVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JianyanVo(String jianyanId, String jianyanBetween, Date jianyanCreateDate, String jianyanName,
			String jianyanRemark) {
		super();
		this.jianyanId = jianyanId;
		this.jianyanBetween = jianyanBetween;
		this.jianyanCreateDate = jianyanCreateDate;
		this.jianyanName = jianyanName;
		this.jianyanRemark = jianyanRemark;
	}

	public JianyanVo(String jianyanName) {
		super();
		this.jianyanName = jianyanName;
	}

	public JianyanVo(String jianyanId, String jianyanName) {
		super();
		this.jianyanId = jianyanId;
		this.jianyanName = jianyanName;
	}

	

	
	
}
