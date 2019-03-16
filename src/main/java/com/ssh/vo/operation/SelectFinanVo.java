package com.ssh.vo.operation;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class SelectFinanVo {
	private String financialHistoryId;

	public String getFinancialHistoryId() {
		return financialHistoryId;
	}

	public void setFinancialHistoryId(String financialHistoryId) {
		this.financialHistoryId = financialHistoryId;
	}

	public SelectFinanVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SelectFinanVo(String financialHistoryId) {
		super();
		this.financialHistoryId = financialHistoryId;
	}

	
}
