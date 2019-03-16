package com.ssh.vo.instrument;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class HhVo {
	
	private String qxReturnId;
	private Date qxReturnDate;
	private String qxReturnDuixiang;
	private String qxReturnKeshi;
	private String qxReturnState;
	private String qxReturnWarehouse;
	public String getQxReturnId() {
		return qxReturnId;
	}
	public void setQxReturnId(String qxReturnId) {
		this.qxReturnId = qxReturnId;
	}
	public Date getQxReturnDate() {
		return qxReturnDate;
	}
	public void setQxReturnDate(Date qxReturnDate) {
		this.qxReturnDate = qxReturnDate;
	}
	public String getQxReturnDuixiang() {
		return qxReturnDuixiang;
	}
	public void setQxReturnDuixiang(String qxReturnDuixiang) {
		this.qxReturnDuixiang = qxReturnDuixiang;
	}
	public String getQxReturnKeshi() {
		return qxReturnKeshi;
	}
	public void setQxReturnKeshi(String qxReturnKeshi) {
		this.qxReturnKeshi = qxReturnKeshi;
	}
	public String getQxReturnState() {
		return qxReturnState;
	}
	public void setQxReturnState(String qxReturnState) {
		this.qxReturnState = qxReturnState;
	}
	public String getQxReturnWarehouse() {
		return qxReturnWarehouse;
	}
	public void setQxReturnWarehouse(String qxReturnWarehouse) {
		this.qxReturnWarehouse = qxReturnWarehouse;
	}
	public HhVo(String qxReturnId, Date qxReturnDate, String qxReturnDuixiang, String qxReturnKeshi,
			String qxReturnState, String qxReturnWarehouse) {
		super();
		this.qxReturnId = qxReturnId;
		this.qxReturnDate = qxReturnDate;
		this.qxReturnDuixiang = qxReturnDuixiang;
		this.qxReturnKeshi = qxReturnKeshi;
		this.qxReturnState = qxReturnState;
		this.qxReturnWarehouse = qxReturnWarehouse;
	}
	public HhVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
