package com.ssh.vo.instrument;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class PdVo {

	private String qxLnventoryId;

	
	private Date qxLnventoryDate;

	
	private BigDecimal qxLnventoryState;


	private String qxLnventoryWarehouse;


	public String getQxLnventoryId() {
		return qxLnventoryId;
	}


	public void setQxLnventoryId(String qxLnventoryId) {
		this.qxLnventoryId = qxLnventoryId;
	}


	public Date getQxLnventoryDate() {
		return qxLnventoryDate;
	}


	public void setQxLnventoryDate(Date qxLnventoryDate) {
		this.qxLnventoryDate = qxLnventoryDate;
	}


	public BigDecimal getQxLnventoryState() {
		return qxLnventoryState;
	}


	public void setQxLnventoryState(BigDecimal qxLnventoryState) {
		this.qxLnventoryState = qxLnventoryState;
	}


	public String getQxLnventoryWarehouse() {
		return qxLnventoryWarehouse;
	}


	public void setQxLnventoryWarehouse(String qxLnventoryWarehouse) {
		this.qxLnventoryWarehouse = qxLnventoryWarehouse;
	}


	public PdVo(String qxLnventoryId, Date qxLnventoryDate, BigDecimal qxLnventoryState, String qxLnventoryWarehouse) {
		super();
		this.qxLnventoryId = qxLnventoryId;
		this.qxLnventoryDate = qxLnventoryDate;
		this.qxLnventoryState = qxLnventoryState;
		this.qxLnventoryWarehouse = qxLnventoryWarehouse;
	}


	public PdVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
