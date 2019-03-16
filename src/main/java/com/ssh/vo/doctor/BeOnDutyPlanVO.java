package com.ssh.vo.doctor;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class BeOnDutyPlanVO {
	private String beOnDutyPlanId;

	private Date beOnDutyPlanDate;

	private Date beOnDutyPlanEndDate;

	private byte [] beOnDutyPlanMessage;

	private Date beOnDutyPlanStartDate;

	private String beOnDutyPlanType;
	
	private String tableMess;
	
	private String dateBetween;
	
	

	public String getDateBetween() {
		return dateBetween;
	}

	public void setDateBetween(String dateBetween) {
		this.dateBetween = dateBetween;
	}

	public String getTableMess() {
		return tableMess;
	}

	public void setTableMess(String tableMess) {
		this.tableMess = tableMess;
	}

	public String getBeOnDutyPlanId() {
		return beOnDutyPlanId;
	}

	public void setBeOnDutyPlanId(String beOnDutyPlanId) {
		this.beOnDutyPlanId = beOnDutyPlanId;
	}

	public Date getBeOnDutyPlanDate() {
		return beOnDutyPlanDate;
	}

	public void setBeOnDutyPlanDate(Date beOnDutyPlanDate) {
		this.beOnDutyPlanDate = beOnDutyPlanDate;
	}

	public Date getBeOnDutyPlanEndDate() {
		return beOnDutyPlanEndDate;
	}

	public void setBeOnDutyPlanEndDate(Date beOnDutyPlanEndDate) {
		this.beOnDutyPlanEndDate = beOnDutyPlanEndDate;
	}

	public byte[] getBeOnDutyPlanMessage() {
		return beOnDutyPlanMessage;
	}

	public void setBeOnDutyPlanMessage(byte[] beOnDutyPlanMessage) {
		this.beOnDutyPlanMessage = beOnDutyPlanMessage;
	}

	public Date getBeOnDutyPlanStartDate() {
		return beOnDutyPlanStartDate;
	}

	public void setBeOnDutyPlanStartDate(Date beOnDutyPlanStartDate) {
		this.beOnDutyPlanStartDate = beOnDutyPlanStartDate;
	}

	public String getBeOnDutyPlanType() {
		return beOnDutyPlanType;
	}

	public void setBeOnDutyPlanType(String beOnDutyPlanType) {
		this.beOnDutyPlanType = beOnDutyPlanType;
	}

	public BeOnDutyPlanVO(String beOnDutyPlanId, Date beOnDutyPlanDate, Date beOnDutyPlanEndDate,
			byte[] beOnDutyPlanMessage, Date beOnDutyPlanStartDate, String beOnDutyPlanType) {
		super();
		this.beOnDutyPlanId = beOnDutyPlanId;
		this.beOnDutyPlanDate = beOnDutyPlanDate;
		this.beOnDutyPlanEndDate = beOnDutyPlanEndDate;
		this.beOnDutyPlanMessage = beOnDutyPlanMessage;
		this.beOnDutyPlanStartDate = beOnDutyPlanStartDate;
		this.beOnDutyPlanType = beOnDutyPlanType;
	}

	public BeOnDutyPlanVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
