package com.ssh.vo.drugstorage;

import java.util.Date;

import com.ssh.vo.staff.EmpVO;

public class PrescriptionVo {
	private String prescriptionId;

	private Date prescriptionDate;

	private String prescriptionType;

	private String prescriptionYzzx;

	private String prescriptionZt;
	
	private EmpVO emp;

	public String getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(String prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public Date getPrescriptionDate() {
		return prescriptionDate;
	}

	public void setPrescriptionDate(Date prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}

	public String getPrescriptionType() {
		return prescriptionType;
	}

	public void setPrescriptionType(String prescriptionType) {
		this.prescriptionType = prescriptionType;
	}

	public String getPrescriptionYzzx() {
		return prescriptionYzzx;
	}

	public void setPrescriptionYzzx(String prescriptionYzzx) {
		this.prescriptionYzzx = prescriptionYzzx;
	}

	public String getPrescriptionZt() {
		return prescriptionZt;
	}

	public void setPrescriptionZt(String prescriptionZt) {
		this.prescriptionZt = prescriptionZt;
	}

	public EmpVO getEmp() {
		return emp;
	}

	public void setEmp(EmpVO emp) {
		this.emp = emp;
	}

	public PrescriptionVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PrescriptionVo(String prescriptionId, Date prescriptionDate, String prescriptionType,
			String prescriptionYzzx, String prescriptionZt, EmpVO emp) {
		super();
		this.prescriptionId = prescriptionId;
		this.prescriptionDate = prescriptionDate;
		this.prescriptionType = prescriptionType;
		this.prescriptionYzzx = prescriptionYzzx;
		this.prescriptionZt = prescriptionZt;
		this.emp = emp;
	}

	public PrescriptionVo(String prescriptionId, Date prescriptionDate, String prescriptionType,
			String prescriptionYzzx, String prescriptionZt) {
		super();
		this.prescriptionId = prescriptionId;
		this.prescriptionDate = prescriptionDate;
		this.prescriptionType = prescriptionType;
		this.prescriptionYzzx = prescriptionYzzx;
		this.prescriptionZt = prescriptionZt;
	}
	
}
