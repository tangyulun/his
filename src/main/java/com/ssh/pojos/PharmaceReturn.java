package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PHARMACE_RETURN database table.
 * 
 */
@Entity
@Table(name="PHARMACE_RETURN")
@NamedQuery(name="PharmaceReturn.findAll", query="SELECT p FROM PharmaceReturn p")
public class PharmaceReturn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PHARMACE_RETURN_ID")
	private String pharmaceReturnId;

	@Column(name="PHARMACE_RETURN_BRNAME")
	private String pharmaceReturnBrname;

	@Temporal(TemporalType.DATE)
	@Column(name="PHARMACE_RETURN_TYDATE")
	private Date pharmaceReturnTydate;

	@Column(name="PHARMACE_RETURN_YF")
	private String pharmaceReturnYf;

	@Column(name="PHARMACE_RETURN_ZT")
	private String pharmaceReturnZt;

	@Column(name="PHARMACY_RETURN_TKJE")
	private BigDecimal pharmacyReturnTkje;

	//bi-directional many-to-one association to OutpaitentRegist
	@ManyToOne
	@JoinColumn(name="OUTPAITENT_REGIST_ID")
	private OutpaitentRegist outpaitentRegist;

	//bi-directional many-to-one association to Prescription
	@ManyToOne
	@JoinColumn(name="PRESCRIPTION_ID")
	private Prescription prescription;

	//bi-directional many-to-one association to PharmacyReturnDetali
	@OneToMany(mappedBy="pharmaceReturn")
	private List<PharmacyReturnDetali> pharmacyReturnDetalis;

	public PharmaceReturn() {
	}

	public String getPharmaceReturnId() {
		return this.pharmaceReturnId;
	}

	public void setPharmaceReturnId(String pharmaceReturnId) {
		this.pharmaceReturnId = pharmaceReturnId;
	}

	public String getPharmaceReturnBrname() {
		return this.pharmaceReturnBrname;
	}

	public void setPharmaceReturnBrname(String pharmaceReturnBrname) {
		this.pharmaceReturnBrname = pharmaceReturnBrname;
	}

	public Date getPharmaceReturnTydate() {
		return this.pharmaceReturnTydate;
	}

	public void setPharmaceReturnTydate(Date pharmaceReturnTydate) {
		this.pharmaceReturnTydate = pharmaceReturnTydate;
	}

	public String getPharmaceReturnYf() {
		return this.pharmaceReturnYf;
	}

	public void setPharmaceReturnYf(String pharmaceReturnYf) {
		this.pharmaceReturnYf = pharmaceReturnYf;
	}

	public String getPharmaceReturnZt() {
		return this.pharmaceReturnZt;
	}

	public void setPharmaceReturnZt(String pharmaceReturnZt) {
		this.pharmaceReturnZt = pharmaceReturnZt;
	}

	public BigDecimal getPharmacyReturnTkje() {
		return this.pharmacyReturnTkje;
	}

	public void setPharmacyReturnTkje(BigDecimal pharmacyReturnTkje) {
		this.pharmacyReturnTkje = pharmacyReturnTkje;
	}

	public OutpaitentRegist getOutpaitentRegist() {
		return this.outpaitentRegist;
	}

	public void setOutpaitentRegist(OutpaitentRegist outpaitentRegist) {
		this.outpaitentRegist = outpaitentRegist;
	}

	public Prescription getPrescription() {
		return this.prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	public List<PharmacyReturnDetali> getPharmacyReturnDetalis() {
		return this.pharmacyReturnDetalis;
	}

	public void setPharmacyReturnDetalis(List<PharmacyReturnDetali> pharmacyReturnDetalis) {
		this.pharmacyReturnDetalis = pharmacyReturnDetalis;
	}

	public PharmacyReturnDetali addPharmacyReturnDetali(PharmacyReturnDetali pharmacyReturnDetali) {
		getPharmacyReturnDetalis().add(pharmacyReturnDetali);
		pharmacyReturnDetali.setPharmaceReturn(this);

		return pharmacyReturnDetali;
	}

	public PharmacyReturnDetali removePharmacyReturnDetali(PharmacyReturnDetali pharmacyReturnDetali) {
		getPharmacyReturnDetalis().remove(pharmacyReturnDetali);
		pharmacyReturnDetali.setPharmaceReturn(null);

		return pharmacyReturnDetali;
	}

}