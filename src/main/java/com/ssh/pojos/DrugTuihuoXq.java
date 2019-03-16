package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRUG_TUIHUO_XQ database table.
 * 
 */
@Entity
@Table(name="DRUG_TUIHUO_XQ")
@NamedQuery(name="DrugTuihuoXq.findAll", query="SELECT d FROM DrugTuihuoXq d")
public class DrugTuihuoXq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DRUG_TUIHUO_XQ_ID")
	private long drugTuihuoXqId;

	@Column(name="DRUG_ACCEPTANCE_XQ_MONEY")
	private BigDecimal drugAcceptanceXqMoney;

	@Column(name="DRUG_ACCEPTANCE_XQ_NUM")
	private BigDecimal drugAcceptanceXqNum;

	@Column(name="DRUG_ACCEPTANCE_XQ_PH")
	private String drugAcceptanceXqPh;

	@Column(name="DRUG_ACCEPTANCE_XQ_PRICE")
	private BigDecimal drugAcceptanceXqPrice;

	@Column(name="DRUG_ACCEPTANCE_XQ_REMARK")
	private String drugAcceptanceXqRemark;

	//bi-directional many-to-one association to Drug
	@ManyToOne
	@JoinColumn(name="DRUG_ID")
	private Drug drug;

	//bi-directional many-to-one association to DrugTuihuo
	@ManyToOne
	@JoinColumn(name="DRUG_TUIHUO_ID")
	private DrugTuihuo drugTuihuo;

	public DrugTuihuoXq() {
	}

	public long getDrugTuihuoXqId() {
		return this.drugTuihuoXqId;
	}

	public void setDrugTuihuoXqId(long drugTuihuoXqId) {
		this.drugTuihuoXqId = drugTuihuoXqId;
	}

	public BigDecimal getDrugAcceptanceXqMoney() {
		return this.drugAcceptanceXqMoney;
	}

	public void setDrugAcceptanceXqMoney(BigDecimal drugAcceptanceXqMoney) {
		this.drugAcceptanceXqMoney = drugAcceptanceXqMoney;
	}

	public BigDecimal getDrugAcceptanceXqNum() {
		return this.drugAcceptanceXqNum;
	}

	public void setDrugAcceptanceXqNum(BigDecimal drugAcceptanceXqNum) {
		this.drugAcceptanceXqNum = drugAcceptanceXqNum;
	}

	public String getDrugAcceptanceXqPh() {
		return this.drugAcceptanceXqPh;
	}

	public void setDrugAcceptanceXqPh(String drugAcceptanceXqPh) {
		this.drugAcceptanceXqPh = drugAcceptanceXqPh;
	}

	public BigDecimal getDrugAcceptanceXqPrice() {
		return this.drugAcceptanceXqPrice;
	}

	public void setDrugAcceptanceXqPrice(BigDecimal drugAcceptanceXqPrice) {
		this.drugAcceptanceXqPrice = drugAcceptanceXqPrice;
	}

	public String getDrugAcceptanceXqRemark() {
		return this.drugAcceptanceXqRemark;
	}

	public void setDrugAcceptanceXqRemark(String drugAcceptanceXqRemark) {
		this.drugAcceptanceXqRemark = drugAcceptanceXqRemark;
	}

	public Drug getDrug() {
		return this.drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public DrugTuihuo getDrugTuihuo() {
		return this.drugTuihuo;
	}

	public void setDrugTuihuo(DrugTuihuo drugTuihuo) {
		this.drugTuihuo = drugTuihuo;
	}

}