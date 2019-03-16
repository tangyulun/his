package com.ssh.vo.outpatient;

import java.math.BigDecimal;
import java.util.List;


public class FinacialVo {
	private String financialId;
	private String financialExplain;
	private BigDecimal financialMoney;
	private BigDecimal financialPrice;
	private String financialName;
	private String financialType;
	private BigDecimal financialZhekoujia;
	
	private FinancialTypeVo finanTypeVo;
	
	private List<FinancialHistoryVo> financialHistoriesVo;//一个项目有多条记录

	
	public FinacialVo(String financialId, String financialName) {
		super();
		this.financialId = financialId;
		this.financialName = financialName;
	}

	public BigDecimal getFinancialPrice() {
		return financialPrice;
	}

	public void setFinancialPrice(BigDecimal financialPrice) {
		this.financialPrice = financialPrice;
	}

	public String getFinancialId() {
		return financialId;
	}

	public void setFinancialId(String financialId) {
		this.financialId = financialId;
	}

	public String getFinancialExplain() {
		return financialExplain;
	}

	public void setFinancialExplain(String financialExplain) {
		this.financialExplain = financialExplain;
	}

	public BigDecimal getFinancialMoney() {
		return financialMoney;
	}

	public void setFinancialMoney(BigDecimal financialMoney) {
		this.financialMoney = financialMoney;
	}

	public String getFinancialName() {
		return financialName;
	}

	public void setFinancialName(String financialName) {
		this.financialName = financialName;
	}

	public String getFinancialType() {
		return financialType;
	}

	public void setFinancialType(String financialType) {
		this.financialType = financialType;
	}

	
	public BigDecimal getFinancialZhekoujia() {
		return financialZhekoujia;
	}

	public void setFinancialZhekoujia(BigDecimal financialZhekoujia) {
		this.financialZhekoujia = financialZhekoujia;
	}

	public List<FinancialHistoryVo> getFinancialHistoriesVo() {
		return financialHistoriesVo;
	}

	public void setFinancialHistoriesVo(List<FinancialHistoryVo> financialHistoriesVo) {
		this.financialHistoriesVo = financialHistoriesVo;
	}

	public FinacialVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public FinacialVo(String financialId, BigDecimal financialMoney, String financialName) {
		super();
		this.financialId = financialId;
		this.financialMoney = financialMoney;
		this.financialName = financialName;
	}

	public FinancialTypeVo getFinanTypeVo() {
		return finanTypeVo;
	}

	public void setFinanTypeVo(FinancialTypeVo finanTypeVo) {
		this.finanTypeVo = finanTypeVo;
	}

	public FinacialVo(String financialId) {
		super();
		this.financialId = financialId;
	}



	public FinacialVo(String financialId, String financialExplain, BigDecimal financialMoney, BigDecimal financialPrice,
			String financialName, String financialType, BigDecimal financialZhekoujia) {
		super();
		this.financialId = financialId;
		this.financialExplain = financialExplain;
		this.financialMoney = financialMoney;
		this.financialPrice = financialPrice;
		this.financialName = financialName;
		this.financialType = financialType;
		this.financialZhekoujia = financialZhekoujia;
	}
	
	
}
