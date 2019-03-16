package com.ssh.vo.nurse;

import java.util.Date;

import com.ssh.pojos.Emp;
import com.ssh.pojos.HospitalRegistration;
import com.ssh.pojos.OutpaitentRegist;
import com.ssh.pojos.Prescription;

public class PrescriptionVo {
	private String prescriptionId;

	private Date prescriptionDate;

	private String prescriptionType;

	private String prescriptionYzzx;

	private String prescriptionZt;

	private Emp emp;

	private HospitalRegistration hospitalRegistration;

	private OutpaitentRegist outpaitentRegist;

	private Prescription prescription;

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

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public HospitalRegistration getHospitalRegistration() {
		return hospitalRegistration;
	}

	public void setHospitalRegistration(HospitalRegistration hospitalRegistration) {
		this.hospitalRegistration = hospitalRegistration;
	}

	public OutpaitentRegist getOutpaitentRegist() {
		return outpaitentRegist;
	}

	public void setOutpaitentRegist(OutpaitentRegist outpaitentRegist) {
		this.outpaitentRegist = outpaitentRegist;
	}

	public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	public PrescriptionVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PrescriptionVo(String prescriptionId, Date prescriptionDate, String prescriptionType,
			String prescriptionYzzx, String prescriptionZt, Emp emp, HospitalRegistration hospitalRegistration,
			OutpaitentRegist outpaitentRegist, Prescription prescription) {
		super();
		this.prescriptionId = prescriptionId;
		this.prescriptionDate = prescriptionDate;
		this.prescriptionType = prescriptionType;
		this.prescriptionYzzx = prescriptionYzzx;
		this.prescriptionZt = prescriptionZt;
		this.emp = emp;
		this.hospitalRegistration = hospitalRegistration;
		this.outpaitentRegist = outpaitentRegist;
		this.prescription = prescription;
	}

	public PrescriptionVo(String prescriptionId) {
		super();
		this.prescriptionId = prescriptionId;
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
