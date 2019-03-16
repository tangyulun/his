package com.ssh.vo.outpatient;

import java.math.BigDecimal;
import java.util.Date;


public class FinancialHistoryVo {

	private long id;
	private String financialHistoryId;
	private String financialHistoryShoufeilx;
	private String financialHistoryShoufeixm;
	private Date financialHistoryShoufeirq;
	private String financialHistoryShoufeisj;
	private BigDecimal financialHistoryShoufeije;
	private String financialHistoryShoufeizt;
	private BigDecimal financialHistoryShoufeiNum;
	
	public BigDecimal getFinancialHistoryShoufeiNum() {
		return financialHistoryShoufeiNum;
	}
	public void setFinancialHistoryShoufeiNum(BigDecimal financialHistoryShoufeiNum) {
		this.financialHistoryShoufeiNum = financialHistoryShoufeiNum;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFinancialHistoryId() {
		return financialHistoryId;
	}
	public void setFinancialHistoryId(String financialHistoryId) {
		this.financialHistoryId = financialHistoryId;
	}
	public String getFinancialHistoryShoufeilx() {
		return financialHistoryShoufeilx;
	}
	public void setFinancialHistoryShoufeilx(String financialHistoryShoufeilx) {
		this.financialHistoryShoufeilx = financialHistoryShoufeilx;
	}
	public String getFinancialHistoryShoufeixm() {
		return financialHistoryShoufeixm;
	}
	public void setFinancialHistoryShoufeixm(String financialHistoryShoufeixm) {
		this.financialHistoryShoufeixm = financialHistoryShoufeixm;
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
	public BigDecimal getFinancialHistoryShoufeije() {
		return financialHistoryShoufeije;
	}
	public void setFinancialHistoryShoufeije(BigDecimal financialHistoryShoufeije) {
		this.financialHistoryShoufeije = financialHistoryShoufeije;
	}
	public String getFinancialHistoryShoufeizt() {
		return financialHistoryShoufeizt;
	}
	public void setFinancialHistoryShoufeizt(String financialHistoryShoufeizt) {
		this.financialHistoryShoufeizt = financialHistoryShoufeizt;
	}
	
	public FinancialHistoryVo(String financialHistoryId, String financialHistoryShoufeilx,
			String financialHistoryShoufeixm, Date financialHistoryShoufeirq, String financialHistoryShoufeisj,
			BigDecimal financialHistoryShoufeije, String financialHistoryShoufeizt) {
		super();
		this.financialHistoryId = financialHistoryId;
		this.financialHistoryShoufeilx = financialHistoryShoufeilx;
		this.financialHistoryShoufeixm = financialHistoryShoufeixm;
		this.financialHistoryShoufeirq = financialHistoryShoufeirq;
		this.financialHistoryShoufeisj = financialHistoryShoufeisj;
		this.financialHistoryShoufeije = financialHistoryShoufeije;
		this.financialHistoryShoufeizt = financialHistoryShoufeizt;
	}
	public FinancialHistoryVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FinancialHistoryVo(long id, String financialHistoryId, String financialHistoryShoufeilx,
			String financialHistoryShoufeixm, Date financialHistoryShoufeirq, String financialHistoryShoufeisj,
			BigDecimal financialHistoryShoufeije, String financialHistoryShoufeizt) {
		super();
		this.id = id;
		this.financialHistoryId = financialHistoryId;
		this.financialHistoryShoufeilx = financialHistoryShoufeilx;
		this.financialHistoryShoufeixm = financialHistoryShoufeixm;
		this.financialHistoryShoufeirq = financialHistoryShoufeirq;
		this.financialHistoryShoufeisj = financialHistoryShoufeisj;
		this.financialHistoryShoufeije = financialHistoryShoufeije;
		this.financialHistoryShoufeizt = financialHistoryShoufeizt;
	}
	@Override
	public String toString() {
		return "FinancialHistoryVo [id=" + id + ", financialHistoryId=" + financialHistoryId
				+ ", financialHistoryShoufeilx=" + financialHistoryShoufeilx + ", financialHistoryShoufeixm="
				+ financialHistoryShoufeixm + ", financialHistoryShoufeirq=" + financialHistoryShoufeirq
				+ ", financialHistoryShoufeisj=" + financialHistoryShoufeisj + ", financialHistoryShoufeije="
				+ financialHistoryShoufeije + ", financialHistoryShoufeizt=" + financialHistoryShoufeizt
				+ ", financialHistoryShoufeiNum=" + financialHistoryShoufeiNum + "]";
	}
	
	
}
