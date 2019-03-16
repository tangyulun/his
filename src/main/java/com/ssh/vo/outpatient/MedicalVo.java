package com.ssh.vo.outpatient;

import java.math.BigDecimal;
import java.util.Date;

public class MedicalVo {
	private String medicalCardCardId;

	private BigDecimal empId;

	private String medicalCardAge;
	
	private String medicalCardBingzhuang;

	private Date medicalCardDate;

	private String medicalCardHunyanzk;

	private String medicalCardIdencard;

	private String medicalCardName;

	private String medicalCardSex;

	public String getMedicalCardCardId() {
		return medicalCardCardId;
	}

	public void setMedicalCardCardId(String medicalCardCardId) {
		this.medicalCardCardId = medicalCardCardId;
	}

	public BigDecimal getEmpId() {
		return empId;
	}

	public void setEmpId(BigDecimal empId) {
		this.empId = empId;
	}

	public String getMedicalCardAge() {
		return medicalCardAge;
	}

	public void setMedicalCardAge(String medicalCardAge) {
		this.medicalCardAge = medicalCardAge;
	}

	public String getMedicalCardBingzhuang() {
		return medicalCardBingzhuang;
	}

	public void setMedicalCardBingzhuang(String medicalCardBingzhuang) {
		this.medicalCardBingzhuang = medicalCardBingzhuang;
	}

	public Date getMedicalCardDate() {
		return medicalCardDate;
	}

	public void setMedicalCardDate(Date medicalCardDate) {
		this.medicalCardDate = medicalCardDate;
	}

	public String getMedicalCardHunyanzk() {
		return medicalCardHunyanzk;
	}

	public void setMedicalCardHunyanzk(String medicalCardHunyanzk) {
		this.medicalCardHunyanzk = medicalCardHunyanzk;
	}

	public String getMedicalCardIdencard() {
		return medicalCardIdencard;
	}

	public void setMedicalCardIdencard(String medicalCardIdencard) {
		this.medicalCardIdencard = medicalCardIdencard;
	}

	public String getMedicalCardName() {
		return medicalCardName;
	}

	public void setMedicalCardName(String medicalCardName) {
		this.medicalCardName = medicalCardName;
	}

	public String getMedicalCardSex() {
		return medicalCardSex;
	}

	public void setMedicalCardSex(String medicalCardSex) {
		this.medicalCardSex = medicalCardSex;
	}

	public MedicalVo(String medicalCardCardId, BigDecimal empId, String medicalCardAge, String medicalCardBingzhuang,
			Date medicalCardDate, String medicalCardHunyanzk, String medicalCardIdencard, String medicalCardName,
			String medicalCardSex) {
		super();
		this.medicalCardCardId = medicalCardCardId;
		this.empId = empId;
		this.medicalCardAge = medicalCardAge;
		this.medicalCardBingzhuang = medicalCardBingzhuang;
		this.medicalCardDate = medicalCardDate;
		this.medicalCardHunyanzk = medicalCardHunyanzk;
		this.medicalCardIdencard = medicalCardIdencard;
		this.medicalCardName = medicalCardName;
		this.medicalCardSex = medicalCardSex;
	}

	public MedicalVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MedicalVo(String medicalCardCardId, String medicalCardName) {
		super();
		this.medicalCardCardId = medicalCardCardId;
		this.medicalCardName = medicalCardName;
	}
	
	public MedicalVo(String medicalCardCardId, String medicalCardAge, String medicalCardBingzhuang,
			Date medicalCardDate, String medicalCardHunyanzk, String medicalCardIdencard, String medicalCardName,
			String medicalCardSex) {
		super();
		this.medicalCardCardId = medicalCardCardId;
		this.medicalCardAge = medicalCardAge;
		this.medicalCardBingzhuang = medicalCardBingzhuang;
		this.medicalCardDate = medicalCardDate;
		this.medicalCardHunyanzk = medicalCardHunyanzk;
		this.medicalCardIdencard = medicalCardIdencard;
		this.medicalCardName = medicalCardName;
		this.medicalCardSex = medicalCardSex;
	}

	@Override
	public String toString() {
		return "MedicalVo [medicalCardCardId=" + medicalCardCardId + ", empId=" + empId + ", medicalCardAge="
				+ medicalCardAge + ", medicalCardBingzhuang=" + medicalCardBingzhuang + ", medicalCardDate="
				+ medicalCardDate + ", medicalCardHunyanzk=" + medicalCardHunyanzk + ", medicalCardIdencard="
				+ medicalCardIdencard + ", medicalCardName=" + medicalCardName + ", medicalCardSex=" + medicalCardSex
				+ "]";
	}
	
}
