package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the MEDICAL_CARD database table.
 * 
 */
@Entity
@Table(name="MEDICAL_CARD")
@NamedQuery(name="MedicalCard.findAll", query="SELECT m FROM MedicalCard m")
public class MedicalCard implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MEDICAL_CARD_CARD_ID")
	private String medicalCardCardId;

	@Column(name="EMP_ID")
	private BigDecimal empId;

	@Column(name="MEDICAL_CARD_AGE")
	private String medicalCardAge;

	@Column(name="MEDICAL_CARD_BINGZHUANG")
	private String medicalCardBingzhuang;

	@Temporal(TemporalType.DATE)
	@Column(name="MEDICAL_CARD_DATE")
	private Date medicalCardDate;

	@Column(name="MEDICAL_CARD_HUNYANZK")
	private String medicalCardHunyanzk;

	@Column(name="MEDICAL_CARD_IDENCARD")
	private String medicalCardIdencard;

	@Column(name="MEDICAL_CARD_NAME")
	private String medicalCardName;

	@Column(name="MEDICAL_CARD_SEX")
	private String medicalCardSex;

	//bi-directional many-to-one association to OutpaitentRegist
	@OneToMany(mappedBy="medicalCard")
	private List<OutpaitentRegist> outpaitentRegists;

	public MedicalCard() {
	}

	public String getMedicalCardCardId() {
		return this.medicalCardCardId;
	}

	public void setMedicalCardCardId(String medicalCardCardId) {
		this.medicalCardCardId = medicalCardCardId;
	}

	public BigDecimal getEmpId() {
		return this.empId;
	}

	public void setEmpId(BigDecimal empId) {
		this.empId = empId;
	}

	public String getMedicalCardAge() {
		return this.medicalCardAge;
	}

	public void setMedicalCardAge(String medicalCardAge) {
		this.medicalCardAge = medicalCardAge;
	}

	public String getMedicalCardBingzhuang() {
		return this.medicalCardBingzhuang;
	}

	public void setMedicalCardBingzhuang(String medicalCardBingzhuang) {
		this.medicalCardBingzhuang = medicalCardBingzhuang;
	}

	public Date getMedicalCardDate() {
		return this.medicalCardDate;
	}

	public void setMedicalCardDate(Date medicalCardDate) {
		this.medicalCardDate = medicalCardDate;
	}

	public String getMedicalCardHunyanzk() {
		return this.medicalCardHunyanzk;
	}

	public void setMedicalCardHunyanzk(String medicalCardHunyanzk) {
		this.medicalCardHunyanzk = medicalCardHunyanzk;
	}

	public String getMedicalCardIdencard() {
		return this.medicalCardIdencard;
	}

	public void setMedicalCardIdencard(String medicalCardIdencard) {
		this.medicalCardIdencard = medicalCardIdencard;
	}

	public String getMedicalCardName() {
		return this.medicalCardName;
	}

	public void setMedicalCardName(String medicalCardName) {
		this.medicalCardName = medicalCardName;
	}

	public String getMedicalCardSex() {
		return this.medicalCardSex;
	}

	public void setMedicalCardSex(String medicalCardSex) {
		this.medicalCardSex = medicalCardSex;
	}

	public List<OutpaitentRegist> getOutpaitentRegists() {
		return this.outpaitentRegists;
	}

	public void setOutpaitentRegists(List<OutpaitentRegist> outpaitentRegists) {
		this.outpaitentRegists = outpaitentRegists;
	}

	public OutpaitentRegist addOutpaitentRegist(OutpaitentRegist outpaitentRegist) {
		getOutpaitentRegists().add(outpaitentRegist);
		outpaitentRegist.setMedicalCard(this);

		return outpaitentRegist;
	}

	public OutpaitentRegist removeOutpaitentRegist(OutpaitentRegist outpaitentRegist) {
		getOutpaitentRegists().remove(outpaitentRegist);
		outpaitentRegist.setMedicalCard(null);

		return outpaitentRegist;
	}

}