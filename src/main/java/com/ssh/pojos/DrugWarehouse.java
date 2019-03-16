package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the DRUG_WAREHOUSE database table.
 * 
 */
@Entity
@Table(name="DRUG_WAREHOUSE")
@NamedQuery(name="DrugWarehouse.findAll", query="SELECT d FROM DrugWarehouse d")
public class DrugWarehouse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DRUG_WAREHOUSE_ID")
	private String drugWarehouseId;

	@Column(name="DRUG_WAREHOUSE_CGY")
	private String drugWarehouseCgy;

	@Column(name="DRUG_WAREHOUSE_NAME")
	private String drugWarehouseName;

	@Column(name="DRUG_WAREHOUSE_PZDH")
	private String drugWarehousePzdh;

	@Temporal(TemporalType.DATE)
	@Column(name="DRUG_WAREHOUSE_RKDATE")
	private Date drugWarehouseRkdate;

	@Column(name="DRUG_WAREHOUSE_RKLX")
	private String drugWarehouseRklx;

	@Column(name="DRUG_WAREHOUSE_ZT")
	private String drugWarehouseZt;

	//bi-directional many-to-one association to DrugAcceptance
	@ManyToOne
	@JoinColumn(name="DRUG_ACCEPTANCE_ID")
	private DrugAcceptance drugAcceptance;

	//bi-directional many-to-one association to DrugWarehouseXq
	@OneToMany(mappedBy="drugWarehouse")
	private List<DrugWarehouseXq> drugWarehouseXqs;

	public DrugWarehouse() {
	}

	public String getDrugWarehouseId() {
		return this.drugWarehouseId;
	}

	public void setDrugWarehouseId(String drugWarehouseId) {
		this.drugWarehouseId = drugWarehouseId;
	}

	public String getDrugWarehouseCgy() {
		return this.drugWarehouseCgy;
	}

	public void setDrugWarehouseCgy(String drugWarehouseCgy) {
		this.drugWarehouseCgy = drugWarehouseCgy;
	}

	public String getDrugWarehouseName() {
		return this.drugWarehouseName;
	}

	public void setDrugWarehouseName(String drugWarehouseName) {
		this.drugWarehouseName = drugWarehouseName;
	}

	public String getDrugWarehousePzdh() {
		return this.drugWarehousePzdh;
	}

	public void setDrugWarehousePzdh(String drugWarehousePzdh) {
		this.drugWarehousePzdh = drugWarehousePzdh;
	}

	public Date getDrugWarehouseRkdate() {
		return this.drugWarehouseRkdate;
	}

	public void setDrugWarehouseRkdate(Date drugWarehouseRkdate) {
		this.drugWarehouseRkdate = drugWarehouseRkdate;
	}

	public String getDrugWarehouseRklx() {
		return this.drugWarehouseRklx;
	}

	public void setDrugWarehouseRklx(String drugWarehouseRklx) {
		this.drugWarehouseRklx = drugWarehouseRklx;
	}

	public String getDrugWarehouseZt() {
		return this.drugWarehouseZt;
	}

	public void setDrugWarehouseZt(String drugWarehouseZt) {
		this.drugWarehouseZt = drugWarehouseZt;
	}

	public DrugAcceptance getDrugAcceptance() {
		return this.drugAcceptance;
	}

	public void setDrugAcceptance(DrugAcceptance drugAcceptance) {
		this.drugAcceptance = drugAcceptance;
	}

	public List<DrugWarehouseXq> getDrugWarehouseXqs() {
		return this.drugWarehouseXqs;
	}

	public void setDrugWarehouseXqs(List<DrugWarehouseXq> drugWarehouseXqs) {
		this.drugWarehouseXqs = drugWarehouseXqs;
	}

	public DrugWarehouseXq addDrugWarehouseXq(DrugWarehouseXq drugWarehouseXq) {
		getDrugWarehouseXqs().add(drugWarehouseXq);
		drugWarehouseXq.setDrugWarehouse(this);

		return drugWarehouseXq;
	}

	public DrugWarehouseXq removeDrugWarehouseXq(DrugWarehouseXq drugWarehouseXq) {
		getDrugWarehouseXqs().remove(drugWarehouseXq);
		drugWarehouseXq.setDrugWarehouse(null);

		return drugWarehouseXq;
	}

}