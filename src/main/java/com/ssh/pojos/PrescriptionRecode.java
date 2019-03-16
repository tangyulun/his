package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PRESCRIPTION_RECODE database table.
 * 
 */
@Entity
@Table(name="PRESCRIPTION_RECODE")
@NamedQuery(name="PrescriptionRecode.findAll", query="SELECT p FROM PrescriptionRecode p")
public class PrescriptionRecode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PRESCRIPTION_RECODE_ID")
	private String prescriptionRecodeId;

	@Column(name="PRESCRIPTION_ID")
	private String prescriptionId;

	@Column(name="PRESCRIPTION_RECODE_DRUG_TYPE")
	private String prescriptionRecodeDrugType;

	@Column(name="PRESCRIPTION_RECODE_EXPLAIN")
	private String prescriptionRecodeExplain;

	@Column(name="PRESCRIPTION_RECODE_MONEY")
	private BigDecimal prescriptionRecodeMoney;

	@Column(name="PRESCRIPTION_RECODE_NUM")
	private BigDecimal prescriptionRecodeNum;

	@Column(name="PRESCRIPTION_RECODE_PRICE")
	private BigDecimal prescriptionRecodePrice;

	@Temporal(TemporalType.DATE)
	@Column(name="PRESCRIPTION_RECODE_RQ")
	private Date prescriptionRecodeRq;

	@Column(name="PRESCRIPTION_RECODE_SJ")
	private String prescriptionRecodeSj;

	@Column(name="PRESCRIPTION_RECODE_TYPE")
	private String prescriptionRecodeType;

	@Column(name="PRESCRIPTION_RECODE_ZT")
	private String prescriptionRecodeZt;

	//bi-directional many-to-one association to Drug
	@ManyToOne
	@JoinColumn(name="DRUG_ID")
	private Drug drug;

	public PrescriptionRecode() {
	}

	public String getPrescriptionRecodeId() {
		return this.prescriptionRecodeId;
	}

	public void setPrescriptionRecodeId(String prescriptionRecodeId) {
		this.prescriptionRecodeId = prescriptionRecodeId;
	}

	public String getPrescriptionId() {
		return this.prescriptionId;
	}

	public void setPrescriptionId(String prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public String getPrescriptionRecodeDrugType() {
		return this.prescriptionRecodeDrugType;
	}

	public void setPrescriptionRecodeDrugType(String prescriptionRecodeDrugType) {
		this.prescriptionRecodeDrugType = prescriptionRecodeDrugType;
	}

	public String getPrescriptionRecodeExplain() {
		return this.prescriptionRecodeExplain;
	}

	public void setPrescriptionRecodeExplain(String prescriptionRecodeExplain) {
		this.prescriptionRecodeExplain = prescriptionRecodeExplain;
	}

	public BigDecimal getPrescriptionRecodeMoney() {
		return this.prescriptionRecodeMoney;
	}

	public void setPrescriptionRecodeMoney(BigDecimal prescriptionRecodeMoney) {
		this.prescriptionRecodeMoney = prescriptionRecodeMoney;
	}

	public BigDecimal getPrescriptionRecodeNum() {
		return this.prescriptionRecodeNum;
	}

	public void setPrescriptionRecodeNum(BigDecimal prescriptionRecodeNum) {
		this.prescriptionRecodeNum = prescriptionRecodeNum;
	}

	public BigDecimal getPrescriptionRecodePrice() {
		return this.prescriptionRecodePrice;
	}

	public void setPrescriptionRecodePrice(BigDecimal prescriptionRecodePrice) {
		this.prescriptionRecodePrice = prescriptionRecodePrice;
	}

	public Date getPrescriptionRecodeRq() {
		return this.prescriptionRecodeRq;
	}

	public void setPrescriptionRecodeRq(Date prescriptionRecodeRq) {
		this.prescriptionRecodeRq = prescriptionRecodeRq;
	}

	public String getPrescriptionRecodeSj() {
		return this.prescriptionRecodeSj;
	}

	public void setPrescriptionRecodeSj(String prescriptionRecodeSj) {
		this.prescriptionRecodeSj = prescriptionRecodeSj;
	}

	public String getPrescriptionRecodeType() {
		return this.prescriptionRecodeType;
	}

	public void setPrescriptionRecodeType(String prescriptionRecodeType) {
		this.prescriptionRecodeType = prescriptionRecodeType;
	}

	public String getPrescriptionRecodeZt() {
		return this.prescriptionRecodeZt;
	}

	public void setPrescriptionRecodeZt(String prescriptionRecodeZt) {
		this.prescriptionRecodeZt = prescriptionRecodeZt;
	}

	public Drug getDrug() {
		return this.drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

}