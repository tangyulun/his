package com.ssh.vo.drugstorage;

import java.math.BigDecimal;

public class DrugPurchaseDetaliVo {
	
	private long drugPurchaseDetailsId;

	private String drugPurchaseDetailsBz;

	private BigDecimal drugPurchaseDetailsDj;

	private BigDecimal drugPurchaseDetailsJe;

	private BigDecimal drugPurchaseDetailsNum;

	private String drugPurchaseDetailsPh;

	private DrugVo drug;

	private DrugPurchaseVo drugPurchase;

	public long getDrugPurchaseDetailsId() {
		return drugPurchaseDetailsId;
	}

	public void setDrugPurchaseDetailsId(long drugPurchaseDetailsId) {
		this.drugPurchaseDetailsId = drugPurchaseDetailsId;
	}

	public String getDrugPurchaseDetailsBz() {
		return drugPurchaseDetailsBz;
	}

	public void setDrugPurchaseDetailsBz(String drugPurchaseDetailsBz) {
		this.drugPurchaseDetailsBz = drugPurchaseDetailsBz;
	}

	public BigDecimal getDrugPurchaseDetailsDj() {
		return drugPurchaseDetailsDj;
	}

	public void setDrugPurchaseDetailsDj(BigDecimal drugPurchaseDetailsDj) {
		this.drugPurchaseDetailsDj = drugPurchaseDetailsDj;
	}

	public BigDecimal getDrugPurchaseDetailsJe() {
		return drugPurchaseDetailsJe;
	}

	public void setDrugPurchaseDetailsJe(BigDecimal drugPurchaseDetailsJe) {
		this.drugPurchaseDetailsJe = drugPurchaseDetailsJe;
	}

	public BigDecimal getDrugPurchaseDetailsNum() {
		return drugPurchaseDetailsNum;
	}

	public void setDrugPurchaseDetailsNum(BigDecimal drugPurchaseDetailsNum) {
		this.drugPurchaseDetailsNum = drugPurchaseDetailsNum;
	}

	public String getDrugPurchaseDetailsPh() {
		return drugPurchaseDetailsPh;
	}

	public void setDrugPurchaseDetailsPh(String drugPurchaseDetailsPh) {
		this.drugPurchaseDetailsPh = drugPurchaseDetailsPh;
	}

	public DrugVo getDrug() {
		return drug;
	}

	public void setDrug(DrugVo drug) {
		this.drug = drug;
	}

	public DrugPurchaseVo getDrugPurchase() {
		return drugPurchase;
	}

	public void setDrugPurchase(DrugPurchaseVo drugPurchase) {
		this.drugPurchase = drugPurchase;
	}

	public DrugPurchaseDetaliVo(long drugPurchaseDetailsId, String drugPurchaseDetailsBz,
			BigDecimal drugPurchaseDetailsDj, BigDecimal drugPurchaseDetailsJe, BigDecimal drugPurchaseDetailsNum,
			String drugPurchaseDetailsPh, DrugVo drug, DrugPurchaseVo drugPurchase) {
		super();
		this.drugPurchaseDetailsId = drugPurchaseDetailsId;
		this.drugPurchaseDetailsBz = drugPurchaseDetailsBz;
		this.drugPurchaseDetailsDj = drugPurchaseDetailsDj;
		this.drugPurchaseDetailsJe = drugPurchaseDetailsJe;
		this.drugPurchaseDetailsNum = drugPurchaseDetailsNum;
		this.drugPurchaseDetailsPh = drugPurchaseDetailsPh;
		this.drug = drug;
		this.drugPurchase = drugPurchase;
	}

	public DrugPurchaseDetaliVo(long drugPurchaseDetailsId, String drugPurchaseDetailsBz,
			BigDecimal drugPurchaseDetailsDj, BigDecimal drugPurchaseDetailsJe, BigDecimal drugPurchaseDetailsNum,
			String drugPurchaseDetailsPh) {
		super();
		this.drugPurchaseDetailsId = drugPurchaseDetailsId;
		this.drugPurchaseDetailsBz = drugPurchaseDetailsBz;
		this.drugPurchaseDetailsDj = drugPurchaseDetailsDj;
		this.drugPurchaseDetailsJe = drugPurchaseDetailsJe;
		this.drugPurchaseDetailsNum = drugPurchaseDetailsNum;
		this.drugPurchaseDetailsPh = drugPurchaseDetailsPh;
	}

	public DrugPurchaseDetaliVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DrugPurchaseDetali [drugPurchaseDetailsId=" + drugPurchaseDetailsId + ", drugPurchaseDetailsBz="
				+ drugPurchaseDetailsBz + ", drugPurchaseDetailsDj=" + drugPurchaseDetailsDj
				+ ", drugPurchaseDetailsJe=" + drugPurchaseDetailsJe + ", drugPurchaseDetailsNum="
				+ drugPurchaseDetailsNum + ", drugPurchaseDetailsPh=" + drugPurchaseDetailsPh + ", drug=" + drug
				+ ", drugPurchase=" + drugPurchase + "]";
	}
	
	
}
