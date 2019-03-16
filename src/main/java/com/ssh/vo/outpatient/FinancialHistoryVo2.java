package com.ssh.vo.outpatient;

import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class FinancialHistoryVo2 {
	@JSONField(name="treeField")
	private String financialHistoryId;
	private BigDecimal financialHistoryShoufeije;
	private String financialHistoryShoufeilx;
	private Date financialHistoryShoufeirq;
	private String financialHistoryShoufeisj;
	private String financialHistoryShoufeizt;
	private String financialHistoryType;

	public FinancialHistoryVo2(String financialHistoryId, BigDecimal financialHistoryShoufeije,
			String financialHistoryShoufeilx, Date financialHistoryShoufeirq, String financialHistoryShoufeisj,
			String financialHistoryShoufeizt, String financialHistoryType) {
		super();
		this.financialHistoryId = financialHistoryId;
		this.financialHistoryShoufeije = financialHistoryShoufeije;
		this.financialHistoryShoufeilx = financialHistoryShoufeilx;
		this.financialHistoryShoufeirq = financialHistoryShoufeirq;
		this.financialHistoryShoufeisj = financialHistoryShoufeisj;
		this.financialHistoryShoufeizt = financialHistoryShoufeizt;
		this.financialHistoryType = financialHistoryType;
	}

	public FinancialHistoryVo2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFinancialHistoryId() {
		return financialHistoryId;
	}

	public void setFinancialHistoryId(String financialHistoryId) {
		this.financialHistoryId = financialHistoryId;
	}

	public BigDecimal getFinancialHistoryShoufeije() {
		return financialHistoryShoufeije;
	}

	public void setFinancialHistoryShoufeije(BigDecimal financialHistoryShoufeije) {
		this.financialHistoryShoufeije = financialHistoryShoufeije;
	}

	public String getFinancialHistoryShoufeilx() {
		return financialHistoryShoufeilx;
	}

	public void setFinancialHistoryShoufeilx(String financialHistoryShoufeilx) {
		this.financialHistoryShoufeilx = financialHistoryShoufeilx;
	}

	public Date getFinancialHistoryShoufeirq() {
		return financialHistoryShoufeirq;
	}

	public void setFinancialHistoryShoufeirq(Date financialHistoryShoufeirq) {
		this.financialHistoryShoufeirq = financialHistoryShoufeirq;
	}

	public String getFinancialHistoryShoufeisj() {
		return financialHistoryShoufeisj;
	}

	public void setFinancialHistoryShoufeisj(String financialHistoryShoufeisj) {
		this.financialHistoryShoufeisj = financialHistoryShoufeisj;
	}

	public String getFinancialHistoryShoufeizt() {
		return financialHistoryShoufeizt;
	}

	public void setFinancialHistoryShoufeizt(String financialHistoryShoufeizt) {
		this.financialHistoryShoufeizt = financialHistoryShoufeizt;
	}

	public String getFinancialHistoryType() {
		return financialHistoryType;
	}

	public void setFinancialHistoryType(String financialHistoryType) {
		this.financialHistoryType = financialHistoryType;
	}
	
	
}
