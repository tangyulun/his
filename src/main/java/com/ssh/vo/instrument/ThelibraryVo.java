package com.ssh.vo.instrument;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ThelibraryVo {

	private String qxThelibraryId;

	private Date qxThelibraryDate;

	private String qxThelibraryDuixiang;

	private String qxThelibraryPzId;

	private String qxThelibraryState;

	private String qxThelibraryType;

	private String qxThelibraryWarehouse;

	public String getQxThelibraryId() {
		return qxThelibraryId;
	}

	public void setQxThelibraryId(String qxThelibraryId) {
		this.qxThelibraryId = qxThelibraryId;
	}

	public Date getQxThelibraryDate() {
		return qxThelibraryDate;
	}

	public void setQxThelibraryDate(Date qxThelibraryDate) {
		this.qxThelibraryDate = qxThelibraryDate;
	}

	public String getQxThelibraryDuixiang() {
		return qxThelibraryDuixiang;
	}

	public void setQxThelibraryDuixiang(String qxThelibraryDuixiang) {
		this.qxThelibraryDuixiang = qxThelibraryDuixiang;
	}

	public String getQxThelibraryPzId() {
		return qxThelibraryPzId;
	}

	public void setQxThelibraryPzId(String qxThelibraryPzId) {
		this.qxThelibraryPzId = qxThelibraryPzId;
	}

	public String getQxThelibraryState() {
		return qxThelibraryState;
	}

	public void setQxThelibraryState(String qxThelibraryState) {
		this.qxThelibraryState = qxThelibraryState;
	}

	public String getQxThelibraryType() {
		return qxThelibraryType;
	}

	public void setQxThelibraryType(String qxThelibraryType) {
		this.qxThelibraryType = qxThelibraryType;
	}

	public String getQxThelibraryWarehouse() {
		return qxThelibraryWarehouse;
	}

	public void setQxThelibraryWarehouse(String qxThelibraryWarehouse) {
		this.qxThelibraryWarehouse = qxThelibraryWarehouse;
	}

	public ThelibraryVo(String qxThelibraryId, Date qxThelibraryDate, String qxThelibraryDuixiang,
			String qxThelibraryPzId, String qxThelibraryState, String qxThelibraryType, String qxThelibraryWarehouse) {
		super();
		this.qxThelibraryId = qxThelibraryId;
		this.qxThelibraryDate = qxThelibraryDate;
		this.qxThelibraryDuixiang = qxThelibraryDuixiang;
		this.qxThelibraryPzId = qxThelibraryPzId;
		this.qxThelibraryState = qxThelibraryState;
		this.qxThelibraryType = qxThelibraryType;
		this.qxThelibraryWarehouse = qxThelibraryWarehouse;
	}

	public ThelibraryVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
