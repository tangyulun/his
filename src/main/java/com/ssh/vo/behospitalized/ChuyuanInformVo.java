package com.ssh.vo.behospitalized;

import java.math.BigDecimal;
import java.util.Date;

import com.ssh.pojos.Emp;
import com.ssh.pojos.HospitalRegistration;

public class ChuyuanInformVo {
	private String chuyuanInformId;

	private Date chuyuanInformDate;

	private BigDecimal chuyuanInformFeiyongZmoney;

	private String chuyuanInformRemark;

	private String chuyuanInformState;

	private String chuyuanInformType;

	private BigDecimal chuyuanInformYajinZmoney;

	private Emp emp;

	private HospitalRegistration hospitalRegistration;

	public String getChuyuanInformId() {
		return chuyuanInformId;
	}

	public void setChuyuanInformId(String chuyuanInformId) {
		this.chuyuanInformId = chuyuanInformId;
	}

	public Date getChuyuanInformDate() {
		return chuyuanInformDate;
	}

	public void setChuyuanInformDate(Date chuyuanInformDate) {
		this.chuyuanInformDate = chuyuanInformDate;
	}

	public BigDecimal getChuyuanInformFeiyongZmoney() {
		return chuyuanInformFeiyongZmoney;
	}

	public void setChuyuanInformFeiyongZmoney(BigDecimal chuyuanInformFeiyongZmoney) {
		this.chuyuanInformFeiyongZmoney = chuyuanInformFeiyongZmoney;
	}

	public String getChuyuanInformRemark() {
		return chuyuanInformRemark;
	}

	public void setChuyuanInformRemark(String chuyuanInformRemark) {
		this.chuyuanInformRemark = chuyuanInformRemark;
	}

	public String getChuyuanInformState() {
		return chuyuanInformState;
	}

	public void setChuyuanInformState(String chuyuanInformState) {
		this.chuyuanInformState = chuyuanInformState;
	}

	public String getChuyuanInformType() {
		return chuyuanInformType;
	}

	public void setChuyuanInformType(String chuyuanInformType) {
		this.chuyuanInformType = chuyuanInformType;
	}

	public BigDecimal getChuyuanInformYajinZmoney() {
		return chuyuanInformYajinZmoney;
	}

	public void setChuyuanInformYajinZmoney(BigDecimal chuyuanInformYajinZmoney) {
		this.chuyuanInformYajinZmoney = chuyuanInformYajinZmoney;
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

	public ChuyuanInformVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChuyuanInformVo(String chuyuanInformId, Date chuyuanInformDate, BigDecimal chuyuanInformFeiyongZmoney,
			String chuyuanInformRemark, String chuyuanInformState, String chuyuanInformType,
			BigDecimal chuyuanInformYajinZmoney) {
		super();
		this.chuyuanInformId = chuyuanInformId;
		this.chuyuanInformDate = chuyuanInformDate;
		this.chuyuanInformFeiyongZmoney = chuyuanInformFeiyongZmoney;
		this.chuyuanInformRemark = chuyuanInformRemark;
		this.chuyuanInformState = chuyuanInformState;
		this.chuyuanInformType = chuyuanInformType;
		this.chuyuanInformYajinZmoney = chuyuanInformYajinZmoney;
	}

	public ChuyuanInformVo(String chuyuanInformId) {
		super();
		this.chuyuanInformId = chuyuanInformId;
	}

	public ChuyuanInformVo(String chuyuanInformId, BigDecimal chuyuanInformFeiyongZmoney,
			BigDecimal chuyuanInformYajinZmoney) {
		super();
		this.chuyuanInformId = chuyuanInformId;
		this.chuyuanInformFeiyongZmoney = chuyuanInformFeiyongZmoney;
		this.chuyuanInformYajinZmoney = chuyuanInformYajinZmoney;
	}
	
	

}
