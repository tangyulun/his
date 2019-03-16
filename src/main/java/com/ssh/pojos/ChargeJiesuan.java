package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the CHARGE_JIESUAN database table.
 * 
 */
@Entity
@Table(name="CHARGE_JIESUAN")
@NamedQuery(name="ChargeJiesuan.findAll", query="SELECT c FROM ChargeJiesuan c")
public class ChargeJiesuan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CHARGE_JIESUAN_ID")
	private String chargeJiesuanId;

	@Temporal(TemporalType.DATE)
	@Column(name="CHARGE_JIESUAN_DATE")
	private Date chargeJiesuanDate;

	@Column(name="CHARGE_JIESUAN_INVOICE")
	private String chargeJiesuanInvoice;

	@Column(name="CHARGE_JIESUAN_REMARK")
	private String chargeJiesuanRemark;

	@Column(name="CHARGE_JIESUAN_SF")
	private BigDecimal chargeJiesuanSf;

	@Column(name="CHARGE_JIESUAN_STATE")
	private String chargeJiesuanState;

	@Column(name="CHARGE_JIESUAN_TIME")
	private String chargeJiesuanTime;

	@Column(name="CHARGE_JIESUAN_YF")
	private BigDecimal chargeJiesuanYf;

	@Column(name="JIESUAN_TYPE")
	private String jiesuanType;

	@Column(name="MENZHEN_ID")
	private String menzhenId;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	//bi-directional many-to-one association to SettleWay
	@ManyToOne
	@JoinColumn(name="SETTLE_WAY_ID")
	private SettleWay settleWay;

	public ChargeJiesuan() {
	}

	public String getChargeJiesuanId() {
		return this.chargeJiesuanId;
	}

	public void setChargeJiesuanId(String chargeJiesuanId) {
		this.chargeJiesuanId = chargeJiesuanId;
	}

	public Date getChargeJiesuanDate() {
		return this.chargeJiesuanDate;
	}

	public void setChargeJiesuanDate(Date chargeJiesuanDate) {
		this.chargeJiesuanDate = chargeJiesuanDate;
	}

	public String getChargeJiesuanInvoice() {
		return this.chargeJiesuanInvoice;
	}

	public void setChargeJiesuanInvoice(String chargeJiesuanInvoice) {
		this.chargeJiesuanInvoice = chargeJiesuanInvoice;
	}

	public String getChargeJiesuanRemark() {
		return this.chargeJiesuanRemark;
	}

	public void setChargeJiesuanRemark(String chargeJiesuanRemark) {
		this.chargeJiesuanRemark = chargeJiesuanRemark;
	}

	public BigDecimal getChargeJiesuanSf() {
		return this.chargeJiesuanSf;
	}

	public void setChargeJiesuanSf(BigDecimal chargeJiesuanSf) {
		this.chargeJiesuanSf = chargeJiesuanSf;
	}

	public String getChargeJiesuanState() {
		return this.chargeJiesuanState;
	}

	public void setChargeJiesuanState(String chargeJiesuanState) {
		this.chargeJiesuanState = chargeJiesuanState;
	}

	public String getChargeJiesuanTime() {
		return this.chargeJiesuanTime;
	}

	public void setChargeJiesuanTime(String chargeJiesuanTime) {
		this.chargeJiesuanTime = chargeJiesuanTime;
	}

	public BigDecimal getChargeJiesuanYf() {
		return this.chargeJiesuanYf;
	}

	public void setChargeJiesuanYf(BigDecimal chargeJiesuanYf) {
		this.chargeJiesuanYf = chargeJiesuanYf;
	}

	public String getJiesuanType() {
		return this.jiesuanType;
	}

	public void setJiesuanType(String jiesuanType) {
		this.jiesuanType = jiesuanType;
	}

	public String getMenzhenId() {
		return this.menzhenId;
	}

	public void setMenzhenId(String menzhenId) {
		this.menzhenId = menzhenId;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public SettleWay getSettleWay() {
		return this.settleWay;
	}

	public void setSettleWay(SettleWay settleWay) {
		this.settleWay = settleWay;
	}

}