package com.ssh.vo.operation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class OperationVo {
	private String jianyanId;

	private String jianyanBetween;

	private Date jianyanCreateDate;

	private String jianyanName;

	private String jianyanRemark;

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

	public OperationVo(String jianyanId, String jianyanBetween, Date jianyanCreateDate, String jianyanName,
			String jianyanRemark) {
		super();
		this.jianyanId = jianyanId;
		this.jianyanBetween = jianyanBetween;
		this.jianyanCreateDate = jianyanCreateDate;
		this.jianyanName = jianyanName;
		this.jianyanRemark = jianyanRemark;
	}

	public OperationVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
