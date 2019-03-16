package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRUG_PURCHASE_DETAILS_ database table.
 * 
 */
@Entity
@Table(name="DRUG_PURCHASE_DETAILS_")
@NamedQuery(name="DrugPurchaseDetail.findAll", query="SELECT d FROM DrugPurchaseDetail d")
public class DrugPurchaseDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DRUG_PURCHASE_DETAILS_ID")
	private long drugPurchaseDetailsId;

	@Column(name="DRUG_PURCHASE_DETAILS_BZ")
	private String drugPurchaseDetailsBz;

	@Column(name="DRUG_PURCHASE_DETAILS_DJ")
	private BigDecimal drugPurchaseDetailsDj;

	@Column(name="DRUG_PURCHASE_DETAILS_JE")
	private BigDecimal drugPurchaseDetailsJe;

	@Column(name="DRUG_PURCHASE_DETAILS_NUM")
	private BigDecimal drugPurchaseDetailsNum;

	@Column(name="DRUG_PURCHASE_DETAILS_PH")
	private String drugPurchaseDetailsPh;

	//bi-directional many-to-one association to Drug
	@ManyToOne
	@JoinColumn(name="DRUG_ID")
	private Drug drug;

	//bi-directional many-to-one association to DrugPurchase
	@ManyToOne
	@JoinColumn(name="DRUG_PURCHASE_ID")
	private DrugPurchase drugPurchase;

	public DrugPurchaseDetail() {
	}

	public long getDrugPurchaseDetailsId() {
		return this.drugPurchaseDetailsId;
	}

	public void setDrugPurchaseDetailsId(long drugPurchaseDetailsId) {
		this.drugPurchaseDetailsId = drugPurchaseDetailsId;
	}

	public String getDrugPurchaseDetailsBz() {
		return this.drugPurchaseDetailsBz;
	}

	public void setDrugPurchaseDetailsBz(String drugPurchaseDetailsBz) {
		this.drugPurchaseDetailsBz = drugPurchaseDetailsBz;
	}

	public BigDecimal getDrugPurchaseDetailsDj() {
		return this.drugPurchaseDetailsDj;
	}

	public void setDrugPurchaseDetailsDj(BigDecimal drugPurchaseDetailsDj) {
		this.drugPurchaseDetailsDj = drugPurchaseDetailsDj;
	}

	public BigDecimal getDrugPurchaseDetailsJe() {
		return this.drugPurchaseDetailsJe;
	}

	public void setDrugPurchaseDetailsJe(BigDecimal drugPurchaseDetailsJe) {
		this.drugPurchaseDetailsJe = drugPurchaseDetailsJe;
	}

	public BigDecimal getDrugPurchaseDetailsNum() {
		return this.drugPurchaseDetailsNum;
	}

	public void setDrugPurchaseDetailsNum(BigDecimal drugPurchaseDetailsNum) {
		this.drugPurchaseDetailsNum = drugPurchaseDetailsNum;
	}

	public String getDrugPurchaseDetailsPh() {
		return this.drugPurchaseDetailsPh;
	}

	public void setDrugPurchaseDetailsPh(String drugPurchaseDetailsPh) {
		this.drugPurchaseDetailsPh = drugPurchaseDetailsPh;
	}

	public Drug getDrug() {
		return this.drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public DrugPurchase getDrugPurchase() {
		return this.drugPurchase;
	}

	public void setDrugPurchase(DrugPurchase drugPurchase) {
		this.drugPurchase = drugPurchase;
	}

}