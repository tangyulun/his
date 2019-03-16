package com.ssh.vo.nurse;

import java.math.BigDecimal;
import java.util.Date;

import com.ssh.pojos.Drug;
import com.ssh.vo.drugstorage.DrugVo;

public class PrescriptionRecodeVo {

	private String prescriptionRecodeId;

	private String prescriptionId;

	private String prescriptionRecodeDrugType;

	private String prescriptionRecodeExplain;

	private BigDecimal prescriptionRecodeMoney;

	private BigDecimal prescriptionRecodeNum;

	private BigDecimal prescriptionRecodePrice;

	private Date prescriptionRecodeRq;

	private String prescriptionRecodeSj;

	private String prescriptionRecodeType;

	private String prescriptionRecodeZt;

	private DrugVo drug;

	public String getPrescriptionRecodeId() {
		return prescriptionRecodeId;
	}

	public void setPrescriptionRecodeId(String prescriptionRecodeId) {
		this.prescriptionRecodeId = prescriptionRecodeId;
	}

	public String getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(String prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public String getPrescriptionRecodeDrugType() {
		return prescriptionRecodeDrugType;
	}

	public void setPrescriptionRecodeDrugType(String prescriptionRecodeDrugType) {
		this.prescriptionRecodeDrugType = prescriptionRecodeDrugType;
	}

	public String getPrescriptionRecodeExplain() {
		return prescriptionRecodeExplain;
	}

	public void setPrescriptionRecodeExplain(String prescriptionRecodeExplain) {
		this.prescriptionRecodeExplain = prescriptionRecodeExplain;
	}

	public BigDecimal getPrescriptionRecodeMoney() {
		return prescriptionRecodeMoney;
	}

	public void setPrescriptionRecodeMoney(BigDecimal prescriptionRecodeMoney) {
		this.prescriptionRecodeMoney = prescriptionRecodeMoney;
	}

	public BigDecimal getPrescriptionRecodeNum() {
		return prescriptionRecodeNum;
	}

	public void setPrescriptionRecodeNum(BigDecimal prescriptionRecodeNum) {
		this.prescriptionRecodeNum = prescriptionRecodeNum;
	}

	public BigDecimal getPrescriptionRecodePrice() {
		return prescriptionRecodePrice;
	}

	public void setPrescriptionRecodePrice(BigDecimal prescriptionRecodePrice) {
		this.prescriptionRecodePrice = prescriptionRecodePrice;
	}

	public Date getPrescriptionRecodeRq() {
		return prescriptionRecodeRq;
	}

	public void setPrescriptionRecodeRq(Date prescriptionRecodeRq) {
		this.prescriptionRecodeRq = prescriptionRecodeRq;
	}

	public String getPrescriptionRecodeSj() {
		return prescriptionRecodeSj;
	}

	public void setPrescriptionRecodeSj(String prescriptionRecodeSj) {
		this.prescriptionRecodeSj = prescriptionRecodeSj;
	}

	public String getPrescriptionRecodeType() {
		return prescriptionRecodeType;
	}

	public void setPrescriptionRecodeType(String prescriptionRecodeType) {
		this.prescriptionRecodeType = prescriptionRecodeType;
	}

	public String getPrescriptionRecodeZt() {
		return prescriptionRecodeZt;
	}

	public void setPrescriptionRecodeZt(String prescriptionRecodeZt) {
		this.prescriptionRecodeZt = prescriptionRecodeZt;
	}

	public DrugVo getDrugVo() {
		return drug;
	}

	public void setDrug(DrugVo drug) {
		this.drug = drug;
	}

	public PrescriptionRecodeVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PrescriptionRecodeVo(String prescriptionRecodeId, String prescriptionId, String prescriptionRecodeDrugType,
			String prescriptionRecodeExplain, BigDecimal prescriptionRecodeMoney, BigDecimal prescriptionRecodeNum,
			BigDecimal prescriptionRecodePrice, Date prescriptionRecodeRq, String prescriptionRecodeSj,
			String prescriptionRecodeType, String prescriptionRecodeZt) {
		super();
		this.prescriptionRecodeId = prescriptionRecodeId;
		this.prescriptionId = prescriptionId;
		this.prescriptionRecodeDrugType = prescriptionRecodeDrugType;
		this.prescriptionRecodeExplain = prescriptionRecodeExplain;
		this.prescriptionRecodeMoney = prescriptionRecodeMoney;
		this.prescriptionRecodeNum = prescriptionRecodeNum;
		this.prescriptionRecodePrice = prescriptionRecodePrice;
		this.prescriptionRecodeRq = prescriptionRecodeRq;
		this.prescriptionRecodeSj = prescriptionRecodeSj;
		this.prescriptionRecodeType = prescriptionRecodeType;
		this.prescriptionRecodeZt = prescriptionRecodeZt;
	}
	
	
}
