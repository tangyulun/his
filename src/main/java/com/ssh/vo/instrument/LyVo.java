package com.ssh.vo.instrument;

import java.util.Date;



public class LyVo {

	
	private String qxUseId;

	private Date qxUseDate;
	
	private String qxUseDuix;

	private String qxUseKeshi;
	
	private String qxUseState;

	private String qxUseWarehouse;

	public String getQxUseId() {
		return qxUseId;
	}

	public void setQxUseId(String qxUseId) {
		this.qxUseId = qxUseId;
	}

	public Date getQxUseDate() {
		return qxUseDate;
	}

	public void setQxUseDate(Date qxUseDate) {
		this.qxUseDate = qxUseDate;
	}

	public String getQxUseDuix() {
		return qxUseDuix;
	}

	public void setQxUseDuix(String qxUseDuix) {
		this.qxUseDuix = qxUseDuix;
	}

	public String getQxUseKeshi() {
		return qxUseKeshi;
	}

	public void setQxUseKeshi(String qxUseKeshi) {
		this.qxUseKeshi = qxUseKeshi;
	}

	public String getQxUseState() {
		return qxUseState;
	}

	public void setQxUseState(String qxUseState) {
		this.qxUseState = qxUseState;
	}

	public String getQxUseWarehouse() {
		return qxUseWarehouse;
	}

	public void setQxUseWarehouse(String qxUseWarehouse) {
		this.qxUseWarehouse = qxUseWarehouse;
	}

	public LyVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LyVo(String qxUseId, Date qxUseDate, String qxUseDuix, String qxUseKeshi, String qxUseState,
			String qxUseWarehouse) {
		super();
		this.qxUseId = qxUseId;
		this.qxUseDate = qxUseDate;
		this.qxUseDuix = qxUseDuix;
		this.qxUseKeshi = qxUseKeshi;
		this.qxUseState = qxUseState;
		this.qxUseWarehouse = qxUseWarehouse;
	}
	
}
