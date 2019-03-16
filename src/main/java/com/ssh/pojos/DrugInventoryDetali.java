package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DRUG_INVENTORY_DETALIS database table.
 * 
 */
@Entity
@Table(name="DRUG_INVENTORY_DETALIS")
@NamedQuery(name="DrugInventoryDetali.findAll", query="SELECT d FROM DrugInventoryDetali d")
public class DrugInventoryDetali implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DRUG_INVENTORY_DETALIS_ID")
	private String drugInventoryDetalisId;

	@Column(name="DRUG_INVENTORY_DETALIS_DJ")
	private BigDecimal drugInventoryDetalisDj;

	@Column(name="DRUG_INVENTORY_DETALIS_JCNUM")
	private BigDecimal drugInventoryDetalisJcnum;

	@Column(name="DRUG_INVENTORY_DETALIS_KYMONEY")
	private BigDecimal drugInventoryDetalisKymoney;

	@Column(name="DRUG_INVENTORY_DETALIS_KYNUM")
	private BigDecimal drugInventoryDetalisKynum;

	@Column(name="DRUG_INVENTORY_DETALIS_PH")
	private String drugInventoryDetalisPh;

	//bi-directional many-to-one association to Drug
	@ManyToOne
	@JoinColumn(name="DRUG_ID")
	private Drug drug;

	//bi-directional many-to-one association to DrugInventory
	@ManyToOne
	@JoinColumn(name="DRUG_INVENTORY_ID")
	private DrugInventory drugInventory;

	public DrugInventoryDetali() {
	}

	public String getDrugInventoryDetalisId() {
		return this.drugInventoryDetalisId;
	}

	public void setDrugInventoryDetalisId(String drugInventoryDetalisId) {
		this.drugInventoryDetalisId = drugInventoryDetalisId;
	}

	public BigDecimal getDrugInventoryDetalisDj() {
		return this.drugInventoryDetalisDj;
	}

	public void setDrugInventoryDetalisDj(BigDecimal drugInventoryDetalisDj) {
		this.drugInventoryDetalisDj = drugInventoryDetalisDj;
	}

	public BigDecimal getDrugInventoryDetalisJcnum() {
		return this.drugInventoryDetalisJcnum;
	}

	public void setDrugInventoryDetalisJcnum(BigDecimal drugInventoryDetalisJcnum) {
		this.drugInventoryDetalisJcnum = drugInventoryDetalisJcnum;
	}

	public BigDecimal getDrugInventoryDetalisKymoney() {
		return this.drugInventoryDetalisKymoney;
	}

	public void setDrugInventoryDetalisKymoney(BigDecimal drugInventoryDetalisKymoney) {
		this.drugInventoryDetalisKymoney = drugInventoryDetalisKymoney;
	}

	public BigDecimal getDrugInventoryDetalisKynum() {
		return this.drugInventoryDetalisKynum;
	}

	public void setDrugInventoryDetalisKynum(BigDecimal drugInventoryDetalisKynum) {
		this.drugInventoryDetalisKynum = drugInventoryDetalisKynum;
	}

	public String getDrugInventoryDetalisPh() {
		return this.drugInventoryDetalisPh;
	}

	public void setDrugInventoryDetalisPh(String drugInventoryDetalisPh) {
		this.drugInventoryDetalisPh = drugInventoryDetalisPh;
	}

	public Drug getDrug() {
		return this.drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public DrugInventory getDrugInventory() {
		return this.drugInventory;
	}

	public void setDrugInventory(DrugInventory drugInventory) {
		this.drugInventory = drugInventory;
	}

}