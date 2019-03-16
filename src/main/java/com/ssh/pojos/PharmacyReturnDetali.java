package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the PHARMACY_RETURN_DETALIS database table.
 * 
 */
@Entity
@Table(name="PHARMACY_RETURN_DETALIS")
@NamedQuery(name="PharmacyReturnDetali.findAll", query="SELECT p FROM PharmacyReturnDetali p")
public class PharmacyReturnDetali implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PHARMACY_RETURN_DETALIS_ID")
	private String pharmacyReturnDetalisId;

	@Column(name="PHARMACY_RETURN_DETALIS_BZ")
	private String pharmacyReturnDetalisBz;

	@Column(name="PHARMACY_RETURN_DETALIS_DJ")
	private BigDecimal pharmacyReturnDetalisDj;

	@Column(name="PHARMACY_RETURN_DETALIS_JE")
	private BigDecimal pharmacyReturnDetalisJe;

	@Column(name="PHARMACY_RETURN_DETALIS_NUM")
	private BigDecimal pharmacyReturnDetalisNum;

	@Column(name="PHARMACY_RETURN_DETALIS_PH")
	private String pharmacyReturnDetalisPh;

	@Column(name="PHARMACY_RETURN_DETALIS_ZT")
	private String pharmacyReturnDetalisZt;

	//bi-directional many-to-one association to Drug
	@ManyToOne
	@JoinColumn(name="DRUG_ID")
	private Drug drug;

	//bi-directional many-to-one association to PharmaceReturn
	@ManyToOne
	@JoinColumn(name="PHARMACE_RETURN_ID")
	private PharmaceReturn pharmaceReturn;

	public PharmacyReturnDetali() {
	}

	public String getPharmacyReturnDetalisId() {
		return this.pharmacyReturnDetalisId;
	}

	public void setPharmacyReturnDetalisId(String pharmacyReturnDetalisId) {
		this.pharmacyReturnDetalisId = pharmacyReturnDetalisId;
	}

	public String getPharmacyReturnDetalisBz() {
		return this.pharmacyReturnDetalisBz;
	}

	public void setPharmacyReturnDetalisBz(String pharmacyReturnDetalisBz) {
		this.pharmacyReturnDetalisBz = pharmacyReturnDetalisBz;
	}

	public BigDecimal getPharmacyReturnDetalisDj() {
		return this.pharmacyReturnDetalisDj;
	}

	public void setPharmacyReturnDetalisDj(BigDecimal pharmacyReturnDetalisDj) {
		this.pharmacyReturnDetalisDj = pharmacyReturnDetalisDj;
	}

	public BigDecimal getPharmacyReturnDetalisJe() {
		return this.pharmacyReturnDetalisJe;
	}

	public void setPharmacyReturnDetalisJe(BigDecimal pharmacyReturnDetalisJe) {
		this.pharmacyReturnDetalisJe = pharmacyReturnDetalisJe;
	}

	public BigDecimal getPharmacyReturnDetalisNum() {
		return this.pharmacyReturnDetalisNum;
	}

	public void setPharmacyReturnDetalisNum(BigDecimal pharmacyReturnDetalisNum) {
		this.pharmacyReturnDetalisNum = pharmacyReturnDetalisNum;
	}

	public String getPharmacyReturnDetalisPh() {
		return this.pharmacyReturnDetalisPh;
	}

	public void setPharmacyReturnDetalisPh(String pharmacyReturnDetalisPh) {
		this.pharmacyReturnDetalisPh = pharmacyReturnDetalisPh;
	}

	public String getPharmacyReturnDetalisZt() {
		return this.pharmacyReturnDetalisZt;
	}

	public void setPharmacyReturnDetalisZt(String pharmacyReturnDetalisZt) {
		this.pharmacyReturnDetalisZt = pharmacyReturnDetalisZt;
	}

	public Drug getDrug() {
		return this.drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public PharmaceReturn getPharmaceReturn() {
		return this.pharmaceReturn;
	}

	public void setPharmaceReturn(PharmaceReturn pharmaceReturn) {
		this.pharmaceReturn = pharmaceReturn;
	}

}