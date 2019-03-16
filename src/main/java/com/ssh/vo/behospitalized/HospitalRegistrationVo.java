package com.ssh.vo.behospitalized;

import java.util.Date;

import com.ssh.pojos.Bed;
import com.ssh.pojos.Emp;
import com.ssh.pojos.HospitaNotify;

public class HospitalRegistrationVo {

	private String hospitalRegistrationId;

	private Date hospitalRegistrationDate;

	private String hospitalRegistrationState;

	private BedVo bed;

	private EmpVo emp;

	private HospitaNotifyVo hospitaNotify;

	
	public String getHospitalRegistrationId() {
		return hospitalRegistrationId;
	}

	public void setHospitalRegistrationId(String hospitalRegistrationId) {
		this.hospitalRegistrationId = hospitalRegistrationId;
	}

	public Date getHospitalRegistrationDate() {
		return hospitalRegistrationDate;
	}

	public void setHospitalRegistrationDate(Date hospitalRegistrationDate) {
		this.hospitalRegistrationDate = hospitalRegistrationDate;
	}

	public String getHospitalRegistrationState() {
		return hospitalRegistrationState;
	}

	public void setHospitalRegistrationState(String hospitalRegistrationState) {
		this.hospitalRegistrationState = hospitalRegistrationState;
	}

	public BedVo getBed() {
		return bed;
	}

	public void setBed(BedVo bed) {
		this.bed = bed;
	}

	public EmpVo getEmp() {
		return emp;
	}

	public void setEmp(EmpVo emp) {
		this.emp = emp;
	}

	public HospitaNotifyVo getHospitaNotify() {
		return hospitaNotify;
	}

	public void setHospitaNotify(HospitaNotifyVo hospitaNotify) {
		this.hospitaNotify = hospitaNotify;
	}

	public HospitalRegistrationVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HospitalRegistrationVo(String hospitalRegistrationId, Date hospitalRegistrationDate,
			String hospitalRegistrationState) {
		super();
		this.hospitalRegistrationId = hospitalRegistrationId;
		this.hospitalRegistrationDate = hospitalRegistrationDate;
		this.hospitalRegistrationState = hospitalRegistrationState;
	}

	public HospitalRegistrationVo(String hospitalRegistrationId) {
		super();
		this.hospitalRegistrationId = hospitalRegistrationId;
	}
	
	
}
