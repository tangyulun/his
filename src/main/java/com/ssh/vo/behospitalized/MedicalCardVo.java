package com.ssh.vo.behospitalized;

import java.math.BigDecimal;
import java.util.Date;

public class MedicalCardVo {

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

	public MedicalCardVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MedicalCardVo(String medicalCardCardId, BigDecimal empId, String medicalCardAge,
			String medicalCardBingzhuang, Date medicalCardDate, String medicalCardHunyanzk, String medicalCardIdencard,
			String medicalCardName, String medicalCardSex) {
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

	public MedicalCardVo(String medicalCardName) {
		super();
		this.medicalCardName = medicalCardName;
	}

	public MedicalCardVo(String medicalCardCardId, String medicalCardName) {
		super();
		this.medicalCardCardId = medicalCardCardId;
		this.medicalCardName = medicalCardName;
	}

	public MedicalCardVo(String medicalCardCardId,String medicalCardName, String medicalCardAge, 
			String medicalCardSex) {
		super();
		this.medicalCardCardId = medicalCardCardId;
		this.medicalCardName = medicalCardName;
		this.medicalCardAge = medicalCardAge;
		this.medicalCardSex = medicalCardSex;
	}
	
	
	
}
