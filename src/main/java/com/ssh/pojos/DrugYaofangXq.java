package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRUG_YAOFANG_XQ database table.
 * 
 */
@Entity
@Table(name="DRUG_YAOFANG_XQ")
@NamedQuery(name="DrugYaofangXq.findAll", query="SELECT d FROM DrugYaofangXq d")
public class DrugYaofangXq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DRUG_YAOFANG_XQ_ID")
	private long drugYaofangXqId;

	@Column(name="DRUG_YAOFANG_XQ_MONEY")
	private BigDecimal drugYaofangXqMoney;

	@Column(name="DRUG_YAOFANG_XQ_NUMBER")
	private BigDecimal drugYaofangXqNumber;

	@Column(name="DRUG_YAOFANG_XQ_PH")
	private String drugYaofangXqPh;

	@Column(name="DRUG_YAOFANG_XQ_PRICE")
	private BigDecimal drugYaofangXqPrice;

	@Column(name="DRUG_YAOFANG_XQ_REMARK")
	private String drugYaofangXqRemark;

	@Column(name="DRUG_YAOFANG_XQ_STATE")
	private String drugYaofangXqState;

	//bi-directional many-to-one association to Drug
	@ManyToOne
	@JoinColumn(name="DRUG_ID")
	private Drug drug;

	//bi-directional many-to-one association to DrugYaofang
	@ManyToOne
	@JoinColumn(name="DRUG_YAOFANG_ID")
	private DrugYaofang drugYaofang;

	public DrugYaofangXq() {
	}

	public long getDrugYaofangXqId() {
		return this.drugYaofangXqId;
	}

	public void setDrugYaofangXqId(long drugYaofangXqId) {
		this.drugYaofangXqId = drugYaofangXqId;
	}

	public BigDecimal getDrugYaofangXqMoney() {
		return this.drugYaofangXqMoney;
	}

	public void setDrugYaofangXqMoney(BigDecimal drugYaofangXqMoney) {
		this.drugYaofangXqMoney = drugYaofangXqMoney;
	}

	public BigDecimal getDrugYaofangXqNumber() {
		return this.drugYaofangXqNumber;
	}

	public void setDrugYaofangXqNumber(BigDecimal drugYaofangXqNumber) {
		this.drugYaofangXqNumber = drugYaofangXqNumber;
	}

	public String getDrugYaofangXqPh() {
		return this.drugYaofangXqPh;
	}

	public void setDrugYaofangXqPh(String drugYaofangXqPh) {
		this.drugYaofangXqPh = drugYaofangXqPh;
	}

	public BigDecimal getDrugYaofangXqPrice() {
		return this.drugYaofangXqPrice;
	}

	public void setDrugYaofangXqPrice(BigDecimal drugYaofangXqPrice) {
		this.drugYaofangXqPrice = drugYaofangXqPrice;
	}

	public String getDrugYaofangXqRemark() {
		return this.drugYaofangXqRemark;
	}

	public void setDrugYaofangXqRemark(String drugYaofangXqRemark) {
		this.drugYaofangXqRemark = drugYaofangXqRemark;
	}

	public String getDrugYaofangXqState() {
		return this.drugYaofangXqState;
	}

	public void setDrugYaofangXqState(String drugYaofangXqState) {
		this.drugYaofangXqState = drugYaofangXqState;
	}

	public Drug getDrug() {
		return this.drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public DrugYaofang getDrugYaofang() {
		return this.drugYaofang;
	}

	public void setDrugYaofang(DrugYaofang drugYaofang) {
		this.drugYaofang = drugYaofang;
	}

}