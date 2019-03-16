package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the DRUG_LOGIN database table.
 * 
 */
@Entity
@Table(name="DRUG_LOGIN")
@NamedQuery(name="DrugLogin.findAll", query="SELECT d FROM DrugLogin d")
public class DrugLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DRUG_LOGIN_ID")
	private String drugLoginId;

	@Temporal(TemporalType.DATE)
	@Column(name="DRUG_LOGIN_CGDATE")
	private Date drugLoginCgdate;

	@Column(name="DRUG_LOGIN_NUM")
	private BigDecimal drugLoginNum;

	@Column(name="DRUG_LOGIN_PH")
	private String drugLoginPh;

	@Column(name="DRUG_LOGIN_PRICE")
	private BigDecimal drugLoginPrice;

	@Temporal(TemporalType.DATE)
	@Column(name="DRUG_LOGIN_SCDATE")
	private Date drugLoginScdate;

	@Column(name="DRUG_LOGIN_YXDATE")
	private String drugLoginYxdate;

	@Temporal(TemporalType.DATE)
	@Column(name="DRUG_LOGIN_YXQDATE")
	private Date drugLoginYxqdate;

	//bi-directional many-to-one association to Drug
	@ManyToOne
	@JoinColumn(name="DRUG_ID")
	private Drug drug;

	public DrugLogin() {
	}

	public String getDrugLoginId() {
		return this.drugLoginId;
	}

	public void setDrugLoginId(String drugLoginId) {
		this.drugLoginId = drugLoginId;
	}

	public Date getDrugLoginCgdate() {
		return this.drugLoginCgdate;
	}

	public void setDrugLoginCgdate(Date drugLoginCgdate) {
		this.drugLoginCgdate = drugLoginCgdate;
	}

	public BigDecimal getDrugLoginNum() {
		return this.drugLoginNum;
	}

	public void setDrugLoginNum(BigDecimal drugLoginNum) {
		this.drugLoginNum = drugLoginNum;
	}

	public String getDrugLoginPh() {
		return this.drugLoginPh;
	}

	public void setDrugLoginPh(String drugLoginPh) {
		this.drugLoginPh = drugLoginPh;
	}

	public BigDecimal getDrugLoginPrice() {
		return this.drugLoginPrice;
	}

	public void setDrugLoginPrice(BigDecimal drugLoginPrice) {
		this.drugLoginPrice = drugLoginPrice;
	}

	public Date getDrugLoginScdate() {
		return this.drugLoginScdate;
	}

	public void setDrugLoginScdate(Date drugLoginScdate) {
		this.drugLoginScdate = drugLoginScdate;
	}

	public String getDrugLoginYxdate() {
		return this.drugLoginYxdate;
	}

	public void setDrugLoginYxdate(String drugLoginYxdate) {
		this.drugLoginYxdate = drugLoginYxdate;
	}

	public Date getDrugLoginYxqdate() {
		return this.drugLoginYxqdate;
	}

	public void setDrugLoginYxqdate(Date drugLoginYxqdate) {
		this.drugLoginYxqdate = drugLoginYxqdate;
	}

	public Drug getDrug() {
		return this.drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

}