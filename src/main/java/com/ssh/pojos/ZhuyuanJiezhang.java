package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the ZHUYUAN_JIEZHANG database table.
 * 
 */
@Entity
@Table(name="ZHUYUAN_JIEZHANG")
@NamedQuery(name="ZhuyuanJiezhang.findAll", query="SELECT z FROM ZhuyuanJiezhang z")
public class ZhuyuanJiezhang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ZHUYUAN_JIEZHANG_ID")
	private String zhuyuanJiezhangId;

	@Temporal(TemporalType.DATE)
	@Column(name="ZHUYUAN_JIEZHANG_DATE")
	private Date zhuyuanJiezhangDate;

	@Column(name="ZHUYUAN_JIEZHANG_STATE")
	private String zhuyuanJiezhangState;

	@Column(name="ZHUYUAN_JIEZHANG_YHMONEY")
	private BigDecimal zhuyuanJiezhangYhmoney;

	@Column(name="ZHUYUAN_JIEZHANG_YQMONEY")
	private BigDecimal zhuyuanJiezhangYqmoney;

	@Column(name="ZHUYUAN_JIEZHANG_YSMONEY")
	private BigDecimal zhuyuanJiezhangYsmoney;

	@Column(name="ZHUYUAN_JIEZHANG_ZMONEY")
	private BigDecimal zhuyuanJiezhangZmoney;

	//bi-directional many-to-one association to HospitalRegistration
	@ManyToOne
	@JoinColumn(name="HOSPITAL_REGISTRATION_ID")
	private HospitalRegistration hospitalRegistration;

	public ZhuyuanJiezhang() {
	}

	public String getZhuyuanJiezhangId() {
		return this.zhuyuanJiezhangId;
	}

	public void setZhuyuanJiezhangId(String zhuyuanJiezhangId) {
		this.zhuyuanJiezhangId = zhuyuanJiezhangId;
	}

	public Date getZhuyuanJiezhangDate() {
		return this.zhuyuanJiezhangDate;
	}

	public void setZhuyuanJiezhangDate(Date zhuyuanJiezhangDate) {
		this.zhuyuanJiezhangDate = zhuyuanJiezhangDate;
	}

	public String getZhuyuanJiezhangState() {
		return this.zhuyuanJiezhangState;
	}

	public void setZhuyuanJiezhangState(String zhuyuanJiezhangState) {
		this.zhuyuanJiezhangState = zhuyuanJiezhangState;
	}

	public BigDecimal getZhuyuanJiezhangYhmoney() {
		return this.zhuyuanJiezhangYhmoney;
	}

	public void setZhuyuanJiezhangYhmoney(BigDecimal zhuyuanJiezhangYhmoney) {
		this.zhuyuanJiezhangYhmoney = zhuyuanJiezhangYhmoney;
	}

	public BigDecimal getZhuyuanJiezhangYqmoney() {
		return this.zhuyuanJiezhangYqmoney;
	}

	public void setZhuyuanJiezhangYqmoney(BigDecimal zhuyuanJiezhangYqmoney) {
		this.zhuyuanJiezhangYqmoney = zhuyuanJiezhangYqmoney;
	}

	public BigDecimal getZhuyuanJiezhangYsmoney() {
		return this.zhuyuanJiezhangYsmoney;
	}

	public void setZhuyuanJiezhangYsmoney(BigDecimal zhuyuanJiezhangYsmoney) {
		this.zhuyuanJiezhangYsmoney = zhuyuanJiezhangYsmoney;
	}

	public BigDecimal getZhuyuanJiezhangZmoney() {
		return this.zhuyuanJiezhangZmoney;
	}

	public void setZhuyuanJiezhangZmoney(BigDecimal zhuyuanJiezhangZmoney) {
		this.zhuyuanJiezhangZmoney = zhuyuanJiezhangZmoney;
	}

	public HospitalRegistration getHospitalRegistration() {
		return this.hospitalRegistration;
	}

	public void setHospitalRegistration(HospitalRegistration hospitalRegistration) {
		this.hospitalRegistration = hospitalRegistration;
	}

}