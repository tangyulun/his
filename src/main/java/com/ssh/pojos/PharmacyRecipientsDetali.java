package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the PHARMACY_RECIPIENTS_DETALIS database table.
 * 
 */
@Entity
@Table(name="PHARMACY_RECIPIENTS_DETALIS")
@NamedQuery(name="PharmacyRecipientsDetali.findAll", query="SELECT p FROM PharmacyRecipientsDetali p")
public class PharmacyRecipientsDetali implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PHARMACY_RECIPIENTS_DETALIS_ID")
	private String pharmacyRecipientsDetalisId;

	@Column(name="PHARMACY_NUM")
	private BigDecimal pharmacyNum;

	@Column(name="PHARMACY_RECIPIENTS_DETALIS_PH")
	private String pharmacyRecipientsDetalisPh;

	@Column(name="PHARMACY_RICIPIENTS_DETALIS_BZ")
	private String pharmacyRicipientsDetalisBz;

	//bi-directional many-to-one association to Drug
	@ManyToOne
	@JoinColumn(name="DRUG_ID")
	private Drug drug;

	//bi-directional many-to-one association to PharmacyRecipient
	@ManyToOne
	@JoinColumn(name="PHARMACY_RECIPIENTS_ID")
	private PharmacyRecipient pharmacyRecipient;

	public PharmacyRecipientsDetali() {
	}

	public String getPharmacyRecipientsDetalisId() {
		return this.pharmacyRecipientsDetalisId;
	}

	public void setPharmacyRecipientsDetalisId(String pharmacyRecipientsDetalisId) {
		this.pharmacyRecipientsDetalisId = pharmacyRecipientsDetalisId;
	}

	public BigDecimal getPharmacyNum() {
		return this.pharmacyNum;
	}

	public void setPharmacyNum(BigDecimal pharmacyNum) {
		this.pharmacyNum = pharmacyNum;
	}

	public String getPharmacyRecipientsDetalisPh() {
		return this.pharmacyRecipientsDetalisPh;
	}

	public void setPharmacyRecipientsDetalisPh(String pharmacyRecipientsDetalisPh) {
		this.pharmacyRecipientsDetalisPh = pharmacyRecipientsDetalisPh;
	}

	public String getPharmacyRicipientsDetalisBz() {
		return this.pharmacyRicipientsDetalisBz;
	}

	public void setPharmacyRicipientsDetalisBz(String pharmacyRicipientsDetalisBz) {
		this.pharmacyRicipientsDetalisBz = pharmacyRicipientsDetalisBz;
	}

	public Drug getDrug() {
		return this.drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public PharmacyRecipient getPharmacyRecipient() {
		return this.pharmacyRecipient;
	}

	public void setPharmacyRecipient(PharmacyRecipient pharmacyRecipient) {
		this.pharmacyRecipient = pharmacyRecipient;
	}

}