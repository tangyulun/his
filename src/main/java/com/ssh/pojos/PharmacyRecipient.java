package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PHARMACY_RECIPIENTS database table.
 * 
 */
@Entity
@Table(name="PHARMACY_RECIPIENTS")
@NamedQuery(name="PharmacyRecipient.findAll", query="SELECT p FROM PharmacyRecipient p")
public class PharmacyRecipient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PHARMACY_RECIPIENTS_ID")
	private String pharmacyRecipientsId;

	@Column(name="PHARMACY_RECIPIENTS_DUIXIANG")
	private String pharmacyRecipientsDuixiang;

	@Column(name="PHARMACY_RECIPIENTS_DX")
	private String pharmacyRecipientsDx;

	@Temporal(TemporalType.DATE)
	@Column(name="PHARMACY_RECIPIENTS_LYDATE")
	private Date pharmacyRecipientsLydate;

	@Column(name="PHARMACY_RECIPIENTS_YF")
	private String pharmacyRecipientsYf;

	@Column(name="PHARMACY_RECIPIENTS_ZT")
	private String pharmacyRecipientsZt;

	//bi-directional many-to-one association to PharmacyRecipientsDetali
	@OneToMany(mappedBy="pharmacyRecipient")
	private List<PharmacyRecipientsDetali> pharmacyRecipientsDetalis;

	public PharmacyRecipient() {
	}

	public String getPharmacyRecipientsId() {
		return this.pharmacyRecipientsId;
	}

	public void setPharmacyRecipientsId(String pharmacyRecipientsId) {
		this.pharmacyRecipientsId = pharmacyRecipientsId;
	}

	public String getPharmacyRecipientsDuixiang() {
		return this.pharmacyRecipientsDuixiang;
	}

	public void setPharmacyRecipientsDuixiang(String pharmacyRecipientsDuixiang) {
		this.pharmacyRecipientsDuixiang = pharmacyRecipientsDuixiang;
	}

	public String getPharmacyRecipientsDx() {
		return this.pharmacyRecipientsDx;
	}

	public void setPharmacyRecipientsDx(String pharmacyRecipientsDx) {
		this.pharmacyRecipientsDx = pharmacyRecipientsDx;
	}

	public Date getPharmacyRecipientsLydate() {
		return this.pharmacyRecipientsLydate;
	}

	public void setPharmacyRecipientsLydate(Date pharmacyRecipientsLydate) {
		this.pharmacyRecipientsLydate = pharmacyRecipientsLydate;
	}

	public String getPharmacyRecipientsYf() {
		return this.pharmacyRecipientsYf;
	}

	public void setPharmacyRecipientsYf(String pharmacyRecipientsYf) {
		this.pharmacyRecipientsYf = pharmacyRecipientsYf;
	}

	public String getPharmacyRecipientsZt() {
		return this.pharmacyRecipientsZt;
	}

	public void setPharmacyRecipientsZt(String pharmacyRecipientsZt) {
		this.pharmacyRecipientsZt = pharmacyRecipientsZt;
	}

	public List<PharmacyRecipientsDetali> getPharmacyRecipientsDetalis() {
		return this.pharmacyRecipientsDetalis;
	}

	public void setPharmacyRecipientsDetalis(List<PharmacyRecipientsDetali> pharmacyRecipientsDetalis) {
		this.pharmacyRecipientsDetalis = pharmacyRecipientsDetalis;
	}

	public PharmacyRecipientsDetali addPharmacyRecipientsDetali(PharmacyRecipientsDetali pharmacyRecipientsDetali) {
		getPharmacyRecipientsDetalis().add(pharmacyRecipientsDetali);
		pharmacyRecipientsDetali.setPharmacyRecipient(this);

		return pharmacyRecipientsDetali;
	}

	public PharmacyRecipientsDetali removePharmacyRecipientsDetali(PharmacyRecipientsDetali pharmacyRecipientsDetali) {
		getPharmacyRecipientsDetalis().remove(pharmacyRecipientsDetali);
		pharmacyRecipientsDetali.setPharmacyRecipient(null);

		return pharmacyRecipientsDetali;
	}

}