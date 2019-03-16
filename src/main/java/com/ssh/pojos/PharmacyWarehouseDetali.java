package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PHARMACY_WAREHOUSE_DETALIS database table.
 * 
 */
@Entity
@Table(name="PHARMACY_WAREHOUSE_DETALIS")
@NamedQuery(name="PharmacyWarehouseDetali.findAll", query="SELECT p FROM PharmacyWarehouseDetali p")
public class PharmacyWarehouseDetali implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PHARMACY_WAREHOUSE_DETALIS_ID")
	private String pharmacyWarehouseDetalisId;

	@Column(name="PHARMACY_WAREHOUSE_DETALIS_BZ")
	private String pharmacyWarehouseDetalisBz;

	@Column(name="PHARMACY_WAREHOUSE_DETALIS_DJ")
	private BigDecimal pharmacyWarehouseDetalisDj;

	@Column(name="PHARMACY_WAREHOUSE_DETALIS_JE")
	private BigDecimal pharmacyWarehouseDetalisJe;

	@Column(name="PHARMACY_WAREHOUSE_DETALIS_NUM")
	private BigDecimal pharmacyWarehouseDetalisNum;

	@Column(name="PHARMACY_WAREHOUSE_DETALIS_PH")
	private String pharmacyWarehouseDetalisPh;

	@Temporal(TemporalType.DATE)
	@Column(name="PHARMACY_WD_BZQZ")
	private Date pharmacyWdBzqz;

	@Temporal(TemporalType.DATE)
	@Column(name="PHARMACY_WD_SCRQ")
	private Date pharmacyWdScrq;

	//bi-directional many-to-one association to Drug
	@ManyToOne
	@JoinColumn(name="DRUG_ID")
	private Drug drug;

	//bi-directional many-to-one association to YaofangRuku
	@ManyToOne
	@JoinColumn(name="PHARMACY_WAREHOUSE_ID")
	private YaofangRuku yaofangRuku;

	public PharmacyWarehouseDetali() {
	}

	public String getPharmacyWarehouseDetalisId() {
		return this.pharmacyWarehouseDetalisId;
	}

	public void setPharmacyWarehouseDetalisId(String pharmacyWarehouseDetalisId) {
		this.pharmacyWarehouseDetalisId = pharmacyWarehouseDetalisId;
	}

	public String getPharmacyWarehouseDetalisBz() {
		return this.pharmacyWarehouseDetalisBz;
	}

	public void setPharmacyWarehouseDetalisBz(String pharmacyWarehouseDetalisBz) {
		this.pharmacyWarehouseDetalisBz = pharmacyWarehouseDetalisBz;
	}

	public BigDecimal getPharmacyWarehouseDetalisDj() {
		return this.pharmacyWarehouseDetalisDj;
	}

	public void setPharmacyWarehouseDetalisDj(BigDecimal pharmacyWarehouseDetalisDj) {
		this.pharmacyWarehouseDetalisDj = pharmacyWarehouseDetalisDj;
	}

	public BigDecimal getPharmacyWarehouseDetalisJe() {
		return this.pharmacyWarehouseDetalisJe;
	}

	public void setPharmacyWarehouseDetalisJe(BigDecimal pharmacyWarehouseDetalisJe) {
		this.pharmacyWarehouseDetalisJe = pharmacyWarehouseDetalisJe;
	}

	public BigDecimal getPharmacyWarehouseDetalisNum() {
		return this.pharmacyWarehouseDetalisNum;
	}

	public void setPharmacyWarehouseDetalisNum(BigDecimal pharmacyWarehouseDetalisNum) {
		this.pharmacyWarehouseDetalisNum = pharmacyWarehouseDetalisNum;
	}

	public String getPharmacyWarehouseDetalisPh() {
		return this.pharmacyWarehouseDetalisPh;
	}

	public void setPharmacyWarehouseDetalisPh(String pharmacyWarehouseDetalisPh) {
		this.pharmacyWarehouseDetalisPh = pharmacyWarehouseDetalisPh;
	}

	public Date getPharmacyWdBzqz() {
		return this.pharmacyWdBzqz;
	}

	public void setPharmacyWdBzqz(Date pharmacyWdBzqz) {
		this.pharmacyWdBzqz = pharmacyWdBzqz;
	}

	public Date getPharmacyWdScrq() {
		return this.pharmacyWdScrq;
	}

	public void setPharmacyWdScrq(Date pharmacyWdScrq) {
		this.pharmacyWdScrq = pharmacyWdScrq;
	}

	public Drug getDrug() {
		return this.drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public YaofangRuku getYaofangRuku() {
		return this.yaofangRuku;
	}

	public void setYaofangRuku(YaofangRuku yaofangRuku) {
		this.yaofangRuku = yaofangRuku;
	}

}