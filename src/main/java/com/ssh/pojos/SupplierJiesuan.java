package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the SUPPLIER_JIESUAN database table.
 * 
 */
@Entity
@Table(name="SUPPLIER_JIESUAN")
@NamedQuery(name="SupplierJiesuan.findAll", query="SELECT s FROM SupplierJiesuan s")
public class SupplierJiesuan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SUPPLIER_JIESUAN_ID")
	private String supplierJiesuanId;

	@Column(name="DEAL_MONEY")
	private BigDecimal dealMoney;

	@Column(name="OUTO_MONEY")
	private BigDecimal outoMoney;

	@Temporal(TemporalType.DATE)
	@Column(name="SUPPLIER_JIESUAN_DATE")
	private Date supplierJiesuanDate;

	@Column(name="SUPPLIER_JIESUAN_INVOICE")
	private String supplierJiesuanInvoice;

	@Column(name="SUPPLIER_JIESUAN_REMARK")
	private String supplierJiesuanRemark;

	@Column(name="SUPPLIER_JIESUAN_STATE")
	private BigDecimal supplierJiesuanState;

	@Column(name="SUPPLIER_JIESUAN_TIME")
	private String supplierJiesuanTime;

	@Column(name="SUPPLIER_JIESUAN_TYPE")
	private BigDecimal supplierJiesuanType;

	//bi-directional many-to-one association to FukuanRecord
	@OneToMany(mappedBy="supplierJiesuan")
	private List<FukuanRecord> fukuanRecords;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	//bi-directional many-to-one association to SettleWay
	@ManyToOne
	@JoinColumn(name="SETTLE_WAY_ID")
	private SettleWay settleWay;

	public SupplierJiesuan() {
	}

	public String getSupplierJiesuanId() {
		return this.supplierJiesuanId;
	}

	public void setSupplierJiesuanId(String supplierJiesuanId) {
		this.supplierJiesuanId = supplierJiesuanId;
	}

	public BigDecimal getDealMoney() {
		return this.dealMoney;
	}

	public void setDealMoney(BigDecimal dealMoney) {
		this.dealMoney = dealMoney;
	}

	public BigDecimal getOutoMoney() {
		return this.outoMoney;
	}

	public void setOutoMoney(BigDecimal outoMoney) {
		this.outoMoney = outoMoney;
	}

	public Date getSupplierJiesuanDate() {
		return this.supplierJiesuanDate;
	}

	public void setSupplierJiesuanDate(Date supplierJiesuanDate) {
		this.supplierJiesuanDate = supplierJiesuanDate;
	}

	public String getSupplierJiesuanInvoice() {
		return this.supplierJiesuanInvoice;
	}

	public void setSupplierJiesuanInvoice(String supplierJiesuanInvoice) {
		this.supplierJiesuanInvoice = supplierJiesuanInvoice;
	}

	public String getSupplierJiesuanRemark() {
		return this.supplierJiesuanRemark;
	}

	public void setSupplierJiesuanRemark(String supplierJiesuanRemark) {
		this.supplierJiesuanRemark = supplierJiesuanRemark;
	}

	public BigDecimal getSupplierJiesuanState() {
		return this.supplierJiesuanState;
	}

	public void setSupplierJiesuanState(BigDecimal supplierJiesuanState) {
		this.supplierJiesuanState = supplierJiesuanState;
	}

	public String getSupplierJiesuanTime() {
		return this.supplierJiesuanTime;
	}

	public void setSupplierJiesuanTime(String supplierJiesuanTime) {
		this.supplierJiesuanTime = supplierJiesuanTime;
	}

	public BigDecimal getSupplierJiesuanType() {
		return this.supplierJiesuanType;
	}

	public void setSupplierJiesuanType(BigDecimal supplierJiesuanType) {
		this.supplierJiesuanType = supplierJiesuanType;
	}

	public List<FukuanRecord> getFukuanRecords() {
		return this.fukuanRecords;
	}

	public void setFukuanRecords(List<FukuanRecord> fukuanRecords) {
		this.fukuanRecords = fukuanRecords;
	}

	public FukuanRecord addFukuanRecord(FukuanRecord fukuanRecord) {
		getFukuanRecords().add(fukuanRecord);
		fukuanRecord.setSupplierJiesuan(this);

		return fukuanRecord;
	}

	public FukuanRecord removeFukuanRecord(FukuanRecord fukuanRecord) {
		getFukuanRecords().remove(fukuanRecord);
		fukuanRecord.setSupplierJiesuan(null);

		return fukuanRecord;
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