package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the PHARMACY_INVENTORY_DETALIS database table.
 * 
 */
@Entity
@Table(name="PHARMACY_INVENTORY_DETALIS")
@NamedQuery(name="PharmacyInventoryDetali.findAll", query="SELECT p FROM PharmacyInventoryDetali p")
public class PharmacyInventoryDetali implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PHARMACY_INVENTORY_DETALIS_ID")
	private String pharmacyInventoryDetalisId;

	@Column(name="PHARMACY_ID_JCNUM")
	private BigDecimal pharmacyIdJcnum;

	@Column(name="PHARMACY_ID_KYJE")
	private BigDecimal pharmacyIdKyje;

	@Column(name="PHARMACY_ID_KYNUM")
	private BigDecimal pharmacyIdKynum;

	@Column(name="PHARMACY_INVENTORY_DETALIS_DJ")
	private BigDecimal pharmacyInventoryDetalisDj;

	@Column(name="PHARMACY_INVENTORY_DETALIS_PH")
	private String pharmacyInventoryDetalisPh;

	//bi-directional many-to-one association to Drug
	@ManyToOne
	@JoinColumn(name="DRUG_ID")
	private Drug drug;

	//bi-directional many-to-one association to PharmacyInventory
	@ManyToOne
	@JoinColumn(name="PHARMACY_INVENTORY_ID")
	private PharmacyInventory pharmacyInventory;

	public PharmacyInventoryDetali() {
	}

	public String getPharmacyInventoryDetalisId() {
		return this.pharmacyInventoryDetalisId;
	}

	public void setPharmacyInventoryDetalisId(String pharmacyInventoryDetalisId) {
		this.pharmacyInventoryDetalisId = pharmacyInventoryDetalisId;
	}

	public BigDecimal getPharmacyIdJcnum() {
		return this.pharmacyIdJcnum;
	}

	public void setPharmacyIdJcnum(BigDecimal pharmacyIdJcnum) {
		this.pharmacyIdJcnum = pharmacyIdJcnum;
	}

	public BigDecimal getPharmacyIdKyje() {
		return this.pharmacyIdKyje;
	}

	public void setPharmacyIdKyje(BigDecimal pharmacyIdKyje) {
		this.pharmacyIdKyje = pharmacyIdKyje;
	}

	public BigDecimal getPharmacyIdKynum() {
		return this.pharmacyIdKynum;
	}

	public void setPharmacyIdKynum(BigDecimal pharmacyIdKynum) {
		this.pharmacyIdKynum = pharmacyIdKynum;
	}

	public BigDecimal getPharmacyInventoryDetalisDj() {
		return this.pharmacyInventoryDetalisDj;
	}

	public void setPharmacyInventoryDetalisDj(BigDecimal pharmacyInventoryDetalisDj) {
		this.pharmacyInventoryDetalisDj = pharmacyInventoryDetalisDj;
	}

	public String getPharmacyInventoryDetalisPh() {
		return this.pharmacyInventoryDetalisPh;
	}

	public void setPharmacyInventoryDetalisPh(String pharmacyInventoryDetalisPh) {
		this.pharmacyInventoryDetalisPh = pharmacyInventoryDetalisPh;
	}

	public Drug getDrug() {
		return this.drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public PharmacyInventory getPharmacyInventory() {
		return this.pharmacyInventory;
	}

	public void setPharmacyInventory(PharmacyInventory pharmacyInventory) {
		this.pharmacyInventory = pharmacyInventory;
	}

}