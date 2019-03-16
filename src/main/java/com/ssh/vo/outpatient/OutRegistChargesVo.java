package com.ssh.vo.outpatient;

import java.math.BigDecimal;
import java.util.Date;


public class OutRegistChargesVo {

	private long id;
	private String financialHistoryId;
	private BigDecimal financialHistoryNum;
	private String financialHistoryShoufeiName;
	private BigDecimal financialHistoryShoufeije;
	private BigDecimal financialHistoryPrice;
	private String financialHistoryShoufeilx;

	private Date financialHistoryShoufeirq;

	private String financialHistoryShoufeisj;

	private String financialHistoryShoufeizt;
	private String prescriptionRecodeExplain;
	private String financialHistoryType;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFinancialHistoryId() {
		return financialHistoryId;
	}

	
	public BigDecimal getFinancialHistoryPrice() {
		return financialHistoryPrice;
	}

	public void setFinancialHistoryPrice(BigDecimal financialHistoryPrice) {
		this.financialHistoryPrice = financialHistoryPrice;
	}

	public void setFinancialHistoryId(String financialHistoryId) {
		this.financialHistoryId = financialHistoryId;
	}

	public BigDecimal getFinancialHistoryNum() {
		return financialHistoryNum;
	}

	public void setFinancialHistoryNum(BigDecimal financialHistoryNum) {
		this.financialHistoryNum = financialHistoryNum;
	}

	public BigDecimal getFinancialHistoryShoufeije() {
		return financialHistoryShoufeije;
	}

	public void setFinancialHistoryShoufeije(BigDecimal financialHistoryShoufeije) {
		this.financialHistoryShoufeije = financialHistoryShoufeije;
	}
	

	public String getPrescriptionRecodeExplain() {
		return prescriptionRecodeExplain;
	}

	public void setPrescriptionRecodeExplain(String prescriptionRecodeExplain) {
		this.prescriptionRecodeExplain = prescriptionRecodeExplain;
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
	
	public String getFinancialHistoryShoufeiName() {
		return financialHistoryShoufeiName;
	}

	public void setFinancialHistoryShoufeiName(String financialHistoryShoufeiName) {
		this.financialHistoryShoufeiName = financialHistoryShoufeiName;
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

	public OutRegistChargesVo(String financialHistoryId, BigDecimal financialHistoryNum,
			String financialHistoryShoufeiName, BigDecimal financialHistoryShoufeije, String financialHistoryShoufeilx,
			Date financialHistoryShoufeirq, String financialHistoryShoufeisj, String financialHistoryShoufeizt,
			String financialHistoryType) {
		super();
		this.financialHistoryId = financialHistoryId;
		this.financialHistoryNum = financialHistoryNum;
		this.financialHistoryShoufeiName = financialHistoryShoufeiName;
		this.financialHistoryShoufeije = financialHistoryShoufeije;
		this.financialHistoryShoufeilx = financialHistoryShoufeilx;
		this.financialHistoryShoufeirq = financialHistoryShoufeirq;
		this.financialHistoryShoufeisj = financialHistoryShoufeisj;
		this.financialHistoryShoufeizt = financialHistoryShoufeizt;
		this.financialHistoryType = financialHistoryType;
	}

	public OutRegistChargesVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OutRegistChargesVo(long id, String financialHistoryId, BigDecimal financialHistoryNum,
			String financialHistoryShoufeiName, BigDecimal financialHistoryShoufeije, BigDecimal financialHistoryPrice,
			String financialHistoryShoufeilx, Date financialHistoryShoufeirq, String financialHistoryShoufeisj,
			String financialHistoryShoufeizt, String financialHistoryType) {
		super();
		this.id = id;
		this.financialHistoryId = financialHistoryId;
		this.financialHistoryNum = financialHistoryNum;
		this.financialHistoryShoufeiName = financialHistoryShoufeiName;
		this.financialHistoryShoufeije = financialHistoryShoufeije;
		this.financialHistoryPrice = financialHistoryPrice;
		this.financialHistoryShoufeilx = financialHistoryShoufeilx;
		this.financialHistoryShoufeirq = financialHistoryShoufeirq;
		this.financialHistoryShoufeisj = financialHistoryShoufeisj;
		this.financialHistoryShoufeizt = financialHistoryShoufeizt;
		this.financialHistoryType = financialHistoryType;
	}
	
	
	
	
}
