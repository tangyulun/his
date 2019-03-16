package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the DRUG_WAREHOUSE_XQ database table.
 * 
 */
@Entity
@Table(name="DRUG_WAREHOUSE_XQ")
@NamedQuery(name="DrugWarehouseXq.findAll", query="SELECT d FROM DrugWarehouseXq d")
public class DrugWarehouseXq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DRUG_WAREHOUSE_XQ_ID")
	private long drugWarehouseXqId;

	@Temporal(TemporalType.DATE)
	@Column(name="DRUG_WAREHOUSE_XQ_BZ_DATE")
	private Date drugWarehouseXqBzDate;

	@Temporal(TemporalType.DATE)
	@Column(name="DRUG_WAREHOUSE_XQ_CG_DATE")
	private Date drugWarehouseXqCgDate;

	@Column(name="DRUG_WAREHOUSE_XQ_NUM")
	private BigDecimal drugWarehouseXqNum;

	@Column(name="DRUG_WAREHOUSE_XQ_PH")
	private String drugWarehouseXqPh;

	@Column(name="DRUG_WAREHOUSE_XQ_REMARK")
	private String drugWarehouseXqRemark;

	@Temporal(TemporalType.DATE)
	@Column(name="DRUG_WAREHOUSE_XQ_SC_DATE")
	private Date drugWarehouseXqScDate;

	//bi-directional many-to-one association to Drug
	@ManyToOne
	@JoinColumn(name="DRUG_ID")
	private Drug drug;

	//bi-directional many-to-one association to DrugWarehouse
	@ManyToOne
	@JoinColumn(name="DRUG_WAREHOUSE_ID")
	private DrugWarehouse drugWarehouse;

	public DrugWarehouseXq() {
	}

	public long getDrugWarehouseXqId() {
		return this.drugWarehouseXqId;
	}

	public void setDrugWarehouseXqId(long drugWarehouseXqId) {
		this.drugWarehouseXqId = drugWarehouseXqId;
	}

	public Date getDrugWarehouseXqBzDate() {
		return this.drugWarehouseXqBzDate;
	}

	public void setDrugWarehouseXqBzDate(Date drugWarehouseXqBzDate) {
		this.drugWarehouseXqBzDate = drugWarehouseXqBzDate;
	}

	public Date getDrugWarehouseXqCgDate() {
		return this.drugWarehouseXqCgDate;
	}

	public void setDrugWarehouseXqCgDate(Date drugWarehouseXqCgDate) {
		this.drugWarehouseXqCgDate = drugWarehouseXqCgDate;
	}

	public BigDecimal getDrugWarehouseXqNum() {
		return this.drugWarehouseXqNum;
	}

	public void setDrugWarehouseXqNum(BigDecimal drugWarehouseXqNum) {
		this.drugWarehouseXqNum = drugWarehouseXqNum;
	}

	public String getDrugWarehouseXqPh() {
		return this.drugWarehouseXqPh;
	}

	public void setDrugWarehouseXqPh(String drugWarehouseXqPh) {
		this.drugWarehouseXqPh = drugWarehouseXqPh;
	}

	public String getDrugWarehouseXqRemark() {
		return this.drugWarehouseXqRemark;
	}

	public void setDrugWarehouseXqRemark(String drugWarehouseXqRemark) {
		this.drugWarehouseXqRemark = drugWarehouseXqRemark;
	}

	public Date getDrugWarehouseXqScDate() {
		return this.drugWarehouseXqScDate;
	}

	public void setDrugWarehouseXqScDate(Date drugWarehouseXqScDate) {
		this.drugWarehouseXqScDate = drugWarehouseXqScDate;
	}

	public Drug getDrug() {
		return this.drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public DrugWarehouse getDrugWarehouse() {
		return this.drugWarehouse;
	}

	public void setDrugWarehouse(DrugWarehouse drugWarehouse) {
		this.drugWarehouse = drugWarehouse;
	}

}