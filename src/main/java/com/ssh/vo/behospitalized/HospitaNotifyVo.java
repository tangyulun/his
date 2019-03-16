package com.ssh.vo.behospitalized;

import java.math.BigDecimal;
import java.util.Date;

public class HospitaNotifyVo {
	private String hospitalNotifyNumber;

	private BigDecimal hospitalNotifyAlertTheJine;

	private BigDecimal hospitalNotifyCashFeiyong;

	private BigDecimal hospitalNotifyCashYanjin;

	private BigDecimal hospitalNotifyCost;

	private Date hospitalNotifyDate;

	private String hospitalNotifyExplain;

	private String hospitalNotifyState;

	private OutpaitentRegistVo outpaitentRegist;

	public String getHospitalNotifyNumber() {
		return hospitalNotifyNumber;
	}

	public void setHospitalNotifyNumber(String hospitalNotifyNumber) {
		this.hospitalNotifyNumber = hospitalNotifyNumber;
	}

	public BigDecimal getHospitalNotifyAlertTheJine() {
		return hospitalNotifyAlertTheJine;
	}

	public void setHospitalNotifyAlertTheJine(BigDecimal hospitalNotifyAlertTheJine) {
		this.hospitalNotifyAlertTheJine = hospitalNotifyAlertTheJine;
	}

	public BigDecimal getHospitalNotifyCashFeiyong() {
		return hospitalNotifyCashFeiyong;
	}

	public void setHospitalNotifyCashFeiyong(BigDecimal hospitalNotifyCashFeiyong) {
		this.hospitalNotifyCashFeiyong = hospitalNotifyCashFeiyong;
	}

	public BigDecimal getHospitalNotifyCashYanjin() {
		return hospitalNotifyCashYanjin;
	}

	public void setHospitalNotifyCashYanjin(BigDecimal hospitalNotifyCashYanjin) {
		this.hospitalNotifyCashYanjin = hospitalNotifyCashYanjin;
	}

	public BigDecimal getHospitalNotifyCost() {
		return hospitalNotifyCost;
	}

	public void setHospitalNotifyCost(BigDecimal hospitalNotifyCost) {
		this.hospitalNotifyCost = hospitalNotifyCost;
	}

	public Date getHospitalNotifyDate() {
		return hospitalNotifyDate;
	}

	public void setHospitalNotifyDate(Date hospitalNotifyDate) {
		this.hospitalNotifyDate = hospitalNotifyDate;
	}

	public String getHospitalNotifyExplain() {
		return hospitalNotifyExplain;
	}

	public void setHospitalNotifyExplain(String hospitalNotifyExplain) {
		this.hospitalNotifyExplain = hospitalNotifyExplain;
	}

	public String getHospitalNotifyState() {
		return hospitalNotifyState;
	}

	public void setHospitalNotifyState(String hospitalNotifyState) {
		this.hospitalNotifyState = hospitalNotifyState;
	}

	public OutpaitentRegistVo getOutpaitentRegist() {
		return outpaitentRegist;
	}

	public void setOutpaitentRegist(OutpaitentRegistVo outpaitentRegist) {
		this.outpaitentRegist = outpaitentRegist;
	}

	public HospitaNotifyVo(String hospitalNotifyNumber, BigDecimal hospitalNotifyAlertTheJine,
			BigDecimal hospitalNotifyCashFeiyong, BigDecimal hospitalNotifyCashYanjin, BigDecimal hospitalNotifyCost,
			Date hospitalNotifyDate, String hospitalNotifyExplain, String hospitalNotifyState) {
		super();
		this.hospitalNotifyNumber = hospitalNotifyNumber;
		this.hospitalNotifyAlertTheJine = hospitalNotifyAlertTheJine;
		this.hospitalNotifyCashFeiyong = hospitalNotifyCashFeiyong;
		this.hospitalNotifyCashYanjin = hospitalNotifyCashYanjin;
		this.hospitalNotifyCost = hospitalNotifyCost;
		this.hospitalNotifyDate = hospitalNotifyDate;
		this.hospitalNotifyExplain = hospitalNotifyExplain;
		this.hospitalNotifyState = hospitalNotifyState;
	}

	
	public HospitaNotifyVo(String hospitalNotifyNumber) {
		super();
		this.hospitalNotifyNumber = hospitalNotifyNumber;
	}

	public HospitaNotifyVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HospitaNotifyVo(String hospitalNotifyNumber, BigDecimal hospitalNotifyCashFeiyong,
			BigDecimal hospitalNotifyCashYanjin) {
		super();
		this.hospitalNotifyNumber = hospitalNotifyNumber;
		this.hospitalNotifyCashFeiyong = hospitalNotifyCashFeiyong;
		this.hospitalNotifyCashYanjin = hospitalNotifyCashYanjin;
	}

	
	

	
}
