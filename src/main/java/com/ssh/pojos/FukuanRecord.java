package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the FUKUAN_RECORD database table.
 * 
 */
@Entity
@Table(name="FUKUAN_RECORD")
@NamedQuery(name="FukuanRecord.findAll", query="SELECT f FROM FukuanRecord f")
public class FukuanRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FUKUAN_RECORD_ID")
	private long fukuanRecordId;

	@Column(name="FUKUAN_MONEY")
	private BigDecimal fukuanMoney;

	@Column(name="FUKUAN_REMARK")
	private String fukuanRemark;

	//bi-directional many-to-one association to Fukuan
	@ManyToOne
	@JoinColumn(name="FUKUAN_ID")
	private Fukuan fukuan;

	//bi-directional many-to-one association to SupplierJiesuan
	@ManyToOne
	@JoinColumn(name="SUPPLIER_JIESUAN_ID")
	private SupplierJiesuan supplierJiesuan;

	public FukuanRecord() {
	}

	public long getFukuanRecordId() {
		return this.fukuanRecordId;
	}

	public void setFukuanRecordId(long fukuanRecordId) {
		this.fukuanRecordId = fukuanRecordId;
	}

	public BigDecimal getFukuanMoney() {
		return this.fukuanMoney;
	}

	public void setFukuanMoney(BigDecimal fukuanMoney) {
		this.fukuanMoney = fukuanMoney;
	}

	public String getFukuanRemark() {
		return this.fukuanRemark;
	}

	public void setFukuanRemark(String fukuanRemark) {
		this.fukuanRemark = fukuanRemark;
	}

	public Fukuan getFukuan() {
		return this.fukuan;
	}

	public void setFukuan(Fukuan fukuan) {
		this.fukuan = fukuan;
	}

	public SupplierJiesuan getSupplierJiesuan() {
		return this.supplierJiesuan;
	}

	public void setSupplierJiesuan(SupplierJiesuan supplierJiesuan) {
		this.supplierJiesuan = supplierJiesuan;
	}

}