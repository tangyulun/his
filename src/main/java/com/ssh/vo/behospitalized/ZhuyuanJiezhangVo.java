package com.ssh.vo.behospitalized;

import java.math.BigDecimal;
import java.util.Date;

import com.ssh.pojos.HospitalRegistration;

public class ZhuyuanJiezhangVo {
	private String zhuyuanJiezhangId;

	private Date zhuyuanJiezhangDate;

	private String zhuyuanJiezhangState;

	private BigDecimal zhuyuanJiezhangYhmoney;

	private BigDecimal zhuyuanJiezhangYqmoney;

	private BigDecimal zhuyuanJiezhangYsmoney;

	private BigDecimal zhuyuanJiezhangZmoney;

	private HospitalRegistration hospitalRegistration;

	public String getZhuyuanJiezhangId() {
		return zhuyuanJiezhangId;
	}

	public void setZhuyuanJiezhangId(String zhuyuanJiezhangId) {
		this.zhuyuanJiezhangId = zhuyuanJiezhangId;
	}

	public Date getZhuyuanJiezhangDate() {
		return zhuyuanJiezhangDate;
	}

	public void setZhuyuanJiezhangDate(Date zhuyuanJiezhangDate) {
		this.zhuyuanJiezhangDate = zhuyuanJiezhangDate;
	}

	public String getZhuyuanJiezhangState() {
		return zhuyuanJiezhangState;
	}

	public void setZhuyuanJiezhangState(String zhuyuanJiezhangState) {
		this.zhuyuanJiezhangState = zhuyuanJiezhangState;
	}

	public BigDecimal getZhuyuanJiezhangYhmoney() {
		return zhuyuanJiezhangYhmoney;
	}

	public void setZhuyuanJiezhangYhmoney(BigDecimal zhuyuanJiezhangYhmoney) {
		this.zhuyuanJiezhangYhmoney = zhuyuanJiezhangYhmoney;
	}

	public BigDecimal getZhuyuanJiezhangYqmoney() {
		return zhuyuanJiezhangYqmoney;
	}

	public void setZhuyuanJiezhangYqmoney(BigDecimal zhuyuanJiezhangYqmoney) {
		this.zhuyuanJiezhangYqmoney = zhuyuanJiezhangYqmoney;
	}

	public BigDecimal getZhuyuanJiezhangYsmoney() {
		return zhuyuanJiezhangYsmoney;
	}

	public void setZhuyuanJiezhangYsmoney(BigDecimal zhuyuanJiezhangYsmoney) {
		this.zhuyuanJiezhangYsmoney = zhuyuanJiezhangYsmoney;
	}

	public BigDecimal getZhuyuanJiezhangZmoney() {
		return zhuyuanJiezhangZmoney;
	}

	public void setZhuyuanJiezhangZmoney(BigDecimal zhuyuanJiezhangZmoney) {
		this.zhuyuanJiezhangZmoney = zhuyuanJiezhangZmoney;
	}

	public HospitalRegistration getHospitalRegistration() {
		return hospitalRegistration;
	}

	public void setHospitalRegistration(HospitalRegistration hospitalRegistration) {
		this.hospitalRegistration = hospitalRegistration;
	}

	public ZhuyuanJiezhangVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ZhuyuanJiezhangVo(String zhuyuanJiezhangId, Date zhuyuanJiezhangDate, String zhuyuanJiezhangState,
			BigDecimal zhuyuanJiezhangYhmoney, BigDecimal zhuyuanJiezhangYqmoney, BigDecimal zhuyuanJiezhangYsmoney,
			BigDecimal zhuyuanJiezhangZmoney, HospitalRegistration hospitalRegistration) {
		super();
		this.zhuyuanJiezhangId = zhuyuanJiezhangId;
		this.zhuyuanJiezhangDate = zhuyuanJiezhangDate;
		this.zhuyuanJiezhangState = zhuyuanJiezhangState;
		this.zhuyuanJiezhangYhmoney = zhuyuanJiezhangYhmoney;
		this.zhuyuanJiezhangYqmoney = zhuyuanJiezhangYqmoney;
		this.zhuyuanJiezhangYsmoney = zhuyuanJiezhangYsmoney;
		this.zhuyuanJiezhangZmoney = zhuyuanJiezhangZmoney;
		this.hospitalRegistration = hospitalRegistration;
	}

	public ZhuyuanJiezhangVo(BigDecimal zhuyuanJiezhangZmoney) {
		super();
		this.zhuyuanJiezhangZmoney = zhuyuanJiezhangZmoney;
	}

	
	
	

}
