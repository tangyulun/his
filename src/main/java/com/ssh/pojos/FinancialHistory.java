package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the FINANCIAL_HISTORY database table.
 * 
 */
@Entity
@Table(name="FINANCIAL_HISTORY")
@NamedQuery(name="FinancialHistory.findAll", query="SELECT f FROM FinancialHistory f")
public class FinancialHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FINANCIAL_HISTORY_ID")
	private String financialHistoryId;

	@Column(name="FINANCIAL_HISTORY_NUM")
	private BigDecimal financialHistoryNum;

	@Column(name="FINANCIAL_HISTORY_SHOUFEIJE")
	private BigDecimal financialHistoryShoufeije;

	@Column(name="FINANCIAL_HISTORY_SHOUFEILX")
	private String financialHistoryShoufeilx;

	@Temporal(TemporalType.DATE)
	@Column(name="FINANCIAL_HISTORY_SHOUFEIRQ")
	private Date financialHistoryShoufeirq;

	@Column(name="FINANCIAL_HISTORY_SHOUFEISJ")
	private String financialHistoryShoufeisj;

	@Column(name="FINANCIAL_HISTORY_SHOUFEIZT")
	private String financialHistoryShoufeizt;

	@Column(name="FINANCIAL_HISTORY_TYPE")
	private String financialHistoryType;

	//bi-directional many-to-one association to Financial
	@ManyToOne
	@JoinColumn(name="FINANCIAL_ID")
	private Financial financial;

	//bi-directional many-to-one association to OutpaitentRegist
	@ManyToOne
	@JoinColumn(name="OUTPAITENT_REGIST_ID")
	private OutpaitentRegist outpaitentRegist;

	public FinancialHistory() {
	}

	public String getFinancialHistoryId() {
		return this.financialHistoryId;
	}

	public void setFinancialHistoryId(String financialHistoryId) {
		this.financialHistoryId = financialHistoryId;
	}

	public BigDecimal getFinancialHistoryNum() {
		return this.financialHistoryNum;
	}

	public void setFinancialHistoryNum(BigDecimal financialHistoryNum) {
		this.financialHistoryNum = financialHistoryNum;
	}

	public BigDecimal getFinancialHistoryShoufeije() {
		return this.financialHistoryShoufeije;
	}

	public void setFinancialHistoryShoufeije(BigDecimal financialHistoryShoufeije) {
		this.financialHistoryShoufeije = financialHistoryShoufeije;
	}

	public String getFinancialHistoryShoufeilx() {
		return this.financialHistoryShoufeilx;
	}

	public void setFinancialHistoryShoufeilx(String financialHistoryShoufeilx) {
		this.financialHistoryShoufeilx = financialHistoryShoufeilx;
	}

	public Date getFinancialHistoryShoufeirq() {
		return this.financialHistoryShoufeirq;
	}

	public void setFinancialHistoryShoufeirq(Date financialHistoryShoufeirq) {
		this.financialHistoryShoufeirq = financialHistoryShoufeirq;
	}

	public String getFinancialHistoryShoufeisj() {
		return this.financialHistoryShoufeisj;
	}

	public void setFinancialHistoryShoufeisj(String financialHistoryShoufeisj) {
		this.financialHistoryShoufeisj = financialHistoryShoufeisj;
	}

	public String getFinancialHistoryShoufeizt() {
		return this.financialHistoryShoufeizt;
	}

	public void setFinancialHistoryShoufeizt(String financialHistoryShoufeizt) {
		this.financialHistoryShoufeizt = financialHistoryShoufeizt;
	}

	public String getFinancialHistoryType() {
		return this.financialHistoryType;
	}

	public void setFinancialHistoryType(String financialHistoryType) {
		this.financialHistoryType = financialHistoryType;
	}

	public Financial getFinancial() {
		return this.financial;
	}

	public void setFinancial(Financial financial) {
		this.financial = financial;
	}

	public OutpaitentRegist getOutpaitentRegist() {
		return this.outpaitentRegist;
	}

	public void setOutpaitentRegist(OutpaitentRegist outpaitentRegist) {
		this.outpaitentRegist = outpaitentRegist;
	}

}