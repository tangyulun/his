package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the DRUG_ACCEPTANCE database table.
 * 
 */
@Entity
@Table(name="DRUG_ACCEPTANCE")
@NamedQuery(name="DrugAcceptance.findAll", query="SELECT d FROM DrugAcceptance d")
public class DrugAcceptance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DRUG_ACCEPTANCE_ID")
	private String drugAcceptanceId;

	@Column(name="DRUG_ACCEPTANCE_PZDH")
	private String drugAcceptancePzdh;

	@Temporal(TemporalType.DATE)
	@Column(name="DRUG_ACCEPTANCE_SHDATE")
	private Date drugAcceptanceShdate;

	@Column(name="DRUG_ACCEPTANCE_ZT")
	private String drugAcceptanceZt;

	//bi-directional many-to-one association to DrugPurchase
	@ManyToOne
	@JoinColumn(name="DRUG_PURCHASE_ID")
	private DrugPurchase drugPurchase;

	//bi-directional many-to-one association to DrugAcceptanceXq
	@OneToMany(mappedBy="drugAcceptance")
	private List<DrugAcceptanceXq> drugAcceptanceXqs;

	//bi-directional many-to-one association to DrugTuihuo
	@OneToMany(mappedBy="drugAcceptance")
	private List<DrugTuihuo> drugTuihuos;

	//bi-directional many-to-one association to DrugWarehouse
	@OneToMany(mappedBy="drugAcceptance")
	private List<DrugWarehouse> drugWarehouses;

	public DrugAcceptance() {
	}

	public String getDrugAcceptanceId() {
		return this.drugAcceptanceId;
	}

	public void setDrugAcceptanceId(String drugAcceptanceId) {
		this.drugAcceptanceId = drugAcceptanceId;
	}

	public String getDrugAcceptancePzdh() {
		return this.drugAcceptancePzdh;
	}

	public void setDrugAcceptancePzdh(String drugAcceptancePzdh) {
		this.drugAcceptancePzdh = drugAcceptancePzdh;
	}

	public Date getDrugAcceptanceShdate() {
		return this.drugAcceptanceShdate;
	}

	public void setDrugAcceptanceShdate(Date drugAcceptanceShdate) {
		this.drugAcceptanceShdate = drugAcceptanceShdate;
	}

	public String getDrugAcceptanceZt() {
		return this.drugAcceptanceZt;
	}

	public void setDrugAcceptanceZt(String drugAcceptanceZt) {
		this.drugAcceptanceZt = drugAcceptanceZt;
	}

	public DrugPurchase getDrugPurchase() {
		return this.drugPurchase;
	}

	public void setDrugPurchase(DrugPurchase drugPurchase) {
		this.drugPurchase = drugPurchase;
	}

	public List<DrugAcceptanceXq> getDrugAcceptanceXqs() {
		return this.drugAcceptanceXqs;
	}

	public void setDrugAcceptanceXqs(List<DrugAcceptanceXq> drugAcceptanceXqs) {
		this.drugAcceptanceXqs = drugAcceptanceXqs;
	}

	public DrugAcceptanceXq addDrugAcceptanceXq(DrugAcceptanceXq drugAcceptanceXq) {
		getDrugAcceptanceXqs().add(drugAcceptanceXq);
		drugAcceptanceXq.setDrugAcceptance(this);

		return drugAcceptanceXq;
	}

	public DrugAcceptanceXq removeDrugAcceptanceXq(DrugAcceptanceXq drugAcceptanceXq) {
		getDrugAcceptanceXqs().remove(drugAcceptanceXq);
		drugAcceptanceXq.setDrugAcceptance(null);

		return drugAcceptanceXq;
	}

	public List<DrugTuihuo> getDrugTuihuos() {
		return this.drugTuihuos;
	}

	public void setDrugTuihuos(List<DrugTuihuo> drugTuihuos) {
		this.drugTuihuos = drugTuihuos;
	}

	public DrugTuihuo addDrugTuihuo(DrugTuihuo drugTuihuo) {
		getDrugTuihuos().add(drugTuihuo);
		drugTuihuo.setDrugAcceptance(this);

		return drugTuihuo;
	}

	public DrugTuihuo removeDrugTuihuo(DrugTuihuo drugTuihuo) {
		getDrugTuihuos().remove(drugTuihuo);
		drugTuihuo.setDrugAcceptance(null);

		return drugTuihuo;
	}

	public List<DrugWarehouse> getDrugWarehouses() {
		return this.drugWarehouses;
	}

	public void setDrugWarehouses(List<DrugWarehouse> drugWarehouses) {
		this.drugWarehouses = drugWarehouses;
	}

	public DrugWarehouse addDrugWarehous(DrugWarehouse drugWarehous) {
		getDrugWarehouses().add(drugWarehous);
		drugWarehous.setDrugAcceptance(this);

		return drugWarehous;
	}

	public DrugWarehouse removeDrugWarehous(DrugWarehouse drugWarehous) {
		getDrugWarehouses().remove(drugWarehous);
		drugWarehous.setDrugAcceptance(null);

		return drugWarehous;
	}

}