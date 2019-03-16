package com.ssh.vo.operation;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ssh.pojos.Dclass;
import com.ssh.pojos.Emp;
import com.ssh.pojos.HospitalRegistration;

public class ShouShuMessVo {
	private String shoushuMess;

	private Date shoushuMessDate;

	private BigDecimal shoushuMessMoney;

	private String shoushuMessState;

	private String shoushuMessType;

	private EmpsVo emp;
	
	private DclasssVo dlcass;

	private HotregistionVo hospitalRegistration;
	
	private ShouShuVo shoushu;

	public String getShoushuMess() {
		return shoushuMess;
	}

	public void setShoushuMess(String shoushuMess) {
		this.shoushuMess = shoushuMess;
	}

	public Date getShoushuMessDate() {
		return shoushuMessDate;
	}

	public void setShoushuMessDate(Date shoushuMessDate) {
		this.shoushuMessDate = shoushuMessDate;
	}

	public BigDecimal getShoushuMessMoney() {
		return shoushuMessMoney;
	}

	public void setShoushuMessMoney(BigDecimal shoushuMessMoney) {
		this.shoushuMessMoney = shoushuMessMoney;
	}

	public String getShoushuMessState() {
		return shoushuMessState;
	}

	public void setShoushuMessState(String shoushuMessState) {
		this.shoushuMessState = shoushuMessState;
	}

	public String getShoushuMessType() {
		return shoushuMessType;
	}

	public void setShoushuMessType(String shoushuMessType) {
		this.shoushuMessType = shoushuMessType;
	}

	public EmpsVo getEmp() {
		return emp;
	}

	public void setEmp(EmpsVo emp) {
		this.emp = emp;
	}

	public DclasssVo getDlcass() {
		return dlcass;
	}

	public void setDlcass(DclasssVo dlcass) {
		this.dlcass = dlcass;
	}

	public HotregistionVo getHospitalRegistration() {
		return hospitalRegistration;
	}

	public void setHospitalRegistration(HotregistionVo hospitalRegistration) {
		this.hospitalRegistration = hospitalRegistration;
	}

	public ShouShuVo getShoushu() {
		return shoushu;
	}

	public void setShoushu(ShouShuVo shoushu) {
		this.shoushu = shoushu;
	}

	public ShouShuMessVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShouShuMessVo(String shoushuMess, Date shoushuMessDate, BigDecimal shoushuMessMoney, String shoushuMessState,
			String shoushuMessType) {
		super();
		this.shoushuMess = shoushuMess;
		this.shoushuMessDate = shoushuMessDate;
		this.shoushuMessMoney = shoushuMessMoney;
		this.shoushuMessState = shoushuMessState;
		this.shoushuMessType = shoushuMessType;
	}
	
}
