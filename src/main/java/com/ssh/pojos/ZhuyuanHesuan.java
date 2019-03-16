package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the ZHUYUAN_HESUAN database table.
 * 
 */
@Entity
@Table(name="ZHUYUAN_HESUAN")
@NamedQuery(name="ZhuyuanHesuan.findAll", query="SELECT z FROM ZhuyuanHesuan z")
public class ZhuyuanHesuan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ZHUYUAN_HESUAN_ID")
	private String zhuyuanHesuanId;

	@Temporal(TemporalType.DATE)
	@Column(name="ZHUYUAN_HESUAN_DATE")
	private Date zhuyuanHesuanDate;

	@Column(name="ZHUYUAN_HESUAN_MONEY")
	private BigDecimal zhuyuanHesuanMoney;

	//bi-directional many-to-one association to HospitalRegistration
	@ManyToOne
	@JoinColumn(name="HOSPITAL_REGISTRATION_ID")
	private HospitalRegistration hospitalRegistration;

	public ZhuyuanHesuan() {
	}

	public String getZhuyuanHesuanId() {
		return this.zhuyuanHesuanId;
	}

	public void setZhuyuanHesuanId(String zhuyuanHesuanId) {
		this.zhuyuanHesuanId = zhuyuanHesuanId;
	}

	public Date getZhuyuanHesuanDate() {
		return this.zhuyuanHesuanDate;
	}

	public void setZhuyuanHesuanDate(Date zhuyuanHesuanDate) {
		this.zhuyuanHesuanDate = zhuyuanHesuanDate;
	}

	public BigDecimal getZhuyuanHesuanMoney() {
		return this.zhuyuanHesuanMoney;
	}

	public void setZhuyuanHesuanMoney(BigDecimal zhuyuanHesuanMoney) {
		this.zhuyuanHesuanMoney = zhuyuanHesuanMoney;
	}

	public HospitalRegistration getHospitalRegistration() {
		return this.hospitalRegistration;
	}

	public void setHospitalRegistration(HospitalRegistration hospitalRegistration) {
		this.hospitalRegistration = hospitalRegistration;
	}

}