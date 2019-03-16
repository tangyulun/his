package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRUG_ACCEPTANCE_XQ database table.
 * 
 */
@Entity
@Table(name="DRUG_ACCEPTANCE_XQ")
@NamedQuery(name="DrugAcceptanceXq.findAll", query="SELECT d FROM DrugAcceptanceXq d")
public class DrugAcceptanceXq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DRUG_ACCEPTANCE_XQ")
	private long drugAcceptanceXq;

	@Column(name="DRUG_ACCEPTANCE_XQ_BUHEGE_NUM")
	private BigDecimal drugAcceptanceXqBuhegeNum;

	@Column(name="DRUG_ACCEPTANCE_XQ_HEGE_NUM")
	private BigDecimal drugAcceptanceXqHegeNum;

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

	//bi-directional many-to-one association to DrugAcceptance
	@ManyToOne
	@JoinColumn(name="DRUG_ACCEPTANCE_ID")
	private DrugAcceptance drugAcceptance;

	public DrugAcceptanceXq() {
	}

	public long getDrugAcceptanceXq() {
		return this.drugAcceptanceXq;
	}

	public void setDrugAcceptanceXq(long drugAcceptanceXq) {
		this.drugAcceptanceXq = drugAcceptanceXq;
	}

	public BigDecimal getDrugAcceptanceXqBuhegeNum() {
		return this.drugAcceptanceXqBuhegeNum;
	}

	public void setDrugAcceptanceXqBuhegeNum(BigDecimal drugAcceptanceXqBuhegeNum) {
		this.drugAcceptanceXqBuhegeNum = drugAcceptanceXqBuhegeNum;
	}

	public BigDecimal getDrugAcceptanceXqHegeNum() {
		return this.drugAcceptanceXqHegeNum;
	}

	public void setDrugAcceptanceXqHegeNum(BigDecimal drugAcceptanceXqHegeNum) {
		this.drugAcceptanceXqHegeNum = drugAcceptanceXqHegeNum;
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

	public DrugAcceptance getDrugAcceptance() {
		return this.drugAcceptance;
	}

	public void setDrugAcceptance(DrugAcceptance drugAcceptance) {
		this.drugAcceptance = drugAcceptance;
	}

}