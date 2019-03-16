package com.ssh.vo.dean;

import java.math.BigDecimal;

import com.ssh.vo.drugstorage.DrugVo;

public class DrugHairXqVo {
	private long drugYaofangXqId;

	private BigDecimal drugYaofangXqMoney;

	private BigDecimal drugYaofangXqNumber;

	private String drugYaofangXqPh;

	private BigDecimal drugYaofangXqPrice;

	private String drugYaofangXqRemark;

	private String drugYaofangXqState;
	
	private DrugVo drug;
	
	private DrugHairVo drugHair;

	public long getDrugYaofangXqId() {
		return drugYaofangXqId;
	}

	public void setDrugYaofangXqId(long drugYaofangXqId) {
		this.drugYaofangXqId = drugYaofangXqId;
	}

	public BigDecimal getDrugYaofangXqMoney() {
		return drugYaofangXqMoney;
	}

	public void setDrugYaofangXqMoney(BigDecimal drugYaofangXqMoney) {
		this.drugYaofangXqMoney = drugYaofangXqMoney;
	}

	public BigDecimal getDrugYaofangXqNumber() {
		return drugYaofangXqNumber;
	}

	public void setDrugYaofangXqNumber(BigDecimal drugYaofangXqNumber) {
		this.drugYaofangXqNumber = drugYaofangXqNumber;
	}

	public String getDrugYaofangXqPh() {
		return drugYaofangXqPh;
	}

	public void setDrugYaofangXqPh(String drugYaofangXqPh) {
		this.drugYaofangXqPh = drugYaofangXqPh;
	}

	public BigDecimal getDrugYaofangXqPrice() {
		return drugYaofangXqPrice;
	}

	public void setDrugYaofangXqPrice(BigDecimal drugYaofangXqPrice) {
		this.drugYaofangXqPrice = drugYaofangXqPrice;
	}

	public String getDrugYaofangXqRemark() {
		return drugYaofangXqRemark;
	}

	public void setDrugYaofangXqRemark(String drugYaofangXqRemark) {
		this.drugYaofangXqRemark = drugYaofangXqRemark;
	}

	public String getDrugYaofangXqState() {
		return drugYaofangXqState;
	}

	public void setDrugYaofangXqState(String drugYaofangXqState) {
		this.drugYaofangXqState = drugYaofangXqState;
	}

	public DrugVo getDrug() {
		return drug;
	}

	public void setDrug(DrugVo drug) {
		this.drug = drug;
	}

	public DrugHairVo getDrugHair() {
		return drugHair;
	}

	public void setDrugHair(DrugHairVo drugHair) {
		this.drugHair = drugHair;
	}

	public DrugHairXqVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DrugHairXqVo(long drugYaofangXqId, BigDecimal drugYaofangXqMoney, BigDecimal drugYaofangXqNumber,
			String drugYaofangXqPh, BigDecimal drugYaofangXqPrice, String drugYaofangXqRemark,
			String drugYaofangXqState, DrugVo drug, DrugHairVo drugHair) {
		super();
		this.drugYaofangXqId = drugYaofangXqId;
		this.drugYaofangXqMoney = drugYaofangXqMoney;
		this.drugYaofangXqNumber = drugYaofangXqNumber;
		this.drugYaofangXqPh = drugYaofangXqPh;
		this.drugYaofangXqPrice = drugYaofangXqPrice;
		this.drugYaofangXqRemark = drugYaofangXqRemark;
		this.drugYaofangXqState = drugYaofangXqState;
		this.drug = drug;
		this.drugHair = drugHair;
	}

	public DrugHairXqVo(long drugYaofangXqId, BigDecimal drugYaofangXqMoney, BigDecimal drugYaofangXqNumber,
			String drugYaofangXqPh, BigDecimal drugYaofangXqPrice, String drugYaofangXqRemark,
			String drugYaofangXqState) {
		super();
		this.drugYaofangXqId = drugYaofangXqId;
		this.drugYaofangXqMoney = drugYaofangXqMoney;
		this.drugYaofangXqNumber = drugYaofangXqNumber;
		this.drugYaofangXqPh = drugYaofangXqPh;
		this.drugYaofangXqPrice = drugYaofangXqPrice;
		this.drugYaofangXqRemark = drugYaofangXqRemark;
		this.drugYaofangXqState = drugYaofangXqState;
	}

	@Override
	public String toString() {
		return "DrugHairXqVo [drugYaofangXqId=" + drugYaofangXqId + ", drugYaofangXqMoney=" + drugYaofangXqMoney
				+ ", drugYaofangXqNumber=" + drugYaofangXqNumber + ", drugYaofangXqPh=" + drugYaofangXqPh
				+ ", drugYaofangXqPrice=" + drugYaofangXqPrice + ", drugYaofangXqRemark=" + drugYaofangXqRemark
				+ ", drugYaofangXqState=" + drugYaofangXqState + ", drug=" + drug + ", drugHair=" + drugHair + "]";
	}
	
}
