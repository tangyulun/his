package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the DRUG_PURCHASE database table.
 * 
 */
@Entity
@Table(name="DRUG_PURCHASE")
@NamedQuery(name="DrugPurchase.findAll", query="SELECT d FROM DrugPurchase d")
public class DrugPurchase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DRUG_PURCHASE_ID")
	private String drugPurchaseId;

	@Temporal(TemporalType.DATE)
	@Column(name="DRUG_PURCHASE_DHDATE")
	private Date drugPurchaseDhdate;

	@Temporal(TemporalType.DATE)
	@Column(name="DRUG_PURCHASE_GHDATE")
	private Date drugPurchaseGhdate;

	@Column(name="DRUG_PURCHASE_JHDZ")
	private String drugPurchaseJhdz;

	@Column(name="DRUG_PURCHASE_MONEY")
	private BigDecimal drugPurchaseMoney;

	@Column(name="DRUG_PURCHASE_ZT")
	private String drugPurchaseZt;

	//bi-directional many-to-one association to DrugAcceptance
	@OneToMany(mappedBy="drugPurchase")
	private List<DrugAcceptance> drugAcceptances;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	//bi-directional many-to-one association to Supplier
	@ManyToOne
	@JoinColumn(name="SUPPLIER_ID")
	private Supplier supplier;

	//bi-directional many-to-one association to DrugPurchaseDetail
	@OneToMany(mappedBy="drugPurchase")
	private List<DrugPurchaseDetail> drugPurchaseDetails;

	public DrugPurchase() {
	}

	public String getDrugPurchaseId() {
		return this.drugPurchaseId;
	}

	public void setDrugPurchaseId(String drugPurchaseId) {
		this.drugPurchaseId = drugPurchaseId;
	}

	public Date getDrugPurchaseDhdate() {
		return this.drugPurchaseDhdate;
	}

	public void setDrugPurchaseDhdate(Date drugPurchaseDhdate) {
		this.drugPurchaseDhdate = drugPurchaseDhdate;
	}

	public Date getDrugPurchaseGhdate() {
		return this.drugPurchaseGhdate;
	}

	public void setDrugPurchaseGhdate(Date drugPurchaseGhdate) {
		this.drugPurchaseGhdate = drugPurchaseGhdate;
	}

	public String getDrugPurchaseJhdz() {
		return this.drugPurchaseJhdz;
	}

	public void setDrugPurchaseJhdz(String drugPurchaseJhdz) {
		this.drugPurchaseJhdz = drugPurchaseJhdz;
	}

	public BigDecimal getDrugPurchaseMoney() {
		return this.drugPurchaseMoney;
	}

	public void setDrugPurchaseMoney(BigDecimal drugPurchaseMoney) {
		this.drugPurchaseMoney = drugPurchaseMoney;
	}

	public String getDrugPurchaseZt() {
		return this.drugPurchaseZt;
	}

	public void setDrugPurchaseZt(String drugPurchaseZt) {
		this.drugPurchaseZt = drugPurchaseZt;
	}

	public List<DrugAcceptance> getDrugAcceptances() {
		return this.drugAcceptances;
	}

	public void setDrugAcceptances(List<DrugAcceptance> drugAcceptances) {
		this.drugAcceptances = drugAcceptances;
	}

	public DrugAcceptance addDrugAcceptance(DrugAcceptance drugAcceptance) {
		getDrugAcceptances().add(drugAcceptance);
		drugAcceptance.setDrugPurchase(this);

		return drugAcceptance;
	}

	public DrugAcceptance removeDrugAcceptance(DrugAcceptance drugAcceptance) {
		getDrugAcceptances().remove(drugAcceptance);
		drugAcceptance.setDrugPurchase(null);

		return drugAcceptance;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<DrugPurchaseDetail> getDrugPurchaseDetails() {
		return this.drugPurchaseDetails;
	}

	public void setDrugPurchaseDetails(List<DrugPurchaseDetail> drugPurchaseDetails) {
		this.drugPurchaseDetails = drugPurchaseDetails;
	}

	public DrugPurchaseDetail addDrugPurchaseDetail(DrugPurchaseDetail drugPurchaseDetail) {
		getDrugPurchaseDetails().add(drugPurchaseDetail);
		drugPurchaseDetail.setDrugPurchase(this);

		return drugPurchaseDetail;
	}

	public DrugPurchaseDetail removeDrugPurchaseDetail(DrugPurchaseDetail drugPurchaseDetail) {
		getDrugPurchaseDetails().remove(drugPurchaseDetail);
		drugPurchaseDetail.setDrugPurchase(null);

		return drugPurchaseDetail;
	}

}