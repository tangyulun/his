package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SETTLE_WAY database table.
 * 
 */
@Entity
@Table(name="SETTLE_WAY")
@NamedQuery(name="SettleWay.findAll", query="SELECT s FROM SettleWay s")
public class SettleWay implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SETTLE_WAY_ID")
	private String settleWayId;

	@Column(name="SETTLE_WAY_NAME")
	private String settleWayName;

	//bi-directional many-to-one association to ChargeJiesuan
	@OneToMany(mappedBy="settleWay")
	private List<ChargeJiesuan> chargeJiesuans;

	//bi-directional many-to-one association to SupplierJiesuan
	@OneToMany(mappedBy="settleWay")
	private List<SupplierJiesuan> supplierJiesuans;

	public SettleWay() {
	}

	public String getSettleWayId() {
		return this.settleWayId;
	}

	public void setSettleWayId(String settleWayId) {
		this.settleWayId = settleWayId;
	}

	public String getSettleWayName() {
		return this.settleWayName;
	}

	public void setSettleWayName(String settleWayName) {
		this.settleWayName = settleWayName;
	}

	public List<ChargeJiesuan> getChargeJiesuans() {
		return this.chargeJiesuans;
	}

	public void setChargeJiesuans(List<ChargeJiesuan> chargeJiesuans) {
		this.chargeJiesuans = chargeJiesuans;
	}

	public ChargeJiesuan addChargeJiesuan(ChargeJiesuan chargeJiesuan) {
		getChargeJiesuans().add(chargeJiesuan);
		chargeJiesuan.setSettleWay(this);

		return chargeJiesuan;
	}

	public ChargeJiesuan removeChargeJiesuan(ChargeJiesuan chargeJiesuan) {
		getChargeJiesuans().remove(chargeJiesuan);
		chargeJiesuan.setSettleWay(null);

		return chargeJiesuan;
	}

	public List<SupplierJiesuan> getSupplierJiesuans() {
		return this.supplierJiesuans;
	}

	public void setSupplierJiesuans(List<SupplierJiesuan> supplierJiesuans) {
		this.supplierJiesuans = supplierJiesuans;
	}

	public SupplierJiesuan addSupplierJiesuan(SupplierJiesuan supplierJiesuan) {
		getSupplierJiesuans().add(supplierJiesuan);
		supplierJiesuan.setSettleWay(this);

		return supplierJiesuan;
	}

	public SupplierJiesuan removeSupplierJiesuan(SupplierJiesuan supplierJiesuan) {
		getSupplierJiesuans().remove(supplierJiesuan);
		supplierJiesuan.setSettleWay(null);

		return supplierJiesuan;
	}

}