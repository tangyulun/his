package com.ssh.vo.doctor;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;

/**
 * 处方开药vo
 * @author Administrator
 *
 */
public class EletronicPrescriVo {

	private String id;
	private String prescriptionRecodeId;
	private String drugBname;
	private String prescriptionRecodeDrugType;

	private String prescriptionRecodeExplain;

	private BigDecimal prescriptionRecodeMoney;

	private BigDecimal prescriptionRecodeNum;

	private BigDecimal prescriptionRecodePrice;

	private String prescriptionRecodeType;

	private String prescriptionRecodeZt;
	
	private Date date;
	private String time;
	
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrescriptionRecodeId() {
		return prescriptionRecodeId;
	}

	public void setPrescriptionRecodeId(String prescriptionRecodeId) {
		this.prescriptionRecodeId = prescriptionRecodeId;
	}

	public String getDrugBname() {
		return drugBname;
	}

	public void setDrugBname(String drugBname) {
		this.drugBname = drugBname;
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

	public EletronicPrescriVo(String id, String prescriptionRecodeId, String drugBname, String prescriptionRecodeDrugType,
			String prescriptionRecodeExplain, BigDecimal prescriptionRecodeMoney, BigDecimal prescriptionRecodeNum,
			BigDecimal prescriptionRecodePrice, String prescriptionRecodeType, String prescriptionRecodeZt, Date date,
			String time) {
		super();
		this.id = id;
		this.prescriptionRecodeId = prescriptionRecodeId;
		this.drugBname = drugBname;
		this.prescriptionRecodeDrugType = prescriptionRecodeDrugType;
		this.prescriptionRecodeExplain = prescriptionRecodeExplain;
		this.prescriptionRecodeMoney = prescriptionRecodeMoney;
		this.prescriptionRecodeNum = prescriptionRecodeNum;
		this.prescriptionRecodePrice = prescriptionRecodePrice;
		this.prescriptionRecodeType = prescriptionRecodeType;
		this.prescriptionRecodeZt = prescriptionRecodeZt;
		this.date = date;
		this.time = time;
	}

	
	public EletronicPrescriVo(String prescriptionRecodeId, String drugBname, String prescriptionRecodeDrugType,
			String prescriptionRecodeExplain, BigDecimal prescriptionRecodeMoney, BigDecimal prescriptionRecodeNum,
			BigDecimal prescriptionRecodePrice, String prescriptionRecodeZt) {
		super();
		this.prescriptionRecodeId = prescriptionRecodeId;
		this.drugBname = drugBname;
		this.prescriptionRecodeDrugType = prescriptionRecodeDrugType;
		this.prescriptionRecodeExplain = prescriptionRecodeExplain;
		this.prescriptionRecodeMoney = prescriptionRecodeMoney;
		this.prescriptionRecodeNum = prescriptionRecodeNum;
		this.prescriptionRecodePrice = prescriptionRecodePrice;
		this.prescriptionRecodeZt = prescriptionRecodeZt;
	}

	public EletronicPrescriVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
